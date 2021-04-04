/**ur
 * 
 */
package com.accenture.api.test.store.business;


import static com.accenture.api.test.store.utilities.accentureTestConstants.EXCEPTION_DEV;
import static com.accenture.api.test.store.utilities.accentureTestConstants.EXCEPTION_USER;
import static com.accenture.api.test.store.utilities.accentureTestConstants.MAX_VALUE;
import static com.accenture.api.test.store.utilities.accentureTestConstants.MIN_VALUE;
import static com.accenture.api.test.store.utilities.accentureTestConstants.SUCCESS_DEV;
import static com.accenture.api.test.store.utilities.accentureTestConstants.SUCCESS_USER;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.accenture.api.test.store.domain.detailPurchaseDTO;
import com.accenture.api.test.store.domain.purchaseDTO;
import com.accenture.api.test.store.model.Compra;
import com.accenture.api.test.store.model.Detalle_compra;
import com.accenture.api.test.store.model.Usuario;
import com.accenture.api.test.store.repository.compraRepository;
import com.accenture.api.test.store.repository.detalleCompraRepository;
import com.accenture.api.test.store.repository.usuarioRepository;
import com.accenture.api.test.store.utilities.Response;

/**
 * @author alejandro.hurtado
 *
 */
@Service
public class accentureTestImpl implements accentureTest{
	@Autowired
	private detalleCompraRepository detalleCompra;
	@Autowired
	private usuarioRepository usuario;
	@Autowired
	private compraRepository compra;
	
	@Override
	public Response<Void> purchase(purchaseDTO purchase){
		Response<Void> response = null;
		int total = 0;
		try {
			int totalCarShop = this.detailCarShop(purchase.getDetalle());
			if(totalCarShop >= MIN_VALUE) {
				Optional<Usuario> user = this.usuario.findByCedula(purchase.getCedula());
				
				if(user.isEmpty()) {
					Usuario userCreate = new Usuario();
					userCreate.setNombres(purchase.getNombres());
					userCreate.setApellidos(purchase.getApellidos());
					userCreate.setDireccion(purchase.getDireccion());
					userCreate.setCedula(purchase.getCedula());
					Usuario create = this.usuario.save(userCreate);
					total = this.createPurchase(purchase, create, totalCarShop);
				} else {
					total = this.createPurchase(purchase, user.get(), totalCarShop);
				}
				
				if(total < MAX_VALUE) {
					response = new Response<>(HttpStatus.OK.value(), SUCCESS_USER, SUCCESS_DEV, null, "El valor de su pedido es: "+total+" y el valor del domicilio es: 10.000");
				} else if(total > MAX_VALUE) {
					response = new Response<>(HttpStatus.OK.value(), SUCCESS_USER, SUCCESS_DEV, null, "El valor de su pedido es: "+total+" y el valor del domicilio es: 0");
				}
			} else {
				response = new Response<>(HttpStatus.BAD_REQUEST.value(), EXCEPTION_USER, EXCEPTION_DEV, "400", "El valor de su compra debe ser mínimo 70.000");
			}
		} catch (Exception e) {
			response = new Response<>(HttpStatus.BAD_REQUEST.value(), EXCEPTION_USER, EXCEPTION_DEV, "400", e.getMessage());
		}
		
		return response;
	}
	
	@Override
	public Response<Void> modifyPurchase(purchaseDTO purchase, Long purchaseId){
		Response<Void> response = null;
		try {
			int totalCarShop = this.detailCarShop(purchase.getDetalle());
			if(totalCarShop >= MIN_VALUE) {
				Optional<Compra> buy = this.compra.findById(purchaseId);
				if(!buy.isEmpty()) {
					Compra buyOn = buy.get();
					LocalDateTime searchDate = LocalDateTime.now().minusHours(5);
					if(buyOn.getFechaCompra().toLocalDateTime().isAfter(searchDate)) {
						int totalPurchase = this.getDetailPurchase(purchaseId);
						if(totalCarShop < totalPurchase) {
							response = new Response<>(HttpStatus.BAD_REQUEST.value(), EXCEPTION_USER, EXCEPTION_DEV, "400", "Solo es posible modificar un pedido si el valor de la compra actual es mayor a la compra ya realizada.");
						} else {
							this.detalleCompra.deleteByPurchaseId(buyOn.getCompraId());
							this.compra.updatePurchase(buyOn.getCompraId(), totalCarShop);
							this.detail(purchase.getDetalle(), buyOn);
							if(totalCarShop < MAX_VALUE) {
								response = new Response<>(HttpStatus.OK.value(), SUCCESS_USER, SUCCESS_DEV, null, "El valor de su pedido ahora es de: "+totalCarShop+" y el valor del domicilio ahora es de: 10.000");
							} else if(totalCarShop > MAX_VALUE) {
								response = new Response<>(HttpStatus.OK.value(), SUCCESS_USER, SUCCESS_DEV, null, "El valor de su pedido ahora es de: "+totalCarShop+" y el valor del domicilio ahora es de: 0");
							}
						}
					} else {
						response = new Response<>(HttpStatus.BAD_REQUEST.value(), EXCEPTION_USER, EXCEPTION_DEV, "400", "Ya han pasado más de 5 horas desde la creación del pedido y no es posible modificarlo.");
					}
				} else {
					response = new Response<>(HttpStatus.BAD_REQUEST.value(), EXCEPTION_USER, EXCEPTION_DEV, "400", "No se encontró la compra con el id indicado.");
				}
			} else {
				response = new Response<>(HttpStatus.BAD_REQUEST.value(), EXCEPTION_USER, EXCEPTION_DEV, "400", "El valor de su compra debe ser mínimo 70.000");
			}
		} catch (Exception e) {
			response = new Response<>(HttpStatus.BAD_REQUEST.value(), EXCEPTION_USER, EXCEPTION_DEV, "400", e.getMessage());
		}
		
		return response;
	}
	
	@Override
	public Response<Void> addProductsPurchase(purchaseDTO purchase, Long purchaseId){
		Response<Void> response = null;
		try {
			Optional<Compra> buy = this.compra.findById(purchaseId);
			if(!buy.isEmpty()) {
				Compra buyOn = buy.get();
				LocalDateTime searchDate = LocalDateTime.now().minusHours(5);
				if(buyOn.getFechaCompra().toLocalDateTime().isAfter(searchDate)) {
					this.detail(purchase.getDetalle(), buyOn);
					int totalPurchase = this.getDetailPurchase(purchaseId);
					this.compra.updatePurchase(buyOn.getCompraId(), totalPurchase);
					
					if(totalPurchase < MAX_VALUE) {
						response = new Response<>(HttpStatus.OK.value(), SUCCESS_USER, SUCCESS_DEV, null, "El valor de su pedido ahora es de: "+totalPurchase+" y el valor del domicilio ahora es de: 10.000");
					} else if(totalPurchase > MAX_VALUE) {
						response = new Response<>(HttpStatus.OK.value(), SUCCESS_USER, SUCCESS_DEV, null, "El valor de su pedido ahora es de: "+totalPurchase+" y el valor del domicilio ahora es de: 0");
					}
				}
			} else {
				response = new Response<>(HttpStatus.BAD_REQUEST.value(), EXCEPTION_USER, EXCEPTION_DEV, "400", "No se encontró la compra con el id indicado.");
			}
		} catch (Exception e) {
			response = new Response<>(HttpStatus.BAD_REQUEST.value(), EXCEPTION_USER, EXCEPTION_DEV, "400", e.getMessage());
		}
		
		return response;
	}
	
	public int createPurchase(purchaseDTO purchase, Usuario user, int totalCarShop) {
		int total = 0;
		try {
			Compra compra = new Compra();
			compra.setUsuario(user);
			compra.setTotal(totalCarShop);
			compra.setFechaCompra(new Timestamp(new Date().getTime()));
			Compra buy = this.compra.save(compra);
			total = this.detail(purchase.getDetalle(), buy);			
		} catch (Exception e) {
			System.out.println("El error es: "+e.getMessage());
		}
		
		return total;
	}
	
	public int detail(List<detailPurchaseDTO> detailBuy, Compra buy) {
		int total = 0;
		try {
			for(detailPurchaseDTO detailsBuy : detailBuy) {
				total = total + (detailsBuy.getValor_unitario()*detailsBuy.getCantidad());
				Detalle_compra detail = new Detalle_compra();
				detail.setCompra(buy);
				detail.setProducto(detailsBuy.getProducto());
				detail.setCantidad(detailsBuy.getCantidad());
				detail.setValorUnitario(detailsBuy.getValor_unitario());
				this.detalleCompra.save(detail);
			}
		} catch (Exception e) {
			System.out.println("El error es: "+e.getMessage());
		}
		
		return total;
	}
	
	public int detailCarShop(List<detailPurchaseDTO> detailBuy) {
		int total = 0;
		try {
			for(detailPurchaseDTO detailsBuy : detailBuy) {
				total = total + (detailsBuy.getValor_unitario()*detailsBuy.getCantidad());
			}
		} catch (Exception e) {
			System.out.println("El error es: "+e.getMessage());
		}
		
		return total;
	}
	
	public int getDetailPurchase(Long purchaseId) {
		int total = 0;
		try {
			List<Detalle_compra> detail = detalleCompra.findByAllRecordsById(purchaseId);
			if(!detail.isEmpty()) {
				for(Detalle_compra detail_purchase : detail) {
					total = total + (detail_purchase.getValorUnitario() * detail_purchase.getCantidad());
				}
			}
		} catch (Exception e) {
			System.out.println("El error es: "+e.getMessage());
		}
		
		return total;
	}
}

/**
 * 
 */
package com.accenture.api.test.store.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author alejandro.hurtado
 *
 */
@Entity
@Table(name = "DETALLE_COMPRA")
public class Detalle_compra implements Serializable{

	/*Serializable*/
	private static final long serialVersionUID = 3355190521413528192L;
	/** Identificador principal */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detalle_compra_id")
    private Long detalleCompraId;
    /** producto */
    @Column(name = "producto")
    private String producto;
    /** Cantidad */
    @Column(name = "cantidad")
    private int cantidad;
    /** Valor por producto */
    @Column(name = "valor_unitario")
    private int valorUnitario;
    @ManyToOne
    @JoinColumn(name = "compra_id", referencedColumnName = "compra_id")
    private Compra compra;
    
	/**
	 * @return the detalleCompraId
	 */
	public Long getDetalleCompraId() {
		return detalleCompraId;
	}
	/**
	 * @param detalleCompraId the detalleCompraId to set
	 */
	public void setDetalleCompraId(Long detalleCompraId) {
		this.detalleCompraId = detalleCompraId;
	}
	/**
	 * @return the producto
	 */
	public String getProducto() {
		return producto;
	}
	/**
	 * @param producto the producto to set
	 */
	public void setProducto(String producto) {
		this.producto = producto;
	}
	/**
	 * @return the cantidad
	 */
	public int getCantidad() {
		return cantidad;
	}
	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	/**
	 * @return the valorUnitario
	 */
	public int getValorUnitario() {
		return valorUnitario;
	}
	/**
	 * @param valorUnitario the valorUnitario to set
	 */
	public void setValorUnitario(int valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	/**
	 * @return the compra
	 */
	public Compra getCompra() {
		return compra;
	}
	/**
	 * @param compra the compra to set
	 */
	public void setCompra(Compra compra) {
		this.compra = compra;
	}
    

}

/**
 * 
 */
package com.accenture.api.test.store.domain;

import java.io.Serializable;

/**
 * @author alejandro.hurtado
 *
 */
public class detailPurchaseDTO implements Serializable{

	/**Serializable*/
	private static final long serialVersionUID = 9185504925082022860L;
	private String producto;
	private int cantidad;
	private int valor_unitario;
	
	
	public detailPurchaseDTO() {

	}
	/**
	 * @param producto
	 * @param cantidad
	 * @param valor_unitario
	 */
	public detailPurchaseDTO(String producto, int cantidad, int valor_unitario) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
		this.valor_unitario = valor_unitario;
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
	 * @return the valor_unitario
	 */
	public int getValor_unitario() {
		return valor_unitario;
	}
	/**
	 * @param valor_unitario the valor_unitario to set
	 */
	public void setValor_unitario(int valor_unitario) {
		this.valor_unitario = valor_unitario;
	}
}

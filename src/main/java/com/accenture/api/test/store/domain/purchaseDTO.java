/**
 * 
 */
package com.accenture.api.test.store.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @author alejandro.hurtado
 *
 */
public class purchaseDTO implements Serializable{

	/**Serializable*/
	private static final long serialVersionUID = 3649123828073815583L;
	private String nombres;
	private String apellidos;
	private String direccion; 
	private String cedula;
	private List<detailPurchaseDTO> detalle;
	
	/**
	 * @return the nombres
	 */
	public String getNombres() {
		return nombres;
	}
	/**
	 * @param nombres the nombres to set
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}
	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	/**
	 * @return the cedula
	 */
	public String getCedula() {
		return cedula;
	}
	/**
	 * @param cedula the cedula to set
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	/**
	 * @return the detalle
	 */
	public List<detailPurchaseDTO> getDetalle() {
		return detalle;
	}
	/**
	 * @param detalle the detalle to set
	 */
	public void setDetalle(List<detailPurchaseDTO> detalle) {
		this.detalle = detalle;
	}
}

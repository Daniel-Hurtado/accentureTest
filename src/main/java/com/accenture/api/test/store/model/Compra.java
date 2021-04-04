/**
 * 
 */
package com.accenture.api.test.store.model;

import java.io.Serializable;
import java.sql.Timestamp;

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
@Table(name = "COMPRA")
public class Compra implements Serializable{

	/**Serializable*/
	private static final long serialVersionUID = -7229036483311056108L;
	/** Identificador principal */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "compra_id")
    private Long compraId;
    /** Total de la compra*/
    @Column(name = "total")
    private int total;
    /** Fecha de la compra*/
    @Column(name = "fecha_compra")
    private Timestamp fechaCompra;
    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
    private Usuario usuario;
    
	/**
	 * @return the compraId
	 */
	public Long getCompraId() {
		return compraId;
	}
	/**
	 * @param compraId the compraId to set
	 */
	public void setCompraId(Long compraId) {
		this.compraId = compraId;
	}
	/**
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(int total) {
		this.total = total;
	}
	/**
	 * @return the fechaCompra
	 */
	public Timestamp getFechaCompra() {
		return fechaCompra;
	}
	/**
	 * @param fechaCompra the fechaCompra to set
	 */
	public void setFechaCompra(Timestamp fechaCompra) {
		this.fechaCompra = fechaCompra;
	}
	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}

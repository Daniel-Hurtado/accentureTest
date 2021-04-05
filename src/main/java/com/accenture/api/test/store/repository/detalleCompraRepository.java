/**
 * 
 */
package com.accenture.api.test.store.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.accenture.api.test.store.model.Detalle_compra;

/**
 * @author alejandro.hurtado
 *
 */
public interface detalleCompraRepository extends JpaRepository<Detalle_compra, Long>{
	
	@Query("SELECT dc FROM Detalle_compra dc where dc.compra.compraId = :id")
	List<Detalle_compra> findByAllRecordsById(@Param("id") Long purchaseId);
	
	@Transactional
	@Modifying
	@Query("DELETE Detalle_compra dc where dc.compra.compraId = :id")
	void deleteByPurchaseId(@Param("id") Long purchaseId);
}

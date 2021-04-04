/**
 * 
 */
package com.accenture.api.test.store.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.accenture.api.test.store.model.Compra;

/**
 * @author alejandro.hurtado
 *
 */
public interface compraRepository extends JpaRepository<Compra, Long>{
	@Transactional
	@Modifying
	@Query("UPDATE Compra c SET total = :total where compraId = :id")
	void updatePurchase(@Param("id") Long purchaseId, @Param("total") int total);	
}

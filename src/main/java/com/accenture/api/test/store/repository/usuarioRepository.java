/**
 * 
 */
package com.accenture.api.test.store.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.accenture.api.test.store.model.Usuario;

/**
 * @author alejandro.hurtado
 *
 */
public interface usuarioRepository extends JpaRepository<Usuario, Long>{
	
	@Query("SELECT u FROM Usuario u where u.cedula = :cedula")
	Optional<Usuario> findByCedula(@Param("cedula") String cedula);
}

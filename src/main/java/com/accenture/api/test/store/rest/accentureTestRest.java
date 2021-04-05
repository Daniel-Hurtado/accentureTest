/**
 * 
 */
package com.accenture.api.test.store.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.api.test.store.business.accentureTest;
import com.accenture.api.test.store.domain.purchaseDTO;
import com.accenture.api.test.store.utilities.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author alejandro.hurtado
 *
 */
@RestController
@RequestMapping(value = "/api")
@Api("RestController que expone las Apis de este proyecto")
public class accentureTestRest {
	
	private final accentureTest business;
	
	public accentureTestRest(accentureTest business) {
		this.business = business;
	}
	
	@ApiOperation(value = "Permite realizar la acción de compra", produces = MediaType.APPLICATION_JSON_VALUE, httpMethod = "POST", response = Response.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La acción ha sido realizada exitosamente", response = Response.class),
            @ApiResponse(code = 400, message = "Los datos recibidos no cumplen con la obligatoriedad o formatos esperados", response = Response.class),
            @ApiResponse(code = 500, message = "Ocurre un error dentro del servidor, el cual se puede generar por problemas en el acceso a recursos, consultas de elementos no existentes o errores inesperados", response = Response.class) })
	@PostMapping(value = "/purchase", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE) 
	public Response<Void> getDetailPurchase(@RequestBody(required = true) purchaseDTO purchase) { 
		
		return business.purchase(purchase);
	}
	
	@ApiOperation(value = "Permite realizar la acción de compra", produces = MediaType.APPLICATION_JSON_VALUE, httpMethod = "PUT", response = Response.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La acción ha sido realizada exitosamente", response = Response.class),
            @ApiResponse(code = 400, message = "Los datos recibidos no cumplen con la obligatoriedad o formatos esperados", response = Response.class),
            @ApiResponse(code = 500, message = "Ocurre un error dentro del servidor, el cual se puede generar por problemas en el acceso a recursos, consultas de elementos no existentes o errores inesperados", response = Response.class) })
	@PutMapping(value = "/purchase/{purchase_id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE) 
	public Response<Void> modifyPurchase(@RequestBody(required = true) purchaseDTO purchase,
			@PathVariable(name = "purchase_id", required = true) Long purchaseId) { 
		
		return business.modifyPurchase(purchase, purchaseId);
	}
	
	@ApiOperation(value = "Permite realizar la acción de compra", produces = MediaType.APPLICATION_JSON_VALUE, httpMethod = "POST", response = Response.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La acción ha sido realizada exitosamente", response = Response.class),
            @ApiResponse(code = 400, message = "Los datos recibidos no cumplen con la obligatoriedad o formatos esperados", response = Response.class),
            @ApiResponse(code = 500, message = "Ocurre un error dentro del servidor, el cual se puede generar por problemas en el acceso a recursos, consultas de elementos no existentes o errores inesperados", response = Response.class) })
	@PostMapping(value = "/add-purchase/{purchase_id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE) 
	public Response<Void> addProductsPurchase(@RequestBody(required = true) purchaseDTO purchase,
			@PathVariable(name = "purchase_id", required = true) Long purchaseId) { 
		
		return business.addProductsPurchase(purchase, purchaseId);
	}
	
	@ApiOperation(value = "Permite realizar la acción de compra", produces = MediaType.APPLICATION_JSON_VALUE, httpMethod = "DELETE", response = Response.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La acción ha sido realizada exitosamente", response = Response.class),
            @ApiResponse(code = 400, message = "Los datos recibidos no cumplen con la obligatoriedad o formatos esperados", response = Response.class),
            @ApiResponse(code = 500, message = "Ocurre un error dentro del servidor, el cual se puede generar por problemas en el acceso a recursos, consultas de elementos no existentes o errores inesperados", response = Response.class) })
	@DeleteMapping(value = "/delete-purchase/{purchase_id}", produces = MediaType.APPLICATION_JSON_VALUE) 
	public Response<Void> deletePurchase(@PathVariable(name = "purchase_id", required = true) Long purchaseId) { 
		
		return business.deletePurchase(purchaseId);
	}
	
}

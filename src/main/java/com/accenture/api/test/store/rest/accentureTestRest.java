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

/**
 * @author alejandro.hurtado
 *
 */
@RestController
@RequestMapping(value = "/api")
public class accentureTestRest {
	
	private final accentureTest business;
	
	public accentureTestRest(accentureTest business) {
		this.business = business;
	}
	
	@PostMapping(value = "/purchase", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE) 
	public Response<Void> getDetailPurchase(@RequestBody(required = true) purchaseDTO purchase) { 
		
		return business.purchase(purchase);
	}
	
	@PutMapping(value = "/purchase/{purchase_id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE) 
	public Response<Void> modifyPurchase(@RequestBody(required = true) purchaseDTO purchase,
			@PathVariable(name = "purchase_id", required = true) Long purchaseId) { 
		
		return business.modifyPurchase(purchase, purchaseId);
	}
	
	@PostMapping(value = "/add-purchase/{purchase_id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE) 
	public Response<Void> addProductsPurchase(@RequestBody(required = true) purchaseDTO purchase,
			@PathVariable(name = "purchase_id", required = true) Long purchaseId) { 
		
		return business.addProductsPurchase(purchase, purchaseId);
	}
	
	@DeleteMapping(value = "/delete-purchase/{purchase_id}", produces = MediaType.APPLICATION_JSON_VALUE) 
	public Response<Void> deletePurchase(@PathVariable(name = "purchase_id", required = true) Long purchaseId) { 
		
		return business.deletePurchase(purchaseId);
	}
	
}

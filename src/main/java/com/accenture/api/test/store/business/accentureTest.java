/**
 * 
 */
package com.accenture.api.test.store.business;

import com.accenture.api.test.store.domain.purchaseDTO;
import com.accenture.api.test.store.utilities.Response;

/**
 * @author alejandro.hurtado
 *
 */
public interface accentureTest {
	Response<Void> purchase(purchaseDTO purchase);
	Response<Void> modifyPurchase(purchaseDTO purchase, Long purchaseId);
	Response<Void> addProductsPurchase(purchaseDTO purchase, Long purchaseId);
}

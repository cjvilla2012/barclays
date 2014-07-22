/** Copyright 2014 CJ Villa, LLC. All rights reserved. */
package com.cjvilla.barclays;

import retrofit.http.GET;

/**
 * The RetroFit interface for retrieval of products.
 *
 */
public interface ProductInterface {
	  @GET("/mobile-api/v1/offers.json?page_size=10&page")
	  Offers products();
}

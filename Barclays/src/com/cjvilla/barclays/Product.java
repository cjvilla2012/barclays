/** Copyright 2014 CJ Villa, LLC. All rights reserved. */
package com.cjvilla.barclays;

/**
 * Encapsulates a single product item that is dynamically populated by Gson.
 * The field names match those in the received JSON.
 *
 */
public class Product {
    private String uuid;
    private String title;
    private String end_date;
    private String description;
    private String earliest_redemption_date; 
    private String image; 
    private String available_count;
	/**
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @return the end_date
	 */
	public String getEnd_date() {
		return end_date;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @return the earliest_redemption_date
	 */
	public String getEarliest_redemption_date() {
		return earliest_redemption_date;
	}
	/**
	 * @return the image Href
	 */
	public String getImage() {
		return image;
	}
	/**
	 * @return the available_count
	 */
	public String getAvailable_count() {
		return available_count;
	}

}

package com.zcorum.task;


public class DisplayNameMaker {
	/**
	 * Make display name as described below;
	 * return lastName + ", " + first name - if both are available
	 * return business name - if business name is available and first
	 * name or last name is empty or null
	 * return empty string - if all are empty or null
	 */

	public String displayName(final String firstName, final String
			lastName, final String businessName) {
		if (!isBlank(firstName) && !isBlank(lastName)) {
			return lastName + ", " + firstName;
		}
		if (!isBlank(businessName) && (isBlank(lastName) || isBlank(firstName))) {
			return businessName;
		}
		return "";
	}

	private boolean isBlank(String value) {
		return value == null || value.isBlank();
	}

}

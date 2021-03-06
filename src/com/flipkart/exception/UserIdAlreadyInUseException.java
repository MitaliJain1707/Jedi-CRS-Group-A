/**
 * 
 */
package com.flipkart.exception;


@SuppressWarnings("serial")
public class UserIdAlreadyInUseException extends Exception {

	private int userId;

	/**
	 * @param userId
	 */
	public UserIdAlreadyInUseException(int userId) {
		this.userId = userId;
	}

	/**
	 * Getter Method
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	
	/**
	 * Message returned when Exception is thrown
	 */
	@Override
	public String getMessage() {
		return "\t\tUser Id: " + userId + " is already in use.";
	}
}

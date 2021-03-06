/**
 * 
 */
package com.flipkart.exception;


@SuppressWarnings("serial")
public class ProfessorNotFoundException extends Exception {

	private int professorId;

	/**
	 * @param professorId
	 */
	public ProfessorNotFoundException(int professorId) {
		this.professorId = professorId;
	}

	/**
	 * Getter Method
	 * @return the professorId
	 */
	public int getProfessorId() {
		return professorId;
	}
	
	/**
	 * Message returned when Exception is thrown
	 */
	@Override
	public String getMessage() {
		return "\t\tProfesser with Professor Id: " + professorId + " not found.";
	}
}

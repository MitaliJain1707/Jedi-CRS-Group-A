/**
 * 
 */
package com.flipkart.exception;


@SuppressWarnings("serial")
public class StudentNotFoundException extends Exception {
	private int studentId;

	/**
	 * @param studentId
	 */
	public StudentNotFoundException(int studentId) {
		this.studentId = studentId;
	}


	public StudentNotFoundException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Getter Method
	 * @return the studentId
	 */
	public int getStudentId() {
		return studentId;
	}
	
	/**
	 * Message returned when Exception is thrown
	 */
	@Override
	public String getMessage() {
		return "\t\tStudent with Student Id: " + studentId + " is not found.";
	}
}

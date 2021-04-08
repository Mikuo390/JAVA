/**
 * 
 */
package com.abc.hrmis.exception;

/**
 * 
 * HRMIS系统基础异常
 * 
 * @author 15159
 *
 */
public class HRMISException extends RuntimeException {

	/**
	 * 
	 */
	public HRMISException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public HRMISException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public HRMISException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public HRMISException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public HRMISException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}

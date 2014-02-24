/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lrl.c1.util;

//import com.google.api.ads.dfp.axis.v201308.ApplicationException;

import javax.ejb.ApplicationException;


public class ErrorMessage {
	private String className;
	private String message;
	private String apiMessage;
	private String error;

	public ErrorMessage() {}
	public ErrorMessage(Exception e) {
		className = e.getClass().getName();
		message = e.getMessage();
		if (e instanceof ApplicationException) {
			apiMessage = ((ApplicationException)e).toString();//.getMessage();
		}
		error = e.toString();
	}

	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getApiMessage() {
		return apiMessage;
	}
	public void setApiMessage(String apiMessage) {
		this.apiMessage = apiMessage;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}

}


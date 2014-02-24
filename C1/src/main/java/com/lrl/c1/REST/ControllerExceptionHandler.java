/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lrl.c1.REST;

/**
 *
 * @author logic
 */
//package com.c1x.cis.controller;

import com.lrl.c1.util.ErrorMessage;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

//import com.c1x.cis.api.model.ErrorMessage;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(Exception.class)
	public @ResponseBody ErrorMessage exception(Exception e) {
		return new ErrorMessage(e);
	}
}

package br.com.ficticiusClean.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.ficticiusClean.model.response.ToResult;

public class BaseController {

	protected ResponseEntity<Object> retorno(HttpStatus httpStatus, ToResult toResult) {

		if (toResult.getErrors() != null)
			httpStatus = HttpStatus.BAD_REQUEST;

		toResult.setStatus(httpStatus.value());
		toResult.setStatus_message(httpStatus.name());

		return new ResponseEntity<Object>(toResult, httpStatus);
	}

}

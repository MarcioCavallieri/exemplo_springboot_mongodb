package com.marciocavallieri.workshopmongodb.recursos;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.marciocavallieri.workshopmongodb.servicos.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	//Vai interceptar alguma exceção do tipo passado no parâmetro, montando um objeto StandardError
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound (ObjectNotFoundException e, HttpServletRequest request) {
		String erro = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError se = new StandardError(Instant.now(), status.value(), erro, e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(se);
	}
}

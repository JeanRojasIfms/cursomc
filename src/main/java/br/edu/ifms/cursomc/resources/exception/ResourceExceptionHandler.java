package br.edu.ifms.cursomc.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.edu.ifms.cursomc.services.exception.ObjectNotFoundException;

/* Manipulador de erros 
 * Classe auxiliar que irá interceptar as exceções */

@ControllerAdvice
public class ResourceExceptionHandler {
	
	// o método recebe a exceção q já explodiu
	// HttpServletRequest request --> informações da requisição
	@ExceptionHandler(ObjectNotFoundException.class) // anotação indica q é um tratador desse tipo de exceção
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}

}

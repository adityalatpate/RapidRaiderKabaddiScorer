package com.rapidraider.advice;

import java.util.NoSuchElementException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.rapidraider.exception.EmptyInputException;

@ControllerAdvice
public class MyControllerAdvice extends ResponseEntityExceptionHandler{
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElement(NoSuchElementException noSuchElementException){
		return new ResponseEntity<String>("No value present in DB,please change your request", HttpStatus.NOT_FOUND);
	
	}
@Override
protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
		HttpHeaders headers, HttpStatusCode status, WebRequest request) {
	
	return new ResponseEntity<Object>("please change http method type", HttpStatus.METHOD_NOT_ALLOWED);
}
}





/*@RestController : is the base annotation for classes that handle REST operations.

@ControllerAdvice : The @ControllerAdvice annotation handles exceptions globally – it allows you to use the same ExceptionHandler
for multiple controllers. This way, we can define how to treat an exception in just one place because this handler will be called
whenever the exception is thrown from classes that are covered by ControllerAdvice.
as the name suggests, is “Advice” for multiple controllers.
allows our class to be a global interceptor of exceptions thrown by methods annotated by @RequestMapping.


@ExceptionHandler  : Spring annotation that provides a mechanism to treat exceptions that are thrown during execution of handlers 
(Controller operations). This annotation, if used on methods of controller classes, will serve as the entry point for handling exceptions
 thrown within this controller only. 

Altogether, the most common way is to use @ExceptionHandler on methods of @ControllerAdvice classes so that the exception handling will be
applied globally or to a subset of controllers.


@ExceptionHandler and @ControllerAdvice are used to define a central point for treating exceptions and wrapping them up in a class.*/
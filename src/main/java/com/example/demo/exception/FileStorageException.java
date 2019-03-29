package com.example.demo.exception;



/*
 *
 * Class des exception dans le cas oû un inprévus est retenus ou detecté
 * La FileStorageServiceclasse jette quelques exceptions en cas de situations imprévues
 * 
 * */
public class FileStorageException extends RuntimeException{

	public FileStorageException(String message) {
	        super(message);
	    }

	    public FileStorageException(String message, Throwable cause) {
	        super(message, cause);
	    }
}

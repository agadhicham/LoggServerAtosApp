package com.example.demo.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
 * Cette annotation de role de dire au démarage de spring que le fichier utilisateur 
 * recontre un erreur va envoyer un HTTP response au client 404 
 * */
@ResponseStatus(HttpStatus.NOT_FOUND)
/*
*
* Class des exception dans le cas oû un inprévus est retenus ou detecté
* Il est jeté lorsqu'un fichier que l'utilisateur tente de télécharger est introuvable.
* 
* */
public class MyFileNotFoundException extends RuntimeException{
    public MyFileNotFoundException(String message) {
        super(message);
    }

    public MyFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

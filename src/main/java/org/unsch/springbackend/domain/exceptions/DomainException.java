package org.unsch.springbackend.domain.exceptions;

/**
 * Excepción base del dominio - Representa errores de negocio
 */
public class DomainException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;

    public DomainException(String message) {
        super(message);
    }

    public DomainException(String message, Throwable cause) {
        super(message, cause);
    }
}


package org.repinskie.service.exception;
/**
 * Exception throws when an error occurs in DAO operations.
 */
public class DAOException extends RuntimeException {
    public DAOException(Throwable throwable){
        super(throwable);
    }
}

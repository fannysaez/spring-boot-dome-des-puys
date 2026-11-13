package fr.simplon.domedespuys.Exception;

public class InvalidAddressException extends RuntimeException {
    public InvalidAddressException() {
        super("L'adresse renseignée est invalide");
    }
}
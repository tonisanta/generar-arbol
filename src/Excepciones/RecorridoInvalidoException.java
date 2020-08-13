package Excepciones;

/**
 * Excepción que se produce cuando los recorridos pasados no son válidos
 */
public class RecorridoInvalidoException extends Exception {
    public RecorridoInvalidoException(String errorMessage) {
        super(errorMessage);
    }
}
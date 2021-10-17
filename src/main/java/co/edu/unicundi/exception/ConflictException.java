package co.edu.unicundi.exception;

/**
 * Excepcion personalizada que se dispara cuando se actualiza o crea una persona
 * con una identificacion que ya existe
 *
 * @author Tatiana Ramos Villanueva
 * @author Nicolás Nieto Cárdenas
 * @version 2.0.1
 * @since 1.0.0
 */
public class ConflictException extends Exception {

    /**
     * Constructor de la clase ConflictException
     *
     * @param conflict
     */
    public ConflictException(String conflict) {
        super(conflict);
    }

}

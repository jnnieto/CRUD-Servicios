package co.edu.unicundi.exception;

/**
 * Excepcion personalizada que se dispara cuando se realiza la busqueda de una
 * persona con una identificacion que no existe en la base de datos
 *
 * @author Tatiana Ramos Villanueva
 * @author Nicolás Nieto Cárdenas
 * @version 2.0.1
 * @since 1.0.0
 */
public class PersonNotFoundException extends Exception {

    /**
     * Constructor de la clase PersonNotFoundException
     *
     * @param message
     */
    public PersonNotFoundException(String message) {
        super(message);
    }

}

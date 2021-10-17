package co.edu.unicundi.exception;

import java.util.HashMap;

/**
 * Excepcion personalizada que se dispara cuando ocurren algunos errores al
 * momento de crear o actualizar una persona
 *
 * @author Tatiana Ramos Villanueva
 * @author Nicolás Nieto Cárdenas
 * @version 2.0.1
 * @since 1.0.0
 */
public class ConstraintException extends Exception {

    /**
     * Constructor de la clase ConstraintException
     *
     * @param errores
     */
    public ConstraintException(HashMap<String, String> errores) {
        super(errores.toString());
    }

}

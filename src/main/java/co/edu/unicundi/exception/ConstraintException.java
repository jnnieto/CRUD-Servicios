/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.exception;

import java.util.HashMap;

/**
 *
 * @author nicon
 */
public class ConstraintException extends Exception {

    public ConstraintException(HashMap<String, String> errores) {
        super(errores.toString());
    }
    
}

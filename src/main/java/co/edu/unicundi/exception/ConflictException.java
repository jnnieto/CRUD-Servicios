/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.exception;

/**
 *
 * @author nicon
 */
public class ConflictException extends Exception {

    public ConflictException(String conflict) {
        super(conflict);
    }
    
}
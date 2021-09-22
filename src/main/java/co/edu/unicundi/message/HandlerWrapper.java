/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.message;

import javax.ws.rs.core.Response;

/**
 *
 * @author nicon
 */
public class HandlerWrapper {
    
    public MessageWrapper toResponse(int code, Response.Status status, String url) {
        
        MessageWrapper msg = new MessageWrapper();
        
        switch(code) {
            case 200:
                if (url.equalsIgnoreCase("/eliminarPorId/{identification}")) {
                    msg = new MessageWrapper(code, status, "La persona se eliminó correctamente", url);
                    break;
                }
            case 404:
                msg = new MessageWrapper(code, status, "Persona no encontrada", url);
                break;
            case 409:
                msg = new MessageWrapper(code, status, "Ya existe una persona con la misma identificación", url);
                break;
            default:
                msg = new MessageWrapper(code, status, "Proceso realizado satisfactoriamente", url);
        }
        return msg;
    }
    
}

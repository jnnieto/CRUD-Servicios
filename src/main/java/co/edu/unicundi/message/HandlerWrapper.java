package co.edu.unicundi.message;

import javax.ws.rs.core.Response;

/**
 * Clase que maneja las respuestas proporcionadas por la API
 *
 * @author Tatiana Ramos Villanueva
 * @author Nicolás Nieto Cárdenas
 * @version 1.1.0
 * @since 1.0.0
 */
public class HandlerWrapper {
    
    /**
     * Método que obtiene el código, estado y url del controlador
     * y retorna la envoltura que se enviará como respuesta
     * @param code el código de la respuesta
     * @param status el estado de la repuesta
     * @param url la url del servicio
     * @return la envoltura que se enviará como respuesta
     */
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

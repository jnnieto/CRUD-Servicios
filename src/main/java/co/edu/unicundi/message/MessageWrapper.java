package co.edu.unicundi.message;

import java.util.Date;
import javax.ws.rs.core.Response;

/**
 * Clase que se usa como una envoltura que maneja las respuestas de los servicios
 *
 * @author Tatiana Ramos Villanueva
 * @author Nicolás Nieto Cárdenas
 * @version 1.1.0
 * @since 1.0.0
 */
public class MessageWrapper {
    
    /**
     * Variable de tipo entero que almacena el código de la respuesta
     */
    private int code;
    
    /**
     * Variable de tipo Response.Status que almacena el estado de la respusta
     */
    private Response.Status status;
    
    /**
     * Variable de tipo String que almacena el mensaje que se enviará en la respuesta
     */
    private String message;
    
    /**
     * Variable de tipo String que almacena la fecha de la respuesta
     */
    private String date;
    
    /**
     * Variable de tipo String la URL del endpoint del servicio pedido
     */
    private String url;

    /**
     * Contructor vacío de la clase MessageWrapper
     */
    public MessageWrapper() {
    }

    /**
     * Constructor sobrecargado de la clase MessageWrapper
     * @param code
     * @param status
     * @param message
     * @param url 
     */
    public MessageWrapper(int code, Response.Status status, String message, String url) {
        this.code = code;
        this.status = status;
        this.message = message;
        this.date = new Date().toString();
        this.url = url;
    }

    /**
     * Método que obtiene el código de la envoltura
     * @return
     */
    public int getCode() {
        return code;
    }

    /**
     * Método que asigna el código a la envoltura
     * @param code
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * Método que obtiene el estado de la envoltura
     * @return
     */
    public Response.Status getStatus() {
        return status;
    }

    /**
     * Método que asigna el estado a la envoltura
     * @param status 
     */
    public void setStatus(Response.Status status) {
        this.status = status;
    }

    /**
     * Método que obtiene el mensaje de la envoltura
     * @return
     */
    public String getMessage() {
        return message;
    }

    /**
     * Método que asigna el mensaje a la envoltura
     * @param message 
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Método que obtiene la fecha de la envoltura
     * @return
     */
    public String getDate() {
        return date;
    }

    /**
     * Método que asigna la fecha a la envoltura
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Método que obtiene la URL de la envoltura
     * @return
     */
    public String getUrl() {
        return url;
    }

    /**
     * Método que asigna la URL a la envoltura
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.message;

import java.util.Date;
import javax.ws.rs.core.Response;

/**
 *
 * @author nicon
 */
public class MessageWrapper {
    
    private int code;
    
    private Response.Status status;
    
    private String message;
    
    private String date;
    
    private String url;

    public MessageWrapper() {
    }

    public MessageWrapper(int code, Response.Status status, String message, String url) {
        this.code = code;
        this.status = status;
        this.message = message;
        this.date = new Date().toString();
        this.url = url;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Response.Status getStatus() {
        return status;
    }

    public void setStatus(Response.Status status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}

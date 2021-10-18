package co.edu.unicundi.message;

import co.edu.unicundi.exception.ConflictException;
import co.edu.unicundi.exception.ConstraintException;
import co.edu.unicundi.exception.PersonNotFoundException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.NotAllowedException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.NotSupportedException;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.apache.commons.lang3.StringUtils;

/**
 * Clase que maneja las excepciones que se lanzan desde la clase
 * PersonController
 *
 * @author Tatiana Ramos Villanueva
 * @author Nicolás Nieto Cárdenas
 * @version 2.0.1
 * @since 1.0.0
 */
@Provider
public class HandlerException implements ExceptionMapper<Exception> {

    /**
     * Objeto que obtiene la información del request de la petición realizada
     */
    @Context
    private HttpServletRequest request;

    /**
     * Método que retorna una respuesta de tipo Response en caso de que exista
     * algun tipo de error al momento de hacer la petición
     *
     * @param exception
     * @return una respuesta con error
     */
    @Override
    public Response toResponse(Exception exception) {
        //exception.printStackTrace();
        MessageWrapper msg;
        
        String endpoint = request.getRequestURI();
        
        Response.Status status = Response.Status.BAD_REQUEST;

        if (exception instanceof PersonNotFoundException || exception instanceof NotFoundException) {
            status = Response.Status.NOT_FOUND;
        } 
        if (exception instanceof ConstraintException) {
            String value = exception.getMessage();
            value = StringUtils.substringBetween(value, "{", "}");
            String[] keyValuePairs = value.split(",");
            Map<String, String> map = new HashMap<>();

            for (String pair : keyValuePairs) {
                String[] entry = pair.split("=");
                map.put(entry[0].trim(), entry[1].trim());
            }

            return Response.status(Response.Status.BAD_REQUEST).entity(map).build();
            
        }
        if (exception instanceof ConflictException) {
            status = Response.Status.CONFLICT;
        } 
        if (exception instanceof NotAllowedException) {
            status = Response.Status.METHOD_NOT_ALLOWED;
        } 
        if (exception instanceof NotSupportedException) {
            status = Response.Status.UNSUPPORTED_MEDIA_TYPE;
        }
        if (exception instanceof InternalServerErrorException) {
            status = Response.Status.INTERNAL_SERVER_ERROR;
        }
        
        msg = new MessageWrapper(status.getStatusCode(), status, exception.getMessage(), endpoint);
        return Response.status(status).type(MediaType.APPLICATION_JSON).entity(msg).build();
        
    }

}

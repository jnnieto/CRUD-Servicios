package co.edu.unicundi.message;

import co.edu.unicundi.exception.ConflictException;
import co.edu.unicundi.exception.ConstraintException;
import co.edu.unicundi.exception.PersonNotFoundException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
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

        MessageWrapper msg;

        if (exception instanceof PersonNotFoundException) {
            msg = new MessageWrapper(Response.Status.NOT_FOUND.getStatusCode(), Response.Status.NOT_FOUND, exception.getMessage(), request.getRequestURI());
            return Response.status(Response.Status.NOT_FOUND).entity(msg).build();
        } else if (exception instanceof ConstraintException) {

            String value = exception.getMessage();
            value = StringUtils.substringBetween(value, "{", "}");
            String[] keyValuePairs = value.split(",");
            Map<String, String> map = new HashMap<>();

            for (String pair : keyValuePairs) {
                String[] entry = pair.split("=");
                map.put(entry[0].trim(), entry[1].trim());
            }

            return Response.status(Response.Status.BAD_REQUEST).entity(map).build();
        } else if (exception instanceof ConflictException) {
            msg = new MessageWrapper(Response.Status.CONFLICT.getStatusCode(), Response.Status.CONFLICT, exception.getMessage(), request.getRequestURI());
            return Response.status(Response.Status.CONFLICT).entity(msg).build();
        } else {
            msg = new MessageWrapper(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), Response.Status.INTERNAL_SERVER_ERROR, "", request.getRequestURI());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(msg).build();
        }

    }

}

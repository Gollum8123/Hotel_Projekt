package ch.anakin.hotel_projekt.service;

import ch.anakin.hotel_projekt.data.DataHandler;
import ch.anakin.hotel_projekt.model.Gast;
import ch.anakin.hotel_projekt.model.Hotel;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import java.util.Map;
import java.util.UUID;
import java.util.Vector;

/**
 * short description
 * <p>
 * service for gast
 * <p>
 * Hotel_Projekt
 *
 * @author Anakin Kirschler
 * @version 1.0
 * @since 12.03.20
 */
@Path("gast")
public class GaesteService {


    /**
     * List gaeste response.
     *
     * @param userRole the user role
     * @return the response
     */
    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)

    public Response listBooks(
            @CookieParam("userRole") String userRole
    ) {
        Map<String, Gast> gastMap = null;
        int httpStatus;
        if (userRole == null || userRole.equals("guest")) {
            httpStatus = 403;
        } else {
            httpStatus = 200;
            gastMap = DataHandler.getGastMap();
        }
        NewCookie cookie = new NewCookie(
                "userRole",
                userRole,
                "/",
                "",
                "Login-Cookie",
                600,
                false
        );
        Response response = Response
                .status(httpStatus)
                .entity(gastMap)
                .cookie(cookie)
                .build();
        return response;

    }

    /**
     * Search gast response.
     *
     * @param gastUUID the gastUUID
     * @param userRole the user role
     * @return the response
     */
    @GET
    @Path("search")
    @Produces(MediaType.APPLICATION_JSON)

    public Response readBook(
            @Pattern(regexp = "[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}")
            @QueryParam("uuid") String gastUUID,

            @CookieParam("userRole") String userRole
    ) {
        Gast gast = null;
        int httpStatus;
        if (userRole == null || userRole.equals("guest")) {
            httpStatus = 403;
        } else {
            gast = DataHandler.getGastMap().get(gastUUID);

            if (gast != null) {
                httpStatus = 200;
            } else {
                httpStatus = 404;
            }
        }
        NewCookie cookie = new NewCookie(
                "userRole",
                userRole,
                "/",
                "",
                "Login-Cookie",
                600,
                false
        );
        Response response = Response
                .status(httpStatus)
                .entity(gast)
                .cookie(cookie)
                .build();
        return response;
    }

    /**
     * Create gast response.
     *
     * @param gast     the gast
     * @param userRole the user role
     * @return the response
     */
    @POST
    @Path("create")
    @Produces(MediaType.TEXT_PLAIN)
    public Response createBook(
            @Valid @BeanParam Gast gast,
            @CookieParam("userRole") String userRole
    ) {
        int httpStatus;
        if (userRole != null && userRole.equals("admin")) {

            httpStatus = 200;

            gast.setGastUUID(UUID.randomUUID().toString());
            Map<String, Gast> gastMap = DataHandler.getGastMap();

            gastMap.put(gast.getGastUUID(), gast);
            DataHandler.writeGaeste(gastMap);


        } else {
            httpStatus = 403;
        }
        NewCookie cookie = new NewCookie(
                "userRole",
                userRole,
                "/",
                "",
                "Login-Cookie",
                600,
                false
        );
        Response response = Response
                .status(httpStatus)
                .entity("")
                .cookie(cookie)
                .build();
        return response;
    }

    /**
     * Delete book response.
     *
     * @param gastUUID the gastUUID
     * @param userRole the user role
     * @return the response
     */
    @DELETE
    @Path("delete")
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteBook(
            @Pattern(regexp = "[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}")
            @QueryParam("uuid") String gastUUID,

            @CookieParam("userRole") String userRole
    ) {
        int httpStatus;
        if (userRole != null && userRole.equals("admin")) {

            Map<String, Gast> gastMap = DataHandler.getGastMap();
            Gast gast = gastMap.get(gastUUID);
            if (gast != null) {
                httpStatus = 200;
                gastMap.remove(gastUUID);
                DataHandler.writeGaeste(gastMap);
            } else {
                httpStatus = 404;
            }
        } else {
            httpStatus = 403;
        }
        NewCookie cookie = new NewCookie(
                "userRole",
                userRole,
                "/",
                "",
                "Login-Cookie",
                600,
                false
        );
        Response response = Response
                .status(httpStatus)
                .entity("")
                .cookie(cookie)
                .build();
        return response;
    }


    /**
     * Update book response.
     *
     * @param gast     the gast
     * @param userRole the user role
     * @return the response
     */
    @PUT
    @Path("update")
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateBook(
            @Valid @BeanParam Gast gast,
            @CookieParam("userRole") String userRole
    ) {
        int httpStatus;
        if (userRole != null && userRole.equals("admin")) {

            Map<String, Gast> gastMap = DataHandler.getGastMap();
            if (gastMap.containsKey(gast.getGastUUID())) {
                gastMap.put(gast.getGastUUID(), gast);
                DataHandler.writeGaeste(gastMap);
                httpStatus = 200;
            } else {
                httpStatus = 404;
            }
        } else {
            httpStatus = 403;
        }
        NewCookie cookie = new NewCookie(
                "userRole",
                userRole,
                "/",
                "",
                "Login-Cookie",
                600,
                false
        );
        Response response = Response
                .status(httpStatus)
                .entity("")
                .cookie(cookie)
                .build();
        return response;
    }
}





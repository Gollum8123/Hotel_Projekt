package ch.anakin.hotel_projekt.service;

import ch.anakin.hotel_projekt.data.DataHandler;
import ch.anakin.hotel_projekt.model.Gast;
import ch.anakin.hotel_projekt.model.Hotel;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Vector;

/**
 * short description
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
     * @return the response
     */
    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)

    public Response listGaeste(
            @CookieParam("userRole") String userRole
    ){
        Vector<Gast> gastVector =null;
        int httpStatus;
        if (userRole == null || (!userRole.equals("admin") && !userRole.equals("user"))){
            httpStatus = 403;
        }else{
            httpStatus = 200;
            gastVector = new Hotel().getGaesteListe();
        }



        Response response = Response
                .status(httpStatus)
                .entity(gastVector)
                .build();
        return response;
    }

    /**
     * Search gast response.
     *
     * @param schluesselwort the schluesselwort
     * @return the response
     */
    @GET
    @Path("search")
    @Produces(MediaType.APPLICATION_JSON)

    public Response searchGast(
            @CookieParam("userRole") String userRole,
            @QueryParam("schluesselwort") String schluesselwort
    ) {
        Gast gast = null;
        int hattpStatus;
        if(userRole == null || (!userRole.equals("admin") && !userRole.equals("user"))){
           hattpStatus = 403;
        }else {
            try {
                gast = new Hotel().getGast(schluesselwort);
                if (gast != null) {
                    hattpStatus = 200;
                } else {
                    hattpStatus = 404;
                }

            } catch (IllegalArgumentException argEy) {
                hattpStatus = 400;
            }
        }

        Response response = Response
                .status(hattpStatus)
                .entity(gast)
                .build();
        return response;

    }

    /**
     * Create gast response.
     *
     * @param gast the gast
     * @return the response
     */
    @POST
    @Path("create")
    @Produces(MediaType.TEXT_PLAIN)

    public Response createGast(
        @CookieParam("userRole") String userRole,
        @Valid @BeanParam Gast gast
    ){
        int httpStatus;
        Hotel hotel = null;
        if ((userRole == null || (!userRole.equals("admin") && !userRole.equals("user")))){
            httpStatus = 403;
        }else {
            httpStatus = 200;
            hotel = new Hotel();
            hotel.getGaesteListe().add(gast);

            DataHandler.writeGaeste(hotel.getGaesteListe());
        }
        Response response = Response
                .status(httpStatus)
                .entity("")
                .build();
        return response;

    }

    /**
     * Delete book response.
     *
     * @param schluesselwort the schlüsselwort
     * @return the response
     */
    @DELETE
    @Path("delete")
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteBook(
            @CookieParam("userRole") String userRole,
            @QueryParam("schluesselwort") String schluesselwort
    ) {
        int httpStatus;
        if ((userRole == null || !userRole.equals("admin"))){
            httpStatus = 403;
        }else {
            try {
                Hotel hotel = new Hotel();
                Gast gast = hotel.getGast(schluesselwort);
                if (gast != null) {
                    httpStatus = 200;
                    hotel.getGaesteListe().remove(gast);
                    DataHandler.writeGaeste(hotel.getGaesteListe());
                } else {
                    httpStatus = 404;
                }
            } catch (IllegalArgumentException argEx) {
                httpStatus = 400;
            }
        }

        Response response = Response
                .status(httpStatus)
                .entity("")
                .build();
        return response;
    }


    /**
     * Update book response.
     *
     * @param gast          the gast
     * @return the response
     */
    @PUT
    @Path("update")
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateBook(
            @CookieParam("userRole") String userRole,
            @Valid @BeanParam Gast gast

    ) {
        int httpStatus;
        if ((userRole == null || !userRole.equals("admin"))){
            httpStatus = 403;
        }else {
            try {
                Hotel hotel = new Hotel();
                hotel.getGaesteListe().remove(hotel.getGast(gast.getVorname()));
                hotel.getGaesteListe().add(gast);
                if (gast != null) {
                    httpStatus = 200;

                    DataHandler.writeGaeste(hotel.getGaesteListe());
                } else {
                    httpStatus = 404;
                }
            } catch (IllegalArgumentException argEx) {
                httpStatus = 400;
            }
        }

        Response response = Response
                .status(httpStatus)
                .entity("")
                .build();
        return response;
    }
}





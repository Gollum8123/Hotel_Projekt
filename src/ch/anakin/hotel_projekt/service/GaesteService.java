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
 * @author TODO
 * @version 1.0
 * @since 12.03.20
 */

@Path("gast")
public class GaesteService {


    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)

    public Response listGaeste(){

        Vector<Gast> gastVector = new Hotel().getGaesteListe();

        Response response = Response
                .status(200)
                .entity(gastVector)
                .build();
        return response;
    }

    @GET
    @Path("search")
    @Produces(MediaType.APPLICATION_JSON)

    public Response searchGast(
            @QueryParam("schluesselwort") String schluesselwort
    ) {
        Gast gast = null;
        int hattpStatus;

        try{
            gast = new Hotel().getGast(schluesselwort);
            if (gast !=null){
                hattpStatus = 200;
            }else {
                hattpStatus = 404;
            }

        }catch (IllegalArgumentException argEy){
            hattpStatus = 400;
        }

        Response response = Response
                .status(hattpStatus)
                .entity(gast)
                .build();
        return response;

    }

    @POST
    @Path("create")
    @Produces(MediaType.TEXT_PLAIN)

    public Response createGast(
        @Valid @BeanParam Gast gast
    ){
        int httpStatus = 200;
        Hotel hotel = new Hotel();
        hotel.getGaesteListe().add(gast);

        DataHandler.writeBooks(hotel.getGaesteListe());

        Response response = Response
                .status(httpStatus)
                .entity("")
                .build();
        return response;

    }

    @DELETE
    @Path("delete")
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteBook(
            @QueryParam("schlüsselwort") String schlüsselwort
    ) {
        int httpStatus;
        try {
            Hotel hotel = new Hotel();
            Gast gast  = hotel.getGast(schlüsselwort);
            if (gast != null) {
                httpStatus = 200;
                hotel.getGaesteListe().remove(gast);
                DataHandler.writeBooks(hotel.getGaesteListe());
            } else {
                httpStatus = 404;
            }
        } catch (IllegalArgumentException argEx) {
            httpStatus = 400;
        }

        Response response = Response
                .status(httpStatus)
                .entity("")
                .build();
        return response;
    }


    @PUT
    @Path("update")
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateBook(
            @Valid @BeanParam Gast gast,
            @QueryParam("schlüsselwort") String schlüsselwort

    ) {
        int httpStatus;
        try {
            Hotel hotel = new Hotel();
            gast = hotel.getGast(schlüsselwort);
            if (gast != null) {
                httpStatus = 200;

                DataHandler.writeBooks(hotel.getGaesteListe());
            } else {
                httpStatus = 404;
            }
        } catch (IllegalArgumentException argEx) {
            httpStatus = 400;
        }

        Response response = Response
                .status(httpStatus)
                .entity("")
                .build();
        return response;
    }
}





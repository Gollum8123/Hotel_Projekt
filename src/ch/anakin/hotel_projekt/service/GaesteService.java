package ch.anakin.hotel_projekt.service;

import ch.anakin.hotel_projekt.model.Gast;
import ch.anakin.hotel_projekt.model.Hotel;
import jdk.nashorn.internal.objects.annotations.Getter;

import javax.validation.constraints.Pattern;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;
import java.util.ResourceBundle;
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

}

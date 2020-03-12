package ch.anakin.hotel_projekt.service;

import jdk.nashorn.internal.objects.annotations.Getter;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;
import java.util.ResourceBundle;

/**
 * short description
 * <p>
 * Hotel_Projekt
 *
 * @author TODO
 * @version 1.0
 * @since 12.03.20
 */

@Path("gaeste")
public class GaesteService {


    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)

    public Response listGaeste(){

        Response response = Response
                .status(200)
                .entity()
                .build();
        return response;
    }

}

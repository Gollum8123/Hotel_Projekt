package ch.anakin.hotel_projekt.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * short description
 * <p>
 * Hotel_Project
 *
 * @author Anakin Krischler
 */
@Path("test")
public class TestService {

    @GET
    @Path("test")
    @Produces(MediaType.APPLICATION_JSON)
    public Response test() {
        return Response
                .status(200)
                .entity("{\"Data\":\"foobar\"}")
                .build();
    }
}

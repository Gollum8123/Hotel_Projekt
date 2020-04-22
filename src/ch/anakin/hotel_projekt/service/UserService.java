package ch.anakin.hotel_projekt.service;

import ch.anakin.hotel_projekt.data.DataHandler;
import ch.anakin.hotel_projekt.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import java.awt.*;

/**
 * short description
 * <p>
 * Hotel_Projekt
 *
 * @author Anakin Kirschler
 * @version 1.0
 * @since 07.04.20
 */

@Path("user")
public class UserService {
    @POST
    @Path("login")
    @Produces(MediaType.TEXT_PLAIN)
    public Response login(
            @FormParam("benutzername") String username,
            @FormParam("passwort") String password
    ){
        int httpStautus;
        User user = DataHandler.readUser(username,password);
        if (user.getUserRole().equals("guest")){
            httpStautus = 404;
        }else {
            httpStautus = 200;
        }
        NewCookie cookie = new NewCookie(
                "userRole",
                user.getUserRole(),
                "/",
                "",
                "Login-Cookie",
                600,
                false
        );
        Response response = Response
                .status(httpStautus)
                .entity("")
                .cookie(cookie)
                .build();
        return response;
    }

    @DELETE
    @Path("logout")
    @Produces(MediaType.TEXT_PLAIN)
    public Response logout(){
        NewCookie cookie = new NewCookie(
                "userRole",
                "guest",
                "/",
                "",
                "Login-Cookie",
                1,
                false
        );
        Response response = Response
                .status(200)
                .entity("")
                .cookie(cookie)
                .build();
        return response;
    }
}

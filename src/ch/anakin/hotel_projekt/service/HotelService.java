package ch.anakin.hotel_projekt.service;

import ch.anakin.hotel_projekt.data.DataHandler;
import ch.anakin.hotel_projekt.model.Hotel;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import java.util.Map;
import java.util.UUID;

/**
 * short description
 * <p>
 * Hotel_Projekt
 *
 * @author TODO
 * @version 1.0
 * @since 22.04.20
 */
@Path("hotel")
public class HotelService {

    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)

    public Response listPublisher(
            @CookieParam("userRole") String userRole
    ) {
        Map<String, Hotel> hotellist = null;
        int httpStatus;
        if (userRole == null || userRole.equals("guest")) {
            httpStatus = 403;
        } else {
            httpStatus = 200;
            hotellist = DataHandler.getHotelMap();
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
                .entity(hotellist)
                .cookie(cookie)
                .build();
        return response;

    }

    /**
     * reads a publisher identified by its uuid
     *
     * @param hotelUUID the hotelUUID to be searched
     * @param userRole      the role of the current user
     * @return Response with publisher-object
     */
    @GET
    @Path("search")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readPublisher(
            @Pattern(regexp = "[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}")
            @QueryParam("uuid") String hotelUUID,
            @CookieParam("userRole") String userRole) {
        Hotel hotel = null;
        int httpStatus;
        if (userRole == null || userRole.equals("guest")) {
            httpStatus = 403;
        } else {
            hotel = DataHandler.getHotelMap().get(hotelUUID);

            if (hotel != null) {
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
                .entity(hotel)
                .cookie(cookie)
                .build();
        return response;

    }

    /**
     * creates a new publisher
     *
     * @param hotel a valid hotel
     * @param userRole  the role of the current user
     * @return Response
     */
    @POST
    @Path("create")
    @Produces(MediaType.TEXT_PLAIN)
    public Response createBook(
            @Valid @BeanParam Hotel hotel,
            @CookieParam("userRole") String userRole
    ) {
        int httpStatus;
        if (userRole != null && userRole.equals("admin")) {

            httpStatus = 200;

            hotel.setHotelUUID(UUID.randomUUID().toString());

            Map<String, Hotel> hotelMap = DataHandler.getHotelMap();

            hotelMap.put(hotel.getHotelUUID(), hotel);
            DataHandler.wirteHotel(hotelMap);

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
     * updates an existing publisher
     *
     * @param hotel a valid hotel
     * @param userRole  the role of the current user
     * @return Response
     */
    @PUT
    @Path("update")
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateBook(
            @Valid @BeanParam Hotel hotel,
            @CookieParam("userRole") String userRole
    ) {
        int httpStatus;
        if (userRole != null && userRole.equals("admin")) {

            Map<String, Hotel> hotelMap = DataHandler.getHotelMap();
            if (hotelMap.containsKey(hotel.getHotelUUID())) {
                hotelMap.put(hotel.getHotelUUID(), hotel);
                DataHandler.wirteHotel(hotelMap);
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

    @DELETE
    @Path("delete")
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteBook(
            @Pattern(regexp = "[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}")
            @QueryParam("uuid") String hotelUUID,

            @CookieParam("userRole") String userRole
    ) {
        int httpStatus;
        if (userRole != null && userRole.equals("admin")) {

            Map<String, Hotel> hotelMap = DataHandler.getHotelMap();
            Hotel hotel = hotelMap.get(hotelUUID);
            if (hotel != null) {
                httpStatus = 200;
                hotelMap.remove(hotelUUID);
                DataHandler.wirteHotel(hotelMap);
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

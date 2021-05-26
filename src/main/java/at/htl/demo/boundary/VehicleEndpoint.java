package at.htl.demo.boundary;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

@Path("/demo")
public class VehicleEndpoint {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String hello() {
        return """
               {
                  "brand":"Opel",
                  "type":"Admiral"
               }
               """;
    }

    @POST
    public Response post(@Context UriInfo uriInfo, String text) {
        System.out.println(text);
        URI uri = uriInfo.getAbsolutePathBuilder().path("42").build();
        return Response.created(uri).build();
    }
}
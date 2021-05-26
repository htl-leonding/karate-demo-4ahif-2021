package at.htl.demo.boundary;

import com.intuit.karate.junit5.Karate;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class VehicleEndpointTest {

    @Test
    @Disabled
    public void testHelloEndpoint() {
        given()
                .when().get("/demo")
                .then()
                .statusCode(200)
                .body(is("""
                        {
                           "brand":"Opel",
                           "type":"Admiral"
                        }
                        """));
    }

    @Karate.Test
    Karate testVehicle() {
        return Karate.run("vehicle").relativeTo(getClass());
    }

}
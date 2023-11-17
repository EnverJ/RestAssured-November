import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class getMap {
    @Test
    void getMaps() {

        // 1. specify baseURI

        RestAssured.baseURI = "https://maps.googleapis.com";
        // 2. Request specification-- Request Object
        RequestSpecification httpRequest = RestAssured.given();

        // 3.Response Object. in this response I AM GOING TO VALIDATE THE HEADER
        Response response = httpRequest.request(Method.GET, "/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s\n");

        // print response in console window. Response body normally coming  in Json format. So we need to use asString in order to print it. this step can be ignored in work
        String responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);

        // VERIFY THE HEADER--Capture of headers from response
        String contentType = response.header("Content-Type");
        System.out.println("Content-Type: " + contentType);
        Assert.assertEquals(contentType, "application/xml; charset=UTF-8");

        String contentEncoding = response.header("Content-Encoding");
        System.out.println("Content-Type: " + contentEncoding);
        Assert.assertEquals(contentEncoding, "gzip");

    }
}

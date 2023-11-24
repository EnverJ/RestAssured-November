import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.testng.Assert;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Data
@Slf4j
public class RequestParams {

    public static final String base = "https://reqres.in/api";
    @Getter
    @Setter
    private String pageNumber, pageName;
    private Boolean isValid = false, onePage = false;

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public void setPageNumber(String pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void getCalls(String Number) {
        RestAssured.baseURI = base;
        String filePath = "src/test/resources/getBody";
        String WriteSuccess = "Successfully wrote JSON response to file.";
        RequestSpecification httpRequest = RestAssured.given();

        Response response = httpRequest.request(Method.GET, "/users?page=" + Number);

        String responseBody = response.getBody().asString();
   //     log.info("Response Body: " + responseBody);
        System.out.println("responseBody = " + responseBody);

        String contentType = response.header("Content-Type");
   //     log.info("Content-Type: " + contentType);
        System.out.println("contentType = " + contentType);
        Assert.assertEquals(contentType, "application/json; charset=utf-8");

        String contentEncoding = response.header("Content-Encoding");
  //      log.info("Content-Encoding: " + contentEncoding);
        System.out.println("contentEncoding = " + contentEncoding);
        Assert.assertEquals(contentEncoding, "gzip");
        writeFile(responseBody,filePath,WriteSuccess);
    }

    public void PostCall(String key1, String value1, String key2, String value2) {
            RestAssured.baseURI = base;
            String filePath = "src/test/resources/postBody";
            String WriteSuccess = "Successfully wrote JSON response to file.";
            RequestSpecification httpRequest = RestAssured.given();

            // Request payload
            JSONObject requestParams = new JSONObject();
            requestParams.put(key1, value1);
            requestParams.put(key2, value2);

            // Add header
            httpRequest.header("Content-Type", "application/json");
            httpRequest.body(requestParams.toString()); // Attach data to the request

            // Response object
            Response response = httpRequest.request(Method.POST, "api/users");

            // Print response
            String responseBody = response.getBody().asString();
            log.info("Response Body: " + responseBody);

            // Verify status code
            int statusCode = response.getStatusCode();
            log.info("Status Code: " + statusCode);
            Assert.assertEquals(statusCode, 201);

            // Verify success code
            String successCode = response.jsonPath().get("SuccessCode");
            log.info("Success Code: " + successCode);
            writeFile(responseBody,filePath,WriteSuccess);

    }

    public void getUserInfo(String number) {
        RestAssured.baseURI = base;
        String filePath = "src/test/resources/getUserInfo";
        String WriteSuccess = "Successfully wrote JSON response to file.";

        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET,"/users?page=" + number);

        String responseBody = response.getBody().asString();
        System.out.println("responseBody = " + responseBody);

        int statusCode = response.statusCode();
        System.out.println("statusCode = " + statusCode);
        Assert.assertEquals(statusCode,200);

        String statusLine = response.statusLine();
        System.out.println("statusLine = " + statusLine);
        Assert.assertEquals(statusLine,"HTTP/1.1 200 OK");

        writeFile(responseBody,filePath,WriteSuccess);


    }
    public  void getWeatherDetails() {
        RestAssured.baseURI = "https://maps.googleapis.com";
        String filePath = "src/test/resources/weatherDetails";
        String WriteSuccess = "Successfully wrote JSON response to file.";

        RequestSpecification httpRequest = RestAssured.given();

        Response response = httpRequest.request(Method.GET, "/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s\\n");

        String responseBody = response.getBody().asString();
        System.out.println("responseBody = " + responseBody);

        Headers  allHeaders = response.getHeaders();
        for (Header header:allHeaders) {
            System.out.println("header = " + header.getValue());
        }
        writeFile(responseBody,filePath,WriteSuccess);


    }
    public void readJsonBodyPost(String SourceFilepath) {
        RestAssured.baseURI = base;
        String filePath = "src/test/resources/postBody";
        String WriteSuccess = "Successfully wrote JSON response to file.";
        String jsonBody = null;
        try {
            jsonBody = readJsonBody(SourceFilepath);
        } catch (IOException e) {
            System.out.println("source file dose not exist");
        }
        RequestSpecification httpRequest = RestAssured.given();

        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(jsonBody);
        Response response = httpRequest.request(Method.POST, "api/users");

        String responseBody = response.getBody().asString();
        log.info("Response Body: " + responseBody);
        System.out.println("responseBody = " + responseBody);

        int statusCode = response.getStatusCode();
        log.info("Status Code: " + statusCode);
        Assert.assertEquals(statusCode, 201);

        // Verify success code
        String successCode = response.jsonPath().get("SuccessCode");
        log.info("Success Code: " + successCode);
        writeFile(responseBody,filePath,WriteSuccess);



    }

    public String readJsonBody(String filePath) throws IOException {
         return new String(Files.readAllBytes(Paths.get(filePath)));
    }
    public void writeFile(String responseBody, String filePath, String WriteSuccess) {
        try(FileWriter fileWriter = new FileWriter(filePath)){
            fileWriter.write(responseBody);
            System.out.println( WriteSuccess);
        }catch (IOException E){
            System.out.println("An error occur while json writing to the file");
            E.printStackTrace();
        }
    }
}

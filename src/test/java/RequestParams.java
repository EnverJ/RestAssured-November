import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.groovy.transform.SourceURIASTTransformation;
import org.json.JSONObject;
import org.testng.Assert;

import java.io.FileWriter;
import java.io.IOException;

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

    public void PostCall(String key1, String value1, String key2, String value2) throws IOException {
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

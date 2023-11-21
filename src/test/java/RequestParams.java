import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.json.JSONObject;
import org.testng.Assert;

@Data
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

    public void getMaps(String Number) {
        RestAssured.baseURI=base;
        RequestSpecification httpRequest = RestAssured.given();

        Response response = httpRequest.request(Method.GET, "/users?page=" + Number);

        String responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);

        String contentType = response.header("Content-Type");
        System.out.println("Content-Type: " + contentType);
        Assert.assertEquals(contentType, "application/json; charset=utf-8");

        String contentEncoding = response.header("Content-Encoding");
        System.out.println("Content-Encoding: " + contentEncoding);
        Assert.assertEquals(contentEncoding, "gzip");
    }

    public void getPosts(String key, String value) {
        RestAssured.baseURI=base;
        RequestSpecification postRequest = RestAssured.given();
        // 3.Response Object
        JSONObject requestParams = new JSONObject();
        //request payload sending along with post request
        requestParams.put(key,value);
        requestParams.put(key,value);
        // add header
        postRequest.header("Conten-Type","application/json");
        postRequest.body(requestParams.toString());  // attach above data to the param
        // response object
        Response response=postRequest.request(Method.POST,"api/users");

        // print response in console window. Response body normally coming in Json format. So we need to use asString in order to print it. this step can be ignored in work
        String responseBody=response.getBody().asString();
        System.out.println("Response Body: "+responseBody);

        // Verify status code and Status line
        int statusCode=response.getStatusCode();
        System.out.println("Status Code: "+statusCode);
        Assert.assertEquals(statusCode,201);


        // verify success conde
        String successCode=response.jsonPath().get("SuccessCode");
        System.out.println("Success Code: "+successCode);
    }
}

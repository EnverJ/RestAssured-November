import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;

@Data
public class RequestParams {
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
        RestAssured.baseURI = "https://reqres.in/api";
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

    public void getPosts() {

    }
}

import lombok.NonNull;
import org.testng.annotations.DataProvider;

public class baseTest {
    public static final String uuid = "xxxx";
    public static String inputMessage;
    public RequestParams params;

    public baseTest() {
        this.params = new RequestParams();
    }

    @DataProvider(name = "pagesNumber")
    public Object[][] getPagesNumber() {
        return new Object[][]{
                {"1"},
                {"2"}
        };
    }

    @DataProvider(name = "postMethodValues")
    public Object[][] postnewUser() {
        return new Object[][]{
                {"name", "ezmet","Job", "Developer"},

        };

    }

}

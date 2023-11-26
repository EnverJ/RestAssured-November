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
    @DataProvider(name = "userId")
        public Object[][] userId() {
            return new Object[][]{
                    {"1"}
            };
    }

    @DataProvider(name = "postMethodValues")
    public Object[][] postnewUser() {
        return new Object[][]{
                {"name", "ezmet","Job", "Developer"},

        };

    }
    @DataProvider(name = "postCallMap")
    public Object[][] postnewUserMap() {
        return new Object[][]{
                {"name", "ezmet"},
                {"Job", "Developer"},

        };

    }
    //validateUsers
    @DataProvider(name = "validateUsers")
    public Object[][] getValidateUsers() {
        return new Object[][]{
                {"2"}


        };

    }
    // src/test/resources/input/employeeData

    @DataProvider(name = "postCallInputFilePath")
    public Object[][] postnewUserMapInput() {
        return new Object[][]{
                {"src/test/resources/input/employeeData"}

        };

    }

}

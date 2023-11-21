import org.testng.annotations.Test;

public class mapTest extends baseTest {
    @Test(enabled = true, dataProvider = "pagesNumber")
   public void checkGet(String days) {
    params.getMaps(days);
    }


    @Test(enabled = true, dataProvider = "postMethodValues")
    public void postRequest(String key, String value) {
        params.getPosts(key, value);
    }
}

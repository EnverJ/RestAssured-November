import org.testng.annotations.Test;

import java.io.IOException;

public class mapTest extends baseTest {
    @Test(enabled = true, dataProvider = "pagesNumber")
   public void GetRequest(String days) {
    params.getCalls(days);
    }


    @Test(enabled = true, dataProvider = "postMethodValues")
    public void postRequest(String key, String value,String key2, String value2) throws IOException {
        params.PostCall(key, value, key2, value2);
    }
}

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class mapTest extends baseTest {
    @Test(enabled = true, dataProvider = "pagesNumber")
   public void GetRequest(String days) {
    params.getCalls(days);
    }
   @Test(enabled = true, dataProvider = "userId")
    public void getUserInfo(String userId) {
       params.getUserInfo(userId);
   }
   @Test(enabled = true)
   public void getWeatherInfo() {
        params.getWeatherDetails();
   }

    @Test(enabled = true, dataProvider = "postMethodValues")
    public void postRequest(String key, String value,String key2, String value2){
        params.PostCall(key, value, key2, value2);
    }
    @Test(enabled = true, dataProvider = "validateUsers")
    public  void validateUser(String page) {
        params.validateAllJsonValue(page);
    }
    @Test(enabled = true, dataProvider = "postCallInputFilePath")
     public  void postInputFile(String filepath) {
        params.readJsonBodyPost(filepath);
     }

}

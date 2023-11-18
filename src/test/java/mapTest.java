import org.testng.annotations.Test;

public class mapTest extends baseTest {
    @Test(enabled = true, dataProvider = "pagesNumber")
   public void checkGet(String days) {
    params.getMaps(days);
    }
}

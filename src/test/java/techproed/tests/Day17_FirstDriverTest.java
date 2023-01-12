package techproed.tests;

import org.testng.annotations.Test;
import techproed.utilities.Driver;

public class Day17_FirstDriverTest  {

    @Test
    public void firstDriverTest(){
//   driver -->  Driver.getDriver();
        Driver.getDriver().get("https://techproeducation.com/");

//      close driver
        Driver.closeDriver();//make the driver null so we can make it again when

    }
}

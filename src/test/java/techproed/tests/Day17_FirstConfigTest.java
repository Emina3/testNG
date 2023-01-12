package techproed.tests;

import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Day17_FirstConfigTest {
    //Go to techproed homepage
    //Assert title

    @Test
    public void firstConfigTest(){
        //Go to techproed homepage
       // Driver.getDriver().get("https://techproeducation.com/");
        Driver.getDriver().get(ConfigReader.getProperty("url_prod_techproed"));
        System.out.println(Driver.getDriver().getTitle());

        //Assert the title

 //       System.out.println("Actual Title  = " + Driver.getDriver().getTitle());//we got the title and add to config.properties file
 //       assertEquals("Techpro Education | Online It Courses & Bootcamps", Driver.getDriver().getTitle());//Hard coding
        assertEquals(ConfigReader.getProperty("app_title"), Driver.getDriver().getTitle());//Recomended

    }
}

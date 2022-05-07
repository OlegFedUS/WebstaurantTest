import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.w3c.dom.Text;

import java.time.Duration;
import java.util.List;
import java.util.Locale;

public class WebstaurantTest {

    @Test
    public void WebTest(){

            System.setProperty("webdriver.chrome.driver", "c:\\program files\\google\\chrome\\application\\chromedriver.exe");

            WebDriver driver = new ChromeDriver();

        try {

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();





            driver.get("https://www.webstaurantstore.com/");

            driver.findElement(By.id("searchval")).sendKeys("stainless work table\n");

            List<WebElement> tabels = driver.findElements(By.id("product_listing"));
            for (int i = 0; i < tabels.size(); i++){
                Assert.assertNotEquals(tabels.size(), 0);
                Assert.assertTrue(tabels.get(i).getText().toLowerCase().contains("table"));
                System.out.println();
            }

        }

        finally {
           driver.quit();
        }

    }

}

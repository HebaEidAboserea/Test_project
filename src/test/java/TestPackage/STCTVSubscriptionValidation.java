package TestPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class STCTVSubscriptionValidation {
    public static void main(String[] args) {
        // Set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");

        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the STC TV subscription page
        driver.get("https://subscribe.stctv.com/");

        // Find the subscription packages section
        //WebElement packagesSection = driver.findElement(By.xpath("//*[@id=\'main\']/div/div[2]"));
        WebElement packagesSection = driver.findElement(By.xpath("//*[@id='country-selct']"));
        // Extract the subscription package information for each country
        WebElement egyptPackage = packagesSection.findElement(By.xpath("//*[@id=\'eg\']"));
        String egyptPackageType = egyptPackage.findElement(By.xpath("//*[@id=\'main\']/div/div[1]")).getText();
        String egyptPackagePrice = egyptPackage.findElement(By.xpath("//*[@id=\'main\']/div/div[2]")).getText();
        String egyptPackageCurrency = egyptPackage.findElement(By.xpath("//*[@id=\'main\']/div/div[3]")).getText();

        WebElement jordanPackage = packagesSection.findElement(By.xpath("//*[@id=\'jo\']"));
        String jordanPackageType = jordanPackage.findElement(By.xpath("//*[@id=\'main\']/div/div[1]")).getText();
        String jordanPackagePrice = jordanPackage.findElement(By.xpath("//*[@id=\'main\']/div/div[2]")).getText();
        String jordanPackageCurrency = jordanPackage.findElement(By.xpath("//*[@id=\'main\']/div/div[3]")).getText();

        WebElement uaePackage = packagesSection.findElement(By.xpath("//*[@id=\'ae\']"));
        String uaePackageType = uaePackage.findElement(By.xpath("//*[@id=\'main\']/div/div[1]")).getText();
        String uaePackagePrice = uaePackage.findElement(By.xpath("//*[@id=\'main\']/div/div[2]")).getText();
        String uaePackageCurrency = uaePackage.findElement(By.xpath("//*[@id=\'main\']/div/div[3]")).getText();

        // Print the extracted information for each country
        System.out.println("Egypt Package: " + egyptPackageType + " - " + egyptPackagePrice + " " + egyptPackageCurrency);
        //Assert.assertEquals(egyptPackageType , "7.00");
        Assert.assertTrue(egyptPackageType.contentEquals("7.00 Egyptian pound/month"));
        Assert.assertTrue(egyptPackagePrice.contentEquals("0.5 USD/month"));
        Assert.assertTrue(egyptPackageCurrency.contentEquals("5.33USD/month"));

        System.out.println("Jordan Package: " + jordanPackageType + " - " + jordanPackagePrice + " " + jordanPackageCurrency);
        //validations
        Assert.assertTrue(jordanPackageType.contentEquals("0.99 JOD/week"));
        Assert.assertTrue(jordanPackagePrice.contentEquals("5.2 USD/month"));
        Assert.assertTrue(jordanPackageCurrency.contentEquals("Аvailable"));
        System.out.println("UAE Package: " + uaePackageType + " - " + uaePackagePrice + " " + uaePackageCurrency);
        Assert.assertTrue(uaePackageType.contentEquals("10.00 AED/week"));
        Assert.assertTrue(uaePackagePrice.contentEquals("10.9 USD/month"));
        Assert.assertTrue(uaePackageCurrency.contentEquals("Аvailable"));

        // Close the browser
        driver.quit();
    }
}

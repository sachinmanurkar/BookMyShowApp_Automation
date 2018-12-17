package Steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePage {


    private AppiumDriver appiumDriver;

    @Given("^I launch the book my show App$")
    public void iLaunchBookMyShowApp() throws Throwable {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium version", "6.1");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Moto");
        capabilities.setCapability("app", System.getProperty("user.dir") + "/app/com.bt.bms_2018-12-07.apk");
        capabilities.setCapability("appPackage", "com.bt.bms");
        capabilities.setCapability("automationName", "UiAutomator2");
//      capabilities.setCapability("noReset", "true");
//      capabilities.setCapability("fullReset", "false");
        appiumDriver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        appiumDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

    }

    @Then("^Select the language as English$")
    public void selectLanguageAsEnglish() throws Throwable {
        appiumDriver.findElement(By.id("com.bt.bms:id/language_english")).click();
//        System.out.println("The size is " +values.size());
//        for(WebElement value :  values){
//            if(value.getText().contains(language)){
//                value.click();
//            }
//        }
        appiumDriver.findElement(By.id("com.bt.bms:id/bottom_rel_layout")).click();
    }

    @And("^Click on skip button$")
    public void clickOnSkipButton() throws Throwable {
        appiumDriver.findElement(By.id("com.bt.bms:id/launcher_tv_for_skip")).click();
    }

    @Then("^Click on allow app to access device location")
    public void allowApptoAccessDeviceLocation() throws Throwable {
        appiumDriver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
        appiumDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Then("^Click on search icon on HomePage$")
    public void clickOnSearchIconOnHomePage() throws Throwable {
        List<WebElement> elements = appiumDriver.findElements(By.id("com.bt.bms:id/view_bottom_item_iv"));
        System.out.println("Size is" + elements.size());
        elements.get(1).click();
    }

    @And("^I search for \"([^\"]*)\" under search movie$")
    public void iSearchForMovie(String moviename) throws Throwable {
        appiumDriver.findElement(By.id("com.bt.bms:id/search_src_text")).click();
        appiumDriver.findElement(By.id("com.bt.bms:id/search_src_text")).sendKeys("2.0");
        List<WebElement> elements = appiumDriver.findElements(By.id("com.bt.bms:id/title_container"));
        System.out.println("The size is " + elements.size());
        elements.get(0).click();
//        for (WebElement element : elements) {
//            if (element.getText().contains(moviename)) {
//                element.click();
//                break;
//            }
    }

    @Then("^Verify the Page is displayed with selected movie name \"([^\"]*)\"$")
    public void verifyThePageIsSelectedWithSelectedMovieName(String moviename) throws Throwable {
        String element = appiumDriver.findElement(By.id("com.bt.bms:id/movie_details_activity_text_movie_name")).getText();
        Assert.assertTrue("The Page Contains Selected Movie Name", element.contains(moviename));
    }

    @Then("^Click on Book Tickets Button$")
    public void clickOnBookTicketsButton() throws Throwable {
        appiumDriver.findElement(By.id("com.bt.bms:id/movie_details_activity_lin_bookticket")).click();
    }

    @Then("^Select language Hindi and screentype 3D$")
    public void selectLanguageHindiandFormat3D() throws Throwable {
//        List<WebElement> element = appiumDriver.findElements(By.xpath("//android.widget.TextView[@text ='3D']"));
//        System.out.println("Size is " + element.size());
        //element.get(1).click();

        appiumDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        List<WebElement> elements = appiumDriver.findElements(By.className("android.view.ViewGroup"));
        String language = "Hindi";
        String screenType = "3D";
        WebElement e1 = null;
        System.out.println("Size of elements: ------- " + elements.size());

        for (WebElement e : elements) {
           // if (e.findElement(By.className("android.widget.TextView")).isDisplayed() && e.findElement(By.className("android.widget.TextView")).getText().contains(language)) {
                e1 = e.findElements(By.className("android.view.ViewGroup")).stream().filter(e2 -> e2.getText().contains(screenType)).findFirst().orElse(null);
                break;
            }
        assert e1 != null;
        e1.click();
    }
}
package Steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.List;
import java.util.Set;
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
//      capabilities.setCapability("autoWebview", true);
//      capabilities.setCapability("noReset", "true");
//      capabilities.setCapability("fullReset", "false");
        appiumDriver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        appiumDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

    }

    @Then("^Select the language as English$")
    public void selectLanguageAsEnglish() throws Throwable {
        appiumDriver.findElement(By.id("com.bt.bms:id/language_english")).click();
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
        appiumDriver.findElement(By.id("com.bt.bms:id/search_src_text")).sendKeys(moviename);
        List<WebElement> elements = appiumDriver.findElements(By.id("com.bt.bms:id/title_container"));
        System.out.println("The size is " + elements.size());
        elements.get(0).click();
    }

    @Then("^Verify the Page is displayed with selected movie name \"([^\"]*)\"$")
    public void verifyThePageIsSelectedWithSelectedMovieName(String moviename) throws Throwable {
        String element = appiumDriver.findElement(By.id("com.bt.bms:id/movie_details_activity_text_movie_name")).getText();
        Assert.assertTrue("The Page Contains Selected Movie Name", element.contains(moviename));
    }

    @Then("^Click on Book Tickets Button$")
    public void clickOnBookTicketsButton() throws Throwable {
        appiumDriver.findElement(By.id("com.bt.bms:id/movie_details_activity_lin_bookticket")).click();
        appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(3000);
    }

    @Then("^Select language Hindi and screentype 3D$")
    public void selectLanguageHindiandFormat3D() throws Throwable {
        appiumDriver.findElement(By.xpath("//android.view.ViewGroup/android.widget.TextView[@text = '3D']")).click();
        appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Then("^Select the date \"([^\"]*)\"$")
    public void selectTheDate(int date) throws Throwable {
        appiumDriver.findElement(By.xpath("//android.widget.TextView[@text = " + date + "]")).click();
        appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Then("^Select the time \"([^\"]*)\"$")
    public void selectTheMovieTime(int time) throws Throwable {
        appiumDriver.findElement(By.xpath("//android.widget.TextView[@text = '06:35 PM']")).click();
        appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Then("^Accept terms and conditions$")
    public void acceptorRejectTermsAndConditions() throws Throwable {
        appiumDriver.findElement(By.xpath("//android.widget.TextView[@text = 'Accept']")).click();
        appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Then("Select the number of seats as \"([^\"]*)\"$")
    public void selectNumberOfSeatsAs(int numofseats) throws Throwable {
        appiumDriver.findElement(By.xpath("//android.widget.TextView[@text = " + numofseats + "]")).click();
        appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Then("^Click on Select Seats$")
    public void clickOnSelectSeats() throws Throwable {
        appiumDriver.findElement(By.xpath("//android.widget.TextView[@text = 'Select Seats']")).click();
        appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Then("^Check Wheather it is Webview or native \"([^\"]*)\"$")
    public void checkWheatherWebOrNative(String cont) throws Throwable {
        System.out.println("Before Switching context" + appiumDriver.getContext());
        Set<String> context = appiumDriver.getContextHandles();
        for (String contextName : context) {
            System.out.println("Available context" + contextName);
            if (contextName.contains(cont)) {
                appiumDriver.context(contextName);
                break;
            }
        }
        System.out.println("After switching" + appiumDriver.getContext());
        Thread.sleep(3000);
    }

    @Then("^Tap on the seats$")
    public void tapONSeats() throws Throwable {
        new TouchAction(appiumDriver).tap(PointOption.point(372, 862)).perform();
        Thread.sleep(3000);
    }

    @Then("^Tap on pay$")
    public void tapOnPay() throws Throwable {
        new TouchAction(appiumDriver).tap(PointOption.point(366, 1092)).perform();
        Thread.sleep(3000);
    }

    @Then("Click on skip button on seat selection page$")
    public void clickOnSkipButtonOnSeatSelectionPage() throws Throwable {
        appiumDriver.findElement(By.xpath("//android.widget.TextView[@text = 'Skip']")).click();
    }

}


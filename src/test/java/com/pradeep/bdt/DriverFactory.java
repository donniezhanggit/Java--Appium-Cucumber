package com.pradeep.bdt;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.PerformsTouchActions;

public class DriverFactory {

    public static AndroidDriver driver = null;
    AppiumDriverLocalService appiumService;
    String appiumServiceUrl;
    protected static WebDriverWait waitVar = null;

    public void createDriver() throws MalformedURLException, InterruptedException {

        // set up appium
        final File classpathRoot = new File(System.getProperty("user.dir"));
        final File appDir = new File(classpathRoot, "src/test/resources/apps");
        final File app = new File(appDir,"MoviesDB.apk");
       // final File app = new File("C:\\Drivers\\MoviesDB.apk");


        //Thread.sleep(90000);

        appiumService = AppiumDriverLocalService.buildDefaultService();
        appiumService.start();
        appiumServiceUrl = appiumService.getUrl().toString();
        System.out.println("Appium Service Address : - " + appiumServiceUrl);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Android");
        capabilities.setCapability("app", app);
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appPackage", "com.logitech.assignment");
        driver = new AndroidDriver<>(new URL(appiumServiceUrl), capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    public void tap_on_co_ordinates() {
        TouchAction action = new TouchAction(driver);

        action.release();
        action.perform();


    }

    public void teardown() {
        System.out.println("Stop driver");
        driver.quit();
        System.out.println("Stop appium service");
        appiumService.stop();
    }
}
package com.pradeep.bdt.pages.Android;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.pradeep.bdt.DriverFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.PerformsTouchActions;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.List;

public class Logintech extends DriverFactory {

    public void verifyHomePage() throws InterruptedException {

        Thread.sleep(1000);
        assertEquals(true, driver.findElement(By.xpath("//android.widget.TextView[@text='Movies DB']")).isDisplayed());
    }

    public void click_movie(String movieName) {


        List<MobileElement> elements = driver.findElements(By.xpath("//android.widget.TextView"));
        System.out.println("Number of elements:" + elements.size());

        for (int i = 0; i < elements.size(); i++) {
            System.out.println(elements.get(i).getText());
            if (elements.get(i).getText().equals(movieName)) {
                assertEquals(true, driver.findElement(By.xpath("//android.widget.TextView[@text=" + movieName + "]")).isDisplayed());
                driver.findElement(By.xpath("//android.widget.TextView[@text=" + movieName + "]")).click();
            }
        }

    }

    public void verify_movieDetailPage(String movieName) {
        //click on Agenda Button and wait for next page to appear:
        assertEquals(true, driver.findElement(By.xpath("//android.widget.TextView[@text=" + movieName + "]")).isDisplayed());
    }
    public void tapByCoordinates (int x,  int y) {
        new TouchAction(driver)
                .tap(point(x,y))
                .waitAction(waitOptions(Duration.ofMillis(250))).perform();
    }

    public void contains_text(String text){
        assertEquals(true,driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+text+"')]")).isDisplayed());
    }

}
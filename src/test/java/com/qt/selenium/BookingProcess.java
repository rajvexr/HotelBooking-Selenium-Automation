package com.qt.selenium;

import com.qt.pages.WebPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookingProcess extends Setup{

    @Test
    void LaunchBooking() {
        driver.get("https://www.clock-software.com/demo-clockpms/index.html");
        Assert.assertEquals(driver.getTitle(), "Clock Web Reservation demo");
    }

    @Test
    void booking() {

        WebPages pages = new WebPages();

        ////////////////////////////////Booking////////////////////////////////
        driver.findElement(By.xpath("//input[@id='date-start']")).click();
        driver.findElement(By.xpath("//td[@class='day' and text()='25']")).click();
        driver.findElement(pages.nights).click();
        driver.findElement(pages.nights).clear();
        driver.findElement(pages.nights).sendKeys("4");
        driver.findElement(pages.book_now).click();

        ////////////////////////////////Switching to frame////////////////////////////////
        driver.switchTo().frame("clock_pms_iframe_1");
        driver.findElement(By.xpath("(//a[@class='btn btn-success '])[18]")).click();

        ////////////////////////////////Select any 2 add ons////////////////////////////////
        String quantity = "(//input[@placeholder='Quantity'])";

        driver.findElement(By.xpath(quantity+"[1]")).sendKeys("1");
        driver.findElement(By.xpath(quantity+"[2]")).sendKeys("1");
        driver.findElement(By.xpath("(//input[@value='Add the selected services >>'])[1]")).click();

        /////////////////////////////Create Booking////////////////////////////////
        String details = "//input[@name='booking[guest_attributes]";

        driver.findElement(By.xpath(details+"[e_mail]']")).sendKeys("rajveer@gmail.com");
        driver.findElement(By.xpath(details+"[last_name]']")).sendKeys("Singh");
        driver.findElement(By.xpath(details+"[first_name]']")).sendKeys("Rajveer");
        driver.findElement(By.xpath(details+"[phone_number]']")).sendKeys("07647368463");
        driver.findElement(pages.payment_type).click();
        driver.findElement(pages.terms).click();
        driver.findElement(pages.create_booking).click();


        ////////////////////////////////User Checkout////////////////////////////////
        String userDetails = "(//input[@class='text_field form-control'])";

        driver.findElement(By.xpath(userDetails+"[1]")).sendKeys("5475643795733783");
        Select brand = new Select(driver.findElement(By.id("credit_card_collect_purchase_brand")));
        brand.selectByIndex(2);
        Select ex1 = new Select(driver.findElement(By.id("cardExpirationMonth")));
        ex1.selectByIndex(1);
        Select ex2 = new Select(driver.findElement(By.id("cardExpirationYear")));
        ex2.selectByIndex(3);
        driver.findElement(By.xpath(userDetails+"[3]")).sendKeys("66 address");
        driver.findElement(By.xpath(userDetails+"[4]")).sendKeys("ux9j6l2");
        driver.findElement(By.xpath(userDetails+"[5]")).sendKeys("london");
        driver.findElement(By.xpath(userDetails+"[6]")).sendKeys("Britain");
        Select country = new Select(driver.findElement(By.id("credit_card_collect_purchase_country")));
        country.selectByIndex(10);
        driver.findElement(pages.checkout).click();
        Assert.assertEquals(driver.findElement(By.xpath("//h1[text()='Thank you for your booking!']")).getText(), "Thank you for your booking!");


    }
}

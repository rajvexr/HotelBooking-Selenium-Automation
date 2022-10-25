package org.qt.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;


public class BookingProcess {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://www.clock-software.com/demo-clockpms/index.html");


        ////////////////////////////////Booking////////////////////////////////
        driver.findElement(By.xpath("//input[@id='date-start']")).click();
        driver.findElement(By.xpath("//td[@class='day' and text()='25']")).click();
        driver.findElement(By.xpath("//input[@id='to-place']")).click();
        driver.findElement(By.xpath("//input[@id='to-place']")).clear();
        driver.findElement(By.xpath("//input[@id='to-place']")).sendKeys("4");
        driver.findElement(By.xpath("//input[@class='btn btn-primary btn-block']")).click();


        ////////////////////////////////Switching to frame////////////////////////////////
        driver.switchTo().frame("clock_pms_iframe_1");
        driver.findElement(By.xpath("(//a[@class='btn btn-success '])[18]")).click();


        ////////////////////////////////Select any 2 add ons////////////////////////////////
        driver.findElement(By.xpath("(//input[@placeholder='Quantity'])[1]")).sendKeys("1");
        driver.findElement(By.xpath("(//input[@placeholder='Quantity'])[2]")).sendKeys("1");
        driver.findElement(By.xpath("(//input[@value='Add the selected services >>'])[1]")).click();


        /////////////////////////////Create Booking////////////////////////////////
        driver.findElement(By.xpath("//input[@name='booking[guest_attributes][e_mail]']")).sendKeys("rajveer@gmail.com");
        driver.findElement(By.xpath("//input[@name='booking[guest_attributes][last_name]']")).sendKeys("Singh");
        driver.findElement(By.xpath("//input[@name='booking[guest_attributes][first_name]']")).sendKeys("Rajveer");
        driver.findElement(By.xpath("//input[@name='booking[guest_attributes][phone_number]']")).sendKeys("07647368463");
        driver.findElement(By.xpath("(//input[@name='booking[payment_service]'])[3]")).click();
        driver.findElement(By.xpath("//input[@title='I agree with the hotel and guarantee policy']")).click();
        driver.findElement(By.xpath("//input[@value='Create Booking']")).click();


        ////////////////////////////////User Checkout////////////////////////////////
        driver.findElement(By.xpath("(//input[@class='text_field form-control'])[1]")).sendKeys("5475643795733783");
        Select brand = new Select(driver.findElement(By.id("credit_card_collect_purchase_brand")));
        brand.selectByIndex(2);
        Select ex1 = new Select(driver.findElement(By.id("cardExpirationMonth")));
        ex1.selectByIndex(1);
        Select ex2 = new Select(driver.findElement(By.id("cardExpirationYear")));
        ex2.selectByIndex(3);
        driver.findElement(By.xpath("(//input[@class='text_field form-control'])[3]")).sendKeys("66 address");
        driver.findElement(By.xpath("(//input[@class='text_field form-control'])[4]")).sendKeys("ux9j6l2");
        driver.findElement(By.xpath("(//input[@class='text_field form-control'])[5]")).sendKeys("london");
        driver.findElement(By.xpath("(//input[@class='text_field form-control'])[6]")).sendKeys("Britain");
        Select country = new Select(driver.findElement(By.id("credit_card_collect_purchase_country")));
        country.selectByIndex(10);
        driver.findElement(By.xpath("//button[@class='btn btn-success btn-lg btn-block']")).click();

    }

    ////////////////////////////////Waiting time////////////////////////////////
    public static void wait(int milliseconds){
        try {
            Thread.sleep(milliseconds); //this a type of waiting command
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }


}

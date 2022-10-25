package com.qt.pages;

import org.openqa.selenium.By;

public class WebPages { //Page Object Model (POM)

    public By nights = By.xpath("//input[@id='to-place']");

    public By book_now = By.xpath("//input[@class='btn btn-primary btn-block']");

    public By payment_type = By.xpath("(//input[@name='booking[payment_service]'])[3]");

    public By terms = By.xpath("//input[@title='I agree with the hotel and guarantee policy']");

    public By create_booking = By.xpath("//input[@value='Create Booking']");

    public By checkout = By.xpath("//button[@class='btn btn-success btn-lg btn-block']");

}

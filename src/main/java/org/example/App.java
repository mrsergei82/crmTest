package org.example;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("incognito");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        driver.get("http://crm.geekbrains.space");
        driver.findElement(By.id("prependedInput")).sendKeys(" Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[@class=\"dropdown\"]/a[@class=\"unclickable\"]/span"))
                .click();
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[3]/ul/li[4]/a/span")).click();
        driver.findElement(By.xpath("//a[@title=\"Создать проект\"]")).click();
        driver.findElement(By.name("crm_project[name]")).sendKeys("TestP");
        driver.findElement(By.xpath("//a[@class=\"select2-choice select2-default\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/ul[2]/li[1]/div")).click();
        driver.findElement(By.name("crm_project[businessUnit]")).click();
        driver.findElement(By.xpath("//option[. = 'Research & Development']")).click();
        driver.findElement(By.xpath("//option[. = 'Амелин Владимир']")).click();
        driver.findElement(By.xpath("//option[. = 'Андреев Сергей']")).click();
        driver.findElement(By.name("crm_project[manager]")).sendKeys("Амелина Светлана");
        driver.findElement(By.xpath("//div[@class=\"select2-container select2\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/ul[2]/li[1]/div")).click();
        driver.findElement(By.xpath("//button[@class=\"btn btn-success action-button\"]")).click();



    }
}

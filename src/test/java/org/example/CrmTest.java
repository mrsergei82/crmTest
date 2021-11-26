package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;
import java.util.function.BooleanSupplier;

public class CrmTest {
    @Test
    public void test1(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("incognito");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://crm.geekbrains.space");
        driver.findElement(By.id("prependedInput")).sendKeys(" Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();
        Assertions.assertTrue(driver.getCurrentUrl().equals("https://crm.geekbrains.space/"));

        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[@class=\"dropdown\"]/a[@class=\"unclickable\"]/span"))
                .click();
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[3]/ul/li[4]/a/span")).click();
        driver.findElement(By.xpath("//a[@title=\"Создать проект\"]")).click();
        System.out.println(driver.getCurrentUrl());
        Assertions.assertTrue(driver.getCurrentUrl().equals("https://crm.geekbrains.space/project/create/"));
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
        driver.findElement(By.xpath("//div[@class='filter-container']/span/div[1]/div[1]")).click();

        Assertions.assertTrue(driver.getCurrentUrl().equals("https://crm.geekbrains.space/project/"));
        driver.findElement(By.xpath("//div[@class='filter-container']/span/div[1]/div[2]/div/div/button")).click();
        driver.findElement(By.xpath("//div[@class='filter-container']/span/div/div[2]/div/div/ul/li[3]/a")).click();
        driver.findElement(By.xpath("//div[1]/div/div/span/div[1]/div[2]/div/div[2]/input[1]")).sendKeys("TestP");
        driver.findElement(By.xpath("//button[@class='btn btn-primary filter-update']")).click();
        driver.findElement(By.xpath("//div[@class='grid-container']/table/tbody/tr[@class='grid-row']")).click();
        driver.findElement(By.xpath("//div[@class='pull-right']/div/div[3]/a")).click();
        driver.findElement(By.xpath("//div[@class='modal-footer']/a[@class='btn ok btn-primary']")).click();

        driver.close();
    }
}

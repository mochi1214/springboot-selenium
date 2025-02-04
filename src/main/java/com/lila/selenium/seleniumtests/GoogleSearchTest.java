package com.lila.selenium.seleniumtests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;

public class GoogleSearchTest {

    public static void main(String[] args) {
        // 使用 WebDriverManager 下載並設定 ChromeDriver
        WebDriverManager.chromedriver().setup();

        boolean isHeadless = false;

        // 設定 ChromeOptions
        ChromeOptions options = new ChromeOptions();
        if (isHeadless) {
            options.addArguments("--headless");
        }
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-blink-features=AutomationControlled");

        // 初始化 WebDriver
        WebDriver driver = new ChromeDriver(options);

        try {
            // 打開 Google
            driver.get("https://www.google.com");

            // 驗證標題
            System.out.println("Page Title: " + driver.getTitle());

            // 找到搜尋框並輸入關鍵字
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("Selenium WebDriver"); // 關鍵字
            searchBox.submit(); // 提交表單

            // 等待數秒以模擬人類操作（不推薦 Thread.sleep，但用於簡單示範）
            Thread.sleep(2000);
            
            System.out.println("Search Result Page Title: " + driver.getTitle());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 關閉瀏覽器
//            driver.quit();
        }
    }
}

package selenium_services;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DayTransactionScrapping {
    private String date;
    private String equitiesName;
    private double perv_ClosePrice;
    private double dayOpenPrice;
    private double dayClosePrice;

    public DayTransactionScrapping() {
    }

    public DayTransactionScrapping(String equitiesName, double perv_ClosePrice, double dayOpenPrice, double dayClosePrice) {
        this.setDate(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(LocalDateTime.now()));
        this.setEquitiesName(equitiesName);
        this.setPerv_ClosePrice(perv_ClosePrice);
        this.setDayOpenPrice(dayOpenPrice);
        this.setDayClosePrice(dayClosePrice);
    }
    public DayTransactionScrapping(WebDriver driver) {
        WebElement equitiesNameEle = driver.findElement(By.xpath("//*[@class='text-2xl font-semibold instrument-header_title__GTWDv mobile:mb-2']"));
        WebElement perv_CloseEle = driver.findElement(By.xpath("//dd[@data-test='prevClose']"));
        WebElement dayOpenEle = driver.findElement(By.xpath("//*[@class='key-info_dd-numeric__2cYjc']"));
        WebElement dayCloseEle = driver.findElement(By.xpath("//*[@id='__next']/div/div[1]/div/div/main/div/div[1]/div[2]/div[1]/span"));

        this.setDate(DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDateTime.now()));
        this.setEquitiesName(equitiesNameEle.getText());
        this.setPerv_ClosePrice(Double.parseDouble(perv_CloseEle.getText()));
        this.setDayOpenPrice(Double.parseDouble(dayOpenEle.getText()));
        this.setDayClosePrice(Double.parseDouble(dayCloseEle.getText()));
    }

    public String getEquitiesName() {
        return equitiesName;
    }

    public void setEquitiesName(String equitiesName) {
        this.equitiesName = equitiesName;
    }

    public double getPerv_ClosePrice() {
        return perv_ClosePrice;
    }

    public void setPerv_ClosePrice(double perv_ClosePrice) {
        this.perv_ClosePrice = perv_ClosePrice;
    }

    public double getDayOpenPrice() {
        return dayOpenPrice;
    }

    public void setDayOpenPrice(double dayOpenPrice) {
        this.dayOpenPrice = dayOpenPrice;
    }

    public double getDayClosePrice() {
        return dayClosePrice;
    }

    public void setDayClosePrice(double dayClosePrice) {
        this.dayClosePrice = dayClosePrice;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

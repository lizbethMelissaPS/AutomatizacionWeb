package com.nttdata.steps;

import com.nttdata.page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginSteps {

    private WebDriver driver;

    //constructor
    public LoginSteps(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Escribir el usuario
     * @param user el usuario
     */
    public void typeUser(String user){
        WebElement userInputElement = driver.findElement(LoginPage.userInput);
        userInputElement.sendKeys(user);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.loginButton));


    }

    /**
     * Escribir el password
     * @param password el password del usuario
     */
    public void typePassword(String password){
        this.driver.findElement(LoginPage.passInput).sendKeys(password);
    }

    /**
     * Hacer click en el botón login
     */
    public void login(){
        this.driver.findElement(LoginPage.loginButton).click();
    }




    public void typeCategoria(String categoria) {
        this.driver.findElement(LoginPage.xpathCategoria).click();
    }


    public void typeSubCategoria(String subcategoria) {
        this.driver.findElement(LoginPage.xpathSubCategoria).click();
    }


    public void agregoPrimerUnidad(int cantidad) {
        this.driver.findElement(LoginPage.agregar).click();
    }

    // Asumir que hay un campo de cantidad para agregar el número de unidades
    public void typeCantidad(int cantidad) {
        this.driver.findElement(LoginPage.cantidadInput).clear();
    }

    public void cantidaTotal(int cantidad) {
        this.driver.findElement(LoginPage.cantidadTotal).sendKeys(String.valueOf(cantidad));
    }
}

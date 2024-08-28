package com.nttdata.steps;

import com.nttdata.page.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.nttdata.page.LoginPage.*;


public class LoginSteps {

    private static WebDriver driver;
    //constructor
    public LoginSteps(WebDriver driver){
        this.driver = driver;
    }




    /**
     * Escribir el usuario
     * @param user el usuario
     */
    public void typeUser(String user){
        // Encuentra el campo de correo electrónico utilizando el ID
        WebElement emailInput = driver.findElement(By.id("field-email"));

        // Imprime el valor para depuración
        System.out.println("Campo de email encontrado: " + emailInput);

        // Enviar texto al campo de correo electrónico
        emailInput.sendKeys(user);

        // Imprime el valor ingresado para verificación
        String valorIngresado = emailInput.getAttribute("value");
        System.out.println("Valor ingresado en el campo de email: " + valorIngresado);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit-login")));



    }

    /**
     * Escribir el password
     * @param password el password del usuario
     */
    public void typePassword(String password){
        // Encuentra el campo de contraseña utilizando el ID
        WebElement passwordInput = driver.findElement(By.id("field-password"));

        // Imprime el valor para depuración
        System.out.println("Campo de contraseña encontrado: " + passwordInput);

        // Enviar texto al campo de contraseña
        passwordInput.sendKeys(password);

        // Imprime el valor ingresado para verificación
        String valorIngresado = passwordInput.getAttribute("value");
        System.out.println("Valor ingresado en el campo de contraseña: " + valorIngresado);

    }

    /**
     * Hacer click en el botón login
     */

    public void login(){
        // Encuentra el botón de inicio de sesión utilizando el ID
        WebElement loginButton = driver.findElement(By.id("submit-login"));

        // Imprime el valor para depuración
        System.out.println("Botón de inicio de sesión encontrado: " + loginButton);

        // Hacer clic en el botón de inicio de sesión
        loginButton.click();
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

    public void cantidaTotal(double cantidad) {
        this.driver.findElement(LoginPage.cantidadTotal).sendKeys(String.valueOf(cantidad));
    }


    public void popupMessage() {
        String confirmationMessage = driver.findElement(popupMessage).getText();
        Assert.assertTrue(confirmationMessage.contains("Product added to cart"));
    }


    public static double calculateTotal(double expectedTotal) {
        return getTotalAmount();
    }
    public static double getTotalAmount() {
        String totalText = driver.findElement(totalAmount).getText(); // Obtener el texto del monto total
        totalText = totalText.replace("$", "").replace(",", "").trim(); // Eliminar caracteres de moneda y espacios
        return Double.parseDouble(totalText); // Convertir a número y devolver
    }


}

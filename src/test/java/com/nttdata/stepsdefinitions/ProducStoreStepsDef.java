package com.nttdata.stepsdefinitions;

import com.nttdata.steps.LoginSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.es.Cuando;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;


public class ProducStoreStepsDef {

    private WebDriver driver;


    @Given("estoy en la página de la tienda")
    public void estoyEnLaPáginaDeLaTienda() {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store/pe/iniciar-sesion?back=https%3A%2F%2Fqalab.bensg.com%2Fstore%2Fpe%2F");
        driver.manage().window().maximize();
        screenShot();
    }


    @Cuando("inicio sesión con las credenciales usuario: {string} y contraseña: {string}")
    public void inicio_sesión_con_las_credenciales_usuario_y_contraseña(String user, String password) {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.typeUser(user);
        loginSteps.typePassword(password);
        loginSteps.login();
        screenShot();
    }



    @And("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String usuario, String clave) {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.typeUser(usuario);
        loginSteps.typePassword(clave);
        loginSteps.login();
        screenShot();
    }



    @When("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaYSubcategoria(String categoria, String subcategoria) {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.typeCategoria(categoria);
        loginSteps.typeSubCategoria(subcategoria);
        screenShot();
    }


    @And("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int cantidad) {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.agregoPrimerUnidad(cantidad);
        loginSteps.typeCantidad(cantidad);
        loginSteps.cantidaTotal(cantidad);

        screenShot();
    }

    @Then("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmaciónDelProductoAgregado() {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.popupMessage();
        screenShot();
    }

    @And("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente(double expectedTotal) {
        double actualTotal = LoginSteps.calculateTotal(expectedTotal);
        Assert.assertEquals(expectedTotal, actualTotal, 0.01);
    }



}



package com.nttdata.page;

import org.openqa.selenium.By;

public class LoginPage {

    //Localizadores de elementos
    public static By userInput = By.xpath("/html/body/main/section/div/div/div/section/div/section/form/div/div[1]/div[1]/input");
    public static By passInput = By.xpath("/html/body/main/section/div/div/div/section/div/section/form/div/div[2]/div[1]/div/input");
    public static By loginButton = By.id("submit-login");

    public static By xpathCategoria = By.xpath("/html/body/main/header/div[2]/div/div[1]/div[2]/div[1]/ul/li[1]/a");
    public static By xpathSubCategoria = By.xpath("/html/body/main/header/div[2]/div/div[1]/div[2]/div[1]/ul/li[1]/div/ul/li[1]/a");

    public static By agregar = By.xpath("/html/body/main/section/div/div/div/section/div[1]/div[2]/div[2]/div[2]/form/div[2]/div/div[2]/button");
    //Asumir que hay un campo de cantidad para agregar el número de unidades
    public static By cantidadInput = By.id("quantity_wanted");
    public static By cantidadTotal = By.cssSelector(".quantity_wanted");

    public static By popupMessage = By.xpath("/html/body/div[1]/div");


    public static By totalAmount = By.className(".product-total .value");


}


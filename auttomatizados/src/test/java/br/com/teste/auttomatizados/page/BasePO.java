package br.com.teste.auttomatizados.page;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePO {
    
    // Driver que sera usado pelas pages
    protected WebDriver driver;

    /**
     * Construtor base para criação da fabrica de elementos (PageFactory)
     * @param driver Driver da página atual.
     */
    public BasePO(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    /**
     * Metodo que retorna o titulo da pagina atual
     * @return
     */
    public String obterTituloPagina(){
        return driver.getTitle();
    }


    /**
     * Metodo que sabe escrever em qualquer WebElement do tipo Input e dá um TAB ao final
     * @param input Input a qual sera escrito
     * @param texto Texto que será escrito no input
     */
    public void escrever(WebElement input, String texto) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(input));

        input.sendKeys(Keys.CONTROL + "a");
        input.sendKeys(Keys.DELETE);

        input.sendKeys(texto);
    }

}
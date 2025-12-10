package br.com.teste.auttomatizados.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Classe base que serve de herança para todas as bases testes
 */
public abstract class BaseTest {

    /**
     * Driver do navegador da pagina atual
     */
    protected static WebDriver driver;

    /**
     * Caminho base da URL do sistema a ser testado
     */
    private static final String URL_BASE = "http://127.0.0.1:5500/login.html";

    /**
     * Opções Extras do Chrome
     */
    private static ChromeOptions options;


    /**
      * Metodo para Iniciar o driver do navegador antes de qualquer classe de teste
      */
    @BeforeAll
    protected static void iniciar(){
        options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(URL_BASE);
    }

    /**
     * Metodo que finaliza o driver do navegador depois que qualquer classe
     */
    @AfterAll
    protected static void finalizar(){
        driver.quit();
    }
}
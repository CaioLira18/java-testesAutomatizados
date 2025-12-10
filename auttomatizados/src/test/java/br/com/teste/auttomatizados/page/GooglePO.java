package br.com.teste.auttomatizados.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePO extends BasePO {

    @FindBy(name = "q")
    public WebElement inputPesquisa;

    @FindBy(id = "result-stats")
    public WebElement divResultadoPesquisa;

    /**
     * Construtor para criação da pagina do google
     * @param driver
     */
    public GooglePO(WebDriver driver) {
        super(driver); 
    }

    /**
     * Metodo que ira efetuar uma pesquisa no google baseando no texto informado e concluindo com enter
     * @param texto - Texto a ser pesquisado
     */
    public void pesquisar(String texto){
        inputPesquisa.sendKeys(texto + Keys.ENTER);
    }

    /**
     * Metodo que retorna o resultado aaproximado da pesquisa
     * @return retorna o resultdo da pesquisa
     */

    public String obterResultadoDaPesquisa(){
        return divResultadoPesquisa.getText();
    }
}
package br.com.teste.auttomatizados.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO {

    //#region Região dos WebElements
    @FindBy(id = "email")
    public WebElement inputEmail;

    @FindBy(id = "senha")
    public WebElement inputSenha;

    @FindBy(id = "btn-entrar")
    public WebElement btnSenha;

    @FindBy(css = "form.form-login>div.alert>span")
    public WebElement spanMensagem;

    //#endregion Região dos WebElements

    //#region Construtores

    /**
     * Construtor padrão pra criação de uma nova instancia de pagina de login
     * @param driver Driver da pagina de login
     */
    public LoginPO(WebDriver driver) {
        super(driver);
    }

    public void executarAcaoDeLogar(String email, String senha){
        this.escrever(this.inputEmail, email);
        this.escrever(this.inputSenha, senha);
        this.btnSenha.click();
    }

    //#endregion Construtores

    //#region Metodos

    /**
     * Metodo que obtem a mensagem disparada na tela
     * @return retorna o texto da mensagem
     */

    public String obterMensagem(){
        return spanMensagem.getText();
    }

    /**
     * Metodo que retorna o titulo da pagina atual
     * @return
     */
    public String obterTituloPagina(){
        return driver.getTitle();
    }

    //#endregion Metodos
    
}

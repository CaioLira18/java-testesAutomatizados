package br.com.teste.auttomatizados.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import br.com.teste.auttomatizados.page.LoginPO;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class LoginTest extends BaseTest {

    private static LoginPO loginPage;

    public void executarAcaoDeLogar(String email, String senha){
        loginPage.escrever(loginPage.inputEmail, email);
        loginPage.escrever(loginPage.inputSenha, senha);
        loginPage.btnSenha.click();
    }

    @BeforeAll 
    public static void prepararTestes(){
        loginPage = new LoginPO(driver);
    }

    @Test
    public void TC001_naoDeveLogarNoSistemaComEmailESenhaVazios(){
        loginPage.executarAcaoDeLogar("", "");
        String mensagem = loginPage.obterMensagem();
        assertEquals("Informe usuário e senha, os campos não podem ser brancos.", mensagem);
    }

    @Test
    public void TC002_naoDeveLogarNoSistemaComEmailIncorretoESenhaVazia(){
        loginPage.executarAcaoDeLogar("teste", "");
        String mensagem = loginPage.obterMensagem();
        assertEquals("Informe usuário e senha, os campos não podem ser brancos.", mensagem);
    }

    @Test
    public void TC003_naoDeveLogarNoSistemaComEmailVazioESenhaIncorreta(){
        loginPage.executarAcaoDeLogar("", "teste");
        String mensagem = loginPage.obterMensagem();
        assertEquals("Informe usuário e senha, os campos não podem ser brancos.", mensagem);
    }

    @Test
    public void TC004_DeveLogarNoSistemaComEmailCorretoESenhaCorreta(){
        loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");
        assertEquals(loginPage.obterTituloPagina(), "Controle de Produtos");
    }

    
}

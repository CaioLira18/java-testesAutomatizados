package br.com.teste.auttomatizados.test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import br.com.teste.auttomatizados.page.GooglePO;


@TestMethodOrder(MethodOrderer.MethodName.class)
public class GoogleTest extends BaseTest {   
    
    private static GooglePO googlePage;

    @BeforeAll 
    public static void prepararTestes(){
        driver.get("https://www.google.com/");
        googlePage = new GooglePO(driver);
    
    }

    @Test
    public void TC001_deveSerPossivelPesquisarNoGoogleOTextoBatataFrita(){
        googlePage.pesquisar("Batata Frita");
        String resultado = googlePage.obterResultadoDaPesquisa();
        assertTrue(resultado.contains("Aproximadamente"), resultado);
    }

    public void TC002_deveSerPossivelPesquisarNoGoogleOTextoNutella(){
        googlePage.pesquisar("Nutella");
        String result = googlePage.obterResultadoDaPesquisa();
        assertTrue(result.contains("resultados"), result);
    }
}

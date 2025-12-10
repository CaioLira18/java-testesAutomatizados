package br.com.teste.auttomatizados.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import br.com.teste.auttomatizados.build.ProdutoBuilder;
import br.com.teste.auttomatizados.page.ControleDeProdutoPO;
import br.com.teste.auttomatizados.page.LoginPO;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class ConrolesDeProdutoTest extends BaseTest {

    private static LoginPO loginPage;
    private static ControleDeProdutoPO controleProdutoPage;

    @BeforeAll 
    public static void prepararTestes(){
        loginPage = new LoginPO(driver);
        loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");

        controleProdutoPage = new ControleDeProdutoPO(driver);
        assertEquals(controleProdutoPage.obterTituloPagina(), "Controle de Produtos");
    } 

    @Test
    public void TC001_deveAbrirModalParaCadastroAoClicarNoBotaoCriar(){
        controleProdutoPage.buttonAdicionar.click();
        controleProdutoPage.buttonAdicionar.click();

        String titulo = controleProdutoPage.tituloModal.getText();

        assertEquals("Produto", titulo);
    }

    @Test
    public void TC003_NaoDeveSerPossivelCadastrarUmProdutoSemPreencherTodosOsCampos(){

        String mensagem = "Todos os campos são obrigatórios para o cadastro!";


        // Aqui cria o objeto para adicionar na tela
        ProdutoBuilder produtoBuilder = new ProdutoBuilder(controleProdutoPage);

        // Aqui estamos testamos se o produto é adicionado sem codigo
        produtoBuilder
        .adicionarCodigo("")
        .builder();

        assertEquals(mensagem, controleProdutoPage.spanMensagem.getText());

        // Aqui estamos testamos se o produto é adicionado sem quantidade
        produtoBuilder
        .adicionarCodigo("006")
        .adicionarQuantidade(null)
        .adicionarNome("Martelo")
        .builder();

        assertEquals(mensagem, controleProdutoPage.spanMensagem.getText());

        // Aqui estamos testamos se o produto é adicionado sem nome
        produtoBuilder
        .adicionarQuantidade(15)
        .adicionarNome("")
        .adicionarValor(15.80)
        .builder();

        assertEquals(mensagem, controleProdutoPage.spanMensagem.getText());

        // Aqui estamos testamos se o produto é adicionado sem valor
        produtoBuilder
        .adicionarQuantidade(15)
        .adicionarNome("Cimento")
        .adicionarValor(null)
        .builder();

        assertEquals(mensagem, controleProdutoPage.spanMensagem.getText());

        // Aqui estamos testamos se o produto é adicionado sem data
        produtoBuilder
        .adicionarQuantidade(15)
        .adicionarNome("Martelo")
        .adicionarValor(15.80)
        .adicionarData("")
        .builder();

        assertEquals(mensagem, controleProdutoPage.spanMensagem.getText());

        controleProdutoPage.buttonSair.click();
        controleProdutoPage.buttonSair.click();
    }
}

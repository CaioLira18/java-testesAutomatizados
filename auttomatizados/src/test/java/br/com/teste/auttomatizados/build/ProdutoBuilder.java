package br.com.teste.auttomatizados.build;

import br.com.teste.auttomatizados.page.ControleDeProdutoPO;

/**
 * Classe que sabe construir ou adicionar um produto na tela
 */
public class ProdutoBuilder {
    
    public String codigo = "00001";
    public String nome = "Produto Padrão";
    public Integer quantidade = 1;
    public Double valor = 1.0;
    public String data = "09/12/2025";

    private ControleDeProdutoPO controleDeProdutoPO;

    /**
     * Construtor padrão do produto builder que recebe a pagina de controle de produto
     * @param controleDeProdutoPO
     */
    public ProdutoBuilder(ControleDeProdutoPO controleDeProdutoPO){
        this.controleDeProdutoPO = controleDeProdutoPO;
    }

    /**
     * Metodo que sabe adicionar um codigo ao builder
     * @param codigo Codigo que sera adicionado
     * @return retorna a propria classe ProdutoBuilder
     */
    public ProdutoBuilder adicionarCodigo(String codigo){
        this.codigo = codigo;
        return this;
    }

    /**
     * Metodo que sabe adicionar um nome ao builder
     * @param nome Nome que sera adicionado
     * @return retorna a propria classe ProdutoBuilder
     */
    public ProdutoBuilder adicionarNome(String nome){
        this.nome = nome;
        return this;
    }

    /**
     * Metodo que sabe adicionar uma quantidade ao builder
     * @param quantidade Quantidade que sera adicionado
     * @return retorna a propria classe ProdutoBuilder
     */
    public ProdutoBuilder adicionarQuantidade(Integer quantidade){
        this.quantidade = quantidade;
        return this;
    }

    /**
     * Metodo que sabe adicionar um valor ao builder
     * @param valor Valor que sera adicionado
     * @return retorna a propria classe ProdutoBuilder
     */
    public ProdutoBuilder adicionarValor(Double valor){
        this.valor = valor;
        return this;
    }

    /**
     * Metodo que sabe adicionar uma data ao builder
     * @param data Data que sera adicionada
     * @return retorna a propria classe ProdutoBuilder
     */
    public ProdutoBuilder adicionarData(String data){
        this.data = data;
        return this;
    }

    /**
     * Metodo que constroi o produto, ou seja, adiciona o produto pela tela de cadastro de produto
     */
    public void builder(){
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputCodigo, codigo);
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputNome, nome);
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputQuantidade, (quantidade != null) ? quantidade.toString() : "");
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputValor, (valor != null) ? valor.toString() : "");
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputData, data);

        controleDeProdutoPO.buttonSalvar.click();
    }
}

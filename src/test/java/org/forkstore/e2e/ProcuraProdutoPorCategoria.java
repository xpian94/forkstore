package org.forkstore.e2e;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class ProcuraProdutoPorCategoria {
    @Quando("o cliente procurar por {string}")
    public void oClienteProcurarPor(String categoria) throws JsonProcessingException {

    }

    @Entao("uma lista de produtos deve aparecer com produtos pertencentes a {string}")
    public void umaListaDeProdutosDeveAparecerComProdutosPertencentesA(String categoria) {

    }

    @E("cada produto mostrado aparecera com {string}, {string} e {string}")
    public void cadaProdutoMostradoApareceraComE(String nome, String quantidade, String disponivelAVenda) {

    }
}

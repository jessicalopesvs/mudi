package br.com.alura.mvc.mudi.dto;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;

import javax.validation.constraints.NotBlank;

public class RequisicaoNovoPedido {

    @NotBlank //NotBlank.requisicaoNovoPedido.nome=não pode estar em branco
    private String nome;
    @NotBlank
    private String urlProduto;
    @NotBlank
    private String urlImg;
    @NotBlank
    private String descricao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUrlProduto() {
        return urlProduto;
    }

    public void setUrlProduto(String urlProduto) {
        this.urlProduto = urlProduto;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Pedido toPedido() {
        Pedido pedido = new Pedido();
        pedido.setNome(nome);
        pedido.setUrlProduto(urlProduto);
        pedido.setUrlImg(urlImg);
        pedido.setDescricao(descricao);
        pedido.setStatus(StatusPedido.AGUARDANDO);
        return pedido;
    }
}

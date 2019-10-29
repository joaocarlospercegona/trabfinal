/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author joao
 */
public class Produto {
    private int produto_codigo;
    private String produto_nome;
    private int produto_cod_categoria;
    private String produto_descricao;
    private int produto_peso;

    public Produto() {
    }

    public Produto(int produto_codigo, String produto_nome, int produto_cod_categoria, String produto_descricao, int produto_peso) {
        this.produto_codigo = produto_codigo;
        this.produto_nome = produto_nome;
        this.produto_cod_categoria = produto_cod_categoria;
        this.produto_descricao = produto_descricao;
        this.produto_peso = produto_peso;
    }

    public int getProduto_codigo() {
        return produto_codigo;
    }

    public void setProduto_codigo(int produto_codigo) {
        this.produto_codigo = produto_codigo;
    }

    public String getProduto_nome() {
        return produto_nome;
    }

    public void setProduto_nome(String produto_nome) {
        this.produto_nome = produto_nome;
    }

    public int getProduto_cod_categoria() {
        return produto_cod_categoria;
    }

    public void setProduto_cod_categoria(int produto_cod_categoria) {
        this.produto_cod_categoria = produto_cod_categoria;
    }

    public String getProduto_descricao() {
        return produto_descricao;
    }

    public void setProduto_descricao(String produto_descricao) {
        this.produto_descricao = produto_descricao;
    }

    public int getProduto_peso() {
        return produto_peso;
    }

    public void setProduto_peso(int produto_peso) {
        this.produto_peso = produto_peso;
    }

    @Override
    public String toString() {
        return "Produto{" + "produto_codigo=" + produto_codigo + ", produto_nome=" + produto_nome + ", produto_cod_categoria=" + produto_cod_categoria + ", produto_descricao=" + produto_descricao + ", produto_peso=" + produto_peso + '}';
    }
}

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
public class categoria {
    private int categoria_codigo;
    private String categoria_nome;
    

    public categoria() {
    }

    public categoria(int categoria_codigo, String categoria_nome) {
        this.categoria_codigo = categoria_codigo;
        this.categoria_nome = categoria_nome;
    }

    public int getCategoria_codigo() {
        return categoria_codigo;
    }

    public void setCategoria_codigo(int categoria_codigo) {
        this.categoria_codigo = categoria_codigo;
    }

    public String getCategoria_nome() {
        return categoria_nome;
    }

    public void setCategoria_nome(String categoria_nome) {
        this.categoria_nome = categoria_nome;
    }

    @Override
    public String toString() {
        return "categoria{" + "categoria_codigo=" + categoria_codigo + ", categoria_nome=" + categoria_nome + '}';
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author joao
 */
public class Cliente implements Serializable {
    private String cliente_nome;
    private String cliente_cpf;
    private String cliente_email;
    private String cliente_rua;
    private int    cliente_numero;
    private String cliente_complemento;
    private String cliente_bairro;
    private String cliente_cep;
    private String cliente_cidade;
    private String cliente_telefone;
    private String cliente_senha;
    private String cliente_estado;
    
    public Cliente(){}

    public Cliente(String cliente_nome, String cliente_cpf, String cliente_email, String cliente_rua, int cliente_numero, String cliente_complemento, String cliente_bairro, String cliente_cep, String cliente_cidade, String cliente_telefone, String cliente_senha, String cliente_estado) {
        this.cliente_nome = cliente_nome;
        this.cliente_cpf = cliente_cpf;
        this.cliente_email = cliente_email;
        this.cliente_rua = cliente_rua;
        this.cliente_numero = cliente_numero;
        this.cliente_complemento = cliente_complemento;
        this.cliente_bairro = cliente_bairro;
        this.cliente_cep = cliente_cep;
        this.cliente_cidade = cliente_cidade;
        this.cliente_telefone = cliente_telefone;
        this.cliente_senha = cliente_senha;
        this.cliente_estado = cliente_estado;
    }

    public String getCliente_nome() {
        return cliente_nome;
    }

    public void setCliente_nome(String cliente_nome) {
        this.cliente_nome = cliente_nome;
    }

    public String getCliente_cpf() {
        return cliente_cpf;
    }

    public void setCliente_cpf(String cliente_cpf) {
        this.cliente_cpf = cliente_cpf;
    }

    public String getCliente_email() {
        return cliente_email;
    }

    public void setCliente_email(String cliente_email) {
        this.cliente_email = cliente_email;
    }

    public String getCliente_rua() {
        return cliente_rua;
    }

    public void setCliente_rua(String cliente_rua) {
        this.cliente_rua = cliente_rua;
    }

    public int getCliente_numero() {
        return cliente_numero;
    }

    public void setCliente_numero(int cliente_numero) {
        this.cliente_numero = cliente_numero;
    }

    public String getCliente_complemento() {
        return cliente_complemento;
    }

    public void setCliente_complemento(String cliente_complemento) {
        this.cliente_complemento = cliente_complemento;
    }

    public String getCliente_bairro() {
        return cliente_bairro;
    }

    public void setCliente_bairro(String cliente_bairro) {
        this.cliente_bairro = cliente_bairro;
    }

    public String getCliente_cep() {
        return cliente_cep;
    }

    public void setCliente_cep(String cliente_cep) {
        this.cliente_cep = cliente_cep;
    }

    public String getCliente_cidade() {
        return cliente_cidade;
    }

    public void setCliente_cidade(String cliente_cidade) {
        this.cliente_cidade = cliente_cidade;
    }

    public String getCliente_telefone() {
        return cliente_telefone;
    }

    public void setCliente_telefone(String cliente_telefone) {
        this.cliente_telefone = cliente_telefone;
    }

    public String getCliente_senha() {
        return cliente_senha;
    }

    public void setCliente_senha(String cliente_senha) {
        this.cliente_senha = cliente_senha;
    }

    public String getCliente_estado() {
        return cliente_estado;
    }

    public void setCliente_estado(String cliente_estado) {
        this.cliente_estado = cliente_estado;
    }

    @Override
    public String toString() {
        return "Cliente{" + "cliente_nome=" + cliente_nome + ", cliente_cpf=" + cliente_cpf + ", cliente_email=" + cliente_email + ", cliente_rua=" + cliente_rua + ", cliente_numero=" + cliente_numero + ", cliente_complemento=" + cliente_complemento + ", cliente_bairro=" + cliente_bairro + ", cliente_cep=" + cliente_cep + ", cliente_cidade=" + cliente_cidade + ", cliente_telefone=" + cliente_telefone + ", cliente_senha=" + cliente_senha + '}';
    }
    
    
}

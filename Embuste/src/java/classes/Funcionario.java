/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.Serializable;

/**
 *
 * @author joao
 */
public class Funcionario implements Serializable {
    private String funcionario_nome;
    private String funcionario_cpf;
    private String funcionario_email;
    private String funcionario_rua;
    private int    funcionario_numero;
    private String funcionario_complemento;
    private String funcionario_bairro;
    private String funcionario_cep;
    private String funcionario_cidade;
    private String funcionario_telefone;
    private String funcionario_senha;
    private String funcionario_estado;
    
    public Funcionario(){}

    public Funcionario(String funcionario_nome, String funcionario_cpf, String funcionario_email, String funcionario_rua, int funcionario_numero, String funcionario_complemento, String funcionario_bairro, String funcionario_cep, String funcionario_cidade, String funcionario_telefone, String funcionario_senha, String funcionario_estado) {
        this.funcionario_nome = funcionario_nome;
        this.funcionario_cpf = funcionario_cpf;
        this.funcionario_email = funcionario_email;
        this.funcionario_rua = funcionario_rua;
        this.funcionario_numero = funcionario_numero;
        this.funcionario_complemento = funcionario_complemento;
        this.funcionario_bairro = funcionario_bairro;
        this.funcionario_cep = funcionario_cep;
        this.funcionario_cidade = funcionario_cidade;
        this.funcionario_telefone = funcionario_telefone;
        this.funcionario_senha = funcionario_senha;
        this.funcionario_estado = funcionario_estado;
    }

    public String getFuncionario_nome() {
        return funcionario_nome;
    }

    public void setFuncionario_nome(String funcionario_nome) {
        this.funcionario_nome = funcionario_nome;
    }

    public String getFuncionario_cpf() {
        return funcionario_cpf;
    }

    public void setFuncionario_cpf(String funcionario_cpf) {
        this.funcionario_cpf = funcionario_cpf;
    }

    public String getFuncionario_email() {
        return funcionario_email;
    }

    public void setFuncionario_email(String funcionario_email) {
        this.funcionario_email = funcionario_email;
    }

    public String getFuncionario_rua() {
        return funcionario_rua;
    }

    public void setFuncionario_rua(String funcionario_rua) {
        this.funcionario_rua = funcionario_rua;
    }

    public int getFuncionario_numero() {
        return funcionario_numero;
    }

    public void setFuncionario_numero(int funcionario_numero) {
        this.funcionario_numero = funcionario_numero;
    }

    public String getFuncionario_complemento() {
        return funcionario_complemento;
    }

    public void setFuncionario_complemento(String funcionario_complemento) {
        this.funcionario_complemento = funcionario_complemento;
    }

    public String getFuncionario_bairro() {
        return funcionario_bairro;
    }

    public void setFuncionario_bairro(String funcionario_bairro) {
        this.funcionario_bairro = funcionario_bairro;
    }

    public String getFuncionario_cep() {
        return funcionario_cep;
    }

    public void setFuncionario_cep(String funcionario_cep) {
        this.funcionario_cep = funcionario_cep;
    }

    public String getFuncionario_cidade() {
        return funcionario_cidade;
    }

    public void setFuncionario_cidade(String funcionario_cidade) {
        this.funcionario_cidade = funcionario_cidade;
    }

    public String getFuncionario_telefone() {
        return funcionario_telefone;
    }

    public void setFuncionario_telefone(String funcionario_telefone) {
        this.funcionario_telefone = funcionario_telefone;
    }

    public String getFuncionario_senha() {
        return funcionario_senha;
    }

    public void setFuncionario_senha(String funcionario_senha) {
        this.funcionario_senha = funcionario_senha;
    }

    public String getFuncionario_estado() {
        return funcionario_estado;
    }

    public void setFuncionario_estado(String funcionario_estado) {
        this.funcionario_estado = funcionario_estado;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "funcionario_nome=" + funcionario_nome + ", funcionario_cpf=" + funcionario_cpf + ", funcionario_email=" + funcionario_email + ", funcionario_rua=" + funcionario_rua + ", funcionario_numero=" + funcionario_numero + ", funcionario_complemento=" + funcionario_complemento + ", funcionario_bairro=" + funcionario_bairro + ", funcionario_cep=" + funcionario_cep + ", funcionario_cidade=" + funcionario_cidade + ", funcionario_telefone=" + funcionario_telefone + ", funcionario_senha=" + funcionario_senha + '}';
    }
    
    
}

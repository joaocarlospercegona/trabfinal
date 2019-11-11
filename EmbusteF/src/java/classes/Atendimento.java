/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author joao
 */
public class Atendimento {
    private int atendimento_codigo;
    private Date atendimento_data_hora;
    private String atendimento_cpf_cliente;
    private String atendimento_situacao;
    private int atendimento_cod_produto;
    private int atendimento_cod_tipo_atendimento;
    private String atendimento_descricao;
    private String atendimento_solucao;
    private int atendimento_nivel;
    public Atendimento() {
    }

    public Atendimento(int atendimento_codigo, Date atendimento_data_hora, String atendimento_cpf_cliente, String atendimento_situacao, int atendimento_cod_produto, int atendimento_cod_tipo_atendimento, String atendimento_descricao, String atendimento_solucao, int atendimento_nivel) {
        this.atendimento_codigo = atendimento_codigo;
        this.atendimento_data_hora = atendimento_data_hora;
        this.atendimento_cpf_cliente = atendimento_cpf_cliente;
        this.atendimento_situacao = atendimento_situacao;
        this.atendimento_cod_produto = atendimento_cod_produto;
        this.atendimento_cod_tipo_atendimento = atendimento_cod_tipo_atendimento;
        this.atendimento_descricao = atendimento_descricao;
        this.atendimento_solucao = atendimento_solucao;
        this.atendimento_nivel = atendimento_nivel;
    }

    public int getAtendimento_nivel() {
        return atendimento_nivel;
    }

    public void setAtendimento_nivel(int atendimento_nivel) {
        this.atendimento_nivel = atendimento_nivel;
    }

    

    public int getAtendimento_codigo() {
        return atendimento_codigo;
    }

    public void setAtendimento_codigo(int atendimento_codigo) {
        this.atendimento_codigo = atendimento_codigo;
    }

    public Date getAtendimento_data_hora() {
        return atendimento_data_hora;
    }

    public void setAtendimento_data_hora(Date atendimento_data_hora) {
        this.atendimento_data_hora = atendimento_data_hora;
    }

    public String getAtendimento_cpf_cliente() {
        return atendimento_cpf_cliente;
    }

    public void setAtendimento_cpf_cliente(String atendimento_cpf_cliente) {
        this.atendimento_cpf_cliente = atendimento_cpf_cliente;
    }

    public String getAtendimento_situacao() {
        return atendimento_situacao;
    }

    public void setAtendimento_situacao(String atendimento_situacao) {
        this.atendimento_situacao = atendimento_situacao;
    }

    public int getAtendimento_cod_produto() {
        return atendimento_cod_produto;
    }

    public void setAtendimento_cod_produto(int atendimento_cod_produto) {
        this.atendimento_cod_produto = atendimento_cod_produto;
    }

    public int getAtendimento_cod_tipo_atendimento() {
        return atendimento_cod_tipo_atendimento;
    }

    public void setAtendimento_cod_tipo_atendimento(int atendimento_cod_tipo_atendimento) {
        this.atendimento_cod_tipo_atendimento = atendimento_cod_tipo_atendimento;
    }

    public String getAtendimento_descricao() {
        return atendimento_descricao;
    }

    public void setAtendimento_descricao(String atendimento_descricao) {
        this.atendimento_descricao = atendimento_descricao;
    }

    public String getAtendimento_solucao() {
        return atendimento_solucao;
    }

    public void setAtendimento_solucao(String atendimento_solucao) {
        this.atendimento_solucao = atendimento_solucao;
    }

    @Override
    public String toString() {
        return "Atendimento{" + "atendimento_codigo=" + atendimento_codigo + ", atendimento_data_hora=" + atendimento_data_hora + ", atendimento_cpf_cliente=" + atendimento_cpf_cliente + ", atendimento_situacao=" + atendimento_situacao + ", atendimento_cod_produto=" + atendimento_cod_produto + ", atendimento_cod_tipo_atendimento=" + atendimento_cod_tipo_atendimento + ", atendimento_descricao=" + atendimento_descricao + ", atendimento_solucao=" + atendimento_solucao + ", atendimento_nivel=" + atendimento_nivel + '}';
    }
    
    
    
}

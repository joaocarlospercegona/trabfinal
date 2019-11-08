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
public class Tipo_Atendimento {
    private String tipo_atendimento_nome;
    private int tipo_atendimento_codigo;

    public Tipo_Atendimento() {
    }

    public Tipo_Atendimento(String tipo_atendimento_nome, int tipo_atendimento_codigo) {
        this.tipo_atendimento_nome = tipo_atendimento_nome;
        this.tipo_atendimento_codigo = tipo_atendimento_codigo;
    }

    public String getTipo_atendimento_nome() {
        return tipo_atendimento_nome;
    }

    public void setTipo_atendimento_nome(String tipo_atendimento_nome) {
        this.tipo_atendimento_nome = tipo_atendimento_nome;
    }

    public int getTipo_atendimento_codigo() {
        return tipo_atendimento_codigo;
    }

    public void setTipo_atendimento_codigo(int tipo_atendimento_codigo) {
        this.tipo_atendimento_codigo = tipo_atendimento_codigo;
    }

    @Override
    public String toString() {
        return "Tipo_Atendimento{" + "tipo_atendimento_nome=" + tipo_atendimento_nome + ", tipo_atendimento_codigo=" + tipo_atendimento_codigo + '}';
    }
    
}

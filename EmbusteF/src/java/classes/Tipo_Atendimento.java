package classes;

public class Tipo_Atendimento {
    private String tipo_atendimento_nome;
    private int tipo_atendimento_codigo;
    private int tipo_aberto;
    private int tipo_total;

    public Tipo_Atendimento() {
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

    public int getTipo_aberto() {
        return tipo_aberto;
    }

    public void setTipo_aberto(int tipo_aberto) {
        this.tipo_aberto = tipo_aberto;
    }

    public int getTipo_total() {
        return tipo_total;
    }

    public void setTipo_total(int tipo_total) {
        this.tipo_total = tipo_total;
    }

    public Tipo_Atendimento(String tipo_atendimento_nome, int tipo_atendimento_codigo, int tipo_aberto, int tipo_total) {
        this.tipo_atendimento_nome = tipo_atendimento_nome;
        this.tipo_atendimento_codigo = tipo_atendimento_codigo;
        this.tipo_aberto = tipo_aberto;
        this.tipo_total = tipo_total;
    }
    
    @Override
    public String toString() {
        return "Tipo_Atendimento{" + "tipo_atendimento_nome=" + tipo_atendimento_nome + ", tipo_atendimento_codigo=" + tipo_atendimento_codigo + ", tipo_aberto=" + tipo_aberto + ", tipo_total=" + tipo_total + '}';
    }
}

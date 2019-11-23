package classes;

import java.io.Serializable;

public class Gerente implements Serializable {
    private String gerente_nome;
    private String gerente_cpf;
    private String gerente_email;
    private String gerente_rua;
    private int    gerente_numero;
    private String gerente_complemento;
    private String gerente_bairro;
    private String gerente_cep;
    private String gerente_cidade;
    private String gerente_telefone;
    private String gerente_senha;
    private String gerente_estado;
    private String gerente_salt;
    
    public Gerente(){}
    
    public Gerente(String gerente_nome, String gerente_cpf, String gerente_email, String gerente_rua, int gerente_numero, String gerente_complemento, String gerente_bairro, String gerente_cep, String gerente_cidade, String gerente_telefone, String gerente_senha,String gerente_estado, String gerente_salt) {
        this.gerente_nome = gerente_nome;
        this.gerente_cpf = gerente_cpf;
        this.gerente_email = gerente_email;
        this.gerente_rua = gerente_rua;
        this.gerente_numero = gerente_numero;
        this.gerente_complemento = gerente_complemento;
        this.gerente_bairro = gerente_bairro;
        this.gerente_cep = gerente_cep;
        this.gerente_cidade = gerente_cidade;
        this.gerente_telefone = gerente_telefone;
        this.gerente_senha = gerente_senha;
        this.gerente_estado = gerente_estado;
        this.gerente_salt = gerente_salt;
    }

    public String getGerente_nome() {
        return gerente_nome;
    }

    public void setGerente_nome(String gerente_nome) {
        this.gerente_nome = gerente_nome;
    }

    public String getGerente_cpf() {
        return gerente_cpf;
    }

    public void setGerente_cpf(String gerente_cpf) {
        this.gerente_cpf = gerente_cpf;
    }

    public String getGerente_email() {
        return gerente_email;
    }

    public void setGerente_email(String gerente_email) {
        this.gerente_email = gerente_email;
    }

    public String getGerente_rua() {
        return gerente_rua;
    }

    public void setGerente_rua(String gerente_rua) {
        this.gerente_rua = gerente_rua;
    }

    public int getGerente_numero() {
        return gerente_numero;
    }

    public void setGerente_numero(int gerente_numero) {
        this.gerente_numero = gerente_numero;
    }

    public String getGerente_complemento() {
        return gerente_complemento;
    }

    public void setGerente_complemento(String gerente_complemento) {
        this.gerente_complemento = gerente_complemento;
    }

    public String getGerente_bairro() {
        return gerente_bairro;
    }

    public void setGerente_bairro(String gerente_bairro) {
        this.gerente_bairro = gerente_bairro;
    }

    public String getGerente_cep() {
        return gerente_cep;
    }

    public void setGerente_cep(String gerente_cep) {
        this.gerente_cep = gerente_cep;
    }

    public String getGerente_cidade() {
        return gerente_cidade;
    }

    public void setGerente_cidade(String gerente_cidade) {
        this.gerente_cidade = gerente_cidade;
    }

    public String getGerente_telefone() {
        return gerente_telefone;
    }

    public void setGerente_telefone(String gerente_telefone) {
        this.gerente_telefone = gerente_telefone;
    }

    public String getGerente_senha() {
        return gerente_senha;
    }

    public void setGerente_senha(String gerente_senha) {
        this.gerente_senha = gerente_senha;
    }

    public String getGerente_estado() {
        return gerente_estado;
    }

    public void setGerente_estado(String gerente_estado) {
        this.gerente_estado = gerente_estado;
    }

    public String getGerente_salt() {
        return gerente_salt;
    }

    public void setGerente_salt(String gerente_salt) {
        this.gerente_salt = gerente_salt;
    }

    @Override
    public String toString() {
        return "Gerente{" + "gerente_nome=" + gerente_nome + ", gerente_cpf=" + gerente_cpf + ", gerente_email=" + gerente_email + ", gerente_rua=" + gerente_rua + ", gerente_numero=" + gerente_numero + ", gerente_complemento=" + gerente_complemento + ", gerente_bairro=" + gerente_bairro + ", gerente_cep=" + gerente_cep + ", gerente_cidade=" + gerente_cidade + ", gerente_telefone=" + gerente_telefone + ", gerente_senha=" + gerente_senha + ", gerente_estado=" + gerente_estado + ", gerente_salt=" + gerente_salt + '}';
    }

  
}

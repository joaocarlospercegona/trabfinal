package classes;

public class Pessoa {
    private String pessoa_nome;
    private String pessoa_cpf;
    private String pessoa_email;
    private String pessoa_rua;
    private int    pessoa_numero;
    private String pessoa_complemento;
    private String pessoa_bairro;
    private String pessoa_cep;
    private String pessoa_cidade;
    private String pessoa_telefone;
    private String pessoa_senha;
    private String pessoa_estado;

    public Pessoa() {
    }

    public Pessoa(String pessoa_nome, String pessoa_cpf, String pessoa_email, String pessoa_rua, int pessoa_numero, String pessoa_complemento, String pessoa_bairro, String pessoa_cep, String pessoa_cidade, String pessoa_telefone, String pessoa_senha, String pessoa_estado) {
        this.pessoa_nome = pessoa_nome;
        this.pessoa_cpf = pessoa_cpf;
        this.pessoa_email = pessoa_email;
        this.pessoa_rua = pessoa_rua;
        this.pessoa_numero = pessoa_numero;
        this.pessoa_complemento = pessoa_complemento;
        this.pessoa_bairro = pessoa_bairro;
        this.pessoa_cep = pessoa_cep;
        this.pessoa_cidade = pessoa_cidade;
        this.pessoa_telefone = pessoa_telefone;
        this.pessoa_senha = pessoa_senha;
        this.pessoa_estado = pessoa_estado;
    }

    public String getPessoa_nome() {
        return pessoa_nome;
    }

    public void setPessoa_nome(String pessoa_nome) {
        this.pessoa_nome = pessoa_nome;
    }

    public String getPessoa_cpf() {
        return pessoa_cpf;
    }

    public void setPessoa_cpf(String pessoa_cpf) {
        this.pessoa_cpf = pessoa_cpf;
    }

    public String getPessoa_email() {
        return pessoa_email;
    }

    public void setPessoa_email(String pessoa_email) {
        this.pessoa_email = pessoa_email;
    }

    public String getPessoa_rua() {
        return pessoa_rua;
    }

    public void setPessoa_rua(String pessoa_rua) {
        this.pessoa_rua = pessoa_rua;
    }

    public int getPessoa_numero() {
        return pessoa_numero;
    }

    public void setPessoa_numero(int pessoa_numero) {
        this.pessoa_numero = pessoa_numero;
    }

    public String getPessoa_complemento() {
        return pessoa_complemento;
    }

    public void setPessoa_complemento(String pessoa_complemento) {
        this.pessoa_complemento = pessoa_complemento;
    }

    public String getPessoa_bairro() {
        return pessoa_bairro;
    }

    public void setPessoa_bairro(String pessoa_bairro) {
        this.pessoa_bairro = pessoa_bairro;
    }

    public String getPessoa_cep() {
        return pessoa_cep;
    }

    public void setPessoa_cep(String pessoa_cep) {
        this.pessoa_cep = pessoa_cep;
    }

    public String getPessoa_cidade() {
        return pessoa_cidade;
    }

    public void setPessoa_cidade(String pessoa_cidade) {
        this.pessoa_cidade = pessoa_cidade;
    }

    public String getPessoa_telefone() {
        return pessoa_telefone;
    }

    public void setPessoa_telefone(String pessoa_telefone) {
        this.pessoa_telefone = pessoa_telefone;
    }

    public String getPessoa_senha() {
        return pessoa_senha;
    }

    public void setPessoa_senha(String pessoa_senha) {
        this.pessoa_senha = pessoa_senha;
    }

    public String getPessoa_estado() {
        return pessoa_estado;
    }

    public void setPessoa_estado(String pessoa_estado) {
        this.pessoa_estado = pessoa_estado;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "pessoa_nome=" + pessoa_nome + ", pessoa_cpf=" + pessoa_cpf + ", pessoa_email=" + pessoa_email + ", pessoa_rua=" + pessoa_rua + ", pessoa_numero=" + pessoa_numero + ", pessoa_complemento=" + pessoa_complemento + ", pessoa_bairro=" + pessoa_bairro + ", pessoa_cep=" + pessoa_cep + ", pessoa_cidade=" + pessoa_cidade + ", pessoa_telefone=" + pessoa_telefone + ", pessoa_senha=" + pessoa_senha + ", pessoa_estado=" + pessoa_estado + '}';
    }
}

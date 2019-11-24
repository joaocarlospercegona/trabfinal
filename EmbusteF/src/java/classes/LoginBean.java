package classes;

public class LoginBean {
    String cpf;
    String nome;

    public LoginBean() {
    }

    public LoginBean(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "LoginBean{" + "cpf=" + cpf + ", nome=" + nome + '}';
    }    
}

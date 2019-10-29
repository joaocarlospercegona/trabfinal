/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;


import static Facade.Facade.altera_Cliente;
import static Facade.Facade.buscaTodos_Cliente;
import static Facade.Facade.buscaTodos_Funcionario;
import static Facade.Facade.busca_Cliente;
import static Facade.Facade.insere_Cliente;
import static Facade.Facade.insere_Funcionario;
import static Facade.Facade.insere_Gerente;
import java.util.List;

/**
 *
 * @author lps
 */
public class teste {
    public static void main(String[] args) {
        //fazendo
        Gerente p = new Gerente();

        Cliente c = new Cliente();
        int nr = 813;
        String senha;
        
                                c.setCliente_nome("Joao Carlos Percegona de Souza");
                                c.setCliente_telefone("(41)984348198");
                                c.setCliente_cpf("113.778.709-01");
                                c.setCliente_email("joaokarlospercegona@gmail.com");
                                c.setCliente_cep("83414-090");
                                c.setCliente_estado("Paraná");
                                c.setCliente_cidade("Colombo");
                                c.setCliente_bairro("Centro");
                                c.setCliente_rua("Julio Prestes de Araujo");
                                c.setCliente_numero(nr);
                                c.setCliente_complemento("Esquina");
                                c.setCliente_senha("156225");
                                
                                altera_Cliente(c, "113.778.709-01");
}
}
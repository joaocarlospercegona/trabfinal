/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import DAO.AtendimentoDAO;
import DAO.ClienteDAO;
import DAO.FuncionarioDAO;
import DAO.GerenteDAO;
import classes.Atendimento;
import classes.Cliente;
import classes.Funcionario;
import classes.Gerente;
import java.util.List;

/**
 *
 * @author joao
 */
public class Facade {
//----------------------------------------------------------------------------------------------------
//CLIENTE
    public static void insere_Cliente(Cliente pessoa){
        ClienteDAO dao = new ClienteDAO();
        dao.create(pessoa);
    }
    
    public static void altera_Cliente(Cliente cliente, String cpf){ 
        ClienteDAO dao = new ClienteDAO();
        dao.edit(cliente,cpf); 
    }
    public static void exclui_Cliente(String cpff){
        //int cpf = Integer.parseInt(cpff);
        ClienteDAO dao = new ClienteDAO();
        dao.destroy(cpff);
    }
    public static Cliente busca_Cliente(String cpff){
            ClienteDAO dao = new ClienteDAO();
                    return dao.find(cpff);
    }
    public static List<Cliente> buscaTodos_Cliente(){
        ClienteDAO dao = new ClienteDAO();
        List<Cliente> c = dao.findEntities(true,100,1);
        return c;
    }
    
    public static List<Atendimento> buscaTodos_Atendimentos_Cliente(String cpf){
        ClienteDAO dao = new ClienteDAO();
        List<Atendimento> c = dao.findAtendimentos(true,100,1,cpf);
        return c;
    }
//----------------------------------------------------------------------------------------------------
//FUNCIONARIO
    public static void insere_Funcionario(Funcionario pessoa){
        FuncionarioDAO dao = new FuncionarioDAO();
        dao.create(pessoa);
    }
    public static void altera_Funcionario(Funcionario funcionario, String id){ 
        FuncionarioDAO dao = new FuncionarioDAO();
        dao.edit(funcionario,id); 
    }
    public static void exclui_Funcionario(String idd){
        //int id = Integer.parseInt(idd);
        FuncionarioDAO dao = new FuncionarioDAO();
        dao.destroy(idd);
    }
    public static Funcionario busca_Funcionario(String idd){
            FuncionarioDAO dao = new FuncionarioDAO();
                    return dao.find(idd);
    }
    public static List<Funcionario> buscaTodos_Funcionario(){
        FuncionarioDAO dao = new FuncionarioDAO();
        List<Funcionario> c = dao.findEntities(true,100,1);
        return c;
    }
//-------------------------------------------------------------------------------------------------
//GERENTE
    public static void insere_Gerente(Gerente pessoa){
        GerenteDAO dao = new GerenteDAO();
        dao.create(pessoa);
    }
    public static void altera_Gerente(Gerente gerente, String id){ 
        GerenteDAO dao = new GerenteDAO();
        dao.edit(gerente,id); 
    }
    public static void exclui_Gerente(String idd){
        GerenteDAO dao = new GerenteDAO();
        dao.destroy(idd);
    }
    public static Gerente busca_Gerente(String idd){
            GerenteDAO dao = new GerenteDAO();
                    return dao.find(idd);
    }
    public static List<Gerente> buscaTodos_Gerente(){
        GerenteDAO dao = new GerenteDAO();
        List<Gerente> c = dao.findEntities(true,100,1);
        return c;
    }
//------------------------------------------------------------------------------------------------
//ATENDIMENTO
    public static List<Atendimento> buscaTodos_Atendimentos(){
        AtendimentoDAO dao = new AtendimentoDAO();
        List<Atendimento> c = dao.findEntities(true,100,1);
        return c;
    }
}
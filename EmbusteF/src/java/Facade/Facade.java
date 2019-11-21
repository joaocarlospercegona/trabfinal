/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import DAO.AtendimentoDAO;
import DAO.CategoriaDAO;
import DAO.ClienteDAO;
import DAO.FuncionarioDAO;
import DAO.GerenteDAO;
import DAO.ProdutoDAO;
import classes.Atendimento;
import classes.Cliente;
import classes.Funcionario;
import classes.Gerente;
import classes.Produto;
import classes.Tipo_Atendimento;
import classes.categoria;
import java.util.ArrayList;
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
    public static Tipo_Atendimento BuscaTipo(int id){
        AtendimentoDAO dao = new AtendimentoDAO();
        return dao.findt(id);
    }
    public static List<Tipo_Atendimento> BuscaTodos_Tipos(){
        AtendimentoDAO dao = new AtendimentoDAO();
        List<Tipo_Atendimento> c = dao.findEntitiest(true,100,1);
        return c;
    }
    public static void altera_atendimento(String solucao, int id){ 
        AtendimentoDAO dao = new AtendimentoDAO();
        dao.edit(solucao, id); 
    }
    public static List<Atendimento> buscaTodos_Atendimentos_abertos(){
        AtendimentoDAO dao = new AtendimentoDAO();
        List<Atendimento> c = dao.findEntities(true,100,1);
        List<Atendimento> a = new ArrayList();
        for(Atendimento x : c){
            if(x.getAtendimento_situacao().equals("Em aberto")){
                a.add(x);
            }
        }
        return a;
    }
    public static List<Atendimento> buscaTodos_Atendimentos(){
        AtendimentoDAO dao = new AtendimentoDAO();
        List<Atendimento> c = dao.findEntities(true,100,1);
        return c;
    }
    
    public static Atendimento busca_Atendimento(String cod){
        Atendimento a = new Atendimento();
        int coda = Integer.parseInt(cod);
        AtendimentoDAO dao = new AtendimentoDAO();
        List<Atendimento> c = dao.findEntities(true,100,1);
        for(Atendimento x : c){
            if(x.getAtendimento_codigo() == coda){
                a = x;
            }
        }
        return a;
    }
     public static void insere_atendimento(Atendimento a){
        AtendimentoDAO dao = new AtendimentoDAO();
        dao.create(a);
    }
     
    public static void exclui_Atendimento(String cod){
        AtendimentoDAO dao = new AtendimentoDAO();
        int codd = Integer.parseInt(cod);
        dao.destroy(codd);
    }
//-----------------------------------------------------------------------------------------------
//CATEGORIAS
    public static List<Atendimento> buscaTodos_Atendimentos_aberto_regra(){
        AtendimentoDAO dao = new AtendimentoDAO();
        List<Atendimento> c = dao.findEntities(true,100,1);
        return c;
    }    
    public static List<categoria> buscaTodas_Categorias(){
        CategoriaDAO dao = new CategoriaDAO();
        List<categoria> c = dao.findEntities(true,100,1);
        return c;
    }
    public static void insere_Categoria(categoria categoria){
        CategoriaDAO dao = new CategoriaDAO();
        dao.create(categoria);
    }
     public static void altera_Categoria(categoria categoria, int id){ 
        CategoriaDAO dao = new CategoriaDAO();
        dao.edit(categoria,id); 
    }
    public static String exclui_Categoria(int idd){
        CategoriaDAO dao = new CategoriaDAO();
        String msg = dao.destroy(idd);
        return msg;
    }
    public static categoria busca_Categoria(int idd){
            CategoriaDAO dao = new CategoriaDAO();
                    return dao.find(idd);
    }
//-----------------------------------------------------------------------------------------------
//PRODUTOS
    public static List<Produto> buscaTodos_Produtos(){
        ProdutoDAO dao = new ProdutoDAO();
        List<Produto> c = dao.findEntities(true,100,1);
        return c;
    }
    public static void insere_Produtos(Produto produto){
        ProdutoDAO dao = new ProdutoDAO();
        dao.create(produto);
    }
     public static void altera_Produtos(Produto produto, int id){ 
        ProdutoDAO dao = new ProdutoDAO();
        dao.edit(produto,id); 
    }
    public static void exclui_Produtos(int idd){
        ProdutoDAO dao = new ProdutoDAO();
        dao.destroy(idd);
    }
    public static Produto busca_Produtos(int idd){
            ProdutoDAO dao = new ProdutoDAO();
            return dao.find(idd);
    }
    
    public static String retorna_valor(int cod){
        String a = null;
            ProdutoDAO dao = new ProdutoDAO();
            a= dao.retorna(cod);
        return a;
    }
}
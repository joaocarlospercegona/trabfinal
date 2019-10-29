/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import classes.Atendimento;
import classes.Produto;
import classes.categoria;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author joao
 */
@WebServlet(name = "FuncionarioServlet", urlPatterns = {"/FuncionarioServlet"})
public class FuncionarioServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         HttpSession session = request.getSession();
            String logado = (String) session.getAttribute("logado");
            
                String action = request.getParameter("action");
                if(action != null){
                    switch (action){  
                        case "painel_cadastro":
                        {
                            List<Produto> produtos = new ArrayList();
                            List<categoria> categorias = new ArrayList();
                            //aqui iremos chamar o model para pegar os produtos
                            //aqui iremos chamar o model para pegar as categorias
                            request.setAttribute("produtos",produtos); 
                            request.setAttribute("categorias",categorias);
                            RequestDispatcher rd = getServletContext().
                                   getRequestDispatcher("/funcionario-cadastro.jsp");
                             rd.forward(request, response);
                            break;
                        }
                        case "cadastrar_produto":
                        {   
                            List<categoria> categorias = new ArrayList();
                            categorias = buscar_Categorias();
                            //request.setAttribute("categorias",categorias);
                            RequestDispatcher rd = getServletContext().
                                   getRequestDispatcher("/funcionario-cad-prod.jsp");
                             rd.forward(request, response);
                            break;
                        }
                        case "cadastrar_categoria":
                        {
                            RequestDispatcher rd = getServletContext().
                                   getRequestDispatcher("/funcionario-cad-categ.jsp");
                             rd.forward(request, response);
                            break;
                        }
                        case "cadastrando_produto":
                        {
                            //editar o a tela cadastrar produto falta o campo peso
                            //ver como recebe os campos da cadastrar produto... perguntar pro bolado_carlinhos
                            
                            int cod_categoria = 0;
                            int peso = 0;
                            Produto produto = new Produto();
                            produto.setProduto_nome("");
                            produto.setProduto_descricao("");
                            produto.setProduto_cod_categoria(cod_categoria);           
                            produto.setProduto_peso(peso);
                            
                            //aqui chamamos o model para se conectar com o banco e inserir um novo produto
                            
                            //tem que criar uma menu para o funcionario, nao tem menu de cliente, funcionario nem gerente
                            RequestDispatcher rd = getServletContext().
                                   getRequestDispatcher("/funcionario-cadastro.jsp");
                            rd.forward(request, response);
                            break;
                        }
                        case "cadastrando_categoria":
                        {
                            //ver como recebe os campos da cadastrar produto... perguntar pro bolado_carlinhos
                            
                            categoria categoria = new categoria();
                            categoria.setCategoria_nome("");
                            
                            //aqui chamamos o model para se conectar com o banco e inserir um novo produto
                            
                            //tem que criar uma menu para o funcionario, nao tem menu de cliente, funcionario nem gerente
                            
                            RequestDispatcher rd = getServletContext().
                                   getRequestDispatcher("/funcionario-cadastro.jsp");
                            rd.forward(request, response);
                            break;
                        }
                        case "atendimentos_abertos":
                        {
                            //OS ATENDIMENTOS EM ABERTOS SERAO OS QUE TEM 1 NA SITUACAO E OS ENCERRADOS 0
                            List<Atendimento> atendimentos = new ArrayList();
                            //aqui vai chamar o model para conectar com o banco e trazer os atendimentos em aberto
                            request.setAttribute("atendimentos_abertos",atendimentos);
                            //aqui ver se iremos criar duas jsp uma para abertos e outra para todos os atendimentos
                            RequestDispatcher rd = getServletContext().
                                   getRequestDispatcher("/funcionario-atendimentos.jsp");
                            rd.forward(request, response);
                            break;
                        }
                        case "todos_atendimentos":
                        {
                            List<Atendimento> atendimentos = new ArrayList();
                            //aqui via chamar o model para conectar com o banco e trazer todos os atendimentos
                            request.setAttribute("atendimentos",atendimentos);
                            //aqui ver se iremos criar duas jsp uma para abertos e outra para todos os atendimentos
                            RequestDispatcher rd = getServletContext().
                                   getRequestDispatcher("/funcionario-atendimentos.jsp");
                            rd.forward(request, response);
                            break;
                        }
                        case "resolucao":
                        {
                            //PAREI NESSE AQUI//////////---------------------
                            Atendimento atendimento = new Atendimento();
                            //aqui vai chamar o model para conectar com o banco e trazer o atendimento escolhido pelo funcionario
                            request.setAttribute("antedimento",atendimento);
                            RequestDispatcher rd = getServletContext().
                                   getRequestDispatcher("/resolucao-atendimento.jsp");
                            rd.forward(request, response);
                            break;
                        }
                    }
                
        
            }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

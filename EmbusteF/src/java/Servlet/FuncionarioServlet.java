/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import static Facade.Facade.altera_Categoria;
import static Facade.Facade.altera_Produtos;
import static Facade.Facade.buscaTodas_Categorias;
import static Facade.Facade.buscaTodos_Produtos;
import static Facade.Facade.busca_Categoria;
import static Facade.Facade.busca_Produtos;
import static Facade.Facade.exclui_Categoria;
import static Facade.Facade.exclui_Produtos;
import static Facade.Facade.insere_Categoria;
import static Facade.Facade.insere_Produtos;
import static Facade.Facade.retorna_valor;
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
             PrintWriter out = response.getWriter();
             response.setContentType("text/html;charset=UTF-8");
             HttpSession session = request.getSession();
             String logado = (String) session.getAttribute("logado");
            
                String action = request.getParameter("action");
                if(action != null){
                    switch (action){  
                        case "painel_cadastro":
                        {
                            List<categoria> categorias = buscaTodas_Categorias();
                            out.println(categorias);
                            request.setAttribute("cat",categorias);
                            request.setAttribute("func","categoria");
                            RequestDispatcher rd = getServletContext().
                                   getRequestDispatcher("/funcionario-cadastro.jsp");
                             rd.forward(request, response);
                            break;
                        }
                        case "ver_produtos":
                        {
                              out.println("cheguei papai");
                            List<Produto> produtos = buscaTodos_Produtos();
                            request.setAttribute("func","produto");
                            request.setAttribute("prod",produtos);
                            RequestDispatcher rd = getServletContext().
                                   getRequestDispatcher("/funcionario-cadastro.jsp");
                            rd.forward(request, response);
                            break;
                        }
                        case "cadastrar_produto":
                        {   
                            List<categoria> categorias = new ArrayList();
                            categorias = buscaTodas_Categorias();
                            request.setAttribute("categorias",categorias);
                            request.setAttribute("func","cadastrar");
                            RequestDispatcher rd = getServletContext().
                                   getRequestDispatcher("/funcionario-cad-prod.jsp");
                             rd.forward(request, response);
                            break;
                        }
                        case "cadastrar_categoria":
                        {
                            request.setAttribute("func","cadastrar");
                            RequestDispatcher rd = getServletContext().
                                   getRequestDispatcher("/funcionario-cad-categ.jsp");
                             rd.forward(request, response);
                            break;
                        }
                        case "cadastrando_produto":
                        {
                            String cod = request.getParameter("select");
                            String pesoS = request.getParameter("peso");
                            int cod_categoria = Integer.parseInt(cod);
                            int peso = Integer.parseInt(pesoS);
                            Produto produto = new Produto();
                            produto.setProduto_nome(request.getParameter("nome"));
                            produto.setProduto_descricao(request.getParameter("descricao"));
                            produto.setProduto_cod_categoria(cod_categoria);           
                            produto.setProduto_peso(peso);
                            
                            insere_Produtos(produto);
                            
                            RequestDispatcher rd = getServletContext().
                                   getRequestDispatcher("/FuncionarioServlet?action=ver_produtos");
                            rd.forward(request, response);
                            break;
                        }
                        case "cadastrando_categoria":
                        {
                            categoria categoria = new categoria();
                            categoria.setCategoria_nome(request.getParameter("nome"));
                            //aqui chamamos o model para se conectar com o banco e inserir um novo produto
                            insere_Categoria(categoria);
                            request.setAttribute("func","categoria");
                            RequestDispatcher rd = getServletContext().
                                   getRequestDispatcher("/funcionario-cadastro.jsp");
                            rd.forward(request, response);
                            break;
                        }
                        case "alterar_categoria":
                        {
                            String idd = request.getParameter("id");
                            int id = Integer.parseInt(idd);
                            categoria categoria = new categoria();
                            categoria = busca_Categoria(id);
                            //vamos fazer algo para tudo ficar na funcionario cadastro categoria
                            request.setAttribute("func","alterar");
                            request.setAttribute("categoria", categoria);
                            RequestDispatcher rd = getServletContext().
                                   getRequestDispatcher("/funcionario-cad-categ.jsp");
                            rd.forward(request, response);
                            break;
                        }
                        case "alterar_produto":
                        {
                            String idd = request.getParameter("id");
                            int id = Integer.parseInt(idd);
                            Produto produto = new Produto();
                            produto = busca_Produtos(id);
                            String catnome = retorna_valor(produto.getProduto_cod_categoria());
                            request.setAttribute("nome",catnome); 
                            List<categoria> cat = buscaTodas_Categorias();
                            request.setAttribute("categorias",cat);
                            request.setAttribute("func","alterar");
                            request.setAttribute("prod", produto);
                            RequestDispatcher rd = getServletContext().
                                   getRequestDispatcher("/funcionario-cad-prod.jsp");
                            rd.forward(request, response);
                            break;
                        }
                        case "alterando_categoria":
                        {
                            String idd = request.getParameter("idc");
                            int id = Integer.parseInt(idd);
                            categoria categoria = new categoria();
                            categoria.setCategoria_nome(request.getParameter("nome"));
                            altera_Categoria(categoria,id);
                            RequestDispatcher rd = getServletContext().
                                   getRequestDispatcher("/FuncionarioServlet?action=painel_cadastro");
                            rd.forward(request, response);
                            break;
                        }
                        case "alterando_produto":
                        {
                            String cod = request.getParameter("select");
                            String pesoS = request.getParameter("peso");
                            int cod_categoria = Integer.parseInt(cod);
                            int peso = Integer.parseInt(pesoS);
                            String idd = request.getParameter("idp");
                            int id = Integer.parseInt(idd);
                            out.println("select ="+cod_categoria +"peso = "+ peso +"idp = "+id);
                            Produto produto = new Produto();
                            produto.setProduto_nome(request.getParameter("nome"));
                            produto.setProduto_descricao(request.getParameter("descricao"));
                            produto.setProduto_peso(peso);
                            produto.setProduto_cod_categoria(cod_categoria);
                            
                            altera_Produtos(produto, id);
                            
                            //parei aqui
                            
                            RequestDispatcher rd = getServletContext().
                                   getRequestDispatcher("/FuncionarioServlet?action=ver_produtos");
                            rd.forward(request, response);
                            break;
                        }
                        case "vizualizar_categoria":
                        {
                            String idd = request.getParameter("id");
                            int id = Integer.parseInt(idd);
                            categoria categoria = new categoria();
                            categoria = busca_Categoria(id);
                            request.setAttribute("func","visualizar");
                            request.setAttribute("categoria", categoria);
                            RequestDispatcher rd = getServletContext().
                                   getRequestDispatcher("/funcionario-cad-categ.jsp");
                            rd.forward(request, response);
                            break;
                        }
                        case "visualizar_produto":
                        {
                            out.println("aqui");
                            String idd = request.getParameter("id");
                            int id = Integer.parseInt(idd);
                            Produto produto = busca_Produtos(id);
                            String catnome = retorna_valor(produto.getProduto_cod_categoria());
                            request.setAttribute("nome",catnome);   
                            request.setAttribute("func","visualizar");
                            request.setAttribute("prod", produto);
                            
                            RequestDispatcher rd = getServletContext().
                                   getRequestDispatcher("/funcionario-cad-prod.jsp");
                            rd.forward(request, response);
                            break;
                        }
                        case "remover_categoria":
                        {
                            String idd = request.getParameter("id");
                            int id = Integer.parseInt(idd);
                            exclui_Categoria(id);
                            RequestDispatcher rd = getServletContext().
                                   getRequestDispatcher("/FuncionarioServlet?action=painel_cadastro");
                            rd.forward(request, response);
                            break;
                        }
                        case "remover_produto":
                        {
                            String idd = request.getParameter("id");
                            int id = Integer.parseInt(idd);
                            exclui_Produtos(id);
                            RequestDispatcher rd = getServletContext().
                                   getRequestDispatcher("/FuncionarioServlet?action=ver_produtos");
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

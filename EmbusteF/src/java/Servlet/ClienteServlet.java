/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import static Facade.Facade.altera_Cliente;
import static Facade.Facade.busca_Cliente;
import static Facade.Facade.insere_Cliente;
import classes.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ClienteServlet", urlPatterns = {"/ClienteServlet"})
public class ClienteServlet extends HttpServlet {

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
           // String logado = (String) session.getAttribute("logado");
            String cpf = (String) session.getAttribute("cpf_logado");
            //FAZER O IF DE LOGADO NOVAMENTE
            
            
            //TRAZER O CASE NEW AQUI PRA CIMA
            String action = request.getParameter("action");
                if(action != null){
                    switch (action){
                        case "cadastro_cliente":
                        {
                            int nr = Integer.parseInt(request.getParameter("numero"));
                            String senha = request.getParameter("senha");
                            String senha2 = request.getParameter("senha2");
                            if(senha.equals(senha2)){
                            out.println(nr);
                                Cliente c = new Cliente();
                                c.setCliente_nome(request.getParameter("usuario"));
                                c.setCliente_telefone(request.getParameter("telefone"));
                                c.setCliente_cpf(request.getParameter("cpf"));
                                c.setCliente_email(request.getParameter("email"));
                                c.setCliente_cep(request.getParameter("cep"));
                                c.setCliente_estado(request.getParameter("estado"));
                                c.setCliente_cidade(request.getParameter("cidade"));
                                c.setCliente_bairro(request.getParameter("bairro"));
                                c.setCliente_rua(request.getParameter("rua"));
                                c.setCliente_numero(nr);
                                c.setCliente_complemento(request.getParameter("complemento"));
                                c.setCliente_senha(senha);
                                insere_Cliente(c);
                                RequestDispatcher rd = getServletContext().
                                getRequestDispatcher("/login.jsp");
                                rd.forward(request, response);
                            }
                            break;
                        }                        
                        case "alterar_dados":
                        {
                            Cliente c = busca_Cliente(cpf);
                            request.setAttribute("c",c);
                            RequestDispatcher rd = getServletContext().
                                getRequestDispatcher("/cliente-alterar-dados.jsp");
                            rd.forward(request, response);
                            break;
                        }
                        case "alterando_dados":
                        {
                            //msm campos que a cadastra entao podemos criar uma funçao e retornar apenas o obj, mas deixarei isso 
                            //para depois
                            int nr = Integer.parseInt(request.getParameter("numero"));
                            String senha = request.getParameter("senha");
                            String senha2 = request.getParameter("senha2");
                            if(senha.equals(senha2)){
                                Cliente c = new Cliente();
                                c.setCliente_nome(request.getParameter("usuario"));
                                c.setCliente_telefone(request.getParameter("telefone"));
                                c.setCliente_cpf(request.getParameter("cpfu"));
                                c.setCliente_email(request.getParameter("emailu"));
                                c.setCliente_cep(request.getParameter("cep"));
                                c.setCliente_estado(request.getParameter("estado"));
                                c.setCliente_cidade(request.getParameter("cidade"));
                                c.setCliente_bairro(request.getParameter("bairro"));
                                c.setCliente_rua(request.getParameter("rua"));
                                c.setCliente_numero(nr);
                                c.setCliente_complemento(request.getParameter("complemento"));
                                c.setCliente_senha(senha);
                                
                                out.println(c.getCliente_cpf());
                                altera_Cliente(c, c.getCliente_cpf());
                                
                                RequestDispatcher rd = getServletContext().
                                    getRequestDispatcher("/cliente-meus-atendimentos.jsp");
                                rd.forward(request, response);
                            }
                            break;
                        }
                        case "novo_atendimento":
                        {       
                                //Precisa trazer todos os DADOS DE CATEGORIA
                                //Precisa trazer todos os produtos de todas a categorias
                                //Ver sobre os tipos de atendimentos ... 
                                
                                RequestDispatcher rd = getServletContext().
                                getRequestDispatcher("/cliente-novo-atendimento.jsp");
                                rd.forward(request, response);
                                break;
                        }
                        case "Listagem_atendimentos":
                        {
                            //vai ter q buscar no bando de dados os atendimentos.
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

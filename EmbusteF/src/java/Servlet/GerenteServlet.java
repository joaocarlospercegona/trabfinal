package Servlet;

import static Facade.Facade.BuscaTipo;
import static Facade.Facade.altera_Funcionario;
import static Facade.Facade.altera_Gerente;
import static Facade.Facade.buscaTodas_Categorias;
import static Facade.Facade.buscaTodos_Atendimentos;
import static Facade.Facade.buscaTodos_Atendimentos_abertos;
import static Facade.Facade.buscaTodos_Funcionario;
import static Facade.Facade.buscaTodos_Gerente;
import static Facade.Facade.buscaTodos_Produtos;
import static Facade.Facade.busca_Atendimento;
import static Facade.Facade.busca_Cliente;
import static Facade.Facade.busca_Funcionario;
import static Facade.Facade.busca_Gerente;
import static Facade.Facade.busca_Produtos;
import static Facade.Facade.exclui_Funcionario;
import static Facade.Facade.exclui_Gerente;
import static Facade.Facade.insere_Funcionario;
import static Facade.Facade.insere_Gerente;
import classes.Atendimento;
import classes.Cliente;
import classes.Funcionario;
import classes.Gerente;
import classes.LoginBean;
import classes.Pessoa;
import classes.Produto;
import classes.Tipo_Atendimento;
import classes.categoria;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.joda.time.DateTime;
import org.joda.time.Days;

@WebServlet(name = "GerenteServlet", urlPatterns = {"/GerenteServlet"})
public class GerenteServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             PrintWriter out = response.getWriter();
             response.setContentType("text/html;charset=UTF-8");
            HttpSession session = request.getSession();
            LoginBean logado = (LoginBean) session.getAttribute("gerenteOn");
            String action = request.getParameter("action");
            String cpf1 = logado.getCpf();
            if(logado == null){
                request.setAttribute("msg","Usuario deve se autenticar para acessar o sistema.");
                RequestDispatcher rd = getServletContext().
                    getRequestDispatcher("/login.jsp");
                rd.forward(request, response);
            }
            else{
                if(action != null){
                    switch (action){ 
                        case "listar":
                        {
                            List<Funcionario> funcionarios = buscaTodos_Funcionario();
                            request.setAttribute("funcionarios",funcionarios);
                            request.setAttribute("func","funcionario");
                            RequestDispatcher rd = getServletContext().
                                getRequestDispatcher("/gerente-funcionarios.jsp");
                            rd.forward(request, response);
                            break;
                        }
                        case "listar_gerente":
                        {
                            List<Gerente> gerentes =  buscaTodos_Gerente();
                            request.setAttribute("gerentes",gerentes);
                            request.setAttribute("func","gerente");
                            RequestDispatcher rd = getServletContext().
                                getRequestDispatcher("/gerente-funcionarios.jsp");
                            rd.forward(request, response);
                            break;
                        }
                        case "resolucao":
                        {
                            Cliente c = new Cliente();
                            Produto p = new Produto();
                            Tipo_Atendimento t = new Tipo_Atendimento();
                            String cod = request.getParameter("cod");
                            out.println(cod);
                            Atendimento atendimento = new Atendimento();
                            atendimento = busca_Atendimento(cod);
                            c = busca_Cliente(atendimento.getAtendimento_cpf_cliente());
                            p = busca_Produtos(atendimento.getAtendimento_cod_produto());
                            t = BuscaTipo(atendimento.getAtendimento_cod_tipo_atendimento());
                            request.setAttribute("tipo",t);
                            request.setAttribute("produto",p);
                            request.setAttribute("cliente",c);
                            request.setAttribute("atendimento",atendimento); 
                            RequestDispatcher rd = getServletContext().
                                   getRequestDispatcher("/resolucao-atendimento.jsp");
                            rd.forward(request, response);
                            break;
                        }
                        case "novo":
                        {

                            RequestDispatcher rd = getServletContext().
                                     getRequestDispatcher("/gerente-cadastra.jsp");
                                rd.forward(request, response);
                            break;
                        }
                        case "cadastrando":{
                            String option = (String) request.getParameter("tipo");
                            int nr = Integer.parseInt(request.getParameter("numero"));
                            String senha = request.getParameter("senha");
                            String senha2 = request.getParameter("senha2");
                            
                            if(senha.equals(senha2)){
                                //option == 1 eh gerente
                                //option == 2 eh funcionario
                                
                                if(option.equals("1")){
                                    Gerente gerente = new Gerente();
                                    gerente.setGerente_nome((String) request.getParameter("nome"));
                                    gerente.setGerente_cpf((String) request.getParameter("cpf"));
                                    gerente.setGerente_email((String) request.getParameter("email"));
                                    gerente.setGerente_telefone((String) request.getParameter("telefone"));
                                    gerente.setGerente_cep((String) request.getParameter("cep"));
                                    gerente.setGerente_estado((String) request.getParameter("estado"));
                                    gerente.setGerente_cidade((String) request.getParameter("cidade"));
                                    gerente.setGerente_bairro((String) request.getParameter("bairro"));
                                    gerente.setGerente_rua((String) request.getParameter("rua"));
                                    gerente.setGerente_numero(nr);
                                    gerente.setGerente_complemento((String) request.getParameter("complemento"));
                                    gerente.setGerente_senha(senha);
                                    insere_Gerente(gerente);
                                }
                                else if (option.equals("2")){
                                    Funcionario funcionario = new Funcionario();
                                    funcionario.setFuncionario_nome((String) request.getParameter("nome"));
                                    funcionario.setFuncionario_cpf((String) request.getParameter("cpf"));
                                    funcionario.setFuncionario_email((String) request.getParameter("email"));
                                    funcionario.setFuncionario_telefone((String) request.getParameter("telefone"));
                                    funcionario.setFuncionario_cep((String) request.getParameter("cep"));
                                    funcionario.setFuncionario_estado((String) request.getParameter("estado"));
                                    funcionario.setFuncionario_cidade((String) request.getParameter("cidade"));
                                    funcionario.setFuncionario_bairro((String) request.getParameter("bairro"));
                                    funcionario.setFuncionario_rua((String) request.getParameter("rua"));
                                    funcionario.setFuncionario_numero(nr);
                                    funcionario.setFuncionario_complemento((String) request.getParameter("complemento"));
                                    funcionario.setFuncionario_senha(senha);
                                    insere_Funcionario(funcionario);
                                }
                                RequestDispatcher rd = getServletContext().
                                getRequestDispatcher("/GerenteServlet?action=listar_gerente");
                                rd.forward(request, response);
                            }
                            break;
                        }
                        
                        case "alterar":
                        {
                            String cpf = (String)request.getParameter("cpf");
                            String type = request.getParameter("type");
                            //1 funcionario
                            //2 gerente
                            if(type.equals("1")){
                                Funcionario c = new Funcionario();
                                c = busca_Funcionario(cpf);
                                Pessoa p = new Pessoa();
                                p.setPessoa_nome(c.getFuncionario_nome());
                                p.setPessoa_cpf(c.getFuncionario_cpf());
                                p.setPessoa_email(c.getFuncionario_email());
                                p.setPessoa_telefone(c.getFuncionario_telefone());
                                p.setPessoa_cep(c.getFuncionario_cep());        
                                p.setPessoa_estado(c.getFuncionario_estado());
                                p.setPessoa_cidade(c.getFuncionario_cidade());
                                p.setPessoa_bairro(c.getFuncionario_bairro());
                                p.setPessoa_rua(c.getFuncionario_rua());
                                p.setPessoa_numero(c.getFuncionario_numero());
                                p.setPessoa_complemento(c.getFuncionario_complemento());
                                p.setPessoa_senha(c.getFuncionario_senha());
                                request.setAttribute("func","1");
                                request.setAttribute("c",p);
                            }
                            else if(type.equals("2")){
                                Gerente c = new Gerente();
                                c = busca_Gerente(cpf);
                                Pessoa p = new Pessoa();
                                p.setPessoa_nome(c.getGerente_nome());
                                p.setPessoa_cpf(c.getGerente_cpf());
                                p.setPessoa_email(c.getGerente_email());
                                p.setPessoa_telefone(c.getGerente_telefone());
                                p.setPessoa_cep(c.getGerente_cep());        
                                p.setPessoa_estado(c.getGerente_estado());
                                p.setPessoa_cidade(c.getGerente_cidade());
                                p.setPessoa_bairro(c.getGerente_bairro());
                                p.setPessoa_rua(c.getGerente_rua());
                                p.setPessoa_numero(c.getGerente_numero());
                                p.setPessoa_complemento(c.getGerente_complemento());
                                p.setPessoa_senha(c.getGerente_senha());
                                request.setAttribute("func","2");
                                request.setAttribute("c", p);
                            }
                            RequestDispatcher rd = getServletContext().
                                getRequestDispatcher("/gerente-altera.jsp");
                            rd.forward(request, response);
                            
                            break;
                        }
                        case "alterando":
                        {
                            String cpf = (String) request.getParameter("cpfu");
                            String email = (String) request.getParameter("emailu");
                            String option = (String) request.getParameter("tipo");
                            //option == 2 eh gerente
                            //option == 1 eh funcionario
                            String func = (String) request.getParameter("func");
                            out.println(func);
                            out.println(option);
                            int nr = Integer.parseInt(request.getParameter("numero"));
                            String senha = request.getParameter("senha");
                            String senha2 = request.getParameter("senha2");
                            
                            if(senha.equals(senha2)){
                                Funcionario funcionario = new Funcionario();
                                Gerente gerente = new Gerente();
                                                        
                                funcionario.setFuncionario_nome((String) request.getParameter("nome"));
                                funcionario.setFuncionario_cpf(cpf);
                                funcionario.setFuncionario_email(email);
                                funcionario.setFuncionario_telefone((String) request.getParameter("telefone"));
                                funcionario.setFuncionario_cep((String) request.getParameter("cep"));
                                funcionario.setFuncionario_estado((String) request.getParameter("estado"));
                                funcionario.setFuncionario_cidade((String) request.getParameter("cidade"));
                                funcionario.setFuncionario_bairro((String) request.getParameter("bairro"));
                                funcionario.setFuncionario_rua((String) request.getParameter("rua"));
                                funcionario.setFuncionario_numero(nr);
                                funcionario.setFuncionario_complemento((String) request.getParameter("complemento"));
                                funcionario.setFuncionario_senha(senha);
                            
                                
                                gerente.setGerente_nome((String) request.getParameter("nome"));
                                gerente.setGerente_cpf(cpf);
                                gerente.setGerente_email(email);
                                gerente.setGerente_telefone((String) request.getParameter("telefone"));
                                gerente.setGerente_cep((String) request.getParameter("cep"));
                                gerente.setGerente_estado((String) request.getParameter("estado"));
                                gerente.setGerente_cidade((String) request.getParameter("cidade"));
                                gerente.setGerente_bairro((String) request.getParameter("bairro"));
                                gerente.setGerente_rua((String) request.getParameter("rua"));
                                gerente.setGerente_numero(nr);
                                gerente.setGerente_complemento((String) request.getParameter("complemento"));
                                gerente.setGerente_senha(senha);
                                    
                            if(option.equals(func)){
                                if(option.equals("2")){
                                    altera_Gerente(gerente, gerente.getGerente_cpf());
                                }
                                else if(option.equals("1")){
                                    altera_Funcionario(funcionario, cpf);
                                }
                            }
                            else{
                                if(option.equals("2")){
                                    //deletar o usuario da table func e inserir ele na gerencia
                                    exclui_Funcionario(cpf);
                                    insere_Gerente(gerente);
                                }
                                else if(option.equals("1")){
                                    //deletar o usuario da table gerente e inserir na funcionario
                                    exclui_Gerente(cpf);
                                    insere_Funcionario(funcionario);
                                }
                            }
                             RequestDispatcher rd = getServletContext().
                                   getRequestDispatcher("/GerenteServlet?action=listar");
                             rd.forward(request, response);
                            }
                            break;
                        }
                        case "remover":
                        {
                            String cpf = (String)request.getParameter("cpf");
                            String type = request.getParameter("type");
                            //1 funcionario
                            //2 gerente
                            if(type.equals("1")){
                                exclui_Funcionario(cpf);
                            }
                            else if(type.equals("2")){
                                exclui_Gerente(cpf);
                            }
                            RequestDispatcher rd = getServletContext().
                                   getRequestDispatcher("/GerenteServlet?action=listar");
                             rd.forward(request, response);
                            break;
                        }
                        
                        
                        case "visualizar":
                        {
                            String cpf = (String)request.getParameter("cpf");
                            String type = request.getParameter("type");
                            //1 funcionario
                            //2 gerente
                            if(type.equals("1")){
                                Funcionario c = busca_Funcionario(cpf);
                                Pessoa p = new Pessoa();
                                //fazer o tratamento para pessoa
                                p.setPessoa_nome(c.getFuncionario_nome());
                                p.setPessoa_cpf(c.getFuncionario_cpf());
                                p.setPessoa_email(c.getFuncionario_email());
                                p.setPessoa_telefone(c.getFuncionario_telefone());
                                p.setPessoa_cep(c.getFuncionario_cep());        
                                p.setPessoa_estado(c.getFuncionario_estado());
                                p.setPessoa_cidade(c.getFuncionario_cidade());
                                p.setPessoa_bairro(c.getFuncionario_bairro());
                                p.setPessoa_rua(c.getFuncionario_rua());
                                p.setPessoa_numero(c.getFuncionario_numero());
                                p.setPessoa_complemento(c.getFuncionario_complemento());
                                p.setPessoa_senha(c.getFuncionario_senha());
                                out.println(c);
                                request.setAttribute("func","1");
                                request.setAttribute("c", p);
                            }
                            else if(type.equals("2")){
                                Gerente c = busca_Gerente(cpf);
                                Pessoa p = new Pessoa();
                                //fazer o tratamento para pessoa
                                p.setPessoa_nome(c.getGerente_nome());
                                p.setPessoa_cpf(c.getGerente_cpf());
                                p.setPessoa_email(c.getGerente_email());
                                p.setPessoa_telefone(c.getGerente_telefone());
                                p.setPessoa_cep(c.getGerente_cep());        
                                p.setPessoa_estado(c.getGerente_estado());
                                p.setPessoa_cidade(c.getGerente_cidade());
                                p.setPessoa_bairro(c.getGerente_bairro());
                                p.setPessoa_rua(c.getGerente_rua());
                                p.setPessoa_numero(c.getGerente_numero());
                                p.setPessoa_complemento(c.getGerente_complemento());
                                p.setPessoa_senha(c.getGerente_senha());
                                request.setAttribute("func","2");
                                request.setAttribute("c",p);
                            }
                            RequestDispatcher rd = getServletContext().
                                   getRequestDispatcher("/gerente-ver.jsp");
                            rd.forward(request, response);
                            break;
                        }
                        
                        case "atendimentos_abertos":
                        {
                            List<Atendimento> atendiment =  buscaTodos_Atendimentos_abertos();
                            List<Atendimento> atendimentos = new ArrayList();
                            DateTime dataAtual = new DateTime();
                            for(Atendimento x : atendiment){
                                DateTime dataAtendimento = new DateTime(x.getAtendimento_data_hora());
                                int dias = Days.daysBetween(dataAtendimento, dataAtual).getDays();
                                if (dias > 7)
                                    x.setAtendimento_nivel(1);
                                else
                                    x.setAtendimento_nivel(0);
                                atendimentos.add(x);
                            }
                            List<Produto> prod = buscaTodos_Produtos();
                            request.setAttribute("produtos",prod);
                            request.setAttribute("atendimentos",atendimentos);
                            request.setAttribute("func","aberto");
                            RequestDispatcher rd = getServletContext().
                                   getRequestDispatcher("/gerente-atendimento.jsp");
                            rd.forward(request, response);
                            break;
                        }
                        case "todos_atendimentos":
                        {
                            List<Atendimento> atendimentos = new ArrayList();
                            List<Atendimento> atendiment = buscaTodos_Atendimentos();
                            List<Produto> prod = buscaTodos_Produtos();
                            request.setAttribute("produtos",prod);
                            DateTime dataAtual = new DateTime();
                            for(Atendimento x : atendiment){
                                DateTime dataAtendimento = new DateTime(x.getAtendimento_data_hora());
                                int dias = Days.daysBetween(dataAtendimento, dataAtual).getDays();
                                if (x.getAtendimento_situacao().equals("Finalizado"))
                                    x.setAtendimento_nivel(2);
                                else if (dias > 7)
                                    x.setAtendimento_nivel(1);
                                else
                                    x.setAtendimento_nivel(0);
                                atendimentos.add(x);
                            }                            
                            request.setAttribute("atendimentos",atendimentos);
                            request.setAttribute("func","todos");
                            RequestDispatcher rd = getServletContext().
                                   getRequestDispatcher("/gerente-atendimento.jsp");
                            rd.forward(request, response);
                            break;
                        }                        
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

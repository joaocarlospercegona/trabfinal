package Servlet;

import static Facade.Facade.BuscaTipo;
import static Facade.Facade.altera_Categoria;
import static Facade.Facade.altera_Produtos;
import static Facade.Facade.altera_atendimento;
import static Facade.Facade.buscaTodas_Categorias;
import static Facade.Facade.buscaTodos_Atendimentos;
import static Facade.Facade.buscaTodos_Atendimentos_abertos;
import static Facade.Facade.buscaTodos_Produtos;
import static Facade.Facade.busca_Atendimento;
import static Facade.Facade.busca_Categoria;
import static Facade.Facade.busca_Cliente;
import static Facade.Facade.busca_Produtos;
import static Facade.Facade.exclui_Categoria;
import static Facade.Facade.exclui_Produtos;
import static Facade.Facade.insere_Categoria;
import static Facade.Facade.insere_Produtos;
import static Facade.Facade.retorna_valor;
import classes.Atendimento;
import classes.Cliente;
import classes.LoginBean;
import classes.Produto;
import classes.Tipo_Atendimento;
import classes.categoria;
import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet(name = "FuncionarioServlet", urlPatterns = {"/FuncionarioServlet"})
public class FuncionarioServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             PrintWriter out = response.getWriter();
             response.setContentType("text/html;charset=UTF-8");
             HttpSession session = request.getSession();
            LoginBean funcOn = (LoginBean) session.getAttribute("funcOn");
            String action = request.getParameter("action");
            String cpf = funcOn.getCpf();
            if(funcOn == null){
                request.setAttribute("msg","Usuario deve se autenticar para acessar o sistema.");
                RequestDispatcher rd = getServletContext().
                    getRequestDispatcher("/login.jsp");
                rd.forward(request, response);
            }
            else{
                if(action != null){
                    switch (action){  
                        case "painel_cadastro":
                        {
                            String msg = (String) request.getAttribute("msg");
                            List<categoria> categorias = buscaTodas_Categorias();
                            out.println(categorias);
                            request.setAttribute("cat",categorias);
                            request.setAttribute("func","categoria");
                            request.setAttribute("msgC",msg);
                            RequestDispatcher rd = getServletContext().
                                   getRequestDispatcher("/funcionario-cadastro.jsp");
                             rd.forward(request, response);
                            break;
                        }
                        case "ver_produtos":
                        {
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
                            
                            RequestDispatcher rd = getServletContext().
                                   getRequestDispatcher("/FuncionarioServlet?action=ver_produtos");
                            rd.forward(request, response);
                            break;
                        }
                        case "visualizar_categoria":
                        {
                            String idd = request.getParameter("id");
                            int id = Integer.parseInt(idd);
                            categoria categoria = new categoria();
                            
                            categoria = busca_Categoria(id);
                            request.setAttribute("func","visualizar");
                            request.setAttribute("categoria", categoria);
                            out.println("cat:" + categoria);
                            
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
                            String msg = exclui_Categoria(id);
                            request.setAttribute("msg",msg);
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
                                   getRequestDispatcher("/funcionario-atendimento.jsp");
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
                                   getRequestDispatcher("/funcionario-atendimento.jsp");
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
                        case "finalizar":
                        {
                            String solucao = request.getParameter("solucao");
                            String ids = request.getParameter("id");    
                            int id = Integer.parseInt(ids);
                            altera_atendimento(solucao, id);
                            RequestDispatcher rd = getServletContext().
                                   getRequestDispatcher("/FuncionarioServlet?action=todos_atendimentos");
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

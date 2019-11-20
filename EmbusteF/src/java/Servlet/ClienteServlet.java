package Servlet;

import static Facade.Facade.BuscaTipo;
import static Facade.Facade.BuscaTodos_Tipos;
import static Facade.Facade.altera_Cliente;
import static Facade.Facade.buscaTodas_Categorias;
import static Facade.Facade.buscaTodos_Atendimentos;
import static Facade.Facade.buscaTodos_Atendimentos_Cliente;
import static Facade.Facade.buscaTodos_Produtos;
import static Facade.Facade.busca_Atendimento;
import static Facade.Facade.busca_Cliente;
import static Facade.Facade.busca_Produtos;
import static Facade.Facade.exclui_Atendimento;
import static Facade.Facade.insere_Cliente;
import static Facade.Facade.insere_atendimento;
import classes.Atendimento;
import classes.Cliente;
import classes.LoginBean;
import classes.Produto;
import classes.Tipo_Atendimento;
import classes.categoria;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            throws ServletException, IOException, ParseException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
            HttpSession session = request.getSession();
            LoginBean clienteOn = (LoginBean) session.getAttribute("clienteOn");
            String action = request.getParameter("action");
            String cpf = clienteOn.getCpf();
            
            if((clienteOn == null)&&(!action.equals("cadastro_cliente"))){
                request.setAttribute("msg","Usuario deve se autenticar para acessar o sistema.");
                RequestDispatcher rd = getServletContext().
                    getRequestDispatcher("/login.jsp");
                rd.forward(request, response);
            }
            else{
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
                                    getRequestDispatcher("/ClienteServlet?action=Listagem_atendimentos");
                                rd.forward(request, response);
                            }
                            break;
                        }
                        case "cadastrando_atendimento":
                        {
                            int produto = Integer.parseInt(request.getParameter("produto"));
                            int tipoA = Integer.parseInt(request.getParameter("tipoA"));
                            Atendimento a = new Atendimento();
                            a.setAtendimento_cod_produto(produto);
                            a.setAtendimento_cod_tipo_atendimento(tipoA);
                            a.setAtendimento_cpf_cliente(clienteOn.getCpf());
                            Date data = new Date();
                            SimpleDateFormat formatador = new SimpleDateFormat("dd-MM-yyyy");
                            String dataS = formatador.format(data);
                            data = formatador.parse(dataS);
                            a.setAtendimento_data_hora(data);
                            a.setAtendimento_descricao(request.getParameter("descricao"));
                            a.setAtendimento_situacao("Em aberto");
                            insere_atendimento(a);
                            RequestDispatcher rd = getServletContext().
                                getRequestDispatcher("/ClienteServlet?action=Listagem_atendimentos");
                            rd.forward(request, response);
                            break;
                        }
                        case "novo_atendimento":
                        {       
                                List<Produto> prod = buscaTodos_Produtos();
                                request.setAttribute("produtos",prod);
                                List<categoria> cat = buscaTodas_Categorias();
                                request.setAttribute("categorias",cat);
                                List<Tipo_Atendimento> tipo = BuscaTodos_Tipos();
                                request.setAttribute("tipos_atendimentos",tipo);
                                RequestDispatcher rd = getServletContext().
                                getRequestDispatcher("/cliente-novo-atendimento.jsp");
                                rd.forward(request, response);
                                break;
                        }
                        case "Listagem_atendimentos":
                        {
                            List<Atendimento> atendimentos = new ArrayList();
                            List<Atendimento> atendiment = buscaTodos_Atendimentos_Cliente(clienteOn.getCpf());
                            List<Produto> prod = buscaTodos_Produtos();
                            request.setAttribute("produtos",prod);
                            
                            for(Atendimento x : atendiment){
                                if(x.getAtendimento_situacao().equals("Finalizado")){
                                    x.setAtendimento_nivel(1);
                                }
                                else if(x.getAtendimento_situacao().equals("Em aberto")){
                                    x.setAtendimento_nivel(0);
                                }
                                atendimentos.add(x);
                            }
                            out.println(atendimentos);
                            request.setAttribute("atendimentos", atendimentos);
                            RequestDispatcher rd = getServletContext().
                                getRequestDispatcher("/cliente-meus-atendimentos.jsp");
                            rd.forward(request, response);
                            break;
                        }
                        case "ver_atendimento":
                        {
                            String cod = request.getParameter("cod");
                            Atendimento a = busca_Atendimento(cod);
                            request.setAttribute("atendimento", a);
                            request.setAttribute("clien", "cliente");
                            Cliente c = new Cliente(); 
                            c = busca_Cliente(a.getAtendimento_cpf_cliente());
                            Produto p = new Produto();
                            p = busca_Produtos(a.getAtendimento_cod_produto());
                            Tipo_Atendimento t = new Tipo_Atendimento();
                            t = BuscaTipo(a.getAtendimento_cod_tipo_atendimento());
                            request.setAttribute("tipo",t);
                            request.setAttribute("produto",p);
                            request.setAttribute("cliente",c);
                            RequestDispatcher rd = getServletContext().
                                getRequestDispatcher("/resolucao-atendimento.jsp");
                            rd.forward(request, response);
                            break;
                        }
                        case "remover_atendimento":
                        {
                            String cod = request.getParameter("cod");
                            exclui_Atendimento(cod);
                            RequestDispatcher rd = getServletContext().
                                getRequestDispatcher("/ClienteServlet?action=Listagem_atendimentos");
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
            try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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

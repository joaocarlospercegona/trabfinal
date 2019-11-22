package Servlet;


import static Facade.Facade.buscaTodosCidades;
import static Facade.Facade.buscaTodosEstados;
import static Facade.Facade.buscaTodos_Cliente;
import static Facade.Facade.buscaTodos_Funcionario;
import static Facade.Facade.buscaTodos_Gerente;
import classes.Atendimento;
import classes.Cidade;
import classes.Cliente;
import classes.Estado;
import classes.Funcionario;
import classes.Gerente;
import classes.LoginBean;
import classes.cidadeTeste;
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

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

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
            String usuario = request.getParameter("usuario");
            String senha   = request.getParameter("senha");
            String tipo = request.getParameter("tipo");    
            //Aqui ele vera se o usuario eh do tipo gerente,cliente ou ...
            // 1 para cliente
            // 2 para Funcionario
            // 3 para Gerente
            String action = request.getParameter("action");
            if(action.equals("novo_usuario")){
                List<Estado> estados = buscaTodosEstados();
                    List<Cidade> cidades = buscaTodosCidades();

                    List<cidadeTeste> citeste = new ArrayList();
                    System.out.println("estados:" + estados);
//                    //out.println(cidades);
//                    for (int i = 0; i < cidades.size(); i++) {
//                        cidadeTeste a = new cidadeTeste();
//                        a.setIdcidadeteste(cidades.get(i).getIdCidade());
//                        a.setNomecidadeteste(cidades.get(i).getNomeCidade());
//                        a.setIdestado(cidades.get(i).getFKidestado().getIdEstado());
//                        citeste.add(a);
//                    }
//                    request.setAttribute("cidadess", citeste);

                    request.setAttribute("estadoss", estados);
                    RequestDispatcher rd = getServletContext().
                            getRequestDispatcher("/cadastro.jsp");
                    rd.forward(request, response);
            }
            if((usuario != null)&&(senha != null)&&(tipo != null)){
                try{
                    if("1".equals(tipo)){
                        List<Cliente> lista = buscaTodos_Cliente();
                        for (Cliente x: lista) {
                            if(usuario.equals(x.getCliente_email())&&(senha.equals(x.getCliente_senha()))){
                                LoginBean p = new LoginBean();
                                p.setCpf(x.getCliente_cpf());
                                p.setNome(x.getCliente_nome());
                                session.setAttribute("clienteOn", p);
                                RequestDispatcher rd = getServletContext().
                                    getRequestDispatcher("/ClienteServlet?action=Listagem_atendimentos");
                                rd.forward(request, response);
                            }
                        }
                        request.setAttribute("msg","Usuario/Senha Invalidos");
                        RequestDispatcher rd = getServletContext().
                            getRequestDispatcher("/login.jsp");
                        rd.forward(request, response);
                    }
                                        
                    if("2".equals(tipo)){
                        List<Funcionario> lista = buscaTodos_Funcionario();
                        for (Funcionario x: lista) {
                            if(usuario.equals(x.getFuncionario_email())&&(senha.equals(x.getFuncionario_senha()))){
                                LoginBean p = new LoginBean();
                                p.setCpf(x.getFuncionario_cpf());
                                p.setNome(x.getFuncionario_nome());
                                session.setAttribute("funcOn", p);
                                RequestDispatcher rd = getServletContext().
                                    getRequestDispatcher("/FuncionarioServlet?action=todos_atendimentos");
                                rd.forward(request, response);
                            }
                        }
                            request.setAttribute("msg","Usuario/Senha Invalidos");
                            RequestDispatcher rd = getServletContext().
                                getRequestDispatcher("/login.jsp");
                            rd.forward(request, response);                        
                    }
                    
                    if("3".equals(tipo)){
                        List<Gerente> lista = buscaTodos_Gerente();
                        for (Gerente x: lista) {
                            if(usuario.equals(x.getGerente_email())&&(senha.equals(x.getGerente_senha()))){
                                LoginBean p = new LoginBean();
                                p.setCpf(x.getGerente_cpf());
                                p.setNome(x.getGerente_nome());
                                session.setAttribute("gerenteOn", p);
                                RequestDispatcher rd = getServletContext().
                                    getRequestDispatcher("/GerenteServlet?action=gerente_infos");
                                rd.forward(request, response);
                            }
                        }
                            request.setAttribute("msg","Usuario/Senha Invalidos");
                            RequestDispatcher rd = getServletContext().
                                getRequestDispatcher("/login.jsp");
                            rd.forward(request, response);                    
                    }
                    
                }catch(Exception ex){
                    //ver oq colocar aqui
                } 
            }
//            else{
//                request.setAttribute("msg","Usuario/Senha Invalidos");
//                RequestDispatcher rd = getServletContext().
//                    getRequestDispatcher("/login.jsp");
//                rd.forward(request, response);
//            }
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

package Servlet;

import Facade.Facade;
import classes.Cidade;
import classes.Estado;
import classes.cidadeTeste;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lps
 */
@WebServlet(name = "AJAXServlet", urlPatterns = {"/AJAXServlet"})
public class AJAXServlet extends HttpServlet {

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

        //System.out.println("frick");
        //out.print("frick");
        String estado = request.getParameter("idestado");

        //System.out.println("Id:" + estado);
        // Vai no BD buscar todas as cidades deste estado, em uma lista
        List<Cidade> lista = Facade.buscaTodosCidades();
        List<cidadeTeste> listaMandar = new ArrayList();

        lista.forEach((x) -> {
            String idstring = Integer.toString(x.getFKidestado().getIdEstado());
            //Estado estadox = EstadoFacade.busca(idEstado);
            if (idstring.equals(estado)) {
                cidadeTeste a = new cidadeTeste(x.getIdCidade(), x.getNomeCidade());
                listaMandar.add(a);
            }
        });

//        List<cidadeTeste> lista = new ArrayList<cidadeTeste>();
//        cidadeTeste c = new cidadeTeste();
//        c.setIdcidadeteste(1);
//        c.setNomecidadeteste("Curitiba");
//        lista.add(c);
//        c = new cidadeTeste();
//        c.setIdcidadeteste(2);
//        c.setNomecidadeteste("frick");
//        lista.add(c);
//        
//       
//        // transforma o MAP em JSON
//        String json = new Gson().toJson(lista);   
//
//        // retorna o JSON
//        response.setContentType("application/json");
//        response.setCharacterEncoding("UTF-8");
//        response.getWriter().write(json);  
        //lista.add(c);
        // transforma o MAP em JSON
        String json = new Gson().toJson(listaMandar);

        // retorna o JSON
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
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

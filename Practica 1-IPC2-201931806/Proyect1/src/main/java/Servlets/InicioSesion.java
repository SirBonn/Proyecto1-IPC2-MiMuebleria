/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DB.MetodosDB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author aztk
 */
public class InicioSesion extends HttpServlet {

     /**
      * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
      *
      * @param request servlet request
      * @param response servlet response
      * @throws ServletException if a servlet-specific error occurs
      * @throws IOException if an I/O error occurs
      */
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          response.setContentType("text/html;charset=UTF-8");
          PrintWriter out = response.getWriter();
          /* TODO output your page here. You may use following sample code. */
          HttpSession sesion = request.getSession();
          MetodosDB metodo = new MetodosDB();
          String usuario = request.getParameter("userIngresado");
          String password = request.getParameter("passowordIngresado");

          out.println("<!DOCTYPE html>");
          out.println("<html>");
          out.println("<head>");
          out.println("<title>IniciarSesion</title>");
          out.println("</head>");
          out.println("<body>");
          out.println("<script type=\"text/javascript\">");
          boolean inicioSesion = metodo.accederUsuario(usuario, password);
          if (inicioSesion == true) {
               //out.println("alert('BIENVENIDO!')");
               sesion.setAttribute("usuario", usuario);
               sesion.setAttribute("password", password);
               
               switch (metodo.getArea(usuario)) {
                    case "ventas":
                         out.println("location='Area-Ventas.jsp'");
                         sesion.setAttribute("usuario", usuario);
                         sesion.setAttribute("password", password);
                         break;
                    case "fabrica":
                         out.println("location= 'Area-Fabrica.jsp'");
                         sesion.setAttribute("usuario", usuario);
                         sesion.setAttribute("password", password);
                         break;
                    default:
                         out.println("location= 'index.html'");
                         break;
               }
               
          } else {
               out.println("alert('Credenciales invalidas')");
               out.println("location='Login-Usuario.jsp'");
          }

          out.println("</script>");
          out.println("</body>");
          out.println("</html>");

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

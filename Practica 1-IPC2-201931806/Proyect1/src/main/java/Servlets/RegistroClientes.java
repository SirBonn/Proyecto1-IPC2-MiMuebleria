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

/**
 *
 * @author aztk
 */
public class RegistroClientes extends HttpServlet {

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

          MetodosDB metodo = new MetodosDB();
          String NIT = request.getParameter("NitIngresado");
          String nombre = request.getParameter("NameIngresado");
          String direccion = request.getParameter("DirectionIngresado");
          String telefono = request.getParameter("PhoneIngresado");

          out.println("<!DOCTYPE html>");
          out.println("<html>");
          out.println("<body>");
          out.println("<script type=\"text/javascript\">");

          if (metodo.verificarUsuario(NIT) == true) {
               out.println("alert('El cliente ya esta registrado')");
               out.println("location='index.html' ");

          } else {

               boolean seRegistro = metodo.registrarCliente(NIT, nombre, direccion, telefono);

               if (seRegistro == true) {
                    out.println("alert('se registro un nuevo cliente')");
                    out.println("location='index.html' ");
               } else {
                    out.println("alert('no se registro un nuevo cliente')");
                    out.println("location='index.html' ");

                    System.out.println("el estado de registro es: " + seRegistro);
               }
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

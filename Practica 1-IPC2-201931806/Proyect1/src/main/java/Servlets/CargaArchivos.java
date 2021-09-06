/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author aztk
 */
public class CargaArchivos extends HttpServlet {

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
          out.println("<!DOCTYPE html>");
          out.println("<html>");
          out.println("<head>");
          out.println("</head>");
          out.println("<body>");
          out.println("<script type=\"text/javascript\">");

          Part partFile = request.getPart("archivoDatos");
          String file = partFile.getContentType();
          System.out.println("se esta leyendo " + file + " desde la web");
          InputStream fileStream = partFile.getInputStream();
          
          try (BufferedReader in = new BufferedReader(new InputStreamReader(fileStream))) {
               String linea = in.readLine();

               while (linea != null) {
                    System.out.println(linea);
                    linea = in.readLine();
               }
               out.println("</script>");
               out.println("</body>");
               out.println("</html>");
          } catch (Exception ex) {
 
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

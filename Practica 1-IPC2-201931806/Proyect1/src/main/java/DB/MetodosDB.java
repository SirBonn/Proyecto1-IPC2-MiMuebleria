/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author aztk
 */
public class MetodosDB {

     private Connection connection;
     private PreparedStatement prepStatement;
     private ResultSet result;

     public boolean registrarCliente(String NIT, String nombre, String direccion, String telefono) {

          boolean registro = false;

          try {

               connection = Conection.DBConnection();
               String tmpConsulta = "INSERT INTO clientes (NIT_cliente, nombre_cliente, direccion_cliente, telefono_cliente) VALUES (? , ? , ? , ?)";
               prepStatement = connection.prepareStatement(tmpConsulta);
               prepStatement.setString(1, NIT);
               prepStatement.setString(2, nombre);
               prepStatement.setString(3, direccion);
               prepStatement.setString(4, telefono);

               int tmpResultado = prepStatement.executeUpdate();

               if (tmpResultado > 0) {
                    System.out.println("se registro el cliente");
                    registro = true;
               } else {
                    System.out.println("no se registro el cliente");
               }

          } catch (SQLException e) {

               System.out.println("Error: " + e);

          } finally {

               try {
                    connection.close();
               } catch (SQLException ex) {
                    System.out.println("Error: " + ex);
               }
          }

          System.out.println("se registro: " + registro);
          return registro;
     }

     public boolean verificarUsuario(String NIT) {
          boolean estaRegistrado = false;

          try {
               connection = Conection.DBConnection();
               String consulta = "SELECT NIT_cliente FROM clientes WHERE NIT_cliente = ?";
               prepStatement = connection.prepareStatement(consulta);
               prepStatement.setString(1, NIT);

               result = prepStatement.executeQuery();
               if (result.next()) {
                    estaRegistrado = true;

               } else {
                    estaRegistrado = false;
               }

               connection.close();
          } catch (SQLException e) {

          } finally {
               try {
                    connection.close();
               } catch (SQLException ex) {
                    System.out.println("Error: " + ex);
               }
          }
          System.out.println("el usuario es " + estaRegistrado);
          return estaRegistrado;
     }

     public boolean accederUsuario(String usuario, String password) {
          boolean puedeAcceder = false;
          String area = null;
          try {
               connection = Conection.DBConnection();
               String consulta = "SELECT area_trabajo FROM trabajadores WHERE ID_usuario=? AND password=?";
               prepStatement = connection.prepareStatement(consulta);
               prepStatement.setString(1, usuario);
               prepStatement.setString(2, password);

               result = prepStatement.executeQuery();

               if (result.next()) {
                    puedeAcceder = true;
               } else {
                    puedeAcceder = false;
               }

               connection.close();
          } catch (SQLException e) {

          } finally {
               try {
                    connection.close();
               } catch (SQLException ex) {
                    System.out.println("Error: " + ex);
               }
          }

          return puedeAcceder;
     }

     public String getArea(String Usuario) {
          String area = null;

          try {
               connection = Conection.DBConnection();
               String consulta = "SELECT area_trabajo FROM trabajadores WHERE ID_usuario=?";
               prepStatement = connection.prepareStatement(consulta);
               prepStatement.setString(1, Usuario);
               result = prepStatement.executeQuery();

               if (result.next()) {
                    area = result.getString("area_trabajo");
               } else {
                    area = null;
               }

               connection.close();
          } catch (SQLException e) {
          } finally {
               try {
                    connection.close();
               } catch (SQLException ex) {
                    System.out.println("Error: " + ex);

               }
          }

          return area;
     }
}

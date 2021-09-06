/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author aztk
 */
public class Conection {

     private static final String USER = "sirRoot";
     private static final String PASSWORD = "sirRoot2_";
     private static final String URL = "jdbc:mysql://localhost:3306/muebleria_DB";

     /**
      * @return
      */
     public static Connection DBConnection() {

          Connection connection = null;

          try {
               Class.forName("com.mysql.jdbc.Driver");
               connection = DriverManager.getConnection(URL, USER, PASSWORD);
          } catch (ClassNotFoundException | SQLException e) {
               System.out.println("No se conecta porque: " + e);
          }
          return connection;
     }

}

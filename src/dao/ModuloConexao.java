/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;

/**
 *
 * @author Jader
 */
public class ModuloConexao {
    //metodo para conesão com o banco

    public static Connection conector() {
        java.sql.Connection conexao = null;
        //chamada do driver
        String driver = "com.mysql.jdbc.Driver";
        //variaveis referentes a informações do banco de dados
        String url = "jdbc:mysql://localhost:3306/clinical";
        String user = "root";
        String password = "";
        //conectar ao banco
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (Exception e) {
            return null;
        }
        

    }

}

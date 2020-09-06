package DAL;

import java.sql.*;

public class ModuloConexaoLocal {

    //metodo responsavel por estabelecer a conexão com o banco//
    public static Connection conector() {
        java.sql.Connection conexao = null;
        //a linha abaixo chama o driver de conecxao
        String driver = "com.mysql.jdbc.Driver";
        //variaveis pra armazenar informações referentes ao banco de dados
        String url = "jdbc:mysql://localhost:3306/clinical";
        String user = "root";
        String password = "";
        //estabelecendo a conexão com o banco de dados
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (Exception e) {
            return null;
        }
    }
}

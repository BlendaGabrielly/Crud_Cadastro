package ClienteConexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;

public class ConexaoCL {
	public static final String URL="jdbc:mysql://localhost:3306/projetova_do_bd";
	public static final String Usuario="root";
	private static final String Senha="";
	
	private PreparedStatement Add;
	
	public static Connection getConexaoCL(){
        Connection connect = null;
    try {
         connect = DriverManager.getConnection(URL,Usuario,Senha);
        return connect;
        
    } catch (Exception e) {
        System.err.println(e);
        System.exit(1);
    }
    return connect;
}
public static void fechaConexaoCL(Connection conn) {
    try {
        if (conn != null) {
            conn.close();
            System.out.println("Fechada a conexão com o banco de dados");
        }
    }catch (Exception e) {
        System.out.println("Não foi possível fechar a conexão com o banco de dados " + e.getMessage());
    }
}

public static void fechaConexaoCL(Connection conn, PreparedStatement stm) {
	try {
        if(conn != null){
            fechaConexaoCL(conn);
        }
        if (stm != null) {
            stm.close();
            System.out.println("Fechada a conexão com o banco de dados");
        }
    }catch (Exception e) {
        System.out.println("Não foi possível fechar o statement com o banco de dados " + e.getMessage());
    }
}

public static void fechaConexaoCL(Connection conn, PreparedStatement stm, ResultSet rs) {

	  try {
	        if(conn != null || stm != null){
	            fechaConexaoCL(conn,stm);
	        }
	        if (rs != null) {
	            rs.close();
	            System.out.println("Fechado o resultSet com o banco de dados");
	        }
	    }catch (Exception e) {
	        System.out.println("Não foi possível fechar o resultSet com o banco de dados " + e.getMessage());
	    }
	}

public static void main(String[]args){
}


}






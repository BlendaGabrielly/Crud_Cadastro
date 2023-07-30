package UsuarioDão;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import ClienteConexao.ConexaoCL;
import UsuarioDTO.Usuariodto;

public class Usuario {
     Connection conn;
      public ResultSet Login(Usuariodto usuariodto) {
    	  conn = ConexaoCL.getConexaoCL();
     try {
    	 String sql="Select*From usuario where Login =? and Senha=?";
    	 PreparedStatement pstm=conn.prepareStatement(sql);
    	 pstm.setString(1,usuariodto.getUsuario());
    	 pstm.setString(2,usuariodto.getSenha());
    	 ResultSet rs=pstm.executeQuery();
    	 return rs;
     }catch(SQLException e) {
    	 JOptionPane.showMessageDialog(null,"Erro Usu: "+e);
    	 return null;
     }
    	 
     }

}

package ClienteConexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ModeloC.Cliente;


public class ClienteB implements ICrud {
	Connection conn;
	PreparedStatement pstm;
public void Salvar(Object C) {
	   
	      Cliente cliente = (Cliente) C;
	       
	        if (cliente!= null) {
	            Connection conn = null;
	            try {
	                conn = ConexaoCL.getConexaoCL();
	                PreparedStatement pstm;
	                pstm = conn.prepareStatement("insert into Cliente (Nome,End,Tel) values (?,?,?)");
	                pstm.setString(1,cliente.getNome());
	                pstm.setString(2,cliente.getEnd());
	                pstm.setString(3,cliente.getTel());
	                pstm.execute();
	                System.out.println("Armazenado");
	                ConexaoCL.fechaConexaoCL(conn);
	            } catch (SQLException e) {
	                System.out.println("Erro: "+e);
	            }
	        }
	    }
public void Atualizar(Object C) {
	 Cliente cliente = (Cliente) C;
     
     if (cliente!= null) {
         Connection conn = null;
         try {
             conn = ConexaoCL.getConexaoCL();
             PreparedStatement pstm;
             pstm = conn.prepareStatement("Update Cliente set Nome=?,End=?,Tel=? Where id=?");
             pstm.setString(1,cliente.getNome());
             pstm.setString(2,cliente.getEnd());
             pstm.setString(3,cliente.getTel());
             pstm.setInt(4,cliente.getId());
             pstm.execute();
             System.out.println("Atualizado");
             ConexaoCL.fechaConexaoCL(conn,pstm);
         } catch (SQLException e) {
             System.out.println("Erro Atualizar: "+e);
         }
     }
 }	
public void apagar(int Id) {
	 
	        Connection conn = null;
	        try {
	            conn = ConexaoCL.getConexaoCL();
	            PreparedStatement pstm;
	            pstm = conn.prepareStatement("Delete from Cliente Where id=?");
	            pstm.setInt(1,Id);
	            pstm.execute();
	            System.out.println("Apagado");
	            ConexaoCL.fechaConexaoCL(conn,pstm);
	        } catch (SQLException e) {
	            System.out.println("Erro Apagar: "+e);
	        }
	    }
public List<Object> ListarTd() {
			
			List<Object>cliente=new ArrayList<Object>();
		         Connection conn = null;
		         PreparedStatement pstm=null;
		         //ResultSet resultSet=null;
		         try {
		             conn = ConexaoCL.getConexaoCL();
		             pstm = conn.prepareStatement("Select*from Cliente");
		             ResultSet rset=null;
		             rset=pstm.executeQuery();
		             
		             while(rset.next()) {
		            	 Cliente cli=new Cliente();
		                 cli.setId(rset.getInt("id"));
		                 cli.setNome(rset.getString("Nome"));
		                 cli.setEnd(rset.getString("End"));
		                 cli.setTel(rset.getString("Tel"));
		                 
		                 cliente.add(cli);
		       }
		         } catch (SQLException e) {
		             System.out.println("Erro pesquisa: "+e);
		         }
		         ConexaoCL.fechaConexaoCL(conn,pstm);
			return cliente;	
}
}

	


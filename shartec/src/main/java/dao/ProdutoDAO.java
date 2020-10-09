package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Produto;
import util.DbUtil;

public class ProdutoDAO {
	 private static Connection connection = DbUtil.getConnection();
	 
	    public static Produto addProduto(String titulo, String descricao, String categoria, int valor) {
	        try {
	            PreparedStatement pStmt = connection.prepareStatement("insert into produtos(titulo, descricao, categoria, valor) values (?, ?, ?, ?)",
	                    Statement.RETURN_GENERATED_KEYS);
	            pStmt.setString(1, titulo);
	            pStmt.setString(2, descricao);
	            pStmt.setString(3, categoria);
	            pStmt.setInt(4, valor);
	            pStmt.executeUpdate();
	            ResultSet rs = pStmt.getGeneratedKeys();
	            if (rs.next()) {
	                return new Produto(rs.getInt("id"), rs.getString("titulo"), rs.getString("descricao"), rs.getString("categoria"), rs.getInt("valor"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	 
	        return null;
	    }
	 
	    public static Produto updateProduto(int id, String titulo, String descricao, String categoria, int valor) {
	        try {
	            PreparedStatement pStmt = connection.prepareStatement("update produtos set titulo=?, descricao=?, categoria=?, valor=? where id=?",
	                    Statement.RETURN_GENERATED_KEYS);
	            pStmt.setString(1, titulo);
	            pStmt.setString(2, descricao);
	            pStmt.setString(3, categoria);
	            pStmt.setInt(4, valor);
	            pStmt.setInt(5, id);
	            pStmt.executeUpdate();
	            ResultSet rs = pStmt.getGeneratedKeys();
	            if (rs.next()) {
	            	 return new Produto(rs.getInt("id"), rs.getString("titulo"), rs.getString("descricao"), rs.getString("categoria"), rs.getInt("valor"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	 
	        return null;
	    }
	 
	    public static void deleteProduto(int id) {
	        try {
	            PreparedStatement pStmt = connection.prepareStatement("delete from produtos where id=?");
	            pStmt.setInt(1, id);
	            pStmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 
	    public static List<Produto> getAllProdutos() {
	        List<Produto> produtos = new ArrayList<Produto>();
	        try {
	            Statement stmt = connection.createStatement();
	            ResultSet rs = stmt.executeQuery("select * from produtos order by id");
	            while (rs.next()) {
	            	Produto produto = new Produto(rs.getInt("id"), rs.getString("titulo"), rs.getString("descricao"), rs.getString("categoria"), rs.getInt("valor"));
	            	produtos.add(produto);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	 
	        return produtos;
	    }
	 
	    public static Produto getProduto(int id) {
	        try {
	            PreparedStatement pStmt = connection.prepareStatement("select * from produtos where id=?");
	            pStmt.setInt(1, id);
	            ResultSet rs = pStmt.executeQuery();
	            if (rs.next()) {
	                return new Produto(rs.getInt("id"), rs.getString("titulo"), rs.getString("descricao"), rs.getString("categoria"), rs.getInt("valor"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	 
	        return null;
	    }
	 
	    public static List<Produto> getProdutoByCategoria(String categoria) {
	    	List<Produto> produtos = new ArrayList<Produto>();
	        try {
	            PreparedStatement pStmt = connection.prepareStatement("select * from produtos where categoria=?");
	            pStmt.setString(1, categoria);
	            ResultSet rs = pStmt.executeQuery();
	            while (rs.next()) {
	            	Produto produto = new Produto(rs.getInt("id"), rs.getString("titulo"), rs.getString("descricao"), rs.getString("categoria"), rs.getInt("valor"));
	            	produtos.add(produto);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	 
	        return produtos;
	    }
}

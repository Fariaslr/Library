package com.mycompany.jdbc;

import com.mycompany.dal.ConnectionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mycompany.model.Genero;

public class GeneroJDBC {
    
    public void create (Genero genero){
        Connection conexao = ConnectionMySQL.conectar();
        PreparedStatement pst = null;
        
        String insert = "INSERT INTO generos (descricao_genero) VALE (?)";
        
        try {
            pst = conexao.prepareStatement(insert);
            pst.setString(1, genero.getDescricaoGenero());
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            ConnectionMySQL.closeConnection(conexao, pst);
        }
    }

    public List<Genero> read() {

        Connection conexao = ConnectionMySQL.conectar();
        PreparedStatement pst = null;
        ResultSet rs = null;

        List<Genero> generos = new ArrayList<>();
        String list = "SELECT * FROM generos ORDER BY descricao_genero";

        try {
            pst = conexao.prepareStatement(list);
            rs = pst.executeQuery();

            while (rs.next()) {
                Genero genero = new Genero();

                genero.setIdGenero(rs.getInt("id_genero"));
                genero.setDescricaoGenero(rs.getString("descricao_genero"));

                generos.add(genero);
            }
        } catch (SQLException e) {
            System.out.println("Aqui é o erro: " + e);
        } finally {
            ConnectionMySQL.closeConnection(conexao, pst,rs);
        }
        return generos;
    }

    public Genero search(Genero genero) {
        Connection conexao = ConnectionMySQL.conectar();
        PreparedStatement pst = null;
        ResultSet rs = null;

        String search = "SELECT * FROM generos WHERE id_genero = ?";

        try {
            pst = conexao.prepareStatement(search);
            pst.setInt(1, genero.getIdGenero());

            rs = pst.executeQuery();

            if (rs.next()) {
                genero.setIdGenero(rs.getInt("id_genero"));
                genero.setDescricaoGenero(rs.getString("descricao_genero"));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally{
            ConnectionMySQL.closeConnection(conexao, pst, rs);
        }
        return genero;
    }
}

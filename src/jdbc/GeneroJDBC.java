package jdbc;

import dal.ConnectionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Genero;

public class GeneroJDBC {

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
            ConnectionMySQL.closeConnection(conexao, pst);
        }
        return generos;
    }
}

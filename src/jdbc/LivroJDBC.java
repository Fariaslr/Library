package jdbc;

import dal.ConnectionMySQL;
import java.sql.*;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Genero;
import model.Livro;

public class LivroJDBC {

    public void create(Livro livro) {

        Connection conexao = ConnectionMySQL.conectar();
        PreparedStatement pst = null;

        String insert = "INSERT INTO livros (nome_livro,id_genero) VALUE(?,?)";

        try {
            pst = conexao.prepareStatement(insert);
            pst.setString(1, livro.getNomeLivro());
            pst.setInt(2, livro.getGeneroLivro().getIdGenero());

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e);
        } finally {
            ConnectionMySQL.closeConnection(conexao, pst);
        }

    }

    public List<Livro> read() {

        Connection conexao = ConnectionMySQL.conectar();
        PreparedStatement pst = null;
        ResultSet rs = null;

        List<Livro> livros = new ArrayList<>();
        String list = "SELECT * FROM livros l INNER JOIN generos g ON l.id_genero = g.id_genero ORDER BY nome_livro";

        try {
            pst = conexao.prepareStatement(list);
            rs = pst.executeQuery();

            while (rs.next()) {
                Livro livro = new Livro();
                Genero genero = new Genero();
                
                livro.setIdLivro(rs.getInt("id_livro"));
                livro.setNomeLivro(rs.getString("nome_livro"));
                genero.setIdGenero(rs.getInt("id_genero"));
                genero.setDescricaoGenero(rs.getString("descricao_genero"));
                livro.setGeneroLivro(genero);

                livros.add(livro);
            }
        } catch (SQLException e) {
            System.out.println("Aqui é o erro: " + e);
        } finally {
            ConnectionMySQL.closeConnection(conexao, pst);
        }
        return livros;
    }

    /*public List<Livro> search(Livro livro) {

        Connection conexao = ConnectionMySQL.conectar();
        PreparedStatement pst = null;
        ResultSet rs = null;

        List<Livro> livros = new ArrayList<>();
        String search = "SELECT * FROM livro WHERE nomeLivro LIKE ?";

        try {
            pst = conexao.prepareStatement(search);
            pst.setString(1, "%" + livro.getNomeLivro() + "%");

            rs = pst.executeQuery();

            while (rs.next()) {
                
                livro.setIdLivro(rs.getInt("idLivro"));
                livro.setNomeLivro(rs.getString("nomeLivro"));
                

                professores.add(prof);
            }
        } catch (SQLException e) {
            System.out.println("Aqui é o erro: " + e);
        } finally {
            ConnectionMySQL.closeConnection(conexao, pst);
        }
        return professores;
    }
/*
    @Override
    public void update(Professor p) {

        Connection conexao = ConnectionMySQL.conectar();
        PreparedStatement pst = null;

        String update = "UPDATE professor SET nomeProfessor = ?,matricula = ? WHERE codigoProfessor = ?";

        try {
            pst = conexao.prepareStatement(update);
            pst.setString(1, p.getNomeProfessor());
            pst.setString(2, p.getMatricula());
            pst.setInt(3, p.getCodigoProfessor());

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar: " + e);
        } finally {
            ConnectionMySQL.closeConnection(conexao, pst);
        }
    }
    */
    public void delete(Livro livro) {

        Connection conexao = ConnectionMySQL.conectar();
        PreparedStatement pst = null;

        String update = "DELETE FROM livro WHERE id_livro = ?";

        try {
            pst = conexao.prepareStatement(update);
            pst.setInt(1, livro.getIdLivro());

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir: " + e);
        } finally {
            ConnectionMySQL.closeConnection(conexao, pst);
        }
    }
}

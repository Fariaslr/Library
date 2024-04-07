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

        String insert = "INSERT INTO livros (nome_livro,id_genero,paginas,lido) VALUE(?,?,?,?)";

        try {
            pst = conexao.prepareStatement(insert);
            pst.setString(1, livro.getNomeLivro());
            pst.setInt(2, livro.getGeneroLivro().getIdGenero());
            pst.setInt(3, livro.getPaginas());
            pst.setBoolean(4, livro.isLido());

            pst.executeUpdate();

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e);
        } finally {
            ConnectionMySQL.closeConnection(conexao, pst);
        }

    }

    public List<Livro> read() {

        Connection conexao = ConnectionMySQL.conectar();
        PreparedStatement pst = null;
        ResultSet rs;
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
                livro.setPaginas(rs.getInt("paginas"));
                livro.setDataRegistro(rs.getDate("data_registro"));
                livro.setDataEditado(rs.getDate("data_editado"));
                livro.setLido(rs.getBoolean("lido"));
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

    public List<Livro> search(Livro livro) {

        Connection conexao = ConnectionMySQL.conectar();
        PreparedStatement pst = null;
        ResultSet rs;

        List<Livro> livros = new ArrayList<>();
        String search = "SELECT * FROM livro WHERE nomeLivro LIKE ?";

        try {
            pst = conexao.prepareStatement(search);
            pst.setString(1, "%" + livro.getNomeLivro() + "%");

            rs = pst.executeQuery();

            while (rs.next()) {
                Genero genero = new Genero();

                livro.setIdLivro(rs.getInt("id_livro"));
                livro.setNomeLivro(rs.getString("nome_livro"));
                livro.setPaginas(rs.getInt("paginas"));
                livro.setDataRegistro(rs.getDate("data_registro"));
                livro.setDataEditado(rs.getDate("data_editado"));
                livro.setLido(rs.getBoolean("lido"));
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

    public void update(Livro l) {

        Connection conexao = ConnectionMySQL.conectar();
        PreparedStatement pst = null;

        String update = "UPDATE livros SET nome_livro = ?, paginas = ?, id_genero = ?, lido = ? WHERE id_livro = ?";

        try {
            pst = conexao.prepareStatement(update);
            pst.setString(1, l.getNomeLivro());
            pst.setInt(2, l.getPaginas());
            pst.setInt(3, l.getGeneroLivro().getIdGenero());
            pst.setInt(5, l.getIdLivro());
            pst.setBoolean(4, l.isLido());

            pst.executeUpdate();
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar: " + e);
        } finally {
            ConnectionMySQL.closeConnection(conexao, pst);
        }
    }

    public void delete(Livro livro) {

        Connection conexao = ConnectionMySQL.conectar();
        PreparedStatement pst = null;

        String delete = "DELETE FROM livros WHERE id_livro = ?";

        try {
            pst = conexao.prepareStatement(delete);
            pst.setInt(1, livro.getIdLivro());

            pst.executeUpdate();
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir: " + e);
        } finally {
            ConnectionMySQL.closeConnection(conexao, pst);
        }
    }
}

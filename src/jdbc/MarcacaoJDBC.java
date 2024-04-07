package jdbc;

import dal.ConnectionMySQL;
import java.awt.HeadlessException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Genero;
import model.Livro;
import model.Marcacao;

public class MarcacaoJDBC {

    public void create(Marcacao marcacao) {
        Connection conexao = ConnectionMySQL.conectar();
        PreparedStatement pst;

        String insert = "INSERT INTO marcacoes (titulo,anotacao,id_livro,pagina_atual)"
                + "VALUES(?,?,?,?)";
        try {
            pst = conexao.prepareStatement(insert);
            pst.setString(1, marcacao.getTitulo());
            pst.setString(2, marcacao.getAnotacao());
            pst.setInt(3, marcacao.getLivro().getIdLivro());
            pst.setInt(4, marcacao.getPaginaAtual());

            pst.executeUpdate();
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e);
        }
    }

    public List<Marcacao> read(Livro livro) {
        Connection conexao = ConnectionMySQL.conectar();
        PreparedStatement pst;
        ResultSet rs;
        List<Marcacao> marcacoes = new ArrayList<>();

        String list = "SELECT * FROM marcacoes WHERE id_livro = ?";

        try {
            pst = conexao.prepareStatement(list);
            pst.setInt(1, livro.getIdLivro());

            rs = pst.executeQuery();

            while (rs.next()) {
                Marcacao marcacao = new Marcacao();
                marcacao.setIdMarcacao(rs.getInt("id_marcacao"));
                marcacao.setPaginaAtual(rs.getInt("pagina_atual"));
                marcacao.setAnotacao(rs.getString("anotacao"));
                marcacao.setTitulo(rs.getString("titulo"));
                marcacao.setDataRegistro(rs.getDate("data_registro_marcacao"));
                marcacao.setDataEditado(rs.getDate("data_editado_marcacao"));
                marcacao.setLivro(livro);

                marcacoes.add(marcacao);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return marcacoes;
    }

    public List<Marcacao> list() {
        Connection conexao = ConnectionMySQL.conectar();
        PreparedStatement pst;
        ResultSet rs;
        List<Marcacao> marcacoes = new ArrayList<>();

        String list = "SELECT * FROM marcacoes m \n"
                + "INNER JOIN livros l ON m.id_livro = l.id_livro\n"
                + "INNER JOIN generos g ON g.id_genero = l.id_genero";

        try {
            pst = conexao.prepareStatement(list);
            rs = pst.executeQuery();

            while (rs.next()) {
                Marcacao marcacao = new Marcacao();
                Livro livro = new Livro();
                Genero genero = new Genero();

                marcacao.setIdMarcacao(rs.getInt("id_marcacao"));
                marcacao.setPaginaAtual(rs.getInt("pagina_atual"));
                marcacao.setAnotacao(rs.getString("anotacao"));
                marcacao.setTitulo(rs.getString("titulo"));
                marcacao.setDataRegistro(rs.getDate("data_registro_marcacao"));
                marcacao.setDataEditado(rs.getDate("data_editado_marcacao"));
                livro.setIdLivro(rs.getInt("id_livro"));
                livro.setNomeLivro(rs.getString("nome_livro"));
                livro.setPaginas(rs.getInt("paginas"));
                livro.setDataRegistro(rs.getDate("data_registro_livro"));
                livro.setDataEditado(rs.getDate("data_editado_livro"));
                livro.setLido(rs.getBoolean("lido"));
                genero.setIdGenero(rs.getInt("id_genero"));
                genero.setDescricaoGenero(rs.getString("descricao_genero"));
                livro.setGeneroLivro(genero);
                marcacao.setLivro(livro);

                marcacoes.add(marcacao);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return marcacoes;
    }

    public void update(Marcacao m) {
        Connection conexao = ConnectionMySQL.conectar();
        PreparedStatement pst = null;

        String update = "UPDATE marcacoes SET titulo = ?, anotacao = ?, id_livro = ?, pagina_atual = ? "
                + "WHERE id_marcacao = ?";
        try {
            pst = conexao.prepareStatement(update);
            pst.setString(1, m.getTitulo());
            pst.setString(2, m.getAnotacao());
            pst.setInt(3, m.getLivro().getIdLivro());
            pst.setInt(4, m.getPaginaAtual());
            pst.setInt(5, m.getIdMarcacao());

            pst.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            ConnectionMySQL.closeConnection(conexao, pst);
        }
    }

    public void delete(Marcacao m) {
        Connection conexao = ConnectionMySQL.conectar();
        PreparedStatement pst = null;

        String delete = "DELETE FROM marcacoes WHERE id_marcacao = ?";
        try {
            pst = conexao.prepareStatement(delete);
            pst.setInt(1, m.getIdMarcacao());

            pst.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir: " + e);
        } finally {
            ConnectionMySQL.closeConnection(conexao, pst);
        }
    }
}

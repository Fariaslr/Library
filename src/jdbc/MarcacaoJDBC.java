package jdbc;

import dal.ConnectionMySQL;
import java.awt.HeadlessException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Livro;
import model.Marcacao;

public class MarcacaoJDBC {

    public void create(Marcacao marcacao) {
        Connection conexao = ConnectionMySQL.conectar();
        PreparedStatement pst = null;
        ResultSet rs = null;

        String insert = "INSERT INTO marcacoes (titulo,anotacao,id_livro,pagina_atual)"
                + "VALUES(?,?,?,?)";
        try {
            pst = conexao.prepareStatement(insert);
            pst.setString(1, marcacao.getTitulo());
            pst.setString(2, marcacao.getAnotacao());
            pst.setInt(3, marcacao.getLivro().getIdLivro());
            pst.setInt(4, marcacao.getPaginaAtual());
            
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e);
        }

    }

    public List<Marcacao> read(Livro l) {
        Connection conexao = ConnectionMySQL.conectar();
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Marcacao> marcacoes = new ArrayList<>();

        String list = "SELECT * FROM marcacoes WHERE id_livro = ?";

        try {
            pst = conexao.prepareStatement(list);
            pst.setInt(1, l.getIdLivro());

            rs = pst.executeQuery();

            while (rs.next()) {
                Marcacao m = new Marcacao();
                m.setIdMarcacao(rs.getInt("id_marcacao"));
                m.setPaginaAtual(rs.getInt("pagina_atual"));
                m.setAnotacao(rs.getString("anotacao"));
                m.setTitulo(rs.getString("titulo"));
                m.setLivro(l);

                marcacoes.add(m);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return marcacoes;
    }

    public List<Marcacao> list() {
        Connection conexao = ConnectionMySQL.conectar();
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Marcacao> marcacoes = new ArrayList<>();

        String list = "SELECT * FROM marcacoes m INNER JOIN livros l ON m.id_livro = l.id_livro";

        try {
            pst = conexao.prepareStatement(list);
            rs = pst.executeQuery();

            while (rs.next()) {
                Marcacao marcacao = new Marcacao();
                Livro livro = new Livro();
                marcacao.setIdMarcacao(rs.getInt("id_marcacao"));
                marcacao.setPaginaAtual(rs.getInt("pagina_atual"));
                marcacao.setAnotacao(rs.getString("anotacao"));
                marcacao.setTitulo(rs.getString("titulo"));
                livro.setIdLivro(rs.getInt("id_livro"));
                livro.setNomeLivro(rs.getString("nome_livro"));
                livro.setPaginas(rs.getInt("paginas"));
                livro.setNota(rs.getInt("nota"));
                livro.setDataRegistro(rs.getDate("data_registro"));
                livro.setDataEditado(rs.getDate("data_editado"));
                livro.setLido(rs.getBoolean("lido"));
                marcacao.setLivro(livro);

                marcacoes.add(marcacao);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return marcacoes;
    }
}

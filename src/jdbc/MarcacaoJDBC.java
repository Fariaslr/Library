package jdbc;

import com.mysql.cj.jdbc.PreparedStatementWrapper;
import dal.ConnectionMySQL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Livro;
import model.Marcacao;

public class MarcacaoJDBC {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public void create(Marcacao marcacao) {
        conexao = ConnectionMySQL.conectar();

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
}

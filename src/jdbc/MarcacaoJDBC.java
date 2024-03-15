package jdbc;

import com.mysql.cj.jdbc.PreparedStatementWrapper;
import dal.ConnectionMySQL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Marcacao;

public class MarcacaoJDBC {

    Connection conexao = null;
    PreparedStatement pst = null;

    public void create(Marcacao marcacao) {
        conexao = ConnectionMySQL.conectar();

    }

    public List<Marcacao> read() {
        conexao = ConnectionMySQL.conectar();
        List<Marcacao> marcacoes = new ArrayList<>();
        
        String list = "SELECT * FROM marcacoes m iNNER jOIN livros l ON l.id_livro = m.id_livro WHERE m.id_livro = ?";
        
        return marcacoes;
    }
}

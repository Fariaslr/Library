package model;

import java.util.Date;

public class Livro {

    int idLivro;
    String nomeLivro;
    int paginas;
    int nota;
    Date dataRegistro;
    Genero generoLivro;

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public Date getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public Genero getGeneroLivro() {
        return generoLivro;
    }

    public void setGeneroLivro(Genero generoLivro) {
        this.generoLivro = generoLivro;
    }
}

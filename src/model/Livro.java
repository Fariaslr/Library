package model;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class Livro {

    private int idLivro;
    String nomeLivro;
    int paginas;
    int nota;
    Date dataRegistro;
    Date dataEditado;
    Genero generoLivro;
    boolean lido;

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

    public Date getDataEditado() {
        return dataEditado;
    }

    public void setDataEditado(Date dataEditado) {
        this.dataEditado = dataEditado;
    }

    public Genero getGeneroLivro() {
        return generoLivro;
    }

    public void setGeneroLivro(Genero generoLivro) {
        this.generoLivro = generoLivro;
    }

    public boolean isLido() {
        return lido;
    }

    public void setLido(boolean lido) {
        this.lido = lido;
    }
       
    public int calcularDias() {
        LocalDate birth = LocalDate.now();
        LocalDate nascimento = Instant.ofEpochMilli(dataRegistro.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
        Period periodo = Period.between(nascimento, birth);
        return periodo.getDays();
    }

}

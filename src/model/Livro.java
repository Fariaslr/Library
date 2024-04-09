package model;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class Livro {

    int idLivro;
    String nomeLivro;
    int paginas;
    Date dataRegistro;
    Date dataEditado;
    Genero generoLivro;
    boolean lido;

    public Livro() {
    }

    public Livro(String nomeLivro, int paginas, Genero generoLivro, boolean lido) {
        this.nomeLivro = nomeLivro;
        this.paginas = paginas;
        this.generoLivro = generoLivro;
        this.lido = lido;
    }

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
        LocalDate hoje = LocalDate.now();
        LocalDate dataReg = Instant.ofEpochMilli(dataRegistro.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
        Period periodo = Period.between(dataReg, hoje);
        return periodo.getDays();
    }

    @Override
    public String toString() {
        return nomeLivro;
    }
}

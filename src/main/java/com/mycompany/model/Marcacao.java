package com.mycompany.model;

import java.util.Date;

public class Marcacao {

    int idMarcacao;
    String titulo;
    String anotacao;
    Livro livro;
    int paginaAtual;
    Date dataRegistro;
    Date dataEditado;

    public Marcacao() {
    }

    public Marcacao(String titulo, String anotacao, Livro livro, int paginaAtual) {
        this.titulo = titulo;
        this.anotacao = anotacao;
        this.livro = livro;
        this.paginaAtual = paginaAtual;
    }

    public int getIdMarcacao() {
        return idMarcacao;
    }

    public void setIdMarcacao(int idMarcacao) {
        this.idMarcacao = idMarcacao;
    }

    public int getPaginaAtual() {
        return paginaAtual;
    }

    public void setPaginaAtual(int paginaAtual) {
        this.paginaAtual = paginaAtual;
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

    public String getAnotacao() {
        return anotacao;
    }

    public void setAnotacao(String anotacao) {
        this.anotacao = anotacao;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

}

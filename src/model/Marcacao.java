package model;

import java.util.Date;

public class Marcacao {

    int idMarcacao;
    int paginaAtual;
    Date dataMarcacao;
    String anotacao;

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

    public Date getDataMarcacao() {
        return dataMarcacao;
    }

    public void setDataMarcacao(Date dataMarcacao) {
        this.dataMarcacao = dataMarcacao;
    }

    public String getAnotacao() {
        return anotacao;
    }

    public void setAnotacao(String anotacao) {
        this.anotacao = anotacao;
    }
}

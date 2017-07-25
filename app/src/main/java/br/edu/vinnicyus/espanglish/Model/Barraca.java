package br.edu.vinnicyus.espanglish.Model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Vinnicyus on 05/07/2017.
 */
@Table(name = "barracas", id = "id")
public class Barraca extends Model{

    @Column(name = "recepcao")
    private int recepcao;
    @Column(name = "utilizacao_materiais")
    private int utilizacao_materiais;
    @Column(name = "comidas_bebidas_tipicas")
    private int comidas_bebidas_tipicas;
    @Column(name = "fluencia_lingua")
    private int fluencia_lingua;
    @Column(name = "informacoes_pais_bandeira")
    private int informacoes_pais_bandeira;
    @Column(name = "producao_tecnologica")
    private int producao_tecnologica;
    @Column(name = "jogos_interacao")
    private int jogos_interacao;
    @Column(name = "criatividade")
    private int criatividade;
    @Column(name = "organizacao")
    private int organizacao;

    public int getRecepcao() {
        return recepcao;
    }

    public void setRecepcao(int recepcao) {
        this.recepcao = recepcao;
    }

    public int getUtilizacao_materiais() {
        return utilizacao_materiais;
    }

    public void setUtilizacao_materiais(int utilizacao_materiais) {
        this.utilizacao_materiais = utilizacao_materiais;
    }

    public int getComidas_bebidas_tipicas() {
        return comidas_bebidas_tipicas;
    }

    public void setComidas_bebidas_tipicas(int comidas_bebidas_tipicas) {
        this.comidas_bebidas_tipicas = comidas_bebidas_tipicas;
    }

    public int getFluencia_lingua() {
        return fluencia_lingua;
    }

    public void setFluencia_lingua(int fluencia_lingua) {
        this.fluencia_lingua = fluencia_lingua;
    }

    public int getInformacoes_pais_bandeira() {
        return informacoes_pais_bandeira;
    }

    public void setInformacoes_pais_bandeira(int informacoes_pais_bandeira) {
        this.informacoes_pais_bandeira = informacoes_pais_bandeira;
    }

    public int getProducao_tecnologica() {
        return producao_tecnologica;
    }

    public void setProducao_tecnologica(int producao_tecnologica) {
        this.producao_tecnologica = producao_tecnologica;
    }

    public int getJogos_interacao() {
        return jogos_interacao;
    }

    public void setJogos_interacao(int jogos_interacao) {
        this.jogos_interacao = jogos_interacao;
    }

    public int getCriatividade() {
        return criatividade;
    }

    public void setCriatividade(int criatividade) {
        this.criatividade = criatividade;
    }

    public int getOrganizacao() {
        return organizacao;
    }

    public void setOrganizacao(int organizacao) {
        this.organizacao = organizacao;
    }
}

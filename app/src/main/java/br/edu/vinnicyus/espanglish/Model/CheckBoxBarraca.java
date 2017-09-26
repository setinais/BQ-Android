package br.edu.vinnicyus.espanglish.Model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Vinnicyus on 16/08/2017.
 */
@Table(name = "checkBoxBarracas", id = "id")
public class CheckBoxBarraca extends Model {

    @Column(name = "recepcao")
    private boolean recepcao;
    @Column(name = "utilizacao_materiais")
    private boolean utilizacao_materiais;
    @Column(name = "comidas_bebidas_tipicas")
    private boolean comidas_bebidas_tipicas;
    @Column(name = "fluencia_lingua")
    private boolean fluencia_lingua;
    @Column(name = "informacoes_pais_bandeira")
    private boolean informacoes_pais_bandeira;
    @Column(name = "producao_tecnologica")
    private boolean producao_tecnologica;
    @Column(name = "jogos_interacao")
    private boolean jogos_interacao;
    @Column(name = "criatividade")
    private boolean criatividade;
    @Column(name = "organizacao")
    private boolean organizacao;

    public boolean isRecepcao() {
        return recepcao;
    }

    public void setRecepcao(boolean recepcao) {
        this.recepcao = recepcao;
    }

    public boolean isUtilizacao_materiais() {
        return utilizacao_materiais;
    }

    public void setUtilizacao_materiais(boolean utilizacao_materiais) {
        this.utilizacao_materiais = utilizacao_materiais;
    }

    public boolean isComidas_bebidas_tipicas() {
        return comidas_bebidas_tipicas;
    }

    public void setComidas_bebidas_tipicas(boolean comidas_bebidas_tipicas) {
        this.comidas_bebidas_tipicas = comidas_bebidas_tipicas;
    }

    public boolean isFluencia_lingua() {
        return fluencia_lingua;
    }

    public void setFluencia_lingua(boolean fluencia_lingua) {
        this.fluencia_lingua = fluencia_lingua;
    }

    public boolean isInformacoes_pais_bandeira() {
        return informacoes_pais_bandeira;
    }

    public void setInformacoes_pais_bandeira(boolean informacoes_pais_bandeira) {
        this.informacoes_pais_bandeira = informacoes_pais_bandeira;
    }

    public boolean isProducao_tecnologica() {
        return producao_tecnologica;
    }

    public void setProducao_tecnologica(boolean producao_tecnologica) {
        this.producao_tecnologica = producao_tecnologica;
    }

    public boolean isJogos_interacao() {
        return jogos_interacao;
    }

    public void setJogos_interacao(boolean jogos_interacao) {
        this.jogos_interacao = jogos_interacao;
    }

    public boolean isCriatividade() {
        return criatividade;
    }

    public void setCriatividade(boolean criatividade) {
        this.criatividade = criatividade;
    }

    public boolean isOrganizacao() {
        return organizacao;
    }

    public void setOrganizacao(boolean organizacao) {
        this.organizacao = organizacao;
    }
}

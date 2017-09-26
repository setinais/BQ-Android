package br.edu.vinnicyus.espanglish.Model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Vinnicyus on 16/08/2017.
 */
@Table(name = "checkboxpalcos", id = "id")
public class CheckBoxPalco extends Model {

    @Column(name = "desfile_traje")
    private boolean desfile_traje;
    @Column(name = "fluencia_lingua")
    private boolean fluencia_lingua;
    @Column(name = "presenca_de_palco")
    private boolean presenca_de_palco;
    @Column(name = "qualidade_slide")
    private boolean qualidade_slide;
    @Column(name = "apresentacao_cultural")
    private boolean apresentacao_cultural;
    @Column(name = "uso_tempo")
    private boolean uso_tempo;

    public boolean isDesfile_traje() {
        return desfile_traje;
    }

    public void setDesfile_traje(boolean desfile_traje) {
        this.desfile_traje = desfile_traje;
    }

    public boolean isFluencia_lingua() {
        return fluencia_lingua;
    }

    public void setFluencia_lingua(boolean fluencia_lingua) {
        this.fluencia_lingua = fluencia_lingua;
    }

    public boolean isPresenca_de_palco() {
        return presenca_de_palco;
    }

    public void setPresenca_de_palco(boolean presenca_de_palco) {
        this.presenca_de_palco = presenca_de_palco;
    }

    public boolean isQualidade_slide() {
        return qualidade_slide;
    }

    public void setQualidade_slide(boolean qualidade_slide) {
        this.qualidade_slide = qualidade_slide;
    }

    public boolean isApresentacao_cultural() {
        return apresentacao_cultural;
    }

    public void setApresentacao_cultural(boolean apresentacao_cultural) {
        this.apresentacao_cultural = apresentacao_cultural;
    }

    public boolean isUso_tempo() {
        return uso_tempo;
    }

    public void setUso_tempo(boolean uso_tempo) {
        this.uso_tempo = uso_tempo;
    }
}

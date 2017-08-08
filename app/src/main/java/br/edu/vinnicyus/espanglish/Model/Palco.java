package br.edu.vinnicyus.espanglish.Model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.List;

/**
 * Created by Vinnicyus on 05/07/2017.
 */
@Table(name= "palcos", id = "id")
public class Palco extends Model{

    @Column(name = "codigo")
    private String codigo;
    @Column(name = "desfile_traje")
    private int desfile_traje;
    @Column(name = "fluencia_lingua")
    private int fluencia_lingua;
    @Column(name = "presenca_de_palco")
    private int presenca_de_palco;
    @Column(name = "qualidade_slide")
    private int qualidade_slide;
    @Column(name = "apresentacao_cultural")
    private int apresentacao_cultural;
    @Column(name = "uso_tempo")
    private int uso_tempo;

    //1 - enviado, 2 - não enviado
    @Column(name = "status_envio")
    private int status_envio;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getDesfile_traje() {
        return desfile_traje;
    }

    public void setDesfile_traje(int desfile_traje) {
        this.desfile_traje = desfile_traje;
    }

    public int getFluencia_lingua() {
        return fluencia_lingua;
    }

    public void setFluencia_lingua(int fluencia_lingua) {
        this.fluencia_lingua = fluencia_lingua;
    }

    public int getPresenca_de_palco() {
        return presenca_de_palco;
    }

    public void setPresenca_de_palco(int presenca_de_palco) {
        this.presenca_de_palco = presenca_de_palco;
    }

    public int getQualidade_slide() {
        return qualidade_slide;
    }

    public void setQualidade_slide(int qualidade_slide) {
        this.qualidade_slide = qualidade_slide;
    }

    public int getApresentacao_cultural() {
        return apresentacao_cultural;
    }

    public void setApresentacao_cultural(int apresentacao_cultural) {
        this.apresentacao_cultural = apresentacao_cultural;
    }

    public int getUso_tempo() {
        return uso_tempo;
    }

    public void setUso_tempo(int uso_tempo) {
        this.uso_tempo = uso_tempo;
    }

    public int getStatus_envio() {
        return status_envio;
    }

    public void setStatus_envio(int status_envio) {
        this.status_envio = status_envio;
    }

    public static Palco getVotos(String codigo){
        Palco palco = new Select().from(Palco.class).where("codigo = ?", codigo).executeSingle();
        return palco;
    }

    public static List<Palco> getAll()
    {
        return new Select().from(Palco.class).where("status_envio = ?", 2).execute();
    }
}

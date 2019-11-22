package classes;

/**
 *
 * @author lps
 */
public class cidadeTeste {

    int idcidadeteste;
    String nomecidadeteste;
    int idestado;

    public cidadeTeste(int idcidadeteste, String nomecidadeteste, int idestado) {
        this.idcidadeteste = idcidadeteste;
        this.nomecidadeteste = nomecidadeteste;
        this.idestado = idestado;
    }

    public int getIdestado() {
        return idestado;
    }

    public void setIdestado(int idestado) {
        this.idestado = idestado;
    }

    public cidadeTeste() {
    }

    public cidadeTeste(int idcidadeteste, String nomecidadeteste) {
        this.idcidadeteste = idcidadeteste;
        this.nomecidadeteste = nomecidadeteste;
    }

    @Override
    public String toString() {
        return "cidadeTeste{" + "idcidadeteste=" + idcidadeteste + ", nomecidadeteste=" + nomecidadeteste + '}';
    }

    public int getIdcidadeteste() {
        return idcidadeteste;
    }

    public void setIdcidadeteste(int idcidadeteste) {
        this.idcidadeteste = idcidadeteste;
    }

    public String getNomecidadeteste() {
        return nomecidadeteste;
    }

    public void setNomecidadeteste(String nomecidadeteste) {
        this.nomecidadeteste = nomecidadeteste;
    }

}

package HuffmanAdaptativo;

public class HuffNodeAdaptativo {
    
    private Character caractere;

    private Integer frequencia;

    private HuffNodeAdaptativo esq;

    private HuffNodeAdaptativo dir;

    public HuffNodeAdaptativo(Character caractere) {
        this.caractere = caractere;
        this.frequencia = 1;
        this.dir = null;
        this.esq = null;
    }

    public Character getCaractere() {
        return caractere;
    }

    public void setCaractere(Character caractere) {
        this.caractere = caractere;
    }

    public Integer getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(Integer frequencia) {
        this.frequencia = frequencia;
    }

    public HuffNodeAdaptativo getEsq() {
        return esq;
    }

    public void setEsq(HuffNodeAdaptativo esq) {
        this.esq = esq;
    }

    public HuffNodeAdaptativo getDir() {
        return dir;
    }

    public void setDir(HuffNodeAdaptativo dir) {
        this.dir = dir;
    }


}

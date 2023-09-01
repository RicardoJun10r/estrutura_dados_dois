package RBTree;

public class NoRB<T> {
    
    private T valor;

    /*
     * BLACK - FALSE
     * RED - TRUE
     */
    private boolean cor;

    private NoRB<T> esq;

    private NoRB<T> dir;

    private NoRB<T> pai;

    public NoRB(T valor) {
        this.valor = valor;
        this.cor = true;
        this.esq = null;
        this.dir = null;
        this.pai = null;
    }
    
    public NoRB<T> getPai() {
        return pai;
    }

    public void setPai(NoRB<T> pai) {
        this.pai = pai;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public boolean getCor() {
        return cor;
    }

    public void setCor(boolean cor) {
        this.cor = cor;
    }

    public NoRB<T> getEsq() {
        return esq;
    }

    public void setEsq(NoRB<T> esq) {
        this.esq = esq;
    }

    public NoRB<T> getDir() {
        return dir;
    }

    public void setDir(NoRB<T> dir) {
        this.dir = dir;
    }

}

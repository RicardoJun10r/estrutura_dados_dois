package RBTree;

public class NoRB<T> {
    
    private T valor;

    private boolean cor;

    private NoRB<T> esq;

    private NoRB<T> dir;

    public NoRB(T valor) {
        this.valor = valor;
        this.cor = false;
        this.esq = null;
        this.dir = null;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public boolean isCor() {
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

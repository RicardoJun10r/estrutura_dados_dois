package Tree;

public class Folha<T> {

    private T valor;

    private Folha<T> esq;

    private Folha<T> dir;

    public Folha(T valor){
        this.valor = valor;
        this.esq = null;
        this.dir = null;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public Folha<T> getEsq() {
        return esq;
    }

    public void setEsq(Folha<T> esq) {
        this.esq = esq;
    }

    public Folha<T> getDir() {
        return dir;
    }

    public void setDir(Folha<T> dir) {
        this.dir = dir;
    }

}
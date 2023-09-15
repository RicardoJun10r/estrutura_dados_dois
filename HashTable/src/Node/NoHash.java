package Node;

public class NoHash<T> {
    
    private NoHash<T> prox;
    
    private T valor;
    
    private int chave;

    public NoHash(T valor, int chave) {
        this.prox = null;
        this.valor = valor;
        this.chave = chave;
    }

    public NoHash<T> getProx() {
        return prox;
    }

    public void setProx(NoHash<T> prox) {
        this.prox = prox;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public int getChave() {
        return chave;
    }

    public void setChave(int chave) {
        this.chave = chave;
    }
    
}

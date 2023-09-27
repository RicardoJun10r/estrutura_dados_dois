package Node;

public class NoHash<T> {
    
    private NoHash<T> prox;
    
    private T valor;
    
    private Integer chave;

    public NoHash(T valor, Integer chave) {
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

    public Integer getChave() {
        return chave;
    }

    public void setChave(Integer chave) {
        this.chave = chave;
    }
    
}

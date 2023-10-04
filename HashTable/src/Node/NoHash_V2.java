package Node;

public class NoHash_V2<V, K> {
    
    private NoHash_V2<V, K> prox;

    private NoHash_V2<V, K> ant;

    private V valor;
    
    private K chave;

    private Integer frequencia;

    public NoHash_V2(V valor, K chave) {
        this.prox = null;
        this.valor = valor;
        this.chave = chave;
        this.frequencia = 0;
    }

    public Integer getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(Integer frequencia) {
        this.frequencia = frequencia;
    }

    public NoHash_V2<V, K> getAnt() {
        return ant;
    }

    public void setAnt(NoHash_V2<V, K> ant) {
        this.ant = ant;
    }

    public NoHash_V2<V, K> getProx() {
        return prox;
    }

    public void setProx(NoHash_V2<V, K> prox) {
        this.prox = prox;
    }

    public V getValor() {
        return valor;
    }

    public void setValor(V valor) {
        this.valor = valor;
    }

    public K getChave() {
        return chave;
    }

    public void setChave(K chave) {
        this.chave = chave;
    }

}

package LL;

public class Lista<T extends Comparable<T>> {
    
    /**
     * Talvez de erro por conta do tipo K
     */
    class Ponto <K>{
        
        Ponto<T> prox;
        T valor;

        public Ponto(T val){
            prox = null;
            valor = val;
        }

    }

    Ponto<T> cabeca;

    Ponto<T> calda;

    public Lista(){
        cabeca = null;
        calda = null;
    }

    public void inserir(T val){
        Ponto<T> novo = new Ponto<>(val);
        if(cabeca == null){
            cabeca = novo;
            calda = novo;
        } else {
            cabeca.prox = novo;
            cabeca = novo;
        }
    }

    public void iterar(){
        Ponto<T> index = calda;
        while (index != null) {
            if(index.prox != null) index = index.prox;
            else break;
        }
    }

    public void iterarReversivo(){
        iterarReversivo(calda);
    }

    private void iterarReversivo(Ponto<T> ponto){
        if(ponto == null) return;
        else iterarReversivo(ponto.prox);
    }

}

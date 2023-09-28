package heaps;

import util.Lista;

public class MaxHeap<T extends Comparable<T>> {
    
    private Lista<T> lista;

    public MaxHeap(){
        this.lista = new Lista<>();
    }

    public void Add(T valor){
        int tamanho = this.lista.Size();

        if(tamanho == 0){
            lista.Add(valor);
        } else {
            lista.Add(valor);
            Subir(tamanho);
        }

    }

    private int Piso(int numero){
        return (int)Math.floor(numero);
    }

    private void Subir(int posicao){
        
        int tamanho = this.lista.Size();
        int j = Piso((posicao - 1) / tamanho);

        if(j >= 0 && (lista.Get(j).compareTo(lista.Get(posicao)) < 0)){
            T aux = lista.Get(j);
            lista.Set(j, lista.Get(posicao));
            lista.Set(posicao, aux);
            Subir(j);
        }

    }

    private void Descer(int posicao, int tamanho){
        
        int j = posicao * 2 + 1;

        if(j < tamanho){
            if(j < tamanho - 1){
                if(lista.Get(j + 1).compareTo(lista.Get(j)) > 0){
                    j++;
                }

                if(lista.Get(posicao).compareTo(lista.Get(j)) < 0){
                    T aux = lista.Get(j);
                    lista.Set(j, lista.Get(posicao));
                    lista.Set(posicao, aux);
                    Descer(j, tamanho);
                }

            }
        }

    }

}

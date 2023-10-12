package heaps;

import util.Lista;

public class MinHeap<T extends Comparable<T>> {
    
    private Lista<T> lista;

    public MinHeap(){
        this.lista = new Lista<>();
    }

    public void Add(T valor){

        if(this.lista.Empty()){
            lista.Add(valor);
        } else {
            lista.Add(valor);
            Subir(this.lista.Size()-1);
        }

    }

    public void BuildHeap(Lista<T> lista){

        this.lista = lista;

        int tamanho = Piso(lista.Size()/2) - 1;

        for(int i = tamanho; i >= 0; i--){
            Descer(i, this.lista.Size());
        }

    }

    public void HeapSort(Lista<T> lista){

        int tamanhoAtual = lista.Size();
        BuildHeap(lista);

        for(int i = lista.Size()-1; i >= 0; i--){
            T temp = this.lista.Get(i);
            this.lista.Set(i, this.lista.Get(0));
            this.lista.Set(0, temp);
            tamanhoAtual--;
            Descer(0, tamanhoAtual);
        }

    }

    public void Delete(){
        if(this.lista.Empty()) return;
        else {
            this.lista.Set(0, this.lista.Get(this.lista.Size()-1));
            this.lista.DeleteTail();
            Descer(0, this.lista.Size());
        }
    }

    private int Piso(int numero){
        return (int)Math.floor(numero);
    }

    private void Subir(int posicao){
        
        int j = Piso((posicao - 1) / 2);

        if(j >= 0 && (lista.Get(j).compareTo(lista.Get(posicao)) > 0)){
            T aux = lista.Get(j);
            lista.Set(j, lista.Get(posicao));
            lista.Set(posicao, aux);
            Subir(j);
        }

    }

    private void Descer(int posicao, int tamanho){
        
        int j = (posicao * 2) + 1;

        if(j < tamanho){
            if(j < tamanho - 1){
                if(lista.Get(j + 1).compareTo(lista.Get(j)) < 0){
                    j++;
                }

            }
            if(lista.Get(posicao).compareTo(lista.Get(j)) > 0){
                T aux = lista.Get(j);
                lista.Set(j, lista.Get(posicao));
                lista.Set(posicao, aux);
                Descer(j, tamanho);
            }

        }

    }

    public void Print(){
        System.out.println("=================");
        this.lista.Print();
        System.out.println("=================");
    }

}

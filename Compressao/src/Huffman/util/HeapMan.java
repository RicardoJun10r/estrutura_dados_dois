package Huffman.util;

import util.Lista;

public class HeapMan {
    
    private Lista<HuffNode> lista;

    public HeapMan(){
        this.lista = new Lista<>();
    }

    public void Add(HuffNode valor){

        if(this.lista.Empty()){
            lista.Add(valor);
        } else {
            lista.Add(valor);
            Subir(this.lista.Size()-1);
        }

    }

    public void BuildHeap(Lista<HuffNode> lista){

        this.lista = lista;

        int tamanho = Piso(lista.Size()/2) - 1;

        for(int i = tamanho; i >= 0; i--){
            Descer(i, this.lista.Size());
        }

    }

    public void HeapSort(Lista<HuffNode> lista){

        int tamanhoAtual = lista.Size();
        BuildHeap(lista);

        for(int i = lista.Size()-1; i >= 0; i--){
            HuffNode temp = this.lista.Get(i);
            this.lista.Set(i, this.lista.Get(0));
            this.lista.Set(0, temp);
            tamanhoAtual--;
            Descer(0, tamanhoAtual);
        }

    }

    public HuffNode Delete(){
        if(this.lista.Empty()) return null;
        else {
            HuffNode tmp = this.lista.Get(0);
            this.lista.Set(0, this.lista.Get(this.lista.Size()-1));
            this.lista.DeleteTail();
            Descer(0, this.lista.Size());
            return tmp;
        }
    }

    private int Piso(int numero){
        return (int)Math.floor(numero);
    }

    private void Subir(int posicao){
        
        int j = Piso((posicao - 1) / 2);

        if(j >= 0 && (lista.Get(j).getFrequencia() > lista.Get(posicao).getFrequencia())){
            HuffNode aux = lista.Get(j);
            lista.Set(j, lista.Get(posicao));
            lista.Set(posicao, aux);
            Subir(j);
        }

    }

    private void Descer(int posicao, int tamanho){
        
        int j = (posicao * 2) + 1;

        if(j < tamanho){
            if(j < tamanho - 1){
                if(lista.Get(j + 1).getFrequencia() < lista.Get(j).getFrequencia()){
                    j++;
                }

            }
            if(lista.Get(posicao).getFrequencia() > lista.Get(j).getFrequencia()){
                HuffNode aux = lista.Get(j);
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

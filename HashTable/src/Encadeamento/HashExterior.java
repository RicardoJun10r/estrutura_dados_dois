package Encadeamento;

import Node.NoHash;

public class HashExterior<T> {
    
    private NoHash<T>[] tabela;

    private int M;

    public HashExterior(Integer tamanho){
        this.M = tamanho;
        this.tabela = new NoHash[this.M];
    }

    private Integer hash(Integer chave){
        return chave % this.M;
    }

    public void put(T valor, Integer chave){
        Integer posicao = hash(chave);

        NoHash<T> noHash = this.tabela[posicao];

        while(noHash != null){
            if(noHash.getValor().equals(valor)) break;
            noHash = noHash.getProx();
        }

        if(noHash == null){
            noHash = new NoHash<>(valor, chave);
            noHash.setProx(this.tabela[posicao]);
            this.tabela[posicao] = noHash;
        }
    }

    public NoHash<T> buscar(Integer chave){
        Integer posicao = hash(chave);
        NoHash<T> noHash = this.tabela[posicao];
        while (noHash != null) {
            if(noHash.getChave() == chave) return noHash;
            noHash = noHash.getProx();
        }
        return null;
    }

    public void remover(Integer chave){
        Integer posicao = hash(chave);
        NoHash<T> noHash = this.tabela[posicao];
        if(noHash.getChave().equals(chave)){
            this.tabela[posicao] = noHash.getProx();
            noHash.setProx(null);
            noHash = null;
            return;
        }
        NoHash<T> anterior = null;
        while (noHash != null) {
            if(noHash.getChave().equals(chave) || noHash.getProx() == null) break;
            anterior = noHash;
            noHash = noHash.getProx();
        }

        anterior.setProx(noHash.getProx());
        noHash.setProx(null);
        noHash = null;
    }

    public void print(){
        NoHash<T> index;
        for(int i = 0; i < this.M; i++){
            index = this.tabela[i];
            System.out.print(i);
            while (index != null) {
                System.out.print(" --> " + index.getValor());
                index = index.getProx();
            }
            System.out.println();
        }
    }

}

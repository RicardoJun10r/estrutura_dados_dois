package Aberto;

import Node.NoHash;

public class HashAberto<T> {
    
    private NoHash<T> tabela[];

    private Integer M;

    public HashAberto(Integer tamanho){
        this.M = tamanho;
        this.tabela = new NoHash[this.M];
    }

    private Integer hash(Integer chave){
        return chave % this.M;
    }

    public void put(Integer chave, T valor){
        Integer posicao = hash(chave);

        while(this.tabela[posicao] != null){
            if(this.tabela[posicao].getChave() == chave) break;
            posicao = (posicao+1)%this.M;
        }

        if(this.tabela[posicao] == null){
            this.tabela[posicao] = new NoHash<>(valor, chave);
        }
    }

    public void remover(Integer chave){
        Integer posicao = hash(chave);
        while (this.tabela[posicao] != null) {
            if(this.tabela[posicao].getChave() == chave) this.tabela[posicao] = null;
            posicao = (posicao+1)%this.M;
        }
    }

    public NoHash<T> buscar(Integer chave){
        Integer posicao = hash(chave);
        while (this.tabela[posicao] != null) {
            if(this.tabela[posicao].getChave() == chave) return this.tabela[posicao];
            posicao = (posicao+1)%this.M;
        }
        return null;
    }

    public void print(){
        for(int i = 0; i < this.M; i++){
            if(this.tabela[i] != null){
                System.out.println(i + " --> " + this.tabela[i].getChave());
            } else System.out.println(i);
        }
    }
}

package ListaAutoAjustavel;

public class ListaAjustavel<T> {
    
    private class No<T>{

        private T valor;

        private int frequencia;

        private No<T> prox;

        private No<T> ant;

        public No(T valor){
            this.valor = valor;
            this.prox = null;
            this.ant = null;
            this.frequencia = 0;
        }

    }

    private No<T> head;

    private No<T> tail;

    private int tamanho;

    public ListaAjustavel(){
        this.head = null;
        this.tail = null;
        this.tamanho = 0;
    }

    public void Add(T valor){

        No<T> novo = new No<>(valor);

        if(Empty()){
            this.head = novo;
            this.tail = novo;
        } else {
            this.tail.prox = novo;
            novo.ant = this.tail;
            this.tail = novo;
        }

        this.tamanho++;

    }

    public void DeleteHead(){
        if(Empty()) return;
        else {
            No<T> remover = this.head;
            this.head.prox.ant = null;
            this.head = this.head.prox;
            remover.prox = null;
            remover = null;
            this.tamanho--;
        }
    }

    public void DeleteTail(){
        if(Empty()) return;
        else {
            No<T> remover = this.tail;
            this.tail = this.tail.ant;
            this.tail.prox = null;
            remover.ant = null;
            remover = null;
            this.tamanho--;
        }
    }

    public void Delete(T valor){
        if(Empty()) return;
        else {
            SearchMF(valor);
            DeleteHead();
        }
    }

    public No<T> SearchCF(T valor){
        if(Empty()) return null;
        else {
            No<T> index = this.head;
            while (index != null) {
                if(index.valor.equals(valor)) break;
                index = index.prox;
            }

            if(index != null){
                index.frequencia += 1;
                CF(index);
                return index;
            }
            return null;
        }
    }

    public No<T> SearchMF(T valor){
        if(Empty()) return null;
        else {
            No<T> index = this.head;
            while (index != null) {
                if(index.valor.equals(valor)) break;
                index = index.prox;
            }

            if(index != null){
                MF(index);
                return index;
            }
            return null;
        }
    }

    public No<T> SearchTR(T valor){
        if(Empty()) return null;
        else {
            No<T> index = this.head;
            while (index != null) {
                if(index.valor.equals(valor)) break;
                index = index.prox;
            }

            if(index != null){
                TR(index);
                return index;
            }
            return null;
        }
    }

    private void MF(No<T> no){
        if(Empty()) return;
        else {
            if(this.head.equals(no)) return;
            else{
                no.ant.prox = no.prox;
                no.prox.ant = no.ant;
                no.ant = null;
                no.prox = this.head;
                this.head = no;
            }
        }
    }

    private void TR(No<T> no){
        if(Empty()) return;
        else {
            if(this.head.equals(no)) return;
            else{
                T temp = no.ant.valor;
                int freq = no.ant.frequencia;
                no.ant.valor = no.valor;
                no.ant.frequencia = no.frequencia;
                no.valor = temp;
                no.frequencia = freq;
            }
        }
    }

    private void CF(No<T> no){
        if(Empty()) return;
        else {
            if(this.head.equals(no)) return;
            else{
                while(no.frequencia > no.ant.frequencia){
                    T temp = no.ant.valor;
                    int freq = no.ant.frequencia;
                    no.ant.valor = no.valor;
                    no.ant.frequencia = no.frequencia;
                    no.valor = temp;
                    no.frequencia = freq;
                    if(no.ant != null) no = no.ant;
                    if(this.head.equals(no)) return;
                }
                return;
            }
        }
    }

    public void Print(){
        No<T> index = this.head;
        int i = 1;
        System.out.println("=================");
        while (index != null) {
            System.out.println(i + "°\t--> " + index.valor);
            index = index.prox;
            i++;
        }
        System.out.println("=================");
    }

    public boolean Empty(){
        if(this.head == null && this.tail == null) return true;
        else return false;
    }

}

package RBTree;


/*
 * 
 * RED - BLACK TREE
 * 
 * BLACK --> FALSE
 * 
 * RED --> TRUE
 * 
 */

public class ArvoreRB<T extends Comparable<T>> {
    
    private NoRB<T> raiz;

    public ArvoreRB(){
        this.raiz = null;
    }

    public void insert(T valor){
        if(isEmpty()) this.raiz = new NoRB<>(valor);
        this.raiz = insert(raiz, valor);
    }

    private NoRB<T> insert(NoRB<T> folha, T valor){
        
        if(folha == null) folha = new NoRB<>(valor);
        else if(valor.compareTo(folha.getValor()) > 0) folha.setDir(insert(folha.getDir(), valor));
        else if(valor.compareTo(folha.getValor()) < 0) folha.setEsq(insert(folha.getEsq(), valor));
        return folha;

    }

    private Boolean isEmpty(){
        if(this.raiz == null) return true;
        else return false;
    }

}

package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ArvoreBinaria<T extends Comparable<T>> {

    private Folha<T> raiz;

    private Integer size;

    public ArvoreBinaria(){
        this.raiz = null;
        this.size = 0;
    }

    public void add(T fruto){

        size++;

        if(taCortado()) raiz = new Folha<T>(fruto);

        add(raiz, fruto);

    }

    private void add(Folha<T> galho, T fruto){

        if(fruto.compareTo(galho.getValor()) > 0){
            if(galho.getDir() == null)
                galho.setDir(new Folha<T>(fruto));
            add(galho.getDir(), fruto);
        } else if(fruto.compareTo(galho.getValor()) < 0){
            if(galho.getEsq() == null)
                galho.setEsq(new Folha<T>(fruto));
            add(galho.getEsq(), fruto);
        } else return;

    }

    public Folha<T> add2(T fruto){

        if(taCortado()) return raiz = new Folha<T>(fruto);
        return add2(raiz, fruto);
    
    }

    private Folha<T> add2(Folha<T> galho, T fruto){

        if(galho == null) galho = new Folha<T>(fruto);
        else if(fruto.compareTo(galho.getValor()) > 0) galho.setDir(add2(galho.getDir(), fruto));
        else if(fruto.compareTo(galho.getValor()) < 0) galho.setEsq(add2(galho.getEsq(), fruto));
        return galho;

    }

    public T buscar(T fruto){
        
        return buscar(raiz, fruto).getValor();

    }

    private Folha<T> buscar(Folha<T>galho, T fruto){

        if(galho == null) return null;
        else if(fruto.compareTo(galho.getValor()) > 0) return buscar(galho.getDir(), fruto);
        else if(fruto.compareTo(galho.getValor()) < 0) return buscar(galho.getEsq(), fruto);
        else return galho;

    }

    public T maximo(){
        return maximo(raiz).getValor();
    }

    private Folha<T> maximo(Folha<T> galho){
        if(galho.getDir() != null) return maximo(galho.getDir());
        return galho;
    }

    public T minimo(){
        return minimo(raiz).getValor();
    }

    private Folha<T> minimo(Folha<T> galho){
        if(galho.getEsq() != null) return minimo(galho.getEsq());
        return galho;
    }

    public T buscar2(T fruto){
        
        return buscar2(raiz, fruto).getValor();

    }

    private Folha<T> buscar2(Folha<T>galho, T fruto){

        if(galho == null || fruto == galho.getValor()) return galho;
        if(fruto.compareTo(galho.getValor()) > 0) return buscar2(galho.getDir(), fruto);
        else return buscar2(galho.getEsq(), fruto);

    }

    public void remover(T fruto){

        if(taCortado()) System.out.println("[ VAZIO ]");
        else this.raiz = remover(raiz, fruto);

    }

    private Folha<T> remover(Folha<T> galho, T fruto){
        
        if(galho == null) return null;
        else if(fruto.compareTo(galho.getValor()) > 0) galho.setDir( remover(galho.getDir(), fruto) );
        else if(fruto.compareTo(galho.getValor()) < 0) galho.setEsq( remover(galho.getEsq(), fruto) );
        else {

            Folha<T> aux;

            if(ehFolha(galho)) {

                galho = null;
            
            }

            else if(soFolhaEsq(galho)){

                aux = galho;
                
                galho = aux.getEsq();
                
                aux = null;

            }

            else if(soFolhaDir(galho)){

                aux = galho;

                galho = aux.getDir();
                
                aux = null;

            }

            else {
                
                aux = procurarMaiorRec(galho.getDir());

                galho.setValor( aux.getValor() );

                galho.setDir( remover( galho.getDir(), aux.getValor() ) );

            }
            
        }

        return galho;

    }

    // private Folha<T> procurarMaiorIter(Folha<T> galho){
    //     Folha<T> aux = galho.getDir();

    //     while (aux != null) {
    //         if(aux.getEsq() != null) aux = aux.getEsq();
    //         else break;
    //     }

    //     return aux;
    // }

    private Folha<T> procurarMaiorRec(Folha<T> galho){
        
        if(galho.getEsq() != null) return procurarMaiorRec(galho.getEsq());
        else return galho;

    }

    public void posOrdem(){
        System.out.println("Em pós ordem");
        posOrdem(raiz);
    }

    private void posOrdem(Folha<T> galho){
        
        if(galho != null){
            System.out.println(galho.getValor());
            posOrdem(galho.getEsq());
            posOrdem(galho.getDir());
        }

    }

    public void ordem(){
        System.out.println("Em ordem");
        ordem(raiz);
    }

    private void ordem(Folha<T> galho){

        if(galho != null){

            ordem(galho.getEsq());
            System.out.println(galho.getValor());
            ordem(galho.getDir());

        }

    }

    public void preOrdem(){
        System.out.println("Em pré-ordem");
        preOrdem(raiz);
    }

    private void preOrdem(Folha<T> galho){

        if(galho != null){

            System.out.println(galho.getValor());
            preOrdem(galho.getEsq());
            preOrdem(galho.getDir());

        }

    }

    public void percursoIterativo(){
        percursoIterativo(raiz);
    }

    private void percursoIterativo(Folha<T> galho){
        
        Stack<Folha<T>> pilha = new Stack<>();
        pilha.push(galho);
        Folha<T> index = null;
        while(true){
            index = pilha.pop();
            if(index != null){
                pilha.push(index);
                pilha.push(index.getEsq());
            } else {
                if(pilha.isEmpty()) break;
                index = pilha.pop();
                System.out.println(index.getValor());
                pilha.push(index.getDir());
            }
        }
        pilha.clear();

    }

    public Boolean taCortado(){
        if(raiz == null) return true;
        else return false;
    }

    public void printRaiz(){
        System.out.println("Raiz = " + raiz.getValor());
    }

    private Boolean ehFolha(Folha<T> galho){

        if(galho.getEsq() == null && galho.getDir() == null) return true;
        else return false;

    }

    private Boolean ehGalho(Folha<T> galho){
        
        if(galho.getEsq() != null || galho.getDir() != null) return true;
        else return false;

    }

    private Boolean soFolhaEsq(Folha<T> galho){

        if(galho.getEsq() != null && galho.getDir() == null) return true;
        else return false;

    }

    private Boolean soFolhaDir(Folha<T> galho){

        if(galho.getEsq() == null && galho.getDir() != null) return true;
        else return false;

    }

    public Integer contarFolhas(){
        return contarFolhas(raiz);
    }

    private Integer contarFolhas(Folha<T> galho){
        if(galho == null) return 0;
        else if(ehFolha(galho)) return 1;
        else return contarFolhas(galho.getEsq()) + contarFolhas(galho.getDir());
    }

    public Integer tamanho(){ return size; }

    public Integer contarGalhos(){
        return contarGalhos(raiz);
    }

    private Integer contarGalhos(Folha<T> galho){
        if(galho == null) return 0;
        else if(ehGalho(galho)){
            return 1 + contarGalhos(galho.getEsq()) + contarGalhos(galho.getDir());
        } else {
            return 0;
        }
    }

    public Integer altura(){ return altura(raiz); }

    private Integer altura(Folha<T> galho){

        if(galho == null || ehFolha(galho)) return 0; 
        if(altura(galho.getEsq()) > altura(galho.getDir())) return 1 + altura(galho.getEsq());
        else return 1 + altura(galho.getDir());

    }

    public void percursoEmLargura(){
        if(!taCortado()) percursoEmLargura(raiz);
    }

    private void percursoEmLargura(Folha<T> galho){
        
        Folha<T> index = null;

        Queue<Folha<T>> fila = new LinkedList<>();

        fila.add(galho);

        while(!fila.isEmpty()){
            
            index = fila.remove();

            System.out.println("Valor = " + index.getValor());

            if(index.getEsq() != null) fila.add( index.getEsq() );
            if(index.getDir() != null) fila.add( index.getDir() );
        }

        System.out.println();

    }

}
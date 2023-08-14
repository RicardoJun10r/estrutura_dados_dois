package AVL;

public class AVLTree<T extends Comparable<T>> {
    
    private No<T> raiz;

    public AVLTree() {
        this.raiz = null;
    }

    public void insert(T valor){
        if(isEmpty()) this.raiz = new No<>(valor);
        this.raiz = insert(raiz, valor);
        this.raiz = this.FB(raiz);
    }

    private No<T> insert(No<T> folha, T valor){
        if(folha == null) folha = new No<T>(valor);
        else if(valor.compareTo(folha.getValor()) > 0) folha.setDir(insert(folha.getDir(), valor));
        else if(valor.compareTo(folha.getValor()) < 0) folha.setEsq(insert(folha.getEsq(), valor));
        return folha;
    }

    public void remove(T valor){
        if(isEmpty()) System.out.println("Vazio");
        else {
            this.raiz = remove(raiz, valor);
            this.raiz = this.FB(raiz);
        }
    }

    private No<T> remove(No<T> folha, T valor){

        if(folha == null) return null;
        else if(valor.compareTo(folha.getValor()) > 0) folha.setDir(remove(folha.getDir(), valor));
        else if(valor.compareTo(folha.getValor()) < 0) folha.setEsq(remove(folha.getEsq(), valor));
        else {
            
            if(ehFolha(folha)) folha = null;

            else if(soFolhaEsq(folha)){
                folha.setValor(folha.getEsq().getValor());
                folha.setEsq(null);
            } else if(soFolhaDir(folha)){
                folha.setValor(folha.getDir().getValor());
                folha.setDir(null);
            } else {
                No<T> aux = sucessor(folha);
                folha.setValor(aux.getValor());
                folha.setDir( remove(folha.getDir(), aux.getValor()) );
            }

        }

        return folha;

    }

    private No<T> sucessor(No<T> folha){
        No<T> index = folha.getDir();
        while(index != null){
            if(index.getEsq() != null) index = index.getEsq();
            else break;
        }
        return index;
    }

    public T buscar(T valor){

        return buscar(raiz, valor).getValor();

    }

    private No<T> buscar(No<T> folha, T valor){
        if(folha == null) return null;
        else if(valor.compareTo(folha.getValor()) > 0) return buscar(folha.getDir(), valor);
        else if(valor.compareTo(folha.getValor()) < 0) return buscar(folha.getEsq(), valor);
        else return folha;
    }

    public void emOrdem(){
        if(isEmpty()) System.out.println("Vazio");
        else emOrdem(raiz);
    }

    private void emOrdem(No<T> folha){
        if(folha != null){
            emOrdem(folha.getEsq());
            System.out.println("Valor = " + folha.getValor() + " FB = " + folha.getFB());
            emOrdem(folha.getDir());
        }
    }

    public void preOrdem(){
        if(isEmpty()) System.out.println("Vazio");
        else preOrdem(raiz);
    }

    private void preOrdem(No<T> folha){
        if(folha != null){
            System.out.println("Valor = " + folha.getValor() + " FB = " + folha.getFB());
            preOrdem(folha.getEsq());
            preOrdem(folha.getDir());
        }
    }

    public void posOrdem(){
        if(isEmpty()) System.out.println("Vazio");
        else posOrdem(raiz);
    }

    private void posOrdem(No<T> folha){
        if(folha != null){
            posOrdem(folha.getEsq());
            posOrdem(folha.getDir());
            System.out.println("Valor = " + folha.getValor() + " FB = " + folha.getFB());
        }
    }

    public Integer altura(){
        if(isEmpty()) return -1;
        else return altura(raiz);
    }

    private Integer altura(No<T> folha){

        if(folha == null) return 0;
        else if(altura(folha.getEsq()) > altura(folha.getDir())) return 1 + altura(folha.getEsq());
        else return 1 + altura(folha.getDir());
    }

    private No<T> FB(No<T> folha){
        if(folha != null){
            folha.setEsq( FB(folha.getEsq()) );
            folha.setDir( FB(folha.getDir()) );
            calcularFB(folha);
            calcularFB(folha.getEsq());
            calcularFB(folha.getDir());

            // Rotação Simples a esquerda
            if(folha.getFB() < -1 && folha.getDir().getFB() <= 0){
                return rotacaoEsquerdaSimples(folha);
            }

            // Rotação Simples a direita
            if(folha.getFB() > 1 && folha.getEsq().getFB() >= 0){
                return rotacaoDireitaSimples(folha);
            }

            // Rotação Dupla a esquerda
            if(folha.getFB() < -1 && folha.getDir().getFB() > 0){
                folha.setDir(rotacaoDireitaSimples(folha.getDir()));
                return rotacaoEsquerdaSimples(folha);
            }

            // Rotação Dupla a direita
            if(folha.getFB() > 1 && folha.getEsq().getFB() < 0){
                folha.setEsq(rotacaoEsquerdaSimples(folha.getEsq()));
                return rotacaoDireitaSimples(folha);
            }

        }
        return folha;
    }

    private No<T> rotacaoEsquerdaSimples(No<T> folha){
        No<T> aux = folha.getDir();
        folha.setDir(aux.getEsq());
        aux.setEsq(folha);
        calcularFB(folha);
        calcularFB(aux);
        return aux;
    }

    private No<T> rotacaoDireitaSimples(No<T> folha){
        No<T> aux = folha.getEsq();
        folha.setEsq(aux.getDir());
        aux.setDir(folha);
        calcularFB(folha);
        calcularFB(aux);
        return aux;
    }

    private void calcularFB(No<T> folha){
        if(folha != null){
            if(ehFolha(folha)) folha.setFB(0);
            else folha.setFB( altura(folha.getEsq()) - altura(folha.getDir()) );
        }

    }

    private Boolean ehFolha(No<T> folha){
        if(folha.getEsq() == null && folha.getDir() == null) return true;
        else return false;
    }

    private Boolean soFolhaEsq(No<T> folha){
        if(folha.getEsq() != null && folha.getDir() == null) return true;
        else return false;
    }

    private Boolean soFolhaDir(No<T> folha){
        if(folha.getEsq() == null && folha.getDir() != null) return true;
        else return false;
    }

    private Boolean isEmpty(){
        if(this.raiz == null) return true;
        else return false;
    }

}

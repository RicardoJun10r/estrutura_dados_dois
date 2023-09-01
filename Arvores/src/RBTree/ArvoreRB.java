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
        if(isEmpty()) {
            this.raiz = new NoRB<>(valor);
            this.raiz.setCor(false);
        }
        insert(raiz, valor);
        this.raiz = evaluate(raiz);
    }

    private void insert(NoRB<T> filho, T valor){
        
        if(valor.compareTo(filho.getValor()) > 0){
            if(dirNull(filho)){
                NoRB<T> novo = new NoRB<>(valor);
                filho.setDir(novo);
                novo.setPai(filho);
            }
            insert(filho.getDir(), valor);
        }
        else if(valor.compareTo(filho.getValor()) < 0){
            if(esqNull(filho)){
                NoRB<T> novo = new NoRB<>(valor);
                filho.setEsq(novo);
                novo.setPai(filho);
            }
            insert(filho.getEsq(), valor);
        }

    }

    private NoRB<T> evaluate(NoRB<T> filho){
        if(filho != null){
            filho.setEsq( this.evaluate(filho.getEsq()) );
            filho.setDir( this.evaluate(filho.getDir()) );
            if(filho.getPai() != null)
                if(filho.getCor() == true && filho.getPai().getCor() == true)
                    return balancear(filho);
        }
        return filho;
    }

    private NoRB<T> balancear(NoRB<T> pai){
        NoRB<T> avo = pai.getPai();
        if(pai.getValor().compareTo(avo.getValor()) > 0){
            NoRB<T> tio = avo.getEsq();
            if(tio.getCor()){
                pai.setCor(!pai.getCor());
                tio.setCor(!tio.getCor());
                avo.setCor(!avo.getCor());
                return pai;
            }
            return rotacaoEsquerdaSimples(avo);
        } else {
            NoRB<T> tio = avo.getDir();
            if(tio.getCor()){
                pai.setCor(!pai.getCor());
                tio.setCor(!tio.getCor());
                avo.setCor(!avo.getCor());
                return pai;
            }
            return rotacaoDireitaSimples(avo);
        }
    }

    private NoRB<T> rotacaoEsquerdaSimples(NoRB<T> avo){
        
    }

    private NoRB<T> rotacaoDireitaSimples(NoRB<T> avo){
        NoRB<T> aux = avo.getEsq().getDir();
    }

    private Boolean esqNull(NoRB<T> folha){
        if(folha.getEsq() == null) return true;
        else return false;
    }

    private Boolean dirNull(NoRB<T> folha){
        if(folha.getDir() == null) return true;
        else return false;
    }

    private Boolean isEmpty(){
        if(this.raiz == null) return true;
        else return false;
    }

    public void emOrdem(){
        this.emOrdem(this.raiz);
    }

    private void emOrdem(NoRB<T> folha){
        if(folha != null){
            this.emOrdem(folha.getEsq());
            System.out.println("Valor = " + folha.getValor() + " Cor = " + (folha.getCor() == true ? "Vermelho" : "preto"));
            this.emOrdem(folha.getDir());
        }
    }

    public void preOrdem(){
        this.preOrdem(this.raiz);
    }

    private void preOrdem(NoRB<T> folha){
        if(folha != null){
            System.out.println("Valor = " + folha.getValor() + " Cor = " + (folha.getCor() == true ? "Vermelho" : "preto"));
            this.preOrdem(folha.getEsq());
            this.preOrdem(folha.getDir());
        }
    }

}

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
        // this.raiz = evaluate(raiz);
    }

    private void insert(NoRB<T> pai, T valor){

        if(pai.getValor().compareTo(valor) == 0) return;
        
        if(valor.compareTo(pai.getValor()) > 0){
            if(dirNull(pai)){
                NoRB<T> filho = new NoRB<>(valor);
                pai.setDir(filho);
                filho.setPai(pai);
                if(filho.getPai().getPai() == null) return;
                this.balancearInsercao(filho);
            }
            insert(pai.getDir(), valor);
        }
        else if(valor.compareTo(pai.getValor()) < 0){
            if(esqNull(pai)){
                NoRB<T> filho = new NoRB<>(valor);
                pai.setEsq(filho);
                filho.setPai(pai);
                if(filho.getPai().getPai() == null) return;
                this.balancearInsercao(filho);
            }
            insert(pai.getEsq(), valor);
        }

    }

    private void balancearInsercao(NoRB<T> novo){

        NoRB<T> v = novo;

        NoRB<T> tio = null;

        while(v.getPai().getCor() == true){

            // PAI A DIREITA DO AVÔ
            if(v.getPai() == v.getPai().getPai().getDir()){

                tio = v.getPai().getPai().getEsq();

                // TIO É PRETO
                if(tio == null || tio.getCor() == false){

                    // VALOR A ESQUERDA DO PAI
                    if(v == v.getPai().getEsq()){
                        v = v.getPai();
                        rotacaoDireitaSimples(v);
                    }

                    // VALOR A DIREITA DO PAI
                    v.getPai().setCor(!v.getPai().getCor());
                    v.getPai().getPai().setCor(!v.getPai().getPai().getCor());
                    rotacaoEsquerdaSimples(v.getPai().getPai());

                }
                // TIO É VERMELHO
                else {

                    v.getPai().setCor(!v.getPai().getCor());
                    tio.setCor(!tio.getCor());
                    v.getPai().getPai().setCor(!v.getPai().getPai().getCor());
                    v = v.getPai().getPai();

                }
            } 
            // PAI A ESQUERDA DO AVÔ
            else {
                tio = v.getPai().getPai().getDir();

                // TIO É PRETO
                if(tio == null || tio.getCor() == false){

                    // VALOR A ESQUERDA DO PAI
                    if(v == v.getPai().getDir()){
                        v = v.getPai();
                        rotacaoEsquerdaSimples(v);
                    }

                    // VALOR A DIREITA DO PAI
                    v.getPai().setCor(!v.getPai().getCor());
                    v.getPai().getPai().setCor(!v.getPai().getPai().getCor());
                    rotacaoDireitaSimples(v.getPai().getPai());

                } 

                // TIO É VERMELHO
                else {

                    v.getPai().setCor(!v.getPai().getCor());
                    tio.setCor(!tio.getCor());
                    v.getPai().getPai().setCor(!v.getPai().getPai().getCor());
                    v = v.getPai().getPai();

                }
            }

            if(v == this.raiz) break;

        }
        this.raiz.setCor(false);
    }

    public void remover(T valor){
        if(isEmpty()) return;
        else remover(raiz, valor);
    }

    private void remover(NoRB<T> folha, T valor){
        NoRB<T> remover = null, x = null;
        while(folha != null){
            if(folha.getValor().compareTo(valor) == 0){
                remover = folha;
            }
            if(valor.compareTo(folha.getValor()) > 0) folha = folha.getDir();
            else folha = folha.getEsq();
        }

        if(remover == null) return;

        boolean cor = remover.getCor();
        if(dirNull(remover) && esqNull(remover)){
            if(raiz == remover) raiz = null;
            x = remover.getPai();
            remover = null;
        }
        else if(soFolhaEsq(remover)){
            x = remover.getEsq();
            if(remover.getPai() == null){
                raiz = remover.getEsq();
            }

            x.setPai(remover.getPai().getPai());
            if(remover == remover.getPai().getEsq()){
                remover.getPai().setEsq(x);
            } else {
                remover.getPai().setDir(x);
            }

            remover = null;

            if(x.getCor()){
                cor = x.getCor();
            }
            
        } else if(soFolhaDir(remover)){

            x = remover.getDir();
            if(remover.getPai() == null){
                raiz = remover.getDir();
            }

            x.setPai(remover.getPai().getPai());
            if(remover == remover.getPai().getDir()){
                remover.getPai().setDir(x);
            } else {
                remover.getPai().setEsq(x);
            }

            remover = null;

            if(x.getCor()){
                cor = x.getCor();
            }

        } else {
            NoRB<T> noMinimo = minimo(remover);

            cor = noMinimo.getCor();

            if(raiz == remover){
                raiz = noMinimo;
            }

            

        }

        if(cor == false){
            balancearDelete(x);
        }

    }

    private NoRB<T> minimo(NoRB<T> remover){
        NoRB<T> index = remover.getEsq();
        while(index != null){
            if(index.getDir() != null) index = index.getDir();
            else break;
        }
        return index;
    }

    private void balancearDelete(NoRB<T> x){}

    private void rotacaoEsquerdaSimples(NoRB<T> folha){
        
        NoRB<T> filho = folha.getDir();
        folha.setDir(filho.getEsq());

        if(filho.getEsq() != null){
            filho.getEsq().setPai(folha);
        }

        filho.setPai(folha.getPai());

        if(filho.getPai() == null) raiz = filho;

        else if(folha == folha.getPai().getDir()){
            folha.getPai().setDir(filho);
        } else {
            folha.getPai().setEsq(filho);
        }

        filho.setEsq(folha);
        folha.setPai(filho);

    }

    private void rotacaoDireitaSimples(NoRB<T> folha){

        NoRB<T> filho = folha.getEsq();
        folha.setEsq(filho.getDir());

        if(filho.getDir() != null){
            filho.getDir().setPai(folha);
        }

        filho.setPai(folha.getPai());

        if(filho.getPai() == null) raiz = filho;

        else if(folha == folha.getPai().getDir()){
            folha.getPai().setDir(filho);
        } else {
            folha.getPai().setEsq(filho);
        }

        filho.setDir(folha);
        folha.setPai(filho);

    }

    private Boolean esqNull(NoRB<T> folha){
        if(folha.getEsq() == null) return true;
        else return false;
    }

    private Boolean dirNull(NoRB<T> folha){
        if(folha.getDir() == null) return true;
        else return false;
    }

    private Boolean soFolhaEsq(NoRB<T> folha){
        if(folha.getEsq() != null && folha.getDir() == null) return true;
        else return false;
    }

    private Boolean soFolhaDir(NoRB<T> folha){
        if(folha.getEsq() == null && folha.getDir() != null) return true;
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

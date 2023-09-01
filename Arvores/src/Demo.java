import RBTree.ArvoreRB;

public class Demo {

    public static void main(String[] args) {

        ArvoreRB<Integer> arvoreRB = new ArvoreRB<>();

        arvoreRB.insert(10000);
        arvoreRB.insert(1);
        arvoreRB.insert(1000);
        arvoreRB.insert(100000);
        arvoreRB.insert(100);
        arvoreRB.insert(10);

        arvoreRB.emOrdem();
        
    }
    
}
import RBTree.ArvoreRB;

public class Demo {

    public static void main(String[] args) {

        ArvoreRB<Integer> arvoreRB = new ArvoreRB<>();

        arvoreRB.insert(20);
        arvoreRB.insert(6);
        arvoreRB.insert(2);
        arvoreRB.insert(15);
        arvoreRB.insert(31);
        arvoreRB.insert(8);
        arvoreRB.insert(17);
        arvoreRB.insert(42);
        arvoreRB.insert(1);
        arvoreRB.insert(5);
        arvoreRB.insert(19);

        arvoreRB.preOrdem();
        
    }
    
}
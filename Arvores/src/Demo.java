import AVL.AVLTree;

public class Demo {

    public static void main(String[] args) {

        AVLTree<Integer> avlTree = new AVLTree<>();

        avlTree.insert(14);
        avlTree.insert(10);
        avlTree.insert(15);
        avlTree.insert(35);
        avlTree.insert(-20);
        avlTree.insert(12);
        
        System.out.println("EM ORDEM");
        avlTree.preOrdem();
        
        avlTree.insert(50);

        System.out.println("EM ORDEM ( Rotação )");
        avlTree.preOrdem();

        avlTree.remove(14);

        System.out.println();
        avlTree.preOrdem();


    }
    
}
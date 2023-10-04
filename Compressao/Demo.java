package Compressao;

import Compressao.Huffman.HuffTree;

public class Demo {
    public static void main(String[] args) {

        String texto = "BBBEAAAAFFHHHHCBMMALLLCDDBBBBBBBCC";

        HuffTree huffTree = new HuffTree();

        huffTree.Freq(texto);

        huffTree.PrintVector();

    }

}

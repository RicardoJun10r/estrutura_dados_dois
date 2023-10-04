package Compressao;

import Compressao.Huffman.HuffTree;

public class Demo {
    public static void main(String[] args) {

        String texto = "ABACCDA";

        HuffTree huffTree = new HuffTree(texto);

        String compressed = huffTree.Compress();

        System.out.println(compressed);

        String decompress = huffTree.Decompress(compressed);

        System.out.println(decompress);

    }

}

package Compressao;

import Compressao.Huffman.HuffTree;

public class Demo {
    public static void main(String[] args) {

        String texto = "ABACCDA";

        HuffTree huffTree = new HuffTree();

        huffTree.Freq(texto);

        huffTree.PrintVector();

        String compressed = huffTree.Compress(texto);

        System.out.println(compressed);

        String decompress = huffTree.Decompress(compressed);

        System.out.println(decompress);

    }

}

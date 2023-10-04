package Compressao;

import Compressao.Huffman.HuffTree;

public class Demo {
    public static void main(String[] args) {

        String texto = "ABACCDA";

        HuffTree huffTree = new HuffTree();

        huffTree.Freq(texto);

        System.out.println(huffTree.Compress(texto));

    }

}

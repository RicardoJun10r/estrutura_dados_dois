package Huffman;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Demo {
    public static void main(String[] args) {
        
        // String carro = "";

        
        // for(int i = 0; i < 1; i++){
        //     HuffTree huffTree = new HuffTree();

        //     carro += "0015468" + ";";
        //     carro += "Kwid" + ";";
        //     carro += "Renault" + ";";
        //     carro += "QRT12" + ";";
        //     carro += LocalDate.now().toString() + ";";
        //     carro += "Roberto" + ";";
        //     carro += "041646";

        //     Character[] compressed = huffTree.Compress(carro);

        //     for (int j = 0; j < compressed.length; j++) {
        //         System.out.print(compressed[i]);
        //     }

        //     System.out.println();

        //     carro = "";

        //     String decompressed = huffTree.Decompress(compressed);

        //     System.out.println(decompressed);

        //     String[] splited = decompressed.split(";");

        //     LocalDate localDate = LocalDate.parse(splited[4]);

        //     System.out.println(localDate);

        // }

        String text = "ABRACADABRA ";

        text += "0015468" + ";";
        text += "Kwid" + ";";
        text += "Renault" + ";";
        text += "QRT12" + ";";
        text += LocalDate.now().toString() + ";";
        text += "Roberto" + ";";
        text += "041646";

        HuffTree huffTree = new HuffTree();

        Character[] compressed = huffTree.Compress(text);

        for (int i = 0; i < compressed.length; i++) {
            System.out.print(compressed[i]);
        }

        System.out.println();

        System.out.println("TAMANHO = " + text.length());

        System.out.println("TAMANHO = " + compressed.length);

        String decompress = huffTree.Decompress(compressed);

        System.out.println(decompress);

        huffTree.PrintTree();

    }
}

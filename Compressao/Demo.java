package Compressao;

import Compressao.FrequenciaCaracteres.FreqCarac;

public class Demo {
    public static void main(String[] args) {
        String texto = "BBBACC";
        FreqCarac freqCarac = new FreqCarac();

        // String compressed = freqCarac.Compress(texto);

        // System.out.println( compressed );

        String compressedV_2 = freqCarac.CompressV_2(texto);

        System.out.println( compressedV_2 );

        String decompressedV_2 = freqCarac.DecompressV_2(compressedV_2);

        System.out.println( decompressedV_2 );

        if(decompressedV_2.equals(texto)) System.out.println("TRUE");
        else {
            System.out.println("FALSE");
            System.out.println(texto);
            System.out.println(decompressedV_2);
        }

    }
}

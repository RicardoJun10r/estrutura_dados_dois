package Compressao;

import Compressao.FrequenciaCaracteres.FreqCarac;

public class Demo {
    public static void main(String[] args) {
        String texto = "BBBEAAAAFFHHHHCBMMALLLCDDBBBBBBBCC";
        FreqCarac freqCarac = new FreqCarac();

        String compressed = freqCarac.Compress(texto);

        System.out.println( compressed );

        if(compressed.equals("3B1E4A2F4H1C1B2M1A3L1C2D7B2C")){
            System.out.println("TRUE");
        } else System.out.println("FALSE");



    }
}

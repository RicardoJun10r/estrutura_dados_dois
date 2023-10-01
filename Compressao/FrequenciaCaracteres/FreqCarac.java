package Compressao.FrequenciaCaracteres;

public class FreqCarac {
    
    public FreqCarac(){}

    public String Compress(String texto){
        texto += "*";
        StringBuffer stringBuffer = new StringBuffer();
        Character anterior, atual;
        int freq = 1;
        for(int i = 1; i < texto.length(); i++){
            anterior = texto.charAt(i-1);
            atual = texto.charAt(i);
            if(atual.equals("*")){
                stringBuffer.append(freq);
                stringBuffer.append(anterior);
                break;
            }
            if(anterior == atual){
                freq++;
            } else {
                stringBuffer.append(freq);
                stringBuffer.append(anterior);
                freq = 1;
            }
        }
        return stringBuffer.toString();
    }

    public String Decompress(String texto){
        StringBuffer stringBuffer = new StringBuffer();
        int cont = 0;
        while(cont < texto.length()){
            int quantidade = Integer.parseInt(String.valueOf(texto.charAt(cont)));
            String letra = String.valueOf(texto.charAt(cont+1));
            for(int i = 0; i < quantidade; i++){
                stringBuffer.append(letra);
            }
            cont+=2;
        }
        return stringBuffer.toString();
    }

    public String CompressV_2(String texto){
        texto += "*";
        StringBuffer stringBuffer = new StringBuffer();
        Character anterior, atual;
        int freq = 1;
        for(int i = 1; i < texto.length(); i++){
            anterior = texto.charAt(i-1);
            atual = texto.charAt(i);
            if(atual.equals("*")){
                stringBuffer.append(freq);
                stringBuffer.append(anterior);
                break;
            }
            if(anterior == atual){
                freq++;
            } else {
                if(freq != 1) stringBuffer.append(freq);
                stringBuffer.append(anterior);
                freq = 1;
            }
        }
        return stringBuffer.toString();
    }

    public String DecompressV_2(String texto){
        StringBuffer stringBuffer = new StringBuffer();
        int cont = 0;
        while(cont < (texto.length()-1)){
            int quantidade = 1;
            Character letra = texto.charAt(cont);
            if(Character.isDigit(texto.charAt(cont))){
                quantidade = Integer.parseInt(String.valueOf(texto.charAt(cont)));
                letra = texto.charAt(cont+1);
            }
            for(int i = 0; i < quantidade; i++){
                stringBuffer.append(letra);
            }
            cont++;
        }
        return stringBuffer.toString();
    }

}

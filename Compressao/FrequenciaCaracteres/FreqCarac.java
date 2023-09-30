package Compressao.FrequenciaCaracteres;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class FreqCarac {
    
    private Map<Character, Integer> map;
    
    public FreqCarac(){
        this.map = new HashMap<>();
    }

    public String Compress(String texto){
        StringBuffer stringBuffer = new StringBuffer();
        Character anterior, atual;
        int freq = 1;
        for(int i = 1; i < texto.length(); i++){
            anterior = texto.charAt(i-1);
            atual = texto.charAt(i);
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

    // public String Decompress(String texto){

    // }

    private void Freq(String texto){
        for(int i = 0; i < texto.length(); i++){
            if(this.map.containsKey(texto.charAt(i))){
                Integer freq = this.map.get(texto.charAt(i));
                this.map.replace(texto.charAt(i), freq, (freq+1));
            } else {
                this.map.put(texto.charAt(i), 1);
            }
        }
    }

    public void Print(){
        System.out.println(this.map.toString());
    }

}

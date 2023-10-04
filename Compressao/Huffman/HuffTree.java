package Compressao.Huffman;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class HuffTree {
    
    private Map<Character, Integer> map;

    private HuffNode[] vetor;

    public HuffTree(){
        this.map = new HashMap<>();
    }

    public void Freq(String texto){

        int freq = 1;
        for(int i = 0; i < texto.length(); i++){
            if(this.map.containsKey(texto.charAt(i))){
                this.map.replace(texto.charAt(i), this.map.get(texto.charAt(i)), (this.map.get(texto.charAt(i)) + 1));
            } else {
                this.map.put(texto.charAt(i), freq);
            }
        }

        this.vetor = new HuffNode[this.map.size()];
        BuildVector();
    }

    private void BuildVector(){

        Set<Entry<Character, Integer>> set = this.map.entrySet();

        int cont = 0;
        for (Entry<Character,Integer> entry : set) {
            this.vetor[cont] = new HuffNode(String.valueOf(entry.getKey()), entry.getValue());
            cont++;
        }

        PrintVector();

        shellSort();

    }

    private void shellSort(){

        int H = 1;

        while(H < this.vetor.length){ H = 3*H+1; }

        while(H > 0){

            for(int i = H; i < this.vetor.length; i++){
                HuffNode aux = this.vetor[i];
                int j = i;
                System.out.println("J = " + j + " I = " + i);
                while(j > H - 1 && this.vetor[j - H].getFrequencia() > aux.getFrequencia()){
                    this.vetor[j] = this.vetor[j - H];
                    j = j - H;
                }
                this.vetor[j] = aux;
            }

            H = (int) Math.floor(H / 3);
        }

    }

    public void PrintVector(){
        System.out.println("=================");
        for (int i = 0; i < this.vetor.length; i++) {
            System.out.println(this.vetor[i].getCaractere() + " = " + this.vetor[i].getFrequencia());
        }
        System.out.println("=================");
    }

    public void Print(){
        System.out.println(this.map.toString());
    }

}

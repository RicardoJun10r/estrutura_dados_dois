import Encadeamento.HashExterior_V2;

public class Demo {
    public static void main(String[] args) {
        
        HashExterior_V2<String, Integer> hashExterior_V2 = new HashExterior_V2<>();

        hashExterior_V2.put("UM", 1);
        hashExterior_V2.put("DOIS", 2);
        hashExterior_V2.put("TRES", 3);
        hashExterior_V2.put("QUATRO", 4);
        hashExterior_V2.put("CINCO", 5);
        hashExterior_V2.put("SEIS", 6);
        hashExterior_V2.put("SETE", 7);
        hashExterior_V2.put("OITO", 8);
        hashExterior_V2.put("NOVE", 9);
        hashExterior_V2.put("DEZ", 10);
        hashExterior_V2.put("ONZE", 11);
        hashExterior_V2.put("DOZE", 12);
        hashExterior_V2.put("TREZE", 13);
        hashExterior_V2.put("CATORZE", 14);
        hashExterior_V2.put("QUINZE", 15);
        hashExterior_V2.put("DEZESSEIS", 16);
        hashExterior_V2.put("DEZESSETE", 10);
        hashExterior_V2.put("DEZOITO", 18);
        hashExterior_V2.put("DEZENOVE", 19);
        hashExterior_V2.put("VINTE", 10);

        System.out.println(hashExterior_V2.print());

    }
}

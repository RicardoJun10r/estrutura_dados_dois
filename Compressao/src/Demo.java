package Compressao.src;

import java.time.LocalDate;

import Compressao.src.Huffman.HuffTree;
import ListaAutoAjustavel.ListaAjustavel;

public class Demo {
    public static void main(String[] args) {

        ListaAjustavel<Integer> listaAjustavel = new ListaAjustavel<>();

        listaAjustavel.Add(10);
        listaAjustavel.Add(20);
        listaAjustavel.Add(30);
        listaAjustavel.Add(40);
        listaAjustavel.Add(50);
        listaAjustavel.Add(60);
        listaAjustavel.Add(70);

        listaAjustavel.Print();

        listaAjustavel.SearchCF(60);

        listaAjustavel.Print();

        listaAjustavel.SearchCF(60);

        listaAjustavel.SearchCF(70);

        listaAjustavel.Print();

    }

}

import heaps.Heap;
import util.Lista;

public class Demo {
    public static void main(String[] args) {
        
        Heap<String> heap = new Heap<>();

        Lista<String> lista = new Lista<>();
        
        lista.Add("O");
        lista.Add("R");
        lista.Add("D");
        lista.Add("E");
        lista.Add("N");
        lista.Add("A");
        
        heap.HeapSort(lista);

        heap.Print();


    }
}

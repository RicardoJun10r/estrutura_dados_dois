import ListaAutoAjustavel.ListaAjustavel;

public class Demo {
    public static void main(String[] args) {
        
        ListaAjustavel<Integer> listaAjustavel = new ListaAjustavel<>();

        listaAjustavel.Add(0);
        listaAjustavel.Add(1);
        listaAjustavel.Add(2);
        listaAjustavel.Add(3);
        listaAjustavel.Add(4);
        listaAjustavel.Add(5);
        listaAjustavel.Add(6);
        listaAjustavel.Add(7);
        listaAjustavel.Add(8);
        listaAjustavel.Add(9);
        listaAjustavel.Add(10);
        
        listaAjustavel.Print();

        listaAjustavel.Delete(5);

        listaAjustavel.Print();

    }
}

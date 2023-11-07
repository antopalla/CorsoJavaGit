import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Inventario inventario = new Inventario("TOYS");

        Giocattolo g1 = new Giocattolo("Monopoli", 13.99f, 12);
        inventario.aggiungiGiocattolo(g1);

        System.out.println(inventario);
        
        List<Vendita> registro = new ArrayList<>();

    }
}

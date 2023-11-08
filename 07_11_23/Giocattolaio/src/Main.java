import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Admin admin = new Admin("Antonio", "antonio.palladino@mail.it", "12345");
        Cliente c1 = new Cliente("Giovanni", "giovanni.giorgio@mail.it");
        Cliente c2 = new Cliente("Gastone", "gastonedeigastoni@mail.it");


        Inventario inventario = new Inventario("TOYS");

        Giocattolo g1 = new Giocattolo("Monopoli", 13.99f, 12);
        Giocattolo g2 = new Giocattolo("Nintendo Switch", 289.99f, 14);
        Giocattolo g3 = new Giocattolo("Playstation 4", 379.99f, 16);

        inventario.aggiungiGiocattolo(g1, admin);
        inventario.aggiungiGiocattolo(g2, admin);
        inventario.aggiungiGiocattolo(g3, admin);

        System.out.println(inventario);
        
        
        List<Vendita> registro = new ArrayList<>();

        Vendita v1 = new Vendita(g1, c1);
        RegistroVendite.aggiungiVendita(registro, inventario, v1, admin);

        Vendita v2 = new Vendita(g2, c2);
        RegistroVendite.aggiungiVendita(registro, inventario, v2, admin);

        RegistroVendite.stampaRegistro(registro, admin);
        RegistroVendite.stampaRegistro(registro, c1);
        RegistroVendite.stampaRegistro(registro, c2);

        System.out.println(inventario);

        RegistroVendite.rimuoviVendita(registro, inventario, g1, admin);

        System.out.println(inventario);

    }
}

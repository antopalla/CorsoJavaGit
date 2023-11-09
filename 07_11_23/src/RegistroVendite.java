import java.util.List;

public abstract class RegistroVendite {

    public static void stampaRegistro (List<Vendita> registro, Utente x) {
        for (Vendita v : registro) {
            if (x instanceof Admin) {
                System.out.println(v.toString());
            }
            else {
                if (v.getUtenteVendita() == x) {
                    System.out.println(v.toString());
                }
            }
        }
    }

    public static void aggiungiVendita (List<Vendita> registro, Inventario inventario, Vendita v, Utente utente) {
        registro.add(v);
        inventario.rimuoviGiocattolo(v.getGiocattoloVenduto(), utente);
        System.out.println("Vendita aggiunta con successo al registro!\n");
    }

    public static void rimuoviVendita (List<Vendita> registro, Inventario inventario, Giocattolo g, Utente utente) {
        for (int i=0;i<registro.size();i++) {
            if (registro.get(i).getGiocattoloVenduto().equals(g)) {
                registro.remove(i);
                inventario.aggiungiGiocattolo(g, utente);
                System.out.println("Vendita rimossa con successo dal registro!\n");
                break;
            }
        }
    }


}

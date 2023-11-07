import java.util.List;

public abstract class RegistroVendite {
    public RegistroVendite () {

    }

    public void stampaRegistro (List<Vendita> registro, Utente x) {
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


}

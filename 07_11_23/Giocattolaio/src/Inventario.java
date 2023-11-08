import java.util.List;
import java.util.ArrayList;

public class Inventario {
    private String nome;
    private List<Giocattolo> listaGiocattoli = new ArrayList<>();

    public Inventario (String nome) {
        this.nome = nome;
    }

    public void aggiungiGiocattolo (Giocattolo g, Utente c) {
        if (c instanceof Admin) {
            if (!listaGiocattoli.contains(g)) {
            listaGiocattoli.add(g);
            System.out.println("Giocattolo aggiunto con successo all'inventario!\n");
            }
            else {
                System.out.println("L'inventario già contiene il giocattolo!\n");
            }
        }
        else {
            System.out.println("Non hai i permessi per farlo!");
        }
    }

    public void rimuoviGiocattolo (Giocattolo g, Utente c) {
        if (c instanceof Admin) {
            if (listaGiocattoli.contains(g)) {
            listaGiocattoli.remove(g);
            System.out.println("Giocattolo rimosso con successo dall'inventario!\n");
            }
            else {
                System.out.println("Giocatto non presente nell'inventario!");
            }
        }
        else {
            System.out.println("Non hai i permessi per farlo!");
        } 
    }

    public void rimuoviGiocattolo (int ID, Utente c) {
        if (c instanceof Admin) {
            for (int i=0;i<listaGiocattoli.size();i++) {
                if (listaGiocattoli.get(i).getID() == ID) {
                    listaGiocattoli.remove(i);
                    System.out.println("Giocattolo rimosso con successo dall'inventario!\n");
                }
            }
            System.out.println("Giocattolo non rimosso in quanto non presente!\n");
        }
        else {
            System.out.println("Non hai i permessi per farlo!");
        }
    }

    @Override
    public String toString() {
        String s = "Ecco l'inventario " + nome + ":\n";
        for (Giocattolo g : listaGiocattoli) {
            s += g.toString() + "\n";
        }
        return s;
    }
}


import java.util.List;
import java.util.ArrayList;

public class Inventario {
    private String nome;
    private List<Giocattolo> listaGiocattoli = new ArrayList<>();

    public Inventario (String nome) {
        this.nome = nome;
    }

    public void aggiungiGiocattolo (Giocattolo g) {
        if (!listaGiocattoli.contains(g)) {
            listaGiocattoli.add(g);
            System.out.println("Giocattolo aggiunto con successo!\n");
        }
        else {
            System.out.println("L'inventario già contiene il giocattolo!\n");
        }
    }

    public void rimuoviGiocattolo (int ID) {
        for (int i=0;i<listaGiocattoli.size();i++) {
            if (listaGiocattoli.get(i).getID() == ID) {
                listaGiocattoli.remove(i);
                System.out.println("Giocattolo rimosso con successo!\n");
            }
        }
        System.out.println("Giocattolo non rimosso in quanto non presente!\n");
    }

    @Override
    public String toString() {
        String s = "Ecco l'inventario " + nome + ":\n";
        for (Giocattolo g : listaGiocattoli) {
            s += g.toString();
        }
        return s;
    }
}


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Vendita {
    private static int ID_Progressivo = 0;
    private int id;
    private Giocattolo giocattoloVenduto;
    private LocalDateTime dataVendita;
    private Utente utenteVendita;

    public Vendita (Giocattolo giocattoloVenduto, Utente utenteVendita) {
        this.id = ++ID_Progressivo;
        this.giocattoloVenduto = giocattoloVenduto;
        this.dataVendita = LocalDateTime.now();
        this.utenteVendita = utenteVendita;
    }

    public int getID () {
        return id;
    }

    public Giocattolo getGiocattoloVenduto () {
        return giocattoloVenduto;
    }

    public LocalDateTime getDataVendita () {
        return dataVendita;
    }

    public Utente getUtenteVendita () {
        return utenteVendita;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return "ID Vendita: " + id + "\nData vendita: " + dataVendita.format(formatter) + "\n\nUtente acquirente:\n" + utenteVendita.toString() + "\nGiocattolo venduto:\n" + giocattoloVenduto.toString() + "\n";
    }
}

import java.time.LocalDateTime;

public class Vendita {
    private static int ID_Progressivo = 0;
    private int id;
    private float valoreVendita;
    private String descVendita;
    private LocalDateTime dataVendita;
    private Utente utenteVendita;

    public Vendita (float valoreVendita, String descVendita, Utente utenteVendita) {
        this.id = ++ID_Progressivo;
        this.valoreVendita = valoreVendita;
        this.descVendita = descVendita;
        this.dataVendita = LocalDateTime.now();
        this.utenteVendita = utenteVendita;
    }

    public int getID () {
        return id;
    }

    public float getValoreVendita () {
        return valoreVendita;
    }

    public String getDescVendita () {
        return descVendita;
    }

    public LocalDateTime getDataVendita () {
        return dataVendita;
    }

    public Utente getUtenteVendita () {
        return utenteVendita;
    }

    public void setValoreVendita (float valoreVendita) {
        this.valoreVendita = valoreVendita;
    }

    public void setDescVendita (String descVendita) {
        this.descVendita = descVendita;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\nValore vendita: " + valoreVendita + "\nDescrizione vendita: " + descVendita + "\nData vendita: " + dataVendita.toString() + "\nUtente vendita: " + utenteVendita.toString() + "\n";
    }
}

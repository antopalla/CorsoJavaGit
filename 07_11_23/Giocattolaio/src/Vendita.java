import java.time.LocalDateTime;

public class Vendita {
    private static int ID_Progressivo = 0;
    private int id;
    private float valoreVendita;
    private String descVendita;
    private LocalDateTime dataVendita;

    public Vendita (float valoreVendita, String descVendita) {
        this.id = ++ID_Progressivo;
        this.valoreVendita = valoreVendita;
        this.descVendita = descVendita;
        this.dataVendita = LocalDateTime.now();
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

    public void setValoreVendita (float valoreVendita) {
        this.valoreVendita = valoreVendita;
    }

    public void setDescVendita (String descVendita) {
        this.descVendita = descVendita;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\nValore vendita: " + valoreVendita + "\nDescrizione vendita: " + descVendita + "\nData vendita: " + dataVendita.toString() + "\n";
    }
}

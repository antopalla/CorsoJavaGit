public class Giocattolo {
    private static int ID_Progressivo = 0;
    private int id;
    private String nome;
    private float prezzo;
    private int etaConsigliata;

    public Giocattolo (String nome, float prezzo, int etaConsigliata) {
        this.id = ++ID_Progressivo;
        this.nome = nome;
        this.prezzo = prezzo;
        this.etaConsigliata = etaConsigliata;
    }

    public int getID () {
        return id;
    }
    
    public String getNome () {
        return nome;
    }

    public float getPrezzo () {
        return prezzo;
    }

    public int getEtaConsigliata () {
        return etaConsigliata;
    }

    public void setNome (String nome) {
        this.nome = nome;
    }

    public void setPrezzo (float prezzo) {
        this.prezzo = prezzo;
    }

    public void setEtaConsigliata (int etaConsigliata) {
        this.etaConsigliata = etaConsigliata;
    }

    @Override 
    public String toString () {
        return "ID: " + id + "\nNome: " + nome + "\nPrezzo: " + prezzo + "\nEtà consigliata: " + etaConsigliata + "\n";
    }

    @Override
    public boolean equals (Object o) {
        if (o instanceof Giocattolo) {
            if (id == ((Giocattolo)o).getID() && nome.equals(((Giocattolo)o).getNome())) {
                return true;
            }
        }
        return false;
    }
}

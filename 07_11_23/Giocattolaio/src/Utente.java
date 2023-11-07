public abstract class Utente {
    private static int ID_Progressivo = 0;
    private int id;
    private String nome;
    private String indirizzoMail;

    public Utente (String nome, String indirizzoMail) {
        this.id = ++ID_Progressivo;
        this.nome = nome;
        this.indirizzoMail = indirizzoMail;
    }

    public int getID () {
        return id;
    }

    public String getNome () {
        return nome;
    }

    public String getIndirizzoMail () {
        return indirizzoMail;
    }

    public void setNome (String nome) {
        this.nome = nome;
    }

    public void setIndirizzoMail (String indirizzoMail) {
        this.indirizzoMail = indirizzoMail;
    }

    @Override 
    public String toString () {
        return "ID: " + id + "\nNome: " + nome + "\nIndirizzo mail: " + indirizzoMail + "\n";
    }

    @Override
    public boolean equals (Object o) {
        if (o instanceof Cliente) {
            if (id == ((Cliente)o).getID() && nome.equals(((Cliente)o).getNome()) && indirizzoMail.equals(((Cliente)o).getIndirizzoMail())) {
                return true;
            }
        }
        return false;
    }
}

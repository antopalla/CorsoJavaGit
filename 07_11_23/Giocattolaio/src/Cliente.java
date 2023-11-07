public class Cliente {
    private static int ID_Progressivo = 0;
    private int id;
    private String nome;
    private String indirizzoMail;

    public Cliente (String nome, String indirizzoMail) {
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
}


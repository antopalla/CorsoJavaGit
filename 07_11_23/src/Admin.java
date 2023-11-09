public class Admin extends Utente {
    private String password;

    public Admin (String nome, String indirizzoMail, String password) {
        super(nome, indirizzoMail);
        this.password = password;
    }

    public void setPassword (String password) {
        this.password = password;
    }

    public String getPassword () {
        return password;
    }
}

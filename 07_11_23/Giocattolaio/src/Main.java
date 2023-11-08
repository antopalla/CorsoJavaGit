import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    private static List<Utente> listaUtenti = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        Admin admin = new Admin("Antonio", "antonio.palladino@mail.it", "12345");
        Cliente c1 = new Cliente("Giovanni", "giovanni.giorgio@mail.it");
        Cliente c2 = new Cliente("Gastone", "gastonedeigastoni@mail.it");

        listaUtenti.add(admin);
        listaUtenti.add(c1);
        listaUtenti.add(c2);


        Inventario inventario = new Inventario("TOYS");

        Giocattolo g1 = new Giocattolo("Monopoli", 13.99f, 12);
        Giocattolo g2 = new Giocattolo("Nintendo Switch", 289.99f, 14);
        Giocattolo g3 = new Giocattolo("Playstation 4", 379.99f, 16);

        inventario.aggiungiGiocattolo(g1, admin);
        inventario.aggiungiGiocattolo(g2, admin);
        inventario.aggiungiGiocattolo(g3, admin);

        System.out.println(inventario);


        List<Vendita> registro = new ArrayList<>();
        

        int menuAccesso = -1;
        do {
            System.out.println("Inserisci\n1 per accedere;\n2 per registrarsi;\n3 per uscire:" );
            menuAccesso = scan.nextInt();
            System.out.println();

            String email;
            String password;
            int c = 0;

            switch (menuAccesso) {
                case 1 -> {
                    System.out.println("Inserisci email: ");
                    email = scan.next();
                    if (recuperaUtente(email) != null) {
                        if (recuperaUtente(email) instanceof Admin) {
                            do {
                            System.out.println("Inserisci la tua password: ");
                            password = scan.next();
                            System.out.println();
                            c++;
                        } while (!autenticaUtente(email, password) && c<3);
                        }
                        if (c==3) {
                            System.out.println("Password errata per tre volte! Profilo bloccato...");
                            return;
                        }
                        else {
                            if (recuperaUtente(email) instanceof Admin) {
                                System.out.println("Autenticato come amministratore! Benvenuto...");
                                System.out.println();

                                int menuAmministratore = -1;
                                do {
                                    System.out.println("Inserisci\n1 per visualizzare i giocattoli;\n2 per aggiungere un giocattolo;\n3 per rimuovere un giocattolo;\n4 per vedere lo storico degli acquisti;\n5 per tornare al menu principale:" );
                                    menuAmministratore = scan.nextInt();
                                    System.out.println();

                                    switch (menuAmministratore) {
                                        case 1 -> {
                                            System.out.println(inventario.toString());
                                            System.out.println();
                                        }
                                        case 2 -> {
                                            float prezzo = 0;
                                            int etaConsigliata = 0;
                                            System.out.println("Inserisci il nome del giocattolo: ");
                                            String nome = scan.nextLine();
                                            scan.nextLine();
                                            do { 
                                                System.out.println("Inserisci il prezzo (maggiore di 0): ");
                                                prezzo = scan.nextFloat();
                                            } while (prezzo<1);
                                            do {
                                                System.out.println("Inserisci l'età consigliata (maggiore di 0): ");
                                                etaConsigliata = scan.nextInt();
                                            } while (etaConsigliata < 1);

                                            System.out.println();

                                            inventario.aggiungiGiocattolo((new Giocattolo(nome, prezzo, etaConsigliata)), recuperaUtente(email));
                                        }
                                        case 3 -> {
                                            System.out.println("Inserisci l'ID del giocattolo da rimuovere: ");
                                            int ID = scan.nextInt();

                                            inventario.rimuoviGiocattolo(ID, recuperaUtente(email));
                                        }
                                        case 4 -> {
                                            RegistroVendite.stampaRegistro(registro, recuperaUtente(email));
                                            System.out.println();
                                        }
                                        case 5 -> {
                                            menuAmministratore = 0;
                                        }
                                    }
                                } while (menuAmministratore != 0);
                            }
                            else {
                                System.out.println("Autenticato come utente! Benvenuto...");
                                System.out.println();

                                int menuUtente = -1;
                                do {
                                    System.out.println("Inserisci\n1 per visualizzare i giocattoli;\n2 per acquistare un giocattolo;\n3 per vedere i tuoi acquisti;\n4 per tornare al menu principale:" );
                                    menuUtente = scan.nextInt();
                                    System.out.println();

                                    switch (menuUtente) {
                                        case 1 -> {
                                            System.out.println(inventario.toString());
                                            System.out.println();
                                        }
                                        case 2 -> {
                                            System.out.println("Inserisci l'ID del giocattolo che vuoi acquistare: ");
                                            int ID = scan.nextInt();
                                            System.out.println();

                                            if (inventario.getGiocattolo(ID) != null) {
                                                System.out.println("Ecco le informazioni del giocattolo da te acquistato: ");
                                                System.out.println(inventario.getGiocattolo(ID).toString());
                                                System.out.println();

                                                RegistroVendite.aggiungiVendita(registro, inventario, new Vendita(inventario.getGiocattolo(ID), recuperaUtente(email)), admin);
                                            }
                                            else {
                                                System.out.println("Giocattolo non presente nel catalogo!");
                                                System.out.println();
                                            }
                                        }
                                        case 3 -> {
                                            RegistroVendite.stampaRegistro(registro, recuperaUtente(email));
                                            System.out.println();
                                        }
                                        case 4 -> {
                                            menuUtente = 0;
                                        }
                                    }
                                } while (menuUtente != 0);
                            }
                        }
                    }
                    else {
                        System.out.println("Email non presente nel sistema!");
                        System.out.println();
                    }
                }
                case 2 -> {
                    System.out.println("Inserisci il tuo nome: ");
                    String nomeUtente = scan.next();
                    System.out.println("Inserisci la tua email: ");
                    String emailUtente = scan.next();
                    System.out.println();

                    listaUtenti.add(new Cliente(nomeUtente, emailUtente));
                    System.out.println();
                }
                case 3 -> {
                    menuAccesso = 0;
                }
            }
        } while (menuAccesso !=0);

    }

    private static boolean autenticaUtente (String email, String password) {
        for (int i=0;i<listaUtenti.size();i++) {
            if (listaUtenti.get(i).getIndirizzoMail().equals(email)) {
                if (listaUtenti.get(i) instanceof Admin) {
                    if (((Admin)listaUtenti.get(i)).getPassword().equals(password)) {
                        return true;
                    }
                    else {
                        return false;
                    }
                }
                else {
                    return true;
                }
            }
        }
        return false;
    }

    private static Utente recuperaUtente (String email) {
        for (int i=0;i<listaUtenti.size();i++) {
            if (listaUtenti.get(i).getIndirizzoMail().equals(email)) {
                return listaUtenti.get(i);
            }
        }
        return null;
    }
}

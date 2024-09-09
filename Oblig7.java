import java.util.Scanner;

public class Oblig7 {
    public static void main(String[] args) {
        Labyrint lab = new Labyrint(args[0]);

        // ta inn input
        String[] svar;
        Scanner input = new Scanner(System.in);
        System.out.println("\n--Meny--");
        while (true) {
            System.out.println("Skriv inn koordinater <rad> <kolonne> ('-1' for aa avslutte): ");

            svar = input.nextLine().split(" ");
            if (svar[0].equals("-1")) {
                break;
            } else if (svar.length == 2) {
                lab.finnVeiUtFra(Integer.parseInt(svar[0]), Integer.parseInt(svar[1]));
            }
        }
        input.close();

    }
}

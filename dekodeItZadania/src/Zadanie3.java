import java.util.Arrays;
import java.util.Scanner;

public class Zadanie3 {

    void zad3() {
        Scanner scan = new Scanner(System.in);
        int t = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < t; i++) {
            Scanner scan1 = new Scanner(System.in);
            String a = scan.nextLine();
            int roznica = Integer.parseInt(a);
            int licznik = 0;
            String[] tabA = a.split("");
            while (roznica != 6174 && licznik < 10) {
                Arrays.sort(tabA);
                String liczba = Arrays.toString(tabA).join("", tabA);
                int l1 = Integer.parseInt(liczba);
                StringBuilder st = new StringBuilder(liczba).reverse();
                String[] pomoc = st.toString().split("");
                //System.out.println("l1 = " + l1);
                int l2 = Integer.parseInt(Arrays.toString(pomoc).join("", pomoc));
                //System.out.println("l2 = " + l2);
                licznik++;
                roznica = l2 - l1;
                tabA = String.format("%4s", Integer.toString(roznica)).replace(' ', '0').split("");
                //System.out.println("Roznica " + roznica + "\n Licznik: " + licznik);
            }
            if (licznik == 100) {
                licznik = -1;
            }
            System.out.println("" + licznik);

        }
    }
}

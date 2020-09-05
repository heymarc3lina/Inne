import java.util.Scanner;
import java.util.StringTokenizer;

public class Zadanie1 {

    public void zbadajCzyUniesie() {
        int lTestow=0;
        boolean tNieZgodne = true;
        boolean parametryNiezgodne = true;
        while(tNieZgodne==true ) {
            Scanner scan = new Scanner(System.in);
           // System.out.println("Ile testów wykonać?");
            String liczbaTestow = scan.nextLine();
            if (Integer.parseInt(liczbaTestow) <= 100) {
                tNieZgodne= false;
                lTestow = Integer.parseInt(liczbaTestow);
            }
        }
        int proba =0;
       // System.out.println("Podaj liczbe metrów, udżwig Toma oraz wage nawozu oddzielone spacja.");
        while(parametryNiezgodne == true ||  proba < lTestow) {
            Scanner scan = new Scanner(System.in);
            String parametry = scan.nextLine();
            StringTokenizer t1 = new StringTokenizer(parametry);
            int[] tabParametrow = new int[3];
            int i = 0;
            while (t1.hasMoreElements()) {
                tabParametrow[i] = Integer.parseInt(t1.nextToken());
                i++;
            }
            if(i <3 ){
               // System.out.println("Zla liczba parametrow");
                continue;
            }
            for (int j = 0; j < 3; j++) {
                if (tabParametrow[j] >= 1 && tabParametrow[j] <= 100) {
                    parametryNiezgodne = false;
                }
            }
            if (parametryNiezgodne == false) {
                if (tabParametrow[1] >= tabParametrow[0] * tabParametrow[2]) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
            }
            proba++;
        }


    }
}
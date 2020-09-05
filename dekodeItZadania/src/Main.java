import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //liczba przypadkow testowych
        int t = Integer.parseInt(scan.nextLine());
        for(int i = 0; i< t; i++) {
            scan = new Scanner(System.in);
            int n = Integer.parseInt(scan.nextLine());
            scan = new Scanner(System.in);
            String str = scan.nextLine();
            ArrayList<String> listaStringow = new ArrayList<>(4*n);
            String output = "";
            for(int j = 0 ; j < n; j++ ){
               listaStringow.add(str.substring(j*4,4*j+4));
                //System.out.println("args = " +listaStringow.get(j));
                String liczba1 = String.valueOf(listaStringow.get(j).charAt(0)) + String.valueOf(listaStringow.get(j).charAt(2));
                String liczba2 = String.valueOf(listaStringow.get(j).charAt(1)) + String.valueOf(listaStringow.get(j).charAt(3));
                int asci1 = Integer.parseInt(liczba1);
                int asci2 = Integer.parseInt(liczba2);
                output += (char)(asci1 + asci2);

            }
            System.out.println(output);

        }

    }
}

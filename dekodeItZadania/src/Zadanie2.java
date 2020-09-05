import java.util.Scanner;

public class Zadanie2 {

    public void Soroban(){
        Scanner scan = new Scanner(System.in);
        String dane = scan.nextLine();
        String[] tabDanych = dane.split(" ");
        int r = Integer.parseInt(tabDanych[0]);
        int s = Integer.parseInt(tabDanych[1]);

        int tabPomocnicza[] = {2, 4, 6, 8, 10};
        int soroban[] = new int[r];

        boolean rozkladanie= true;
        while (rozkladanie) {
            for (int i = 0; i < r; i++) {
                if(s>0) {
                    soroban[i] += 1;
                    s--;
                }else{
                    rozkladanie= false;
                }
            }
        }
        int sum=1;
        for(int i=0; i < r;i++){
            sum*=tabPomocnicza[soroban[i]];
        }
        System.out.println(sum);

    }
    }


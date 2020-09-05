import javax.swing.*;
import java.awt.*;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;


public class Okno extends JFrame {
    private JLabel nameLabel;
    private JPanel panel = new JPanel();
    private JTextArea opis;
    private JLabel wyszukanie;
    int wyszukania = 1;




    public Okno() {
        super("Wyszukiwarka");
        setSize(400, 800);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setLookAndFeel();
       String response1 = JOptionPane.showInputDialog(null, "Szukam");
       String tekst = userCanLoginByUsername(response1);
       nameLabel = new JLabel("Hasło wyszukania: " + response1, SwingConstants.LEFT);
       if(wyszukania==1) {
           wyszukanie = new JLabel("Liczba wyszukań: " + wyszukania,SwingConstants.LEFT);
       }else{
           wyszukanie = new JLabel("Liczba wyszukań: " + wyszukania + " A jedno z nich zostało przedstawione.",SwingConstants.LEFT);
       }
       opis = new JTextArea( tekst,15,15);
       opis.setLineWrap(true);
       opis.setWrapStyleWord(true);
       opis.setEditable(false);
       panel.add(nameLabel);
       panel.add(wyszukanie);
       panel.add(opis);
add(panel);
        setLookAndFeel();
       setVisible(true);

    }
    private void setLookAndFeel(){
        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        }catch(Exception e){
            System.err.println("Nie potrafię wczytać systemowego wyglądy:  " + e);
        }
    }
    public String userCanLoginByUsername(String hasloWyszukiwania) {
        open("https://pl.wikipedia.org/wiki/Wikipedia:Strona_g%C5%82%C3%B3wna");
        $("#searchInput").setValue(hasloWyszukiwania).pressEnter();
        if($("div#mw-content-text>div>ul>li").exists()){
            wyszukania = $$("div#mw-content-text>div>ul>li").size();
            int random = (int)Math.random()%wyszukania;
            $$("div#mw-content-text>div>ul>li>a").get(random).click();
        }
        return  $("div#mw-content-text> div.mw-parser-output>p").getText();

    }
}

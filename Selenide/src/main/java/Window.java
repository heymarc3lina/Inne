import javax.swing.*;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;


public class Window extends JFrame {
    private JLabel nameLabel;
    private JPanel panel;
    private JTextArea description;
    private JLabel searching;






    public Window() {
       super("Wyszukiwarka");
        panel = new JPanel();
       setSize(400, 800);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setLookAndFeel();
        nameLabel = new JLabel();
        searching = new JLabel();

       description = new JTextArea( null,15,15);
       description.setLineWrap(true);
       description.setWrapStyleWord(true);
       description.setEditable(false);
       panel.add(nameLabel);
       panel.add(searching);
       panel.add(description);
       add(panel);
       setLookAndFeel();


    }

    public String userGiveWord(){
        String wordToSearch = JOptionPane.showInputDialog(null, "Szukam");
        return wordToSearch;
    }

    public void informationAboutSearch(String wordToSearch, String text, int numberOfSearches){
        nameLabel.setText("Hasło wyszukania: " + wordToSearch);
        nameLabel.setHorizontalTextPosition( SwingConstants.LEFT);
        if(numberOfSearches==1) {
            searching.setText("Liczba wyszukań: " + numberOfSearches);
            searching.setHorizontalTextPosition( SwingConstants.LEFT);

        }else{
            searching.setText("Liczba wyszukań: " + numberOfSearches+ ". A jedno z nich zostało przedstawione.");
            searching.setHorizontalTextPosition( SwingConstants.LEFT);
        }
        description.setText(text);
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

}

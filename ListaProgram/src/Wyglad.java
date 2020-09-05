import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Wyglad extends JFrame {
    Obsluga obsluga = new Obsluga(this);

    JPanel panel1 = new JPanel();
    JButton add = new JButton("Dodaj");
    JButton delete = new JButton("Usuń");
     JPanel panel2 = new JPanel();
    JLabel addPositionLabel = new JLabel("Dodaj/Wybierz pozycje");
    JLabel ammout = new JLabel("Ilość: 0");
    JButton increas = new JButton("+");
    JButton decreas = new JButton("-");
    JTextField addPositionField = new JTextField();
    JComboBox listOFProducts = new JComboBox();
    ArrayList<Food> foodArrayList = new ArrayList<>();

    public Wyglad(){
        super("Spis jedzenia");
        setSize(550,250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridLayout layout = new GridLayout(2,1,10,10);
        setLayout(layout);

        FlowLayout layout1 = new FlowLayout(FlowLayout.CENTER);
        panel1.add(add);
        panel1.add(delete);

        add.addActionListener(obsluga);
        delete.addActionListener(obsluga);
        increas.addActionListener(obsluga);
        decreas.addActionListener(obsluga);
        listOFProducts.addItemListener(obsluga);
        addPositionField.addKeyListener(obsluga);

        GridLayout layout2 = new GridLayout(2,3,10,10);
        panel2.add(addPositionLabel);
        panel2.add(addPositionField);
        listOFProducts.addItem("Wybierz produkt");
        for(Food f: foodArrayList){
            listOFProducts.addItem(f.getName());
        }
        panel2.add(listOFProducts);
        panel2.add(ammout);
        panel2.add(increas);
        panel2.add(decreas);

        panel2.setLayout(layout2);
        panel1.setLayout(layout1);
        add(panel2);
        add(panel1);
        setVisible(true);

    }

    void addToArrayList(Food foodToAdd){
        foodArrayList.add(foodToAdd);
    }

    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                    "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
            );
        } catch (Exception exc) {
            // ignore error
        }
    }



    public static void main(String[] args) {
        Wyglad.setLookAndFeel();
        Wyglad wyglad = new Wyglad();
    }
}

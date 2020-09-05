import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ConcurrentModificationException;

public class Obsluga implements ActionListener, ItemListener, KeyListener {
    String writeNewFood = "";
    Wyglad gui;
    int ammount = 0;
    boolean fromList = false;
    Food newFood;

    public Obsluga(Wyglad in) {
        gui = in;
    }

    Food getFood() {
        for (Food f : gui.foodArrayList) {
            if (f.getName() == gui.listOFProducts.getSelectedItem().toString()) {
                return f;
            }
        }
        return null;
    }

    void increasing() {
        ammount++;
        gui.ammout.setText("Ilość: " + ammount);
    }

    void decreasing() {
        if (ammount > 0) {
            ammount--;
            gui.ammout.setText("Ilość: " + ammount);
        }
    }

    void comandAdd(){

        if (fromList) { //jesli mamy to w liscie to tylko zmieniamy ilosc

            for (Food f : gui.foodArrayList) {
                if (f.getName() == gui.listOFProducts.getSelectedItem().toString()) {
                    System.out.println(ammount);
                    f.setAmmount(ammount);
                }
            }

        }else {//gdy nie ma w liscie trzeba dodac
            newFood = new Food(writeNewFood, ammount);
            gui.addToArrayList(newFood);
            gui.listOFProducts.addItem(newFood.getName());
            gui.repaint();
        }
        writeNewFood = "";
        gui.addPositionField.setText(writeNewFood);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) throws ConcurrentModificationException {
        String command = actionEvent.getActionCommand();
        if (command.equals("+")) {
            increasing();
        } else if (command.equals("-")) {
            decreasing();
        } else if (command.equals("Dodaj")) {
            if (ammount > 0 || writeNewFood != "") {
                comandAdd();
                ammount = 0;
                gui.ammout.setText("Ilość: " + ammount);
            }
        } else {//wybrano opcje usuniecia
            try {
                for (Food f : gui.foodArrayList) {
                    if (f.getName() == gui.listOFProducts.getSelectedItem().toString()) {
                        System.out.println(gui.listOFProducts.getSelectedItem().toString());
                        gui.listOFProducts.removeItem(gui.listOFProducts.getSelectedItem());
                        ammount = 0;
                        gui.ammout.setText("Ilość: " + ammount);
                        gui.foodArrayList.remove(f);
                        gui.repaint();
                    }
                }
                gui.addPositionField.setText("");
                writeNewFood = "";
            } catch (Exception e) {
                System.out.println("Wyjątek = " + e.getMessage());
            }
        }
    }


    @Override
    public void itemStateChanged(ItemEvent itemEvent) {
        Object item = itemEvent.getItem();
        writeNewFood = "";
        gui.addPositionField.setText("");
        if(item.toString() == gui.listOFProducts.getSelectedItem() && item.toString() !="Wybierz produkt"){
            fromList = true;
            if(getFood()!=null) {
                ammount = getFood().getAmmount();
            }
            gui.ammout.setText("Ilość: " + ammount);
        }

    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        fromList = false;
        ammount = 0;
        gui.ammout.setText("Ilość: " + ammount);
        writeNewFood+=keyEvent.getKeyChar();

    }
    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if(keyEvent.getKeyCode()==8){
            writeNewFood = "";
            gui.addPositionField.setText(writeNewFood);
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        if(keyEvent.getKeyCode()==8){
            writeNewFood = "";
            gui.addPositionField.setText(writeNewFood);
        }
    }
}

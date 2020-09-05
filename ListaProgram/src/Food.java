public class Food {
    private int ammount;
    private String name;

    Food(String name, int ammount){
        this.name = name;
        this.ammount = ammount;
    }

    public String getName(){
        return name;
    }

    public int getAmmount(){
        return ammount;
    }
    public void setAmmount(int ammount){
        this.ammount= ammount;
    }
}

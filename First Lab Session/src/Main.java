public class Main {
    private String name;
    private int maxSpeed;
    private int yearOfMake;

    public Main (String name, int maxSpeed, int yearOfMake) {
        this.name = name;
        this.maxSpeed = maxSpeed;
        this.yearOfMake = yearOfMake;
    }

    public void carNaming() {
        System.out.println(name + " is the name of this model.");
    }

    public void maxSpeed() {
        System.out.println(name + " has a maximum speed of " + maxSpeed + " km/h.");
    }

    public void productYear(){
        System.out.println(name + " was made in " + yearOfMake + ".");
    }

    public static void main(String[] args) {
        Main myCar = new Main("The SpritMobile", 155, 2024);
        myCar.carNaming();
        myCar.maxSpeed();
        myCar.productYear();
    }
}
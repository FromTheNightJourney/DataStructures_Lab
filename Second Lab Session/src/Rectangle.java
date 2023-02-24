public class Rectangle extends Shape {
    double width, height;

    public Rectangle(String color, double width, double height){
        super(color);
        this.width =  width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

}



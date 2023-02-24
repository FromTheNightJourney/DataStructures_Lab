public class TestClass{
    public static void main(String[] args) {
        Rectangle newRect = new Rectangle("blue", 5, 20);
        System.out.println("The color of this rectangle is " + newRect.color + ".");
        System.out.println("The width of this rectangle is " + newRect.width + "cm.");
        System.out.println("The height of the rectangle is " + newRect.height + "cm.");
        System.out.println("The area of this rectangle, finally, is " + newRect.getArea() + "cm².");
    }
    }

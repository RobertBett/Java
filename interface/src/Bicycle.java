
public class Bicycle implements OperateBicycle{
    private int speed;
    public Bicycle() {
        speed = 0;
    }
    // a static method that calls on the interface static method
    public static void staticMethod() {
        OperateBicycle.staticMethod();
    }
    // implementing speedUp
    public void speedUp(int increment) {
        speed += increment;
    }
    // implementing applyBrakes
    public void applyBrakes(int decrement) {
        speed -= decrement;
    }
    public int getSpeed() {
        return speed;
    }
}

package poly.car1;

public class Model3Car implements Car {
    @Override
    public void startEngine() {
        System.out.println("M3.start");
    }

    @Override
    public void offEngine() {
        System.out.println("M3.off");
    }

    @Override
    public void pressAccelerator() {
        System.out.println("M3.accelerator");
    }
}

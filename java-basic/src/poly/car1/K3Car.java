package poly.car1;

public class K3Car implements Car {
    @Override
    public void startEngine() {
        System.out.println("K3.start");
    }

    @Override
    public void offEngine() {
        System.out.println("K3.off");
    }

    @Override
    public void pressAccelerator() {
        System.out.println("K3.accelerator");
    }
}

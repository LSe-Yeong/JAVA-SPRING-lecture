package poly.diamond;

public class Child implements InterfaceA,InterfaceB{

    @Override
    public void methodA() {
        System.out.println("MethodA");
    }

    @Override
    public void methodCommon() {
        System.out.println("MethodCommon");
    }

    @Override
    public void methodB() {
        System.out.println("MethodB");
    }
}

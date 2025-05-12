package extends1.access.parent;

public class Parent {
    public int publicValue;
    protected int protectedValue;
    int defaultValue;
    private int privateValue;

    public void publicMethod() {
        System.out.println("1");
    }
    protected void protectedMethod() {
        System.out.println("2");
    }
    void defaultMethod() {
        System.out.println("3");
    }
    private void privateMethod() {
        System.out.println("4");
    }

    public void printParent() {
        System.out.println("==========Parent 메서드 안 ========");
        System.out.println(publicValue);
        System.out.println(protectedValue);
        System.out.println(defaultValue);
        System.out.println(privateValue);

        defaultMethod();
        privateMethod();
    }
}

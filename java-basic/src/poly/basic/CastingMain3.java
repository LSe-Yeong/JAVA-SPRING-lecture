package poly.basic;

public class CastingMain3 {
    public static void main(String[] args) {
        Child child = new Child();
        Parent parent1 = child; //업 캐스팅 생략 가능

        parent1.parentMethod();
    }
}

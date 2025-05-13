package poly.basic;

public class CastingMain1 {
    public static void main(String[] args) {
        Parent poly = new Child();
        // poly.childMethod(); // 호출 불가

        //다운 캐스팅(부모 -> 자식 타입 변경)
        Child child = (Child) poly; //x001을 대입한다.
        child.childMethod();
    }
}

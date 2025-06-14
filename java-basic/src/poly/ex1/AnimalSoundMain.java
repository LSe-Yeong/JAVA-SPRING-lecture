package poly.ex1;

public class AnimalSoundMain {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Caw caw = new Caw();

        soundDog(dog);
        soundCat(cat);
        soundCaw(caw);

    }

    private static void soundCat(Cat cat) {
        System.out.println("동물 소리 테스트 시작");
        cat.sound();
        System.out.println("테스트 종료");
    }

    private static void soundDog(Dog dog) {
        System.out.println("동물 소리 테스트 시작");
        dog.sound();
        System.out.println("테스트 종료");
    }
    private static void soundCaw(Caw caw) {
        System.out.println("동물 소리 테스트 시작");
        caw.sound();
        System.out.println("테스트 종료");
    }
}

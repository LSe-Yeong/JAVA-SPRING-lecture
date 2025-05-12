package extends1.access.child;

import extends1.access.parent.Parent;

public class Child extends Parent {
    public void call() {
        publicValue = 1;
        protectedValue = 2;
//        defaultValue = 3; //다른 패키지라 불가
//        privateValue = 4; // 같은 클래스가 아니라 불가

        publicMethod();
        protectedMethod();
//        defaultMethod();
//        privateMethod();   위와 같은 이유

        printParent();
    }
}

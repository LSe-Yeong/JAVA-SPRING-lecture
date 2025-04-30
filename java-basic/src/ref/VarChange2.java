package ref;

public class VarChange2 {
    public static void main(String[] args) {
        Data dataA = new Data();
        dataA.value = 10;
        Data dataB = dataA;

        System.out.println("A참조값="+dataA);
        System.out.println("B참조값="+dataB);
        System.out.println("DataA:"+dataA.value);
        System.out.println("DataB:"+dataB.value);

        dataA.value=20;
        System.out.println("DataA:"+dataA.value);
        System.out.println("DataB:"+dataB.value);


        dataB.value=30;
        System.out.println("DataA:"+dataA.value);
        System.out.println("DataB:"+dataB.value);
    }
}


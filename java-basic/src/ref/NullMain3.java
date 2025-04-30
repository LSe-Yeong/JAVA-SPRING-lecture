package ref;

public class NullMain3 {
    public static void main(String[] args) {
        BigData bigData = new BigData();
        System.out.println("count = "+bigData.count);
        System.out.println("data = "+bigData.data);

        System.out.println("data.value = "+bigData.data.value);
    }
}

package final1;

public class ConstantMain1 {
    public static void main(String[] args) {
        System.out.println("프로그램 최대 참여자 수 "+1000);
        int currentUserCount = 999;
        process(currentUserCount++);
        process(currentUserCount++);
        process(currentUserCount++);
        process(currentUserCount++);
    }

    private static void process(int currentCount) {
        System.out.println("참여자 수 : "+currentCount);
        if(currentCount > 1000) {
            System.out.println("대기자로 등록.");
        } else {
            System.out.println("게임에 참여.");
        }
    }
}

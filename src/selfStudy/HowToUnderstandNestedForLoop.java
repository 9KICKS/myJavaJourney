package selfStudy;

public class HowToUnderstandNestedForLoop {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println("in first loop i = " +i);
            for (int j = 0; j < 10; j++) {
                System.out.println("in second loop j = " +j);
            }
        }
    }
}

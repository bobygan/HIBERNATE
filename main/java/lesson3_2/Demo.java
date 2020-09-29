package lesson3_2;

public class Demo {
    public static void main(String[] args) {


        Solution solution = new Solution();
        System.out.println("time delete performance" + (solution.testDeletePerformance()) + "\n");


        System.out.println("time save performance" + (solution.testSavePerformance()) + "\n");
        System.out.println("time delete by id performance" + (solution.testDeleteByIdPerformance()) + "\n");

        System.out.println("time save performance" + (solution.testSavePerformance()) + "\n");
        System.out.println("time delete performance" + (solution.testDeletePerformance()) + "\n");


        System.out.println("time save performance " + (solution.testSavePerformance()) + "\n");
        System.out.println("time select by id performance " + (solution.testSelectByIdPerformance()) + "\n");
        System.out.println("time select performance " + (solution.testSelectPerformance()) + "\n");
    }

}


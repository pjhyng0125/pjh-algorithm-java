package inflearn.array;

/**
 * DES : 1) 피보나키 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.
 *      2) 입력은 피보나치 수열의 총 항의 수 이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다.
 * IN : 첫 줄에 총 항수 N(3<=N<=45)이 입력된다.
 * OUT : 첫 줄에 피보나치 수열을 출력합니다.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class FibonacciSequence {
    public ArrayList<Integer> mySolution(int n) {
        ArrayList<Integer> iList = new ArrayList<>();

        iList.add(1);
        iList.add(1);
        
        int sum = 0;

        for (int i = 1; i < n - 1; i++) {
            sum = iList.get(i - 1) + iList.get(i);
            iList.add(sum);
        }
        
        return iList;
    }

    public static void main(String[] args) {
        FibonacciSequence T = new FibonacciSequence();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        for (int c : T.mySolution(n)) {
            System.out.print(c + " ");
        }
    }
}
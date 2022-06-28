package inflearn.array;

/**
 * DES : N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요. (첫 번째 수는 무조건 출력한다)
 * IN : 첫 줄에 자연수 N(1<=N<=100)이 주어지고, 그 다음 줄에 N개의 정수가 입력된다.
 * OUT : 자신의 바로 앞 수보다 큰 수만 한 줄로 출력한다.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class PrintMaxNumber {
    public ArrayList<Integer> mySolution(int n, int[] arr) {
        ArrayList<Integer> answerList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                answerList.add(arr[i]);
            } else {
                if (arr[i - 1] < arr[i]) {
                    answerList.add(arr[i]);
                }
            }
        }

        return answerList;
    }

    public static void main(String[] args) {
        PrintMaxNumber T = new PrintMaxNumber();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        for (int j : T.mySolution(n, arr)) {
            System.out.print(j + " ");
        }
    }
}
package sort;

/**
 * DES : N개이 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
 *      정렬하는 방법은 삽입정렬입니다.
 * IN : 첫 번째 줄에 자연수 N(1<=N<=100)이 주어집니다.
 *      두 번째 줄에 N개의 자연수가 공백을 사이에 두고 입력됩니다. 각 자연수는 정수형 범위 안에 있습니다.
 * OUT : 오름차순으로 정렬된 수열을 출력합니다.
 */

import java.util.Scanner;

public class InsertSort {
    public void mySolution(int n, int[] arr) {
        for (int i = 0; i < n; i++) {
            int tmp = arr[i], j;
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] > tmp) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = tmp;
        }

        for (int answer : arr) {
            System.out.print(answer + " ");
        }
    }

    public static void main(String[] args) {
        InsertSort T = new InsertSort();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        T.mySolution(n, arr);
    }
}
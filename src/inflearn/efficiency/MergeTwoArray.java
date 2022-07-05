package inflearn.efficiency;

/**
 * DES : 오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.
 * IN : 첫 번째 줄에 첫 번째 배열의 크기 N(1<=N<=100)이 주어집니다.
 *      두 번째 줄에 N개의 배열 원소가 오름차순으로 주어집니다.
 *      세 번째 줄에 두 번째 배열의 크기 M(1<=M<=100)이 주어집니다.
 *      네 번째 줄에 M개의 배열 원소가 오름차순으로 주어집니다.
 *      각 리스트의 원소는 int형 변수의 크기를 넘지 않습니다.
 * OUT : 오름차순으로 정렬된 배열을 출력합니다.
 */

import java.util.Arrays;
import java.util.Scanner;

public class MergeTwoArray {
    public int[] mySolution(int n, int[] arr1, int m, int[] arr2) {
        int[] answer = new int[n + m];

        for (int i = 0; i < n; i++) {
            answer[i] = arr1[i];
        }

        for (int j = 0; j < m; j++) {
            answer[n + j] = arr2[j];
        }

        Arrays.sort(answer);

        return answer;
    }

    public static void main(String[] args) {
        MergeTwoArray T = new MergeTwoArray();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = kb.nextInt();
        }

        int m = kb.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = kb.nextInt();
        }

        for (int num : T.mySolution(n, arr1, m, arr2)) {
            System.out.print(num + " ");
        }
    }
}
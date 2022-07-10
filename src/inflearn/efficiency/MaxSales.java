package inflearn.efficiency;

/**
 * DES : 현수의 아빠는 제과점을 운영합니다. 현수 아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 최대 매출액이 얼마인지 구하라고 했습니다.
 *      만약 N=10이고 10일 간의 매출기록이 아래와 같습니다. 이때 K=3이면
 *      12 1511 20 2510 20 19 13 15
 *      연속된 3일간의 최대 매출액은 11+20+25=56만원입니다.
 *      여러분이 현수를 도와주세요.
 * IN : 첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.
 *      두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.
 * OUT : 첫 줄에 최대 매출액을 출력합니다.
 */

import java.util.Scanner;

public class MaxSales {

    // sliding window
    // 시간 복잡도 n 목표
    public int solution(int n, int k, int[] arr) {
        int maxSum = 0, partSum = 0;

        for (int i = 0; i < k; i++) {
            partSum += arr[i];
        }
        maxSum = partSum;

        for (int i = k; i < n; i++) {
            partSum += arr[i];
            partSum -= arr[i - k];

            // 최대값 구하기
            maxSum = Math.max(maxSum, partSum);
        }

        return maxSum;
    }
    
    // 2중 for문 돌면 n 제곱 시간복잡도
    public int mySolution(int n, int k, int[] arr) {
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < n - (k - 1); i++) {
            int partSum = 0;
            // k 개 부분합 누적합
            for (int j = i; j < i + k ; j++) {
                partSum += arr[j];
            }
            
            // 최대값 구하기
            if (partSum > maxSum) {
                maxSum = partSum;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        MaxSales T = new MaxSales();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        System.out.print(T.solution(n, k, arr));
    }
}
package inflearn.array;

/**
 * DES : 5*5 격자판에 아래롸 같이 숫자가 적혀있습니다.
 *      5*5 격자판에 아래롸 같이 숫자가 적혀있습니다.
 * IN : 첫 줄에 자연수 N이 주어진다.(2<=N<=50)
 *      두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.
 * OUT : 최대합을 출력합니다.
 */

import java.util.Scanner;

public class CalculateMaxSum {
    public int solution(int n, int[][] iArr) {
        int answer = Integer.MIN_VALUE;
        int sum1, sum2;

        // 가로, 세로 한번에 구하기
        for (int i = 0; i < n; i++){
            sum1 = sum2 = 0;
            for (int j = 0; j < n; j++) {
                sum1 += iArr[i][j];
                sum2 += iArr[j][i];
            }
            answer = Math.max(answer, sum1);
            answer = Math.max(answer, sum2);
        }

        // 대각선 방향
        sum1 = sum2 = 0;
        for (int i = 0; i < n; i++){
            sum1 += iArr[i][i];
            sum2 += iArr[i][4-i];
        }
        answer = Math.max(answer, sum1);
        answer = Math.max(answer, sum2);

        return answer;
    }

    public int mySolution(int n, int[][] iArr) {
        int max = 0, sum;

        // 가로 방향 합
        for (int scoreList[] : iArr) {
            sum = 0;
            for (int score : scoreList) {
                sum += score;
            }
            max = getMaxSum(sum, max);
        }

        // 세로 방향 합
        for (int i = 0; i < n; i++) {
            sum = 0;
            for (int j = 0; j < n; j++) {
                sum += iArr[j][i];
            }
            max = getMaxSum(sum, max);
        }

        sum = 0;
        // 대각선 방향 합 (오른쪽 아래 방향)
        for (int i = 0; i < n; i++) {
            sum += iArr[i][i];
        }
        max = getMaxSum(sum, max);

        sum = 0;
        // 대각선 방향 합 (왼쪽 위 방향)
        for (int i = 0; i < n; i++) {
            sum += iArr[i][4-i];
        }
        max = getMaxSum(sum, max);

        return max;
    }

    private int getMaxSum(int sum, int max) {
        if (max < sum) {
            return sum;
        }
        return max;
    }

    public static void main(String[] args) {
        CalculateMaxSum T = new CalculateMaxSum();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = kb.nextInt();
            }
        }

        System.out.print(T.mySolution(n, arr));
    }
}
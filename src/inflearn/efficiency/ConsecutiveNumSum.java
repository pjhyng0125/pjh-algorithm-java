package inflearn.efficiency;

/**
 * DES : N입력으로 양의 정수 N이 입력되면 2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는 방법의 가짓수를 출력하는 프로그램을 작성하세요.
 *      만약 N=15이면
 *      7+8=15
 *      4+5+6=15
 *      1+2+3+4+5=15
 *      와 같이 총 3가지의 경우가 존재한다.
 * IN : 첫 번째 줄에 양의 정수 N(7<=N<1000)이 주어집니다.
 * OUT : 첫 줄에 총 경우수를 출력합니다.
 */

import java.util.Scanner;

public class ConsecutiveNumSum {

    public int mySolution(int n) {
        int maxIdx = (int) Math.ceil(n / 2);
        int cnt = 0, sum = 0;

        for (int i = 1; i <= maxIdx; i++) {
            sum = 0;
            for (int j = i; j <= n; j++) {
                sum += j;
                if (sum == n) {
                    cnt++;
                    break;
                } else if (sum > n) {
                    break;
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        ConsecutiveNumSum T = new ConsecutiveNumSum();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        System.out.print(T.mySolution(n));
    }
}
package inflearn.array;

/**
 * DES : A, B 두 사람이 가위바위보 게임을 합니다. 총 N번의 게임을 하여 A가 이기면 A를 출력하고, B가 이기면 B를 출력합니다. 비길 경우에는 D를 출력합니다.
 *      가위, 바위, 보의 정보는 1:가위, 2:바위, 3:보로 정하겠습니다.
 *      예를 들어 N=5이면
 *      두 사람의 각 회의 가위, 바위, 보 정보가 주어지면 각 회를 누가 이겼는지 출력하는 프로그램을 작성하세요.
 * IN : 첫 번째 줄에 게임 횟수인 자연수 N(1<=N<=100)이 주어집니다.
 *      두 번째 줄에는 A가 낸 가위, 바위, 보 정보가 N개 주어집니다.
 *      세 번째 줄에는 B가 낸 가위, 바위, 보 정보가 N개 주어집니다.
 * OUT : 각 줄에 각 회의 승자를 출력합니다. 비겼을 경우는 D를 출력합니다.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class RockScissorPaper {
    public ArrayList<Character> mySolution(int n, int[] a, int[] b) {
        ArrayList<Character> cList = new ArrayList<>();

        for (int lt = 0; lt < n; lt++) {
            if (a[lt] == b[lt]) {
                cList.add('D');
            } else if (a[lt] == 3 && b[lt] == 1) {
                cList.add('B');
            } else if (b[lt] == 3 && a[lt] == 1) {
                cList.add('A');
            } else if (b[lt] > a[lt]) {
                cList.add('B');
            } else if (a[lt] > b[lt]) {
                cList.add('A');
            }
        }
        return cList;
    }

    public static void main(String[] args) {
        RockScissorPaper T = new RockScissorPaper();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = kb.nextInt();
        }

        for (int i = 0; i < n; i++) {
            b[i] = kb.nextInt();
        }

        for (char c : T.mySolution(n, a, b)) {
            System.out.println(c);
        }
    }
}
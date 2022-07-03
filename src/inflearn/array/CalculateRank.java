package inflearn.array;

/**
 * DES : N명의 학생의 국어점수가 입력되면 각 학생의 등수를 입력된 순서대로 출력하는 프로그램을 작성하세요.
 *      같은 점수가 입력될 경우 높은 등수로 동일 처리한다.
 *      즉 가장 높은 점수가 92점인데 92점이 3명 존재하면 1등이 3명이고 그 다음 학생은 4등이 된다.
 * IN : 첫 줄에 N(3<=N<=100)이 입력되고, 두 번째 줄에 국어점수를 의미하는 N개의 정수가 입력된다.
 * OUT : 입력된 순서대로 등수를 출력한다.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class CalculateRank {
    public ArrayList<Integer> mySolution(int n, int[] iArr) {
        ArrayList<Integer> iList = new ArrayList<>();
        int rank = 0, criteriaScore = 0;

        for (int c = 0; c < n; c++) {
            rank = 1;
            criteriaScore = iArr[c];
            for (int s = 0; s < n; s++) {
                if (s != c) {
                    if (criteriaScore < iArr[s]) {
                        rank++;
                    }
                }
            }
            iList.add(rank);
        }

        return iList;
    }

    public static void main(String[] args) {
        CalculateRank T = new CalculateRank();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        for (int rank : T.mySolution(n, arr)) {
            System.out.print(rank + " ");
        }
    }
}
package sort;

/**
 * DES : N개의 평면상의 좌표(x, y)가 주어지면 모든 좌표를 오름차순으로 정렬하는 프로그램을 작성하세요.
 *      정렬기준은 먼저 x값의 의해서 정렬하고, x값이 같을 경우 y값에 의해 정렬합니다.
 * IN : 첫째 줄에 좌표의 개수인 N(3<=N<=100,000)이 주어집니다.
 *      두 번째 줄부터 N개의 좌표가 x, y 순으로 주어집니다. x, y값은 양수만 입력됩니다.
 * OUT : N개의 좌표를 정렬하여 출력하세요.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Point implements Comparable<Point> {
    public int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        // 오름차순
        if (this.x == o.x) return this.y - o.y;
        else return this.x - o.x;

        // 내림차순
//        if (this.x == o.x) return o.y - this.y;
//        else return o.x - this.x;
    }
}

public class CoordinateLineup {
    public static void main(String[] args) {
        CoordinateLineup T = new CoordinateLineup();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        ArrayList<Point> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = kb.nextInt();
            int y = kb.nextInt();
            list.add(new Point(x, y));
        }
        Collections.sort(list);
        for (Point point : list) {
            System.out.println(point.x + " " + point.y);
        }
    }
}
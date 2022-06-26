package inflearn.string;

/**
 * DES : 한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.
 * IN : 첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다.
 *      문자열의 길이는 100을 넘지 않는다.
 * OUT : 첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class ShortDistanceChar {
    public ArrayList<Integer> solution(String s) {
        ArrayList<Integer> answerList = new ArrayList<>();

        String[] splitBySpaceStr = s.split(" ");
        String str = splitBySpaceStr[0];
        String standardStr = splitBySpaceStr[1];

        char[] charArr = str.toCharArray();
        int distance = 1000;

        // 오른쪽 방향
        for (int lt = 0; lt < charArr.length; lt++) {
            if (standardStr.equals(String.valueOf(charArr[lt]))) {
                distance = 0;
            } else {
                distance += 1;
            }
            answerList.add(distance);
        }

        // 거리 초기화
        distance = 1000;

        // 왼쪽 방향
        for (int rt = charArr.length - 1; rt >= 0; rt--) {
            if (standardStr.equals(String.valueOf(charArr[rt]))) {
                distance = 0;
            } else {
                distance += 1;
            }
            if (distance < answerList.get(rt)) {
                answerList.set(rt, distance);
            }
        }

        return answerList;
    }

    public ArrayList<Integer> mySolution(String s) {
        ArrayList<Integer> answerList = new ArrayList<>();

        String[] splitBySpaceStr = s.split(" ");
        String str = splitBySpaceStr[0];
        String standardStr = splitBySpaceStr[1];

        int end = str.length() - 1;

        char[] charArr = str.toCharArray();

        int nowIdx = 0;

        for (char c : charArr) {
            if (standardStr.equals(String.valueOf(charArr[nowIdx]))) {
                answerList.add(0);
            } else {
                for (int distance = 1; distance <= charArr.length / 2; distance++) {
                    int lt = nowIdx - distance;
                    int rt = nowIdx + distance;

                    if (lt < 0) {
                        if (standardStr.equals(String.valueOf(charArr[rt]))) {
                            answerList.add(distance);
                            break;
                        }
                    } else if (rt > end) {
                        if (standardStr.equals(String.valueOf(charArr[lt]))) {
                            answerList.add(distance);
                            break;
                        }
                    } else if (lt >= 0 && rt <= end) {

                        if (standardStr.equals(String.valueOf(charArr[lt])) || standardStr.equals(String.valueOf(charArr[rt]))) {
                            answerList.add(distance);
                            break;
                        }

                    }
                }
            }
            // 현재 index 증가
            nowIdx++;
        }

        return answerList;
    }

    public static void main(String[] args) {
        ShortDistanceChar T = new ShortDistanceChar();
        Scanner kb = new Scanner(System.in);
        String s = kb.nextLine();
        ArrayList<Integer> answer = T.solution(s);
        for (int i = 0; i < answer.size(); i ++) {
            System.out.print(answer.get(i));
            if (i != answer.size()-1) {
                System.out.print(" ");
            }
        }
    }
}
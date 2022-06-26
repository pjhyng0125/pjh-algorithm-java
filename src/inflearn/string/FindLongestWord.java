package inflearn.string;

/**
 * DES : 한 개의 문장이 주어지면 그 문장 속에서 가장 긴 단어를 출력하는 프로그램을 작성하세요. 문장속의 각 단어는 공백으로 구분됩니다.
 * IN : 첫 줄에 길이가 100을 넘지 않는 한 개의 문장이 주어집니다. 문장은 영어 알파벳으로만 구성되어 있습니다.
 * OUT : 첫 줄에 가장 긴 단어를 출력한다. 가장 길이가 긴 단어가 여러개일 경우 문장속에서 가장 앞쪽에 위치한 단어를 답으로 합니다.
 */

import java.util.Scanner;

public class FindLongestWord {
    public String mySolution(String orginStr) {
        String answer = "";
        // 1. 공백 구분
        String[] splitSpaceArr = orginStr.split("\\s");

        // 2. 길이 체크 => 배열 생성
        int[] strLenArr = new int[splitSpaceArr.length];
        for (int i = 0; i < splitSpaceArr.length; i++) {
            String str = splitSpaceArr[i];
            strLenArr[i] = str.length();
        }

        // 3. 최대값 확인
        int max = strLenArr[0];
        for (int j = 0; j < strLenArr.length; j++) {
            int num = strLenArr[j];
            if (num > max) {
                max = num;
            }
        }

        // 4. 최대값 에 해당하는 2. index 값 반환
        int maxIdx = 0;
        for (int k = 0; k < strLenArr.length; k++) {
            int num = strLenArr[k];
            if (num == max) {
                maxIdx = k;
                break;
            }
        }

        answer = splitSpaceArr[maxIdx];

        return answer;
    }

    public String solution1(String str) {
        String answer = "";
        int m = Integer.MIN_VALUE;
        String[] s = str.split("\\s");
        for (String x : s) {
            int len = x.length();
            // 초과 일 경우, 갱신 X
            if (len > m) {
                m = len;
                answer = x;
            }
        }

        return answer;
    }

    public String solution2(String str) {
        String answer = "";
        int m = Integer.MIN_VALUE, pos;
        while ((pos = str.indexOf("\\s+")) != -1) {
            String tmp = str.substring(0, pos);
            int len = tmp.length();
            if (len > m) {
                m = len;
                answer = tmp;
            }
            str = str.substring(pos+1);
        }
        // 마지막 단어 처리 필요
        if (str.length() > m) {
            answer = str;
        }
        return answer;
    }

    public String solution3(String str) {
        String answer = "";

        return answer;
    }

    public static void main(String[] args) {
        FindLongestWord T = new FindLongestWord();
        Scanner kb = new Scanner(System.in);
        String orginStr = kb.nextLine();
        System.out.println(T.mySolution(orginStr));
    }
}
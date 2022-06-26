package inflearn.string;

/**
 * DES : 알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는
 *      문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시오.
 *      단 반복횟수가 1인 경우 생략합니다.
 * IN : 첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.
 * OUT : 첫 줄에 압축된 문자열을 출력한다.
 */

import java.util.Scanner;

public class CompressString {
    public String mySolution(String s) {
        StringBuffer answerBuf = new StringBuffer();
        char[] charArr = s.toCharArray();

        // 연속 횟수 값 선언
        int continueCnt = 1;

        for (int lt = 0; lt < charArr.length; lt++) {
            // answer 문자열 추가
            if (continueCnt == 1) {
                answerBuf.append(charArr[lt]);
            }

            // 연속 횟수 체크
            if (lt != charArr.length - 1) {
                if (charArr[lt] == charArr[lt + 1]) {
                    continueCnt++;
                } else {
                    // answer 숫자 추가 (1이 아닌 경우만)
                    if (continueCnt != 1) {
                        answerBuf.append(continueCnt);
                    }
                    continueCnt = 1;
                    continue;
                }
            } else {
                // 마지막 문자열 비교 case
                if (charArr[lt] == charArr[lt - 1]) {
                    answerBuf.append(continueCnt);
                }
            }
        }

        return answerBuf.toString();
    }

    public static void main(String[] args) {
        CompressString T = new CompressString();
        Scanner kb = new Scanner(System.in);
        String s = kb.next();
        System.out.println(T.mySolution(s));
    }
}
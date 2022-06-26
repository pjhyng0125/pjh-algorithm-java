package inflearn.string;

/**
 * DES : 대문자와 소문자가 같이 존재하는 문자열을 입력받아 대문자는 소문자로 소문자는 대문자로 변환하여 출력하는 프로그램을 작성하세요.
 * IN : 첫 줄에 문자열이 입력된다. 문자열의 길이는 100을 넘지 않습니다. 문자열은 영어 알파벳으로만 구성되어 있습니다.
 * OUT : 첫 줄에 대문자는 소문자로, 소문자는 대문자로 변환된 문자열을 출력합니다.
 */

import java.util.Scanner;

public class ConvertStringCase {
    public String mySolution(String orginStr) {
        StringBuffer answerBuf = new StringBuffer();
        for (char c : orginStr.toCharArray()) {
            if (Character.isUpperCase(c)) {
                answerBuf.append(Character.toLowerCase(c));
            } else if (Character.isLowerCase(c)) {
                answerBuf.append(Character.toUpperCase(c));
            }
        }
        return answerBuf.toString();
    }
    public static void main(String[] args) {
        ConvertStringCase T = new ConvertStringCase();
        Scanner kb = new Scanner(System.in);
        String orginStr = kb.next();
        System.out.println(T.mySolution(orginStr));
    }
}
package inflearn.sample;

import java.util.Scanner;

/**
 * 알고리즘 문제 정답 입력 Sample을 제공
 */
public class StringSample {
    public String solution(int n, String s) {
        String answer = "1";
        return answer;
    }
    public static void main(String[] args) {
        StringSample T = new StringSample();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String str = kb.next();
        System.out.println(T.solution(n,str));
    }
}

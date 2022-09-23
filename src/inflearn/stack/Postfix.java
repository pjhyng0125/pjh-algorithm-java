package stack;

/**
 * DES : 후위연산식이 주어지면 연산한 결과를 출력하는 프로그램을 작성하세요.
 *       만약 3*(5+2)-9 을 후위연산식으로 표현하면 352+*9- 로 표현되며 그 결과는 12입니다.
 * IN : 첫 줄에 후위연산식이 주어집니다. 연산식의 길이는 50을 넘지 않습니다.
 *      식은 1~9의 숫자와 +, -, *, / 연산자로만 이루어진다.
 * OUT : 연산한 결과를 출력합니다.
 */

import java.util.Scanner;
import java.util.Stack;

public class Postfix {
    public int mySolution(String str) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(c - 48);
            } else {
                int rt = stack.pop();
                int lt = stack.pop();

                if (c == '+') {
                    stack.push(lt + rt);
                } else if (c == '-') {
                    stack.push(lt - rt);
                } else if (c == '*') {
                    stack.push(lt * rt);
                } else if (c == '/') {
                    stack.push(lt / rt);
                }
            }
        }

        answer = stack.peek();

        return answer;
    }

    public static void main(String[] args) {
        Postfix T = new Postfix();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.println(T.mySolution(str));
    }
}
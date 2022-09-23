package queue;

/**
 * DES : 메디컬 병원 응급실에는 의사가 한 명밖에 없습니다.
 *      응급실은 환자가 도착한 순서대로 진료를 합니다. 하지만 위험도가 높은 환자는 빨리 응급조치를 의사가 해야 합니다.
 *      이런 문제를 보완하기 위해 응급실은 다음과 같은 방법으로 환자의 진료순서를 정합니다.
 *      • 환자가 접수한 순서대로의 목록에서 제일 앞에 있는 환자목록을 꺼냅니다.
 *      • 나머지 대기 목록에서 꺼낸 환자 보다 위험도가 높은 환자가 존재하면 대기목록 제일 뒤로 다시 넣습니다. 그렇지 않으면 진료를 받습니다.
 *      즉 대기목록에 자기 보다 위험도가 높은 환자가 없을 때 자신이 진료를 받는 구조입니다.
 *      현재 N명의 환자가 대기목록에 있습니다.
 *      N명의 대기목록 순서의 환자 위험도가 주어지면, 대기목록상의 M번째 환자는 몇 번째로 진료를 받는지 출력하는 프로그램을 작성하세요.
 *      대기목록상의 M번째는 대기목록의 제일 처음 환자를 0번째로 간주하여 표현한 것입니다.
 * IN : 첫 줄에 자연수 N(5<=N<=100)과 M(0<=M<N) 주어집니다.
 *      두 번째 줄에 접수한 순서대로 환자의 위험도(50<=위험도<=100)가 주어집니다.
 *      위험도는 값이 높을 수록 더 위험하다는 뜻입니다. 같은 값의 위험도가 존재할 수 있습니다.
 * OUT : M번째 환자의 몇 번째로 진료받는지 출력하세요.
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class EmergencyRoom {
    class Person {
        private int id;
        private int priority;

        public Person(int id, int priority) {
            this.id = id;
            this.priority = priority;
        }
        public int getId() {
            return id;
        }
        public int getPriority() {
            return priority;
        }
    }
    public int solution(int n, int m, String str) {
        int answer = 0;
        int idx = 0;

        Queue<Person> waitList = new LinkedList<>();
        String[] splited = str.split("\\s+");

        // 환자 대기 목록 Queue 생성
        for (String s : splited) {
            waitList.add(new Person(idx++, Integer.parseInt(s)));
        }

        while(!waitList.isEmpty()) {
            Person presentPatient = waitList.poll();
            // 대기 목록 중 위험도 더 높은 환자 있는지 확인
            for (Person p : waitList) {
                if (p.getPriority() > presentPatient.getPriority()) {
                    waitList.add(presentPatient);
                    presentPatient = null;
                    break;
                }
            }

            if (presentPatient != null) {
                answer++;
                if (presentPatient.getId() == m) {
                    return answer;
                }
            }
        }
        return answer;
    }

    public int mySolution(int n, int m, String str) {
        int answer = 0; // 진료 완료 환자 수
        int mIdx = m; // M 번째 환자 idx

        Queue<Integer> waitList = new LinkedList<>();
        String[] splited = str.split("\\s+");

        // 환자 대기 목록 Queue 생성
        for (String s : splited) {
            waitList.add(Integer.parseInt(s));
        }

        // M 번째 환자의 idx가 0이 되는 시점까지 반복
        while(!waitList.isEmpty()) {
            int frontPatient = waitList.poll();

            // 대기 목록 중 위험도 더 높은 환자 있는지 확인
            int max = frontPatient;
            for (int num : waitList) {
                max = Math.max(max, num);
            }

            if (frontPatient < max) {
                waitList.add(frontPatient);
                if (mIdx == 0) {
                    mIdx = waitList.size() - 1;
                } else {
                    mIdx--;
                }
            } else {
                answer++;
                if (mIdx == 0) {
                    return answer;
                }
                mIdx--;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        EmergencyRoom T = new EmergencyRoom();
        Scanner kb = new Scanner(System.in);

        String num = kb.nextLine();
        String[] splitedNum = num.split("\\s+");
        int n = Integer.parseInt(splitedNum[0]);
        int m = Integer.parseInt(splitedNum[1]);

        String str = kb.nextLine(); // 위험도
        System.out.println(T.solution(n, m, str));
    }
}
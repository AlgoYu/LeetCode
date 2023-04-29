package xiaoyu.algo.leetcode;

public class 无法吃午餐的学生数量 {
    public int countStudents(int[] students, int[] sandwiches) {
        int n = students.length;
        if (n == 1) {
            return students[0] == sandwiches[0] ? 0 : 1;
        }
        boolean[] eat = new boolean[n];
        int sa = 0;
        int sb = 0;
        for (int i = 0; i < n; i++) {
            if (students[i] == 0) {
                sa++;
            } else {
                sb++;
            }
        }
        int queneIndex = 0;
        int i = 0;
        for (; i < n; i++) {
            if (sandwiches[i] == 0 && sa == 0) {
                break;
            }
            if (sandwiches[i] == 1 && sb == 0) {
                break;
            }
            while (eat[queneIndex] || students[queneIndex] != sandwiches[i]) {
                queneIndex = (queneIndex + 1) % n;
            }
            eat[queneIndex] = true;
            if (students[queneIndex] == 0) {
                sa--;
            } else {
                sb--;
            }
        }
        return n - i;
    }
}
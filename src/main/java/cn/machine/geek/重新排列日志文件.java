package cn.machine.geek;

public class 重新排列日志文件 {
    public static void main(String[] args) {
        重新排列日志文件 test = new 重新排列日志文件();
        test.reorderLogFiles(new String[]{"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"});
    }

    public String[] reorderLogFiles(String[] logs) {
        for (int i = 0; i < logs.length; i++) {
            for (int j = 0; j < logs.length - i - 1; j++) {
                if (compare(logs[j], logs[j + 1]) > 0) {
                    String temp = logs[j];
                    logs[j] = logs[j + 1];
                    logs[j + 1] = temp;
                }
            }
        }
        return logs;
    }

    private int compare(String logA, String logB) {
        String[] splitA = logA.split(" ", 2);
        String[] splitB = logB.split(" ", 2);
        char charA = splitA[1].charAt(0);
        char charB = splitB[1].charAt(0);
        if (Character.isDigit(charA) && Character.isLetter(charB)) {
            return 1;
        }
        if (Character.isLetter(charA) && Character.isLetter(charB)) {
            int result = splitA[1].compareTo(splitB[1]);
            if (result != 0) {
                return result;
            }
            return splitA[0].compareTo(splitB[0]);
        }
        return -1;
    }
}

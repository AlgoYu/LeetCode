package cn.machine.geek;

class 最大交换 {
    public int maximumSwap(int num) {
        char[] numStr = String.valueOf(num).toCharArray();
        for (int i = 0; i < numStr.length; i++) {
            int cur = numStr[i] - '0';
            int max = cur;
            int index = i;
            for (int j = i + 1; j < numStr.length; j++) {
                if (numStr[j] - '0' >= max) {
                    index = j;
                    max = numStr[j] - '0';
                }
            }
            if (cur != max) {
                char tmp = numStr[i];
                numStr[i] = numStr[index];
                numStr[index] = tmp;
                break;
            }
        }
        return Integer.parseInt(String.valueOf(numStr));
    }
}
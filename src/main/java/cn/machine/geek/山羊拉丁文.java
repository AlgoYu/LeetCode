package cn.machine.geek;

public class 山羊拉丁文 {
    public String toGoatLatin(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            char first = words[i].toLowerCase().charAt(0);
            if (first == 'a' || first == 'e' || first == 'i' || first == 'o' || first == 'u') {
                sb.append(words[i]).append("ma");
            } else {
                sb.append(words[i].substring(1, words[i].length())).append(words[i].charAt(0)).append("ma");
            }
            int n = 0;
            while (n <= i) {
                sb.append('a');
                n++;
            }
            if (i < words.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}

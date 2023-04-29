package xiaoyu.algo.leetcode;

public class 赢得比赛需要的最少训练时长 {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int hour = 0;
        int n = energy.length;
        for (int i = 0; i < n; i++) {
            if (initialEnergy <= energy[i]) {
                int diff = Math.abs(initialEnergy - energy[i]) + 1;
                hour += diff;
                initialEnergy += diff;
            }
            if (initialExperience <= experience[i]) {
                int diff = Math.abs(initialExperience - experience[i]) + 1;
                hour += diff;
                initialExperience += diff;
            }
            if (initialEnergy > energy[i] && initialExperience > experience[i]) {
                initialEnergy -= energy[i];
                initialExperience += experience[i];
            }
        }
        return hour;
    }
}

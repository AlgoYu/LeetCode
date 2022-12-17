package cn.machine.geek;

class 通过连接另一个数组的子数组得到一个数组 {
    public boolean canChoose(int[][] groups, int[] nums) {
        int index = 0;
        int groupIndex = 0;
        while (groupIndex < groups.length && index < nums.length) {
            if (check(groups[groupIndex], nums, index)) {
                index += groups[groupIndex].length;
                groupIndex++;
            } else {
                index++;
            }
        }
        return groupIndex == groups.length;
    }

    private boolean check(int[] group, int[] nums, int index) {
        if (nums.length - index < group.length) {
            return false;
        }
        int i = 0;
        while (i < group.length) {
            if (group[i] != nums[index + i]) {
                return false;
            }
            i++;
        }
        return i == group.length;
    }
}
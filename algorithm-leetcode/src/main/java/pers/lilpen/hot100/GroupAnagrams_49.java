package pers.lilpen.hot100;

import java.util.*;

/**
 * @author : penghuaishun
 * @version : 1.0
 **/
public class GroupAnagrams_49 {
    /**
     * 49. 字母异位词分组
     * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
     * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<ArrayKey, List<String>> stringArrayListHashMap = new HashMap<>();
        for (String str : strs) {
            int[] letterCountNums = new int[26];
            for (char c : str.toCharArray()) {
                int num = c - 'a';
                letterCountNums[num]++;
            }
            ArrayKey array = new ArrayKey(letterCountNums);
            List<String> resList = stringArrayListHashMap.getOrDefault(array, new ArrayList<>());
            resList.add(str);
            stringArrayListHashMap.put(array, resList);
        }
        return new ArrayList<>(stringArrayListHashMap.values());
    }

    private static class ArrayKey {
        public int[] array;
        public ArrayKey(int[] array) {
            this.array = array;
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) return true;
            if (object == null || getClass() != object.getClass()) return false;
            ArrayKey array1 = (ArrayKey) object;
            return Objects.deepEquals(array, array1.array);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(array);
        }
    }
}

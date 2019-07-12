package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *  给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。
 *  S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 *
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 * 示例 1:
 *
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 */
public class Demo1 {

    public static void main(String[] args) {
        String origin = "aA";
        String target = "aAAbbbAAaAb";
        int i = testDemo(origin, target);
        System.out.println(i);

        char a = 'a';
        System.out.println((int)a);
    }

    public static int testDemo(String origin, String target){
        int count = 0;
        char[] chars = target.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        for (char aChar : chars) {
            if (map.containsKey(aChar)){
                map.put(aChar, map.get(aChar) + 1);
            }else {
                map.put(aChar,1);
            }
        }

        char[] chars1 = origin.toCharArray();
        for (char c : chars1) {
            if (map.containsKey(c)){
                count += map.get(c);
            }
        }
        return count;
    }
}

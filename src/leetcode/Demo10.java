package leetcode;

import com.sun.javafx.fxml.expression.KeyPath;

import java.util.*;

/**
 *给定两个句子 A 和 B 。 （句子是一串由空格分隔的单词。每个单词仅由小写字母组成。）
 *
 * 如果一个单词在其中一个句子中只出现一次，
 * 在另一个句子中却没有出现，那么这个单词就是不常见的。
 *
 * 返回所有不常用单词的列表。
 *
 * 您可以按任何顺序返回列表。
 *
 * 示例 1：
 *
 * 输入：A = "this apple is sweet", B = "this apple is sour"
 * 输出：["sweet","sour"]
 */
public class Demo10 {

    public static void main(String[] args) {
        String A = "this apple is sweet", B = "this apple is sour";
        uncommonFromSentences(A,B);
    }

    public static String[] uncommonFromSentences(String A, String B) {
        String finalString = A + " " + B;
        String[] finalSentence = finalString.split(" ");
        Map<String ,Integer> map = new HashMap<>();
        for (String s : finalSentence) {
            if (map.containsKey(s)){
                map.put(s , map.get(s) + 1);
            }else {
                map.put(s, 1);
            }
        }
        List<String> list = new ArrayList<>();
        for (String s : map.keySet()) {
            if (map.get(s) == 1){
                list.add(s);
            }
        }
        String[] array = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }
}

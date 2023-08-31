package org.example;

import java.util.ArrayList;
import java.util.List;

// 笛卡尔积
// 富途面试多音字组合：提供系统函数返回单字符拼音，有多音字，pinyin(char)，'行'，"xin,hang"，
// 实现返回字符串拼音所有可能，pinyinstr(String)，“银行”，“[yin,hang],[yin,xin]”
public class Descartes {
    private static void descartes(List<List<String>> dimvalue, List<List<String>> result, int layer, List<String> curList) {
        if (layer < dimvalue.size() - 1) {
            if (dimvalue.get(layer).size() == 0) {
                descartes(dimvalue, result, layer + 1, curList);
            } else {
                for (int i = 0; i < dimvalue.get(layer).size(); i++) {
                    List<String> list = new ArrayList<String>(curList);
                    list.add(dimvalue.get(layer).get(i));
                    descartes(dimvalue, result, layer + 1, list);
                }
            }
        } else if (layer == dimvalue.size() - 1) {
            if (dimvalue.get(layer).size() == 0) {
                result.add(curList);
            } else {
                for (int i = 0; i < dimvalue.get(layer).size(); i++) {
                    List<String> list = new ArrayList<String>(curList);
                    list.add(dimvalue.get(layer).get(i));
                    result.add(list);
                }
            }
        }
    }

    public static void main(String[] args) {
        List<List<String>> list = new ArrayList<List<String>>();
        List<String> listSub1 = new ArrayList<String>();
        List<String> listSub2 = new ArrayList<String>();
        List<String> listSub3 = new ArrayList<String>();
        listSub1.add("1");
        listSub1.add("2");

        listSub2.add("3");
        listSub2.add("4");

        listSub3.add("a");
        listSub3.add("b");

        list.add(listSub1);
        list.add(listSub2);
        list.add(listSub3);
        List<List<String>> result = new ArrayList<List<String>>();
        descartes(list, result, 0, new ArrayList<String>());
        System.out.println(result.size());

    }

}

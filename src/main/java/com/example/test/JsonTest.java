package com.example.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.*;

/**
 * @author zhangyi
 * @date 2023-02-08 09:56
 */
public class JsonTest {
    public static void main(String[] args) {
        LinkedHashMap<String, List<String>> map = new LinkedHashMap<>();
        map.put("z", Arrays.asList("1", "2"));
        map.put("x", Arrays.asList("3", "4"));
        map.put("y", Arrays.asList("5", "6"));
        String str = JSON.toJSONString(map);
        Map<String, List<String>> stringListLinkedHashMap = JSON.parseObject(str, new TypeReference<HashMap<String, List<String>>>() {});
        System.out.println(str);
        System.out.println(stringListLinkedHashMap);
    }
}

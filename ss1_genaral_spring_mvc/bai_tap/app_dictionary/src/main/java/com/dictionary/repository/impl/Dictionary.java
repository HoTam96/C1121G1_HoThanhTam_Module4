package com.dictionary.repository.impl;

import com.dictionary.repository.IDictionary;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Repository
public class Dictionary implements IDictionary {
    @Override
    public String result(String name) {
        Map<String, String> stringMap = new HashMap<>();
        stringMap.put("hello", "xin chào");
        stringMap.put("sorry", "xin lỗi");
        stringMap.put("curency", "tiền tệ");
        stringMap.put("convert", "chuyển đổi");
        stringMap.put("pen", "bút");
        stringMap.put("span", "máy quạt");

        Set<String> stringSet = stringMap.keySet();
        boolean flag = true;
        for (String element : stringSet) {
            if (element.equals(name)) {
                return stringMap.get(element);
            } else {
                flag = false;
            }
        }

        if (!flag) {
            return "không tìm thấy từ khóa ";
        }
        return null;
    }
}

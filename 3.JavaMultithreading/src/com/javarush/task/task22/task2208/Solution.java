package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/* 
Формируем WHERE
Формируем WHERE
Сформируй часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.

Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}

Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"


Требования:
1. Метод getQuery должен принимать один параметр типа Map.
2. Метод getQuery должен иметь тип возвращаемого значения String.
3. Метод getQuery должен быть статическим.
4. Метод getQuery должен возвращать строку сформированную по правилам описанным в условии задачи.
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> params = new LinkedHashMap<>();
        //System.out.println(params);
        params.put("name", "Ivanov");
        params.put("country", "Ukraine");
        params.put("city", "Kiev");
        params.put("age", null);
        params.put(null, "java");
        System.out.println(getQuery(params));

    }
    public static String getQuery(Map<String, String> params) {
        if (params == null || params.size() == 0) {return "";}
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String,String> map : params.entrySet()){
            if (map.getKey() != null && map.getValue() != null){
                if (stringBuilder.toString().equals("")) {
                    stringBuilder.append(map.getKey()).append(" = '").append(map.getValue()).append("'");
                }else{stringBuilder.append(" and ").append(map.getKey()).append(" = '").append(map.getValue()).append("'");}
            }

        }
        //stringBuilder.delete(stringBuilder.length() - 5, stringBuilder.length());


        return stringBuilder.toString();
    }
}

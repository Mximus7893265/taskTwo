package ru.task.two;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TaskTwo {

	private List<Map<String, String>> list;
    
    public TaskTwo(){
    	list=new ArrayList<>();
        list.add(new LinkedHashMap<String, String>());
        list.get(list.size()-1).put("Имя", "Кирилл");
        list.get(list.size()-1).put("Возраст", "26");
        list.get(list.size()-1).put("Должность", "Middle java dev");
        list.get(list.size()-1).put("Зарплата", "150000руб");
        list.add(new LinkedHashMap<String, String>());
        list.get(list.size()-1).put("Имя", "Виталий");
        list.get(list.size()-1).put("Возраст", "28");
        list.get(list.size()-1).put("Должность", "Senior java automation QA");
        list.get(list.size()-1).put("Зарплата", "2000$");
        list.add(new LinkedHashMap<String, String>());
        list.get(list.size()-1).put("Имя", "Александр");
        list.get(list.size()-1).put("Возраст", "31");
        list.get(list.size()-1).put("Должность", "junior functional tester");
        list.get(list.size()-1).put("Зарплата", "50000 руб");
        list.add(new LinkedHashMap<String, String>());
        list.get(list.size()-1).put("Имя", "Дементий");
        list.get(list.size()-1).put("Возраст", "35");
        list.get(list.size()-1).put("Должность", "dev-ops");
        list.get(list.size()-1).put("Зарплата", "1500$");
    }
    
    public TaskTwo(List<Map<String, String>> list) {
    	this.list=list;
    }
    
    public List<Map<String, String>> getList() {
    	return list;
    }
   
    public void showNameAgeLess(List<Map<String, String>> list, int age) {
    	for(Map<String, String>map:list){
            if(Integer.parseInt(map.get("Возраст"))<age)
                System.out.println(map.get("Имя"));
         }
    }
    
    public void showNameAgeLess30(List<Map<String, String>> list){
       showNameAgeLess(list,30);
    }
    
    public void showNameAgeLessStream(List<Map<String, String>> list, int age){
    	list.stream().filter((myMap)->Integer.parseInt(myMap.get("Возраст"))<age)
        .forEach((myMap)->System.out.println(myMap.get("Имя")));
    }
    
    public void showNameAgeLess30Stream(List<Map<String, String>> list){
        showNameAgeLessStream(list, 30);
    }
    
    public void showNameWhereCostEqualsRub(List<Map<String, String>> list){
        for(Map<String, String>map:list){
          if(map.get("Зарплата").endsWith("руб"))
              System.out.println(map.get("Имя"));
       }
    }
    
    public void showNameWhereCostEqialsRubStream(List<Map<String, String>> list){
        list.stream().filter((myMap)->myMap.get("Зарплата").endsWith("руб"))
                .forEach((myMap)->System.out.println(myMap.get("Имя")));
    }
    
    public void averageAge(List<Map<String, String>> list){
        double averageAge=0.0;
        for(Map<String, String>map:list)
            averageAge+=Integer.parseInt(map.get("Возраст"));
        System.out.println(averageAge/list.size());
    }
    
    public void averageAgeStream(List<Map<String, String>> list){
        System.out.println(
                list.stream().mapToInt((myMap)->Integer.parseInt(myMap.get("Возраст"))).average().getAsDouble()
        );
    }
}

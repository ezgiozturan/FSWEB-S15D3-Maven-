package org.example;

import org.example.entity.Employee;

import java.util.*;

public class Main {


    public static void main(String[] args) {

        LinkedList<Employee> employeeList = new LinkedList<>();

        employeeList.add(new Employee(1,"ali" , "veli"));
        employeeList.add(new Employee(2,"ayse" , "veli"));
        employeeList.add(new Employee(3,"nur" , "asli"));
        employeeList.add(new Employee(1,"ali" , "veli"));
        employeeList.add(new Employee(4,"ezgi" , "oz"));



        List<Employee> duplicates = findDuplicates(employeeList);
        System.out.println("Duplicates: " + duplicates);

        Map<Integer, String> uniqueEmployees = findUniques(employeeList);
        System.out.println("Unique Employees: " + uniqueEmployees.values());

        List<Employee> noDuplicates = removeDuplicates(employeeList);
        System.out.println("List after removing duplicates: " + noDuplicates);

        String text = "When the offensive resumed, the Turks received their first victory when the Greeks encountered stiff resistance in the battles of First and Second İnönü," +
                " due to İsmet Pasha's organization of an irregular militia into a regular army. " +
                " The two victories led to Allied proposals to amend the Treaty of Sèvres where both Ankara and Istanbul were represented, but Greece refused." +
                " With the conclusion of the Southern and Eastern fronts, Ankara was able to concentrate more forces on the West against the Greeks." +
                " They also began to receive support from Soviet Union, as well as France and Italy, who sought to check British influence in the Near East." +
                " June–July 1921 saw heavy fighting in the Battle of Kütahya-Eskişehir. While it was an eventual Greek victory, the Turkish army withdrew in good order to the Sakarya river, their last line of defence." +
                " Mustafa Kemal Pasha replaced İsmet Pasha after the defeat as commander in chief as well as his political duties." +
                " The decision was made in the Greek military command to march on the nationalist capital of Ankara to force Mustafa Kemal to the negotiating table." +
                " For 21 days, the Turks and Greeks fought a pitched battle at the Sakarya river, which ended in Greek withdrawal." +
                " Almost of year of stalemate without much fighting followed, during which Greek moral and discipline faltered while Turkish strength increased." +
                " French and Italian forces evacuated from Anatolia. The Allies offered an armistice to the Turks, which Mustafa Kemal refused.";

        Map<String,Integer> wordCount = WordCounter.calculateWord(text);

        for (Map.Entry<String,Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    public static List<Employee> findDuplicates(List<Employee> list) {
        Set<Employee> uniqueSet = new HashSet<>();
        List<Employee> duplicates = new LinkedList<>();
        for (Employee emp : list) {
            if (!uniqueSet.add(emp)) {
                duplicates.add(emp);
            }
        }
        return duplicates;
    }


    public static Map<Integer,String> findUniques(List<Employee> list) {
        Map<Integer,String> uniqueMap = new HashMap<>();
        for (Employee emp : list) {
            if (!uniqueMap.containsKey(emp.getId())) {
                uniqueMap.put(emp.getId(), String.valueOf(emp));
            }

        }
        return uniqueMap;
    }

    public static List<Employee> removeDuplicates(List<Employee> list) {
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();
        List<Employee> result = new LinkedList<>();


        for (Employee emp : list) {
            if (!seen.add(emp.getId())) {
                duplicates.add(emp.getId());
            }
        }

        for (Employee emp : list) {
            if (!duplicates.contains(emp.getId())) {
                result.add(emp);
            }
        }

        return result;
    }


}


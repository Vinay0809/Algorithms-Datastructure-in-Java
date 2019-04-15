package edu.uncc.ad.hashtable;

import java.util.*;

/**
 * @author venky
 */

/**
 * Task is to remove duplicate employees from list using HashTable.
 */
public class Main {

    public static void main(String[] args) {

        LinkedList<Employee> employees = new LinkedList<> ();
        employees.add(new Employee("Jane", "Jones", 123));
        employees.add(new Employee("John", "Doe", 5678));
        employees.add(new Employee("Mike", "Wilson", 45));
        employees.add(new Employee("Mary", "Smith", 5555));
        employees.add(new Employee("John", "Doe", 5678));
        employees.add(new Employee("Bill", "End", 3948));
        employees.add(new Employee("Jane", "Jones", 123));

        employees.forEach(e -> System.out.println(e));

        Map<Integer, Employee> hashTable = new Hashtable<> ();
        List<Employee> duplicateIdList = new ArrayList<> ();
        for ( Employee emp: employees ){
            if ( hashTable.containsKey (emp.getId ()) ){
                duplicateIdList.add (emp);
            } else {
                hashTable.put (emp.getId (), emp);
            }
        }
        for ( Employee emp:duplicateIdList ){
            employees.remove (emp);
        }
        System.out.println (employees);

    }
}

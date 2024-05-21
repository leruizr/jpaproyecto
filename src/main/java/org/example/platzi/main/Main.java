package org.example.platzi.main;

import org.example.platzi.Util.UtilEntity;
import org.example.platzi.entity.Employee;

import javax.persistence.EntityManager;
import java.util.List;

public class Main {
    public static void main(String[] args){
        EntityManager em = UtilEntity.getEntityManager();
        List<Employee> employees = em.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
        System.out.println("--------List of Employees--------");
        employees.forEach(System.out::println);

    }

}

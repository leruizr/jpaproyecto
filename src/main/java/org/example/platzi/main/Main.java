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


        System.out.println("---------Buscar por ID---------");
        int employeeId = 3;
        Employee employee = em.find(Employee.class, employeeId);
        System.out.println("Empleado encontrado:" + employee);


        /*System.out.println("---------Crear un nuevo empleado---------");
        Employee newEmployee = new Employee();
        newEmployee.setFirst_name("Juan");
        newEmployee.setPa_surname("Perez");
        newEmployee.setMa_surname("Gomez");
        newEmployee.setEmail("juan@example.com");
        newEmployee.setSalary(89000F);
        em.getTransaction().begin();
        em.persist(newEmployee);
        em.getTransaction().commit();
        System.out.println("Nuevo empleado creado:" + newEmployee);*/


        /*System.out.println("---------Actualizar un empleado---------");
        int employeeToUpdateId = 2;
        Employee employeeToUpdate = em.find(Employee.class, employeeToUpdateId);
        System.out.println("Empleado a actualizar:" + employeeToUpdate);
        employeeToUpdate.setFirst_name("Pancho");
        employeeToUpdate.setPa_surname("Lopez");
        employeeToUpdate.setMa_surname("Perez");
        employeeToUpdate.setSalary(97000F);
        em.getTransaction().begin();
        em.merge(employeeToUpdate);
        em.getTransaction().commit();
        System.out.println("Empleado actualizado:" + employeeToUpdate);*/

        System.out.println("---------Eliminar un empleado---------");
        int employeeToDeleteId = 1;
        Employee employeeToDelete = em.find(Employee.class, employeeToDeleteId);
        System.out.println("Empleado a eliminar:" + employeeToDelete);
        em.getTransaction().begin();
        em.remove(employeeToDelete);
        em.getTransaction().commit();
        em.close();



    }

}

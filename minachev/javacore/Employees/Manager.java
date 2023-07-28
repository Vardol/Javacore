package ru.minachev.javacore.Employees;

//Опишите класс руководителя, наследник от сотрудника.
// Перенесите статический метод повышения зарплаты в класс руководителя,
// модифицируйте метод таким образом, чтобы он мог поднять заработную плату всем, кроме руководителей.



public class Manager extends Employee {

    public Manager(String fullName, String position, String phone, int age, int salary) {
        super(fullName, position, phone, age, salary);
    }

    //– Написать тот же метод повышения в качестве статического в классе сотрудника. Метод должен принимать в качестве параметра массив сотрудников.
    public static void raiseSalaryAboveAge(Employee[] employees, int ageCriteria, int salaryRaise){
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getAge() > ageCriteria && !(employees[i] instanceof Manager)){
                employees[i].setSalary(employees[i].getSalary() + salaryRaise);
            }
        }
    }
}

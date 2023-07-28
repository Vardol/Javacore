package ru.minachev.javacore.Employees;

public class Main {
    //– Создать метод, повышающий зарплату всем сотрудникам старше 45 лет на 5000. Возраст и размер повышения должны быть параметрами метода.

    public static void raiseSalaryAboveAge(Employee[] employees, int ageCriteria, int salaryRaise){
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getAge() > ageCriteria){
                employees[i].setSalary(employees[i].getSalary() + salaryRaise);
            }
        }
    }

        //– Написать методы (принимающие на вход массив сотрудников), вычисляющие средний возраст и среднюю зарплату сотрудников, вывести результаты работы в консоль.
        public static float averageAge(Employee[] employees){
            float avgAge = 0;
            if (employees == null || employees.length < 1){
                System.out.println("Empty list.");
                return -1;
            }
            for (int i = 0; i < employees.length; i++) {
                avgAge += employees[i].getAge();
            }

            avgAge /= employees.length;
            System.out.println("Average age = " + avgAge);
            return avgAge;
        }

    public static float averageWage(Employee[] employees){
        float avgWage = 0;
        if (employees == null || employees.length < 1){
            System.out.println("Empty list.");
            return -1;
        }
        for (int i = 0; i < employees.length; i++) {
            avgWage += employees[i].getSalary();
        }

        avgWage /= employees.length;
        System.out.println("Average wage = " + avgWage);
        return avgWage;
    }


    public static void main(String[] args) {
        //– Создать массив из 5 сотрудников
        Employee[] employees = new Employee[6];


        employees[0] = new Employee("Name1", "Junior", "7999999999", 25, 50000);
        employees[1] = new Employee("Name2", "Junior", "7999983799", 23, 55000);
        employees[2] = new Employee("Name3", "Middle", "7999789999", 32, 100000);
        employees[3] = new Employee("Name4", "Middle", "7928799999", 37, 150000);
        employees[4] = new Employee("Name5", "Senior", "7999923456", 47, 300000);
        employees[5] = new Manager("Mr. Boss", "Manager", "7999923456", 18, 3000000);
        System.out.println("-------------------------------------");

        for (int i = 0; i < employees.length; i++) {
        System.out.println(employees[i]);
        }

        //Применяем местный метод
        raiseSalaryAboveAge(employees, 45, 5000);
        System.out.println("-------------------------------------");

        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }

// В основной программе создайте руководителя и поместите его в общий массив сотрудников.
// Повысьте зарплату всем сотрудникам и проследите, чтобы зарплата руководителя не повысилась.
        Manager.raiseSalaryAboveAge(employees,0,10000);

        System.out.println("-------------------------------------");

        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }


        //тестим методы расчета средних
        averageAge(employees);
        averageWage(employees);


    }
}

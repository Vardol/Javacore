package ru.minachev.javacore.Employees;

//– Создать класс ”Сотрудник”с полями: ФИО, должность, телефон, зарплата, возраст;
public class Employee {
    private String fullName;
    private String position;
    private String phone;
    private int age;
    private int salary;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Employee(String fullName, String position, String phone, int age, int salary) {
        this.fullName = fullName;
        this.position = position;
        this.phone = phone;
        this.age = age;
        this.salary = salary;
    }

    //– Написать метод выводящую всю доступную информацию об объекте с использованием форматирования строк.
    //Я счел, что этим методом д.б. toString()
    @Override
    public String toString() {
        return String.format("%s, %d y/o, %s, salary %d rub, contacts: %s", this.fullName, this.age, this.position,
                this.salary, this.phone);
    }


}

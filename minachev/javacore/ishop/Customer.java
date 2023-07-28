package ru.minachev.javacore.ishop;

public class Customer {
    private String fullName;
    private int age;
    private String phone;


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Customer(String fullName, int age, String phone) {
        if (fullName.equals("")){
            fullName = "n/a";
        }



        this.fullName = fullName;

        if (age < 0){
            age = 0;
        }
        this.age = age;

        if (phone.equals("")){
            phone = "n/a";
        }
        this.phone = phone;
    }
}

package ru.minachev.javacore.ishop;

/*
1. Написать классы покупатель (ФИО, возраст, телефон), товар (название, цена) и заказ (объект покупатель, объект товар, целочисленное количество).
2. Создать массив покупателей (инициализировать 2 элемента), массив товаров (инициализировать 5 элементов) и массив заказов (пустой на 5 элементов).
3. Создать статический метод «совершить покупку» со строковыми параметрами, соответствующими полям объекта заказа. Метод должен вернуть объект заказа.
4. Если в метод передан несуществующий покупатель – метод должен выбросить исключение CustomerException, если передан несуществующий товар, метод олжен выбросить исключение ProductException, если было передано отрицательное или слишком больше значение количества (например, 100), метод должен выбросить исключение AmountException.
5. Вызвать метод совершения покупки несколько раз таким образом, чтобы заполнить массив покупок возвращаемыми значениями. Обработать исключения следующим образом (в заданном порядке):
–если был передан неверный товар – вывести в консоль сообщение об ошиб-
ке, не совершать данную покупку;
– если было передано неверное количество – купить товар в количестве 1;
–если был передан неверный пользователь – завершить работу приложения с исключением.
6. Вывести в консоль итоговое количество совершённых покупок после выполнения основного кода приложения.
*/


import ru.minachev.javacore.ishop.exceptions.AmountException;
import ru.minachev.javacore.ishop.exceptions.CustomerException;
import ru.minachev.javacore.ishop.exceptions.ProductException;

public class Main {

    //объявляю здесь массивы, чтобы работать с ними внутри статичного класса
    public static Customer[] customers = new Customer[2];

    public static Item[] items = new Item[5];
    public static Order[] orders = new Order[5];


/*  3. Создать статический метод «совершить покупку» со строковыми параметрами, соответствующими полям объекта заказа.
    Метод должен вернуть объект заказа.
      4. Если в метод передан несуществующий покупатель – метод должен выбросить исключение CustomerException,
      если передан несуществующий товар, метод олжен выбросить исключение ProductException, если было передано
      отрицательное или слишком больше значение количества (например, 100), метод должен выбросить исключение
      AmountException.
*/

    public static Order makeOrder(String customer, String item, int amount) throws CustomerException, AmountException, ProductException {
        boolean invalidCustomer = true;
        boolean invalidItem = true;
        boolean invalidAmount = true;
        Customer orderCustomer = null;
        Item orderItem = null;
        int orderAmount = 0;

        for (int i = 0; i < customers.length; i++) {
            if (customer.equals(customers[i].getFullName())) {
                invalidCustomer = false;
                orderCustomer = customers[i];
                break;
            }
        }

        if (invalidCustomer) {
            throw new CustomerException("Customer not found!");
        }

        for (int i = 0; i < items.length; i++) {
            if (item.equals(items[i].getName())) {
                invalidItem = false;
                orderItem = items[i];
                break;
            }
        }

        if (invalidItem) {
            throw new ProductException("Item not found!");
        }

        if (amount > 0 && amount < 100) {
            orderAmount = amount;
            invalidAmount = false;
        }

        //вообще, если мы хотим приводить некорректное количество просто к единице,
        // то на мой взгляд было бы корректно внутри этого метода обрабатывать некорректное количество,
        // но поскольку в задаче сказано выбросить эксепшн в методе и обработать снаружи - я таки сделаю
        if (invalidAmount) {
            throw new AmountException("Invalid amount!");
        }

        return new Order(orderCustomer, orderItem, orderAmount);
    }

    public static void main(String[] args) {
        customers[0] = new Customer("Name1", 20, "+791385135468");
        customers[1] = new Customer("Name2", 30, "+791742136758");

        items[0] = new Item("Item 1", 100);
        items[1] = new Item("Item 2", 200);
        items[2] = new Item("Item 3", 300);
        items[3] = new Item("Item 4", 400);
        items[4] = new Item("Item 5", 500);

        /*
5. Вызвать метод совершения покупки несколько раз таким образом, чтобы заполнить массив покупок возвращаемыми значениями.
 Обработать исключения следующим образом (в заданном порядке):
– если был передан неверный товар – вывести в консоль сообщение об ошибке, не совершать данную покупку;
– если было передано неверное количество – купить товар в количестве 1;
– если был передан неверный пользователь – завершить работу приложения с исключением.
         */

        int amount = 105;
            try {
                orders[0] = makeOrder("Name1", "Item 2", amount);

            } catch (ProductException e) {
                System.out.println(e.getMessage());
            } catch (AmountException e) {
                // мне кажется это некорректная обработка такого кейса, здесь не нужно было в самом методе бросать эксепшн,
                // т.к. мы просто хотим сменить в этом случае значение вводного параметра
                // но поскольку в задаче так сказано - так и делаю
                orders[0] = new Order(customers[0], items[1],1);

            } catch (CustomerException e) {
                System.exit(1);
            }

            amount = 4;
            try {
            orders[1] = makeOrder("Name2", "Item 8", amount);

        } catch (ProductException e) {
            System.out.println(e.getMessage());
        } catch (AmountException e) {
            // в последующих вызовах метода не буду этот эксепшн обрабатывать, т.к. это порнуха какая-то
        } catch (CustomerException e) {
            System.exit(1);
        }

        amount = 2;
        try {
            orders[2] = makeOrder("Name2", "Item 1", amount);

        } catch (ProductException e) {
            System.out.println(e.getMessage());
        } catch (AmountException e) {
            // в последующих вызовах метода не буду этот эксепшн обрабатывать, т.к. это порнуха какая-то
        } catch (CustomerException e) {
            System.exit(1);
        }

        int count = 0;
        for (Order o:orders) {
            if (o != null){
                count++;
            }
        }
        System.out.println("Всего было " + count + " успешных заказов.");

        amount = 2;
        try {
            orders[2] = makeOrder("Name5", "Item 1", amount);

        } catch (ProductException e) {
            System.out.println(e.getMessage());
        } catch (AmountException e) {
            // в последующих вызовах метода не буду этот эксепшн обрабатывать, т.к. это порнуха какая-то
        } catch (CustomerException e) {
            System.exit(10);
        }
    }

}

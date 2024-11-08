package org.example;


import org.example.interfaces.Input;
import org.example.interfaces.Service;
import org.example.model.Clothes;
import org.example.model.Customer;
import org.example.model.Order;

public class App implements Input {

    private final Service<Clothes> clothingService;
    private final Service<Customer> customerService;
    private final Service<Order> orderService;

    public App(Service<Clothes> clothingService, Service<Customer> customerService, Service<Order> orderService) {
        this.clothingService = clothingService;
        this.customerService = customerService;
        this.orderService = orderService;
    }

    public void run() {
        System.out.println("------ Магазин одежды ------");
        System.out.println("----------------------------");
        boolean repeat = true;
        do {
            System.out.println("Список задач: ");
            System.out.println("0. Выйти из программы");
            System.out.println("1. Добавить одежду");
            System.out.println("2. Список одежды");
            System.out.println("3. Редактировать одежду");
            System.out.println("4. Удалить одежду");
            System.out.println("5. Добавить клиента");
            System.out.println("6. Список клиентов");
            System.out.println("7. Редактировать клиента");
            System.out.println("8. Удалить клиента");
            System.out.println("9. Оформить заказ");
            System.out.println("10. Список заказов");

            System.out.print("Введите номер задачи: ");
            int task = Integer.parseInt(getString());
            switch (task) {
                case 0:
                    repeat = false;
                    break;
                case 1:
                    System.out.println("----- Добавление одежды -----");
                    if (clothingService.add()) {
                        System.out.println("Одежда добавлена");
                    } else {
                        System.out.println("Одежду добавить не удалось");
                    }
                    break;
                case 2:
                    System.out.println("----- Список одежды -----");
                    clothingService.print();
                    break;
                case 3:
                    System.out.println("----- Редактирование одежды -----");
                    System.out.print("Введите название одежды для редактирования: ");
                    String clothingName = getString();
                    Clothes clothesToEdit = new Clothes(clothingName, "", "", "",0.0);
                    if (clothingService.edit(clothesToEdit)) {
                        System.out.println("Одежда успешно отредактирована");
                    } else {
                        System.out.println("Одежда не найдена");
                    }
                    break;
                case 4:
                    System.out.println("----- Удаление одежды -----");
                    System.out.print("Введите название одежды для удаления: ");
                    String clothingNameToDelete = getString();
                    Clothes clothesToDelete = new Clothes(clothingNameToDelete, "", "", "",0.0);
                    if (clothingService.remove(clothesToDelete)) {
                        System.out.println("Одежда успешно удалена");
                    } else {
                        System.out.println("Одежда не найдена");
                    }
                    break;
                case 5:
                    System.out.println("----- Добавление клиента -----");
                    if (customerService.add()) {
                        System.out.println("Клиент добавлен");
                    } else {
                        System.out.println("Клиента добавить не удалось");
                    }
                    break;
                case 6:
                    System.out.println("----- Список клиентов -----");
                    customerService.print();
                    break;
                case 7:
                    System.out.println("----- Редактирование клиента -----");
                    System.out.print("Введите фамилию клиента для редактирования: ");
                    String customerLastName = getString();
                    System.out.print("Введите имя клиента для редактирования: ");
                    String customerFirstName = getString();
                    Customer customerToEdit = new Customer(customerFirstName, customerLastName);
                    if (customerService.edit(customerToEdit)) {
                        System.out.println("Клиент успешно отредактирован");
                    } else {
                        System.out.println("Клиент не найден");
                    }
                    break;
                case 8:
                    System.out.println("----- Удаление клиента -----");
                    System.out.print("Введите фамилию клиента для удаления: ");
                    String customerLastNameToDelete = getString();
                    System.out.print("Введите имя клиента для удаления: ");
                    String customerFirstNameToDelete = getString();
                    Customer customerToDelete = new Customer(customerFirstNameToDelete, customerLastNameToDelete);
                    if (customerService.remove(customerToDelete)) {
                        System.out.println("Клиент успешно удален");
                    } else {
                        System.out.println("Клиент не найден");
                    }
                    break;
                case 9:
                    System.out.println("----- Оформление заказа -----");
                    if (orderService.add()) {
                        System.out.println("Заказ оформлен");
                    } else {
                        System.out.println("Не удалось оформить заказ");
                    }
                    break;
                case 10:
                    System.out.println("----- Список заказов -----");
                    orderService.print();
                    break;
                default:
                    System.out.println("Неверный номер задачи, попробуйте снова.");
            }
            System.out.println("----------------------------");
        } while (repeat);
        System.out.println("До свидания :)");
    }
}

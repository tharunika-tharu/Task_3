package Solution2;

import java.util.Scanner;
//taxable interface
interface Taxable {
    double SALES_TAX = 0.07;
    double INCOME_TAX = 0.105;
    //abstract method
    double calcTax();
}

//class employee for employee information
class Employee implements Taxable {
    private int empID;
    private String name;
    private double salary;

    public Employee(int empID, String name, double salary) {
        this.empID = empID;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public double calcTax() {
        return salary * INCOME_TAX;
    }

    @Override
    public String toString() {
        return "Employee[ID: " + empID + ", Name: " + name + ", Salary: " + salary + "]";
    }
}
//class product for product information
class Product implements Taxable {
    private int pid;
    private int price;
    private int quantity;

    public Product(int pid, int price, int quantity) {
        this.pid = pid;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public double calcTax() {
        return price * SALES_TAX;
    }

    @Override
    public String toString() {
        return "Product[ID: " + pid + ", Price: " + price + ", Quantity: " + quantity + "]";
    }
}

public class DriverMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //accept employee information
        System.out.println("Enter Employee Details");
        System.out.print("Employee ID: ");
        int empID = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Salary: ");
        double salary = scanner.nextDouble();

        Employee employee = new Employee(empID, name, salary);
        double incomeTax = employee.calcTax();
        System.out.println(employee);
        System.out.println("Income Tax: " + incomeTax);

        //accept product information
        System.out.println("\nEnter Product Details");
        System.out.print("Product ID: ");
        int pid = scanner.nextInt();
        System.out.print("Price: ");
        int price = scanner.nextInt();
        System.out.print("Quantity: ");
        int quantity = scanner.nextInt();

        Product product = new Product(pid, price, quantity);
        double salesTax = product.calcTax();
        System.out.println(product);
        System.out.println("Sales Tax per Unit: " + salesTax);
    }
}

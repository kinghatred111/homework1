import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class HotDrink {
    private String name;
    private int volume;
    private int temperature;

    public HotDrink(String name, int volume, int temperature) {
        this.name = name;
        this.volume = volume;
        this.temperature = temperature;
    }

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }

    public int getTemperature() {
        return temperature;
    }

    @Override
    public String toString() {
        return "HotDrink{" +
                "name='" + name + '\'' +
                ", volume=" + volume +
                ", temperature=" + temperature +
                '}';
    }
}

interface VendingMachine {
    HotDrink getProduct(String name, int volume, int temperature);
}

class HotDrinkVendingMachine implements VendingMachine {
    private List<HotDrink> drinks;

    public HotDrinkVendingMachine() {
        this.drinks = new ArrayList<>();
    }

    public void addDrink(HotDrink drink) {
        drinks.add(drink);
    }

    @Override
    public HotDrink getProduct(String name, int volume, int temperature) {
        for (HotDrink drink : drinks) {
            if (drink.getName().equals(name) && drink.getVolume() == volume && drink.getTemperature() == temperature) {
                return drink;
            }
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        HotDrink tea = new HotDrink("Чай", 200, 80);
        HotDrink coffee = new HotDrink("Кофе", 150, 90);
        HotDrink cocoa = new HotDrink("Какао", 250, 70);

        HotDrinkVendingMachine machine = new HotDrinkVendingMachine();
        machine.addDrink(tea);
        machine.addDrink(coffee);
        machine.addDrink(cocoa);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите название напитка:");
        String name = scanner.nextLine();

        System.out.println("Введите объем напитка:");
        int volume = scanner.nextInt();

        System.out.println("Введите температуру напитка:");
        int temperature = scanner.nextInt();

        HotDrink drink = machine.getProduct(name, volume, temperature);
        if (drink != null) {
            System.out.println("Выданный напиток: " + drink);
        } else {
            System.out.println("Напиток не найден.");
        }

        scanner.close();
    }
}

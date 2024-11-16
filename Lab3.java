import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class Lab3 {

    // Поля класу меблі
    private final String name;
    private final String material;
    private final double price;
    private final int weight;
    private final double height;

    // Конструктор
    public Lab3(String name, String material, double price, int weight, double height) {
        this.name = name;
        this.material = material;
        this.price = price;
        this.weight = weight;
        this.height = height;
    }

    // Гетери для доступу до полів
    public double getPrice() {
        return price;
    }

    public double getHeight() {
        return height;
    }

    // Перевизначення equals для пошуку ідентичного об'єкта
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lab3 furniture = (Lab3) o;
        return Double.compare(furniture.price, price) == 0 && Double.compare(furniture.height, height) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, height);
    }

    // Метод для виводу інформації про об'єкт
    @Override
    public String toString() {
        return String.format("%-10s | %-8s | %8.2f | %6d | %6.2f", name, material,
                price, weight, height);
    }

    // Виконавчий метод
    public static void main(String[] args) {
        // Створюємо масив об'єктів класу Lab3 (меблі)
        Lab3[] furnitureArray = {
                new Lab3("Table", "Wood", 150.0, 20, 0.75),
                new Lab3("Chair", "Plastic", 50.0, 5, 0.45),
                new Lab3("Sofa", "Fabric", 300.0, 50, 1.2),
                new Lab3("Cupboard", "Metal", 200.0, 40, 1.5),
                new Lab3("Desk", "Wood", 120.0, 25, 0.8)
        };

        // Виводимо заголовки таблиці
        printHeader();

        // Сортування за ціною за зростанням
        Arrays.sort(furnitureArray, Comparator.comparingDouble(Lab3::getPrice));
        System.out.println("Сортування за ціною за зростанням:");
        printHeader();
        for (Lab3 furniture : furnitureArray) {
            System.out.println(furniture);
        }

        // Сортування за висотою за спаданням
        Arrays.sort(furnitureArray, Comparator.comparingDouble(Lab3::getHeight).reversed());
        System.out.println("\nСортування за висотою за спаданням:");
        printHeader();
        for (Lab3 furniture : furnitureArray) {
            System.out.println(furniture);
        }

        // Шукаємо ідентичний об'єкт
        Lab3 searchFurniture = new Lab3("Desk", "Wood",
                120.0, 25, 0.8);
        boolean found = Arrays.asList(furnitureArray).contains(searchFurniture);

        // Результат пошуку
        if (found) {
            System.out.println("\nІдентичний об'єкт знайдено: " + searchFurniture);
        } else {
            System.out.println("\nІдентичний об'єкт не знайдено.");
        }
    }

    // Метод для виводу заголовків таблиці
    public static void printHeader() {
        System.out.println("-------------------------------------------------------------------");
        System.out.printf("%-10s | %-8s | %8s | %6s | %6s%n", "Name", "Material", "Price", "Weight", "Height");
        System.out.println("-------------------------------------------------------------------");
    }
}

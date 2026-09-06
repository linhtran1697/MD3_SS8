import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Animals> animalList = new ArrayList<>();

        try {
            animalList.add(
                    new Dog("Milo", 3, "Golden Retriever")
            );

            animalList.add(
                    new Cat("Luna", 2, "Trắng")
            );

            animalList.add(
                    new Dog("Buddy", 5, "Poodle")
            );

            animalList.add(
                    new Cat("Mimi", 1, "Vàng")
            );

            for (Animals animal : animalList) {
                System.out.println("--------------------");

                animal.displayInfo();

                System.out.println(
                        "Âm thanh: " + animal.makeSound()
                );
            }
        } catch (IllegalArgumentException e) {
            System.out.println(
                    "Dữ liệu không hợp lệ: " + e.getMessage()
            );
        }
    }
}
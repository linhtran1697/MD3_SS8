public class Animals {
    private String name;
    private int age;

    public Animals(String name, int age) {
        setName(name);
        setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Tên động vật không được để trống"
            );
        }

        this.name = name.trim();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException(
                    "Tuổi không được là số âm"
            );
        }

        this.age = age;
    }

    public String makeSound() {
        return "Some generic sound";
    }

    public void displayInfo() {
        System.out.println("Tên: " + name);
        System.out.println("Tuổi: " + age);
    }
}


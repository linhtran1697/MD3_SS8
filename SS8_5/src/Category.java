public class Category {
    private int id;
    private String name;
    private String description;

    // Constructor không tham số
    public Category() {
    }

    // Constructor đầy đủ tham số
    public Category(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    // Getter và Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Hiển thị thông tin danh mục
    public void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Tên danh mục: " + name);
        System.out.println("Mô tả: " + description);
    }
}

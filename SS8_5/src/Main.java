import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CategoryManagement management =
                new CategoryManagement();

        int choice;

        do {
            displayMenu();
            choice = inputInteger(
                    scanner,
                    "Nhập lựa chọn của bạn: "
            );

            switch (choice) {
                case 1:
                    addCategory(scanner, management);
                    break;

                case 2:
                    displayCategories(management);
                    break;

                case 3:
                    updateCategory(scanner, management);
                    break;

                case 4:
                    deleteCategory(scanner, management);
                    break;

                case 5:
                    System.out.println("Đã thoát chương trình.");
                    break;

                default:
                    System.out.println(
                            "Lựa chọn không hợp lệ. Vui lòng chọn từ 1 đến 5."
                    );
            }
        } while (choice != 5);

        scanner.close();
    }

    // Hiển thị menu
    public static void displayMenu() {
        System.out.println("\n========== QUẢN LÝ DANH MỤC ==========");
        System.out.println("1. Thêm danh mục");
        System.out.println("2. Hiển thị danh sách danh mục");
        System.out.println("3. Cập nhật danh mục");
        System.out.println("4. Xóa danh mục");
        System.out.println("5. Thoát");
        System.out.println("=======================================");
    }

    // Chức năng thêm danh mục
    public static void addCategory(
            Scanner scanner,
            CategoryManagement management
    ) {
        System.out.println("\n--- THÊM DANH MỤC ---");

        int id = inputPositiveId(scanner);

        if (management.findById(id) != null) {
            System.out.println("ID danh mục đã tồn tại.");
            return;
        }

        String name = inputNotEmpty(
                scanner,
                "Nhập tên danh mục: "
        );

        String description = inputNotEmpty(
                scanner,
                "Nhập mô tả: "
        );

        Category category =
                new Category(id, name, description);

        management.addCategory(category);
    }

    // Chức năng hiển thị
    public static void displayCategories(
            CategoryManagement management
    ) {
        System.out.println("\n--- DANH SÁCH DANH MỤC ---");

        Category[] categories = management.findAll();

        if (categories.length == 0) {
            System.out.println("Danh sách danh mục đang trống.");
            return;
        }

        for (Category category : categories) {
            System.out.println("-------------------------");
            category.displayInfo();
        }
    }

    // Chức năng cập nhật
    public static void updateCategory(
            Scanner scanner,
            CategoryManagement management
    ) {
        System.out.println("\n--- CẬP NHẬT DANH MỤC ---");

        int id = inputInteger(
                scanner,
                "Nhập ID danh mục cần cập nhật: "
        );

        Category oldCategory = management.findById(id);

        if (oldCategory == null) {
            System.out.println(
                    "Không tìm thấy danh mục có ID: " + id
            );
            return;
        }

        System.out.println("Thông tin hiện tại:");
        oldCategory.displayInfo();

        String newName = inputNotEmpty(
                scanner,
                "Nhập tên mới: "
        );

        String newDescription = inputNotEmpty(
                scanner,
                "Nhập mô tả mới: "
        );

        Category updatedCategory =
                new Category(id, newName, newDescription);

        management.updateCategory(updatedCategory);
    }

    // Chức năng xóa
    public static void deleteCategory(
            Scanner scanner,
            CategoryManagement management
    ) {
        System.out.println("\n--- XÓA DANH MỤC ---");

        int id = inputInteger(
                scanner,
                "Nhập ID danh mục cần xóa: "
        );

        management.deleteById(id);
    }

    // Nhập số nguyên và xử lý nhập sai
    public static int inputInteger(
            Scanner scanner,
            String message
    ) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println(
                        "Dữ liệu không hợp lệ. Vui lòng nhập số nguyên."
                );
            }
        }
    }

    // Kiểm tra ID phải lớn hơn 0
    public static int inputPositiveId(Scanner scanner) {
        while (true) {
            int id = inputInteger(scanner, "Nhập ID: ");

            if (id > 0) {
                return id;
            }

            System.out.println("ID phải lớn hơn 0.");
        }
    }

    // Kiểm tra chuỗi không được để trống
    public static String inputNotEmpty(
            Scanner scanner,
            String message
    ) {
        while (true) {
            System.out.print(message);
            String value = scanner.nextLine().trim();

            if (!value.isEmpty()) {
                return value;
            }

            System.out.println(
                    "Thông tin không được để trống."
            );
        }
    }
}
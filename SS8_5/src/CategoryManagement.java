public class CategoryManagement implements ICRUD {
    private Category[] categories;

    public CategoryManagement() {
        categories = new Category[0];
    }

    @Override
    public Category[] findAll() {
        return categories;
    }

    @Override
    public void addCategory(Category category) {
        // Kiểm tra ID đã tồn tại hay chưa
        if (findById(category.getId()) != null) {
            System.out.println("ID danh mục đã tồn tại.");
            return;
        }

        // Tạo mảng mới lớn hơn mảng cũ một phần tử
        Category[] newCategories =
                new Category[categories.length + 1];

        // Sao chép dữ liệu từ mảng cũ
        for (int i = 0; i < categories.length; i++) {
            newCategories[i] = categories[i];
        }

        // Thêm danh mục mới vào vị trí cuối
        newCategories[newCategories.length - 1] = category;

        // Gán lại mảng
        categories = newCategories;

        System.out.println("Thêm danh mục thành công.");
    }

    @Override
    public void updateCategory(Category category) {
        for (int i = 0; i < categories.length; i++) {
            if (categories[i].getId() == category.getId()) {
                categories[i].setName(category.getName());
                categories[i].setDescription(
                        category.getDescription()
                );

                System.out.println("Cập nhật danh mục thành công.");
                return;
            }
        }

        System.out.println("Không tìm thấy danh mục có ID: "
                + category.getId());
    }

    @Override
    public void deleteById(int id) {
        int deleteIndex = -1;

        // Tìm vị trí cần xóa
        for (int i = 0; i < categories.length; i++) {
            if (categories[i].getId() == id) {
                deleteIndex = i;
                break;
            }
        }

        if (deleteIndex == -1) {
            System.out.println(
                    "Không tìm thấy danh mục có ID: " + id
            );
            return;
        }

        // Tạo mảng mới nhỏ hơn mảng cũ một phần tử
        Category[] newCategories =
                new Category[categories.length - 1];

        int newIndex = 0;

        for (int i = 0; i < categories.length; i++) {
            if (i != deleteIndex) {
                newCategories[newIndex] = categories[i];
                newIndex++;
            }
        }

        categories = newCategories;

        System.out.println("Xóa danh mục thành công.");
    }

    // Phương thức hỗ trợ tìm danh mục theo ID
    public Category findById(int id) {
        for (Category category : categories) {
            if (category.getId() == id) {
                return category;
            }
        }

        return null;
    }
}

import java.util.*;

interface ProductCategory {
    String getCategoryName();
}

class BookCategory implements ProductCategory {
    private String name;

    public BookCategory(String name) {
        this.name = name;
    }

    @Override
    public String getCategoryName() {
        return "Book - " + name;
    }
}

class ClothingCategory implements ProductCategory {
    private String name;

    public ClothingCategory(String name) {
        this.name = name;
    }

    @Override
    public String getCategoryName() {
        return "Clothing - " + name;
    }
}

class GadgetCategory implements ProductCategory {
    private String name;

    public GadgetCategory(String name) {
        this.name = name;
    }

    @Override
    public String getCategoryName() {
        return "Gadget - " + name;
    }
}

class Product<T extends ProductCategory> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public T getCategory() {
        return category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void displayInfo() {
        System.out.println(name + " | " + category.getCategoryName() + " | Price: ₹" + price);
    }
}

class DiscountUtil {
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double discountAmount = product.getPrice() * (percentage / 100);
        product.setPrice(product.getPrice() - discountAmount);
        System.out.println("Applied " + percentage + "% discount on " + product.getName() + ": New Price ₹" + product.getPrice());
    }
}

public class Main {
    public static void main(String[] args) {
        List<Product<? extends ProductCategory>> catalog = new ArrayList<>();

        Product<BookCategory> book = new Product<>("The Alchemist", 499.0, new BookCategory("Fiction"));
        Product<ClothingCategory> tshirt = new Product<>("Graphic Tee", 799.0, new ClothingCategory("Casual"));
        Product<GadgetCategory> smartphone = new Product<>("Smartphone X", 25999.0, new GadgetCategory("Mobile"));

        catalog.add(book);
        catalog.add(tshirt);
        catalog.add(smartphone);

        System.out.println("Product Catalog:");
        for (Product<? extends ProductCategory> product : catalog) {
            product.displayInfo();
        }

        System.out.println("\nApplying Discounts:");
        DiscountUtil.applyDiscount(book, 10);
        DiscountUtil.applyDiscount(tshirt, 20);
        DiscountUtil.applyDiscount(smartphone, 15);
    }
}

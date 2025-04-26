import java.util.*;

class ShoppingCartSystem {
    private Map<String, Double> productPrices = new HashMap<>();
    private LinkedHashMap<String, Integer> cart = new LinkedHashMap<>();

    public void addProductToStore(String product, double price) {
        productPrices.put(product, price);
    }

    public void addToCart(String product, int quantity) {
        if (!productPrices.containsKey(product)) {
            System.out.println("Product '" + product + "' is not available in the store.");
            return;
        }
        cart.put(product, cart.getOrDefault(product, 0) + quantity);
    }

    public void displayCartInOrder() {
        System.out.println("\n🛒 Items in Cart (Order Added):");
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            String product = entry.getKey();
            int quantity = entry.getValue();
            double price = productPrices.get(product);
            System.out.printf("%s - Qty: %d, Price: %.2f each\n", product, quantity, price);
        }
    }

    public void displayCartSortedByPrice() {
        TreeMap<Double, List<String>> sortedByPrice = new TreeMap<>();

        for (String product : cart.keySet()) {
            double price = productPrices.get(product);
            sortedByPrice.putIfAbsent(price, new ArrayList<>());
            sortedByPrice.get(price).add(product);
        }

        System.out.println("\n💲 Items Sorted by Price:");
        for (Map.Entry<Double, List<String>> entry : sortedByPrice.entrySet()) {
            for (String product : entry.getValue()) {
                int quantity = cart.get(product);
                System.out.printf("%s - Qty: %d, Price: %.2f each\n", product, quantity, entry.getKey());
            }
        }
    }
    public void displayTotalBill() {
        double total = 0;
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            total += entry.getValue() * productPrices.get(entry.getKey());
        }
        System.out.printf("\n🧾 Total Bill: ₹%.2f\n", total);
    }

    public static void main(String[] args) {
        ShoppingCartSystem shop = new ShoppingCartSystem();

        shop.addProductToStore("Apple", 20.0);
        shop.addProductToStore("Banana", 10.0);
        shop.addProductToStore("Mango", 30.0);
        shop.addProductToStore("Orange", 25.0);

        shop.addToCart("Apple", 2);
        shop.addToCart("Banana", 5);
        shop.addToCart("Orange", 3);
        shop.addToCart("Mango", 1);

        shop.displayCartInOrder();
        shop.displayCartSortedByPrice();
        shop.displayTotalBill();
    }
}

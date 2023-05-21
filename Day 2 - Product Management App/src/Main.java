import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductService service = new ProductService();

        // hey service, add the products...
        service.addProduct(new Product("Realme Tab", "Tablet", "Backpack", 2022));
        service.addProduct(new Product("Black Dell Notebook", "Laptop", "Study Table", 2019));
        service.addProduct(new Product("Black Oneplus Buds", "Earphones", "Backpack", 2022));
        service.addProduct(new Product("Infinity Headphone", "Earphones", "Cupboard", 2019));
        service.addProduct(new Product("Type C", "Cable", "Cupboard", 2019));
        service.addProduct(new Product("Redgear Gaming Mouse", "Mouse", "Study Table", 2023));


        List<Product> products = service.getAllProducts();

        for(Product product: products) {
            System.out.println(product);
        }
        System.out.println("================================================");

        System.out.println("A Particular Product");

        Product p = service.getProductByName("Infinity Headphone");
        System.out.println(p);

        System.out.println("=================================================");
        System.out.println("A Particular text");

        List<Product> productsBasedOnText = service.getProductsWithText("black");
        for(Product product: productsBasedOnText) {
            System.out.println(product);
        }
        System.out.println(); 

        System.out.println("=================================================");
        System.out.println("A Particular Place");

        List<Product> productsBasedOnPlace = service.getProductsWithPlace("backpack");
        for(Product product: productsBasedOnPlace) {
            System.out.println(product);
        }
        System.out.println();
        
        System.out.println("=================================================");
        System.out.println("Products Out Of Warranty");

        List<Product> productsOutOfWarranty = service.getProductsOutOfWarranty();
        for(Product product: productsOutOfWarranty) {
            System.out.println(product);
        }
        System.out.println();
    }
}

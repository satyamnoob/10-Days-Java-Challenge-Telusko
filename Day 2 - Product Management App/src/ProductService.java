import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductService {
    
    List<Product> products = new ArrayList<>();

    public void addProduct(Product p) {
        products.add(p);
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProductByName(String name) {
        // for (Product product : products) {
        //     if(product.getName().equals(name)) {
        //         return product;
        //     } 
        // }

        // return null;

        List<Product> productByName = products.stream()
                       .filter(product -> product.getName().equalsIgnoreCase(name))
                       .collect(Collectors.toList());
        
        return productByName.isEmpty() ? null : productByName.get(0);
    }

    public List<Product> getProductsWithText(String text) {
        final String textLowerCase = text.toLowerCase();
        // List<Product> productsBasedOnTexList = new ArrayList<>();
        
        // for (Product product : products) {
        //     String name = product.getName().toLowerCase();
        //     String type = product.getType().toLowerCase();
        //     String place = product.getPlace().toLowerCase();

        //     if(name.contains(text) || type.contains(text) || place.contains(text)) {
        //         productsBasedOnTexList.add(product);
        //     } 
        // }

        // return productsBasedOnTexList;

        return products.stream()
                .filter(product -> product.getName().toLowerCase().contains(textLowerCase) || 
                                   product.getType().toLowerCase().contains(textLowerCase) || 
                                   product.getPlace().toLowerCase().contains(textLowerCase))
                .collect(Collectors.toList());
    }

    public List<Product> getProductsWithPlace(String place) {
        return products.stream()
                       .filter(product -> product.getPlace().equalsIgnoreCase(place))
                       .collect(Collectors.toList());
    }

    public List<Product> getProductsOutOfWarranty() {
        int currentYear = Year.now().getValue();

        return products.stream()
                       .filter(product -> product.getWarranty() < currentYear)
                       .collect(Collectors.toList()); 
    }


}

import java.io.*;


public class test {
    public static void main(String[] args) {

//        ProductsToArrayReader xxx = new ProductsToArrayReader("products.csv");
        Product[] products = new Product[0];
        try {
            products = Operations.prodToArrayReader("products.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Operations.printProducts(products);

        System.out.println("Suma cen produktów:" + Operations.priceSum(products));

        String mostExpensiveProduct = Operations.mostExProd(products).toString();
        System.out.println("najdroższy produkt to: " + mostExpensiveProduct);

        String bestProducer = Operations.bestProducer(products);
        System.out.println("The Winner is...  " + bestProducer +  "!!! ;-)");

    }
}


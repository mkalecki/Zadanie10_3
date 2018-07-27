import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Operations {

    public static Product[] prodToArrayReader(String fileName) throws IOException {

        FileReader fileReader = null;
        try {
            fileReader = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bfr = new BufferedReader(fileReader);


        int numOfLines = 0;
        while (bfr.readLine() != null) {
            numOfLines++;
        }
        bfr.close();

        FileReader fileReader1 = new FileReader(fileName);
        BufferedReader bfr1 = new BufferedReader(fileReader1);

        String line;
        Product[] products = new Product[numOfLines];

        for (int i = 0; i < numOfLines; i++) {

            line = bfr1.readLine();
            String[] data = line.split(";");
            products[i] = new Product(data[0], data[1], Double.valueOf(data[2]));
        }
        bfr.close();


        return products;
    }

    public static void printProducts (Product[] products){
        for (Product tmp : products) {
            System.out.println(tmp.getName() + ", " + tmp.getProducer() + ", " + tmp.getPrice());
        }
    }


    public static double priceSum(Product[] products) {

        double sum = 0;
        for (Product product1 : products) {
            sum += product1.getPrice();
        }
        return sum;
    }

    public static Product mostExProd(Product[] products){
        String mExPr = null;
        double mEx = 0;
        Product tmp = null;

        for (Product product : products) {
            if (product.getPrice() > mEx) {
                mEx = product.getPrice();
                mExPr = product.getName();
                tmp = product;
            }
        }
        return tmp;
    }

    public static String bestProducer (Product[] products){

        ArrayList<String> producers = new ArrayList<>();
        producers.add(products[0].getProducer());

        boolean equal = false;
        for (int i = 1; i < products.length; i++) {
            equal = false;
            for (int j = 0; (j< producers.size())&& !equal ; j++) {
                if (products[i].getProducer().equals(producers.get(j))){
                    equal = true;
                }
            }
            if (!equal) producers.add(products[i].getProducer());
        }
//     wynik Lista producentów   System.out.println(producers);
//  teraz liczymy ile razy index producenta wystepuje:
        int[] index = new int [producers.size()];
        for (int i = 0; i < producers.size(); i++) {
            for (int j = 0; j < products.length; j++) {
                if (producers.get(i).equals(products[j].getProducer())) {
                    index[i]++;
                }
            }
        }

        String bestProducer = null;
        for (int i = 0; i < index.length; i++) {
            for (int j = 0; j < i; j++) {
                if (index[i]>index[j])
                    bestProducer = producers.get(i);
            }

        }
        return bestProducer;
    }

}

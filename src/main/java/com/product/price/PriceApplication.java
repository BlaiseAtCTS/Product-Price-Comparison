package com.product.price;

import com.product.price.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

public class PriceApplication {

	public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/product/price/config/applicationContext.xml");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of products: ");
        int numOfProd = sc.nextInt();
        sc.nextLine();
        int id = 0;
        ProductService productService = context.getBean("productService", ProductService.class);
        for(int i=0; i<numOfProd; i++) {
            System.out.println("Enter name: ");
            String name = sc.nextLine();
            System.out.println("Enter price: ");
            double price = sc.nextDouble();
            sc.nextLine();
            productService.addProduct(new Product(id, name, price));
            id++;
        }
        while(true) {
            System.out.println("Choose: \n1. getProductsSortedByName\n2. getProductsSortedByPrice\n3. exit");
            String choice = sc.nextLine();
            if(choice.equals("1")) {
                ArrayList<Product> array = new ArrayList<>();
                array = productService.getProductsSortedByName();
                array.forEach((prod) -> System.out.println("ID: "+prod.getId()+" Name: "+prod.getName()+" Price: "+prod.getPrice()));
            }
            else if(choice.equals("2")) {
                TreeSet<Product> set;
                set = productService.getProductsSortedByPrice();
                set.forEach((prod) -> System.out.println("ID: "+prod.getId()+" Name: "+prod.getName()+" Price: "+prod.getPrice()));
            }
            else if(choice.equals("3")) {
                return;
            }
            else {
                System.out.println("Incorrect choice!");
            }
        }
	}

}

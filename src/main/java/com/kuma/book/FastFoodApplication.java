package com.kuma.book;

import com.kuma.book.dto.model.Auth;
import com.kuma.book.dto.model.Book;
import com.kuma.book.dto.model.Customer;
import com.kuma.book.dto.model.Order;
import com.kuma.book.service.AuthService;
import com.kuma.book.service.BookService;
import com.kuma.book.service.CustomerService;
import com.kuma.book.service.OrderService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.*;

@SpringBootApplication
@EntityScan(basePackages = "com.kuma.fastfood.dto.model")
@RequiredArgsConstructor
public class FastFoodApplication {

    private final AuthService authService;
    private final BookService bookService;
    private final OrderService orderService;
    private final CustomerService customerService;

    @PostConstruct
    public void init(){
        Scanner sc = new Scanner(System.in);
       while (true){
           System.out.println("What did you want to create? :(Auth, Customer, Book, Order) or functional (f)");
           String c = sc.nextLine();
           switch (c){
               case("Customer"):
                   System.out.println("Name");
                   System.out.println(customerService.save(Customer.builder()
                           .name(sc.nextLine())
                           .build()));
                   break;
               case ("Auth"):
                   System.out.println("Name ");
                   System.out.println(authService.save(Auth.builder().name(sc.nextLine()).build()));
                   break;
               case ("Book"):
                   Book b = new Book();
                   System.out.println("Name ");
                   b.setName(sc.nextLine());
                   System.out.println("Write price");
                   b.setPrice(sc.nextDouble());
                   System.out.println("Write stock ");
                   b.setStock(sc.nextLong());
                   bookService.save(b);
                   System.out.println("Which auth");
                   b.addAuth(authService.findById(sc.nextLong()));
                   bookService.save(b);
                   break;
               case ("Order"):
                   Order o = new Order();
                   System.out.println("Name");
                   o.setName(sc.nextLine());
                   orderService.save(o);
                   System.out.println("Which book");
                   Book b1 =  bookService.findById(sc.nextLong());
                   o.addBook(b1);
                   System.out.println("Which customer");
                   o.addCustomer(customerService.findById(sc.nextLong()),b1.getPrice());
                   orderService.save(o);
                   break;
               case ("f"):
                   while (true){
                       System.out.println("What did you want to functional ? :: 1,2,3,4");
                       int f = sc.nextInt();
                       switch (f){
                           case(1):
                               System.out.println("Write auth id");
                               for (Book book1 : bookService.findAllByAuthId(sc.nextLong())) {
                                   System.out.println(book1);
                               }
                               break;
                           case(2):
                               System.out.println("Write book id ");
                               System.out.println(bookService.findById(sc.nextLong()).getIncome());
                               break;
                           case(3):
                               for (Customer customer : customerService.findAllBySold()) {
                                   System.out.println(customer);
                               }
                               break;
                           case(4):
                               System.out.println(bookService.findHighestSold());
                               break;
                           case(5):
                               for (Auth auth : bookService.findBookByAuthHighestSold()) {
                                   System.out.println(auth);
                               }
                               break;
                           case(6):
                               System.out.println(customerService.getHighestSold());
                               break;
                           case(7):
                               System.out.println(bookService.findLowStock().getName());
                               break;
                           case(8):
                               System.out.println(bookService.getSum());
                               break;
                           case(9):
                                List<Customer> customers = customerService.findAllByNoSold();
                                if(customers.size()==0)
                                    System.out.println("Such an object does not exist");
                                else
                                for (Customer customer1 : customers)
                                   System.out.println(customer1);
                                break;
                           case(0):
                               break;
                       }
                   }
               case ("stop"):
                   break;
               default:
                   break;
           }
       }


    }

    public static void main(String[] args) {
        SpringApplication.run(FastFoodApplication.class, args);
    }

}

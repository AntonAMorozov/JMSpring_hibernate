package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        Car car1 = new Car("Alpha", 1818);
        Car car2 = new Car("Beta", 1919);
        Car car3 = new Car("Gamma", 2020);
        Car car4 = new Car("Delta", 2121);

        //userService.add(new User("Harry", "Hole", "hhole@mail.ru", car1));
        //userService.add(new User("Rakel", "Feuke", "rfeuke@mail.ru", car2));
        //userService.add(new User("Jo", "Nesbo", "jnesbo@mail.ru", car3));
        //userService.add(new User("Kaja", "Solness", "ksolness@mail.ru", car4));
        System.out.println();
        System.out.println("--------------");
        System.out.println(userService.getUserByCar("Gamma", 2020).toString());
        System.out.println("--------------");
        System.out.println();

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println(user.getUserCar());
            System.out.println();
        }
        context.close();
    }
}

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
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("Anna", "Sidorova", "Anna@mail.ru",(new Car("Mazda", 2021))));
      userService.add(new User("Ivan", "Ivanov", "Ivan@mail.ru", (new Car("Lexus", 2023))));
      userService.add(new User("Darya", "Fedorova", "Darya@mail.ru",(new Car("Volvo", 2020))));
      userService.add(new User("Petr", "Petrov", "Petr@mail.ru",(new Car("Toyota", 2019))));

      List<User> users = userService.listGetUser("Mazda", 2021);
      for (User user : users) {
         System.out.println(user);
      }
      context.close();
   }
}

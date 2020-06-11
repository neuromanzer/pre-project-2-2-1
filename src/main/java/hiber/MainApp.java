package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        for (int i = 0; i < 4; i++) {
            User user = new User()
                    .setFirstName("First_Name_" + i)
                    .setLastName("Last_Name_" + i)
                    .setEmail("Email_" + i);

            Car car = new Car()
                    .setName("Car_" + i)
                    .setSeries(i)
                    .setUser(user);

            userService.add(user.setCar(car));
        }

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println(user);
            System.out.println();
        }

        System.out.println("Test exist user");
        System.out.println(userService.getByCarNumberAndCarSeries("Car_3", 3));
        System.out.println("Test NOT exist user");
        System.out.println(userService.getByCarNumberAndCarSeries("Car_3", 9));

        /*userService.add(new User("User1", "Lastname1", "user1@mail.ru", new Car("Car 1",1)));
        userService.add(new User("User1", "Lastname1", "user1@mail.ru", new Car("Car 2",2)));
        userService.add(new User("User1", "Lastname1", "user1@mail.ru", new Car("Car 3",3)));
        userService.add(new User("User1", "Lastname1", "user1@mail.ru", new Car("Car 4",4)));

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }

        List<Car> cars = carService.listCars();
        for (Car car : cars) {
            System.out.println("Id = " + car.getId());
            System.out.println("Name = " + car.getName());
            System.out.println("Series = " + car.getSeries());
            System.out.println();
        }
*/
        context.close();
    }
}

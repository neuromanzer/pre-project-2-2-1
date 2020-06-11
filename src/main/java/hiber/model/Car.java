package hiber.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "series")
    private int series;

    @OneToOne
    private User user;

    public User getUser() {
        return user;
    }

    public Car setUser(User user) {
        this.user = user;
        return this;
    }

    public Long getId() {
        return id;
    }

    public Car setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Car setName(String name) {
        this.name = name;
        return this;
    }

    public int getSeries() {
        return series;
    }

    public Car setSeries(int series) {
        this.series = series;
        return this;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", series=" + series +
                ", user_id=" + user.getId() +
                '}';
    }
}

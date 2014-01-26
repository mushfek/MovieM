package net.therap.moviem.domain;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mushfekur
 * Date: 9/2/13
 * Time: 11:38 AM
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "actor", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id"),
        @UniqueConstraint(columnNames = "name")
})
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToMany(mappedBy = "actor", cascade = CascadeType.ALL)
    private List<Movie> actedIn;

    @Column(name = "name")
    private String name;

    @Column(name = "link")
    private String link;

    public Actor() {
    }

    public Actor(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Movie> getActedIn() {
        return actedIn;
    }

    public void setActedIn(List<Movie> actedIn) {
        this.actedIn = actedIn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}

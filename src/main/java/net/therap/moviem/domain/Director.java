package net.therap.moviem.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mushfekur
 * Date: 9/2/13
 * Time: 11:42 AM
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "director", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id"),
        @UniqueConstraint(columnNames = "name")
})
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "link")
    private String link;

    @OneToMany(mappedBy = "director", cascade = CascadeType.ALL)
    private List<Movie> directionList;

    public Director() {
    }

    public Director(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<Movie> getDirectionList() {
        return directionList;
    }

    public void setDirectionList(List<Movie> directionList) {
        this.directionList = directionList;
    }
}
package kovalchuk.library.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private String country;

    public Author() {}
    public Author(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public Long getId() {return id;}
    public void setId(Long id) { this.id = id; }

    public String getName() {return name; }
    public void setName(String name) { this.name = name; }

    public String getCountry() {return country;}
    public void setCountry(String country) { this.country = country; }

}

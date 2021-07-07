package org.example.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ksiazki")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nazwa")
    private String title;

    @Column(name = "wydawnictwo")
    private String publishing_house;

    @Column(name = "cena")
    private Double price;

//    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.MERGE, CascadeType.ALL, CascadeType.REFRESH})
//    @JoinColumn(name = "kategoria_id")
//    private Category category;

    @ManyToOne(cascade=  {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "kategoria_id")
    private Category category;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "autorzy_to_ksiazki",
            joinColumns = @JoinColumn(name = "ksiazka_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id")
    )
    private Set<Author> authors;

    public Book() {};

    public Book(String id) {
        this.id = Integer.parseInt(id);
    }

    public Book(String title, String publishing_house, Double price) {
        this.title = title;
        this.publishing_house = publishing_house;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishing_house() {
        return publishing_house;
    }

    public void setPublishing_house(String publishing_house) {
        this.publishing_house = publishing_house;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    public Category getCategory() {
        return this.category;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public void addAuthor(Author autor) {
        if (authors == null) {
            authors = new HashSet<>();
        }
        authors.add(autor);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", publishing_house='" + publishing_house + '\'' +
                ", price=" + price +
                ", category=" + category +
                '}';
    }
}
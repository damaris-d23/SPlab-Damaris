package ro.damaris.splabdamaris;

import jakarta.persistence.*;

@Entity
@jakarta.persistence.Table(name = "DocumentTable") // Această linie rezolvă eroarea de SQL
public class Table extends Element {
    private String title;

    public Table() {}

    public Table(String title) {
        this.title = title;
    }

    @Override
    public void print() {
        System.out.println("Table: " + title);
    }

    @Override
    public void add(Element element) {}

    @Override
    public void remove(Element element) {}

    @Override
    public Element get(int index) {
        return null;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
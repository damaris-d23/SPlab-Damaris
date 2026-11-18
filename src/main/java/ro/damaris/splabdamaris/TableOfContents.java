package ro.damaris.splabdamaris;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Entity
@Getter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TableOfContents extends Element {

    public TableOfContents() {} // Constructor gol obligatoriu JPA

    @Override
    public void print() {
        System.out.println("Table of Contents");
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
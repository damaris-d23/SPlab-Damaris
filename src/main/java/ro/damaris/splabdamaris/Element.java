package ro.damaris.splabdamaris;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) // Creează tabele separate pentru fiecare subclasă
public abstract class Element {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Cheia primară generată automat

    @Transient // Spunem bazei de date să ignore acest câmp temporar pentru a evita erorile
    protected Element parent = null;

    public Long getId() {
        return id;
    }

    @JsonIgnore
    public Element getParent() {
        return parent;
    }

    public void setParent(Element parent) {
        this.parent = parent;
    }

    public abstract void print();
    public abstract void add(Element element);
    public abstract void remove(Element element);
    public abstract Element get(int index);
    public abstract void accept(Visitor visitor);
}
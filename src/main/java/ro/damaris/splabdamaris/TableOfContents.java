package ro.damaris.splabdamaris;

public class TableOfContents extends Element {
    @Override
    public void print() {
        System.out.println("Table of Contents");
    }

    @Override
    public void add(Element element) {}
    @Override
    public void remove(Element element) {}
    @Override
    public Element get(int index) { return null; }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
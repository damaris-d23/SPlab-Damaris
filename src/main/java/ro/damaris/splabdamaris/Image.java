package ro.damaris.splabdamaris;
import java.util.concurrent.TimeUnit;

public class Image extends Element {
    private String url;

    public Image(String name) {
        this.url = name;
        try {
            // Se adaugă o întârziere de 5 secunde pentru a simula încărcarea unei imagini mari
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void print() {
        System.out.println("Image with name: " + url);
    }

    @Override
    public void add(Element element) {}

    @Override
    public void remove(Element element) {}

    @Override
    public Element get(int index) {
        return null;
    }
}

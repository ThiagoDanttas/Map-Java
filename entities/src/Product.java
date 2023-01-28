import java.util.Objects;

public class Product {

    private String nome;
    private double price;

    public Product(String nome, double price) {
        this.nome = nome;
        this.price = price;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return Double.compare(product.getPrice(), getPrice()) == 0 && Objects.equals(getNome(), product.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getPrice());
    }
}
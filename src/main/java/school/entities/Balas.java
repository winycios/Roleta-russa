package school.entities;

public class Balas {

    private Boolean status;

    public Balas(Boolean status) {
        this.status = status;
    }

    public Boolean getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return String.format("%s", status ? "Carregado" : "Vazio");
    }
}


import java.util.Objects;

public class Ciudad implements Comparable<Ciudad> {
    private String nombre;
    private String pais;
    private int habitantes;

    public Ciudad(String nombre, String pais, int habitantes) {
        this.nombre = nombre;
        this.pais = pais;
        this.habitantes = habitantes;
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getPais() { return pais; }
    public int getHabitantes() { return habitantes; }

    // Para evitar duplicados (mismo nombre y país)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ciudad ciudad = (Ciudad) o;
        return nombre.equals(ciudad.nombre) && pais.equals(ciudad.pais);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, pais);
    }

    // Para ordenar por habitantes (de menor a mayor)
    @Override
    public int compareTo(Ciudad otra) {
        return Integer.compare(this.habitantes, otra.habitantes);
    }

    @Override
    public String toString() {
        return nombre + " (" + pais + ") - " + habitantes + " habitantes";
    }
}
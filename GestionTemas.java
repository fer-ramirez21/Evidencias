import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Collections;
import java.util.Comparator;

class Tema implements Comparable<Tema> {
    String titulo;
    int prioridad;

    public Tema(String titulo, int prioridad) {
        this.titulo = titulo;
        this.prioridad = prioridad;
    }

    @Override
    public int compareTo(Tema otro) {
        return this.titulo.compareToIgnoreCase(otro.titulo);
    }

    @Override
    public String toString() {
        return "Tema{" +
                "titulo='" + titulo + '\'' +
                ", prioridad=" + prioridad +
                '}';
    }
}

public class GestionTemas {
    public static void main(String[] args) {
        // Lista concurrente de temas
        CopyOnWriteArrayList<Tema> temas = new CopyOnWriteArrayList<>();
        temas.add(new Tema("Matemáticas", 2));
        temas.add(new Tema("Programación", 1));
        temas.add(new Tema("Historia", 3));

        // Mostrar lista ordenada alfabéticamente (orden natural)
        Collections.sort(temas);
        System.out.println("Temas ordenados por título:");
        temas.forEach(System.out::println);

        // Ordenar por prioridad ascendente
        temas.sort(Comparator.comparingInt(t -> t.prioridad));
        System.out.println("\nTemas ordenados por prioridad:");
        temas.forEach(System.out::println);

        // Repositorio concurrente de recursos
        ConcurrentHashMap<String, String> repositorio = new ConcurrentHashMap<>();
        repositorio.put("Matemáticas", "https://recursos.com/matematicas");
        repositorio.put("Programación", "https://recursos.com/programacion");
        repositorio.put("Historia", "https://recursos.com/historia");

        System.out.println("\nRepositorio de recursos:");
        repositorio.forEach((clave, valor) -> 
            System.out.println(clave + " → " + valor));
    }
}

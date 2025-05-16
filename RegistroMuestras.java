import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;

public class RegistroMuestras {
    public static void main(String[] args) {
        // Lista con el orden de llegada de las muestras (con posibles repeticiones)
        ArrayList<String> muestras = new ArrayList<>();
        muestras.add("Homo sapiens");
        muestras.add("Mus musculus");
        muestras.add("Arabidopsis thaliana");
        muestras.add("Homo sapiens");

        // Conjunto para especies únicas
        HashSet<String> especiesUnicas = new HashSet<>(muestras);

        // Mapa para asociar ID muestra -> investigador
        HashMap<String, String> muestrasInvestigador = new HashMap<>();
        muestrasInvestigador.put("M-001", "Dra. López");
        muestrasInvestigador.put("M-002", "Dr. Hernández");
        muestrasInvestigador.put("M-003", "Dra. Pérez");

        // Mostrar lista completa y ordenada de muestras
        System.out.println("Lista completa y ordenada de muestras:");
        for (String especie : muestras) {
            System.out.println("- " + especie);
        }

        // Mostrar especies únicas
        System.out.println("\nEspecies únicas procesadas:");
        for (String especie : especiesUnicas) {
            System.out.println("- " + especie);
        }

        // Mostrar relación ID muestra → investigador
        System.out.println("\nRelación ID de muestra → investigador:");
        for (String id : muestrasInvestigador.keySet()) {
            System.out.println(id + " → " + muestrasInvestigador.get(id));
        }

        // Búsqueda por ID de muestra
        String busquedaId = "M-002";
        System.out.println("\nBúsqueda por ID de muestra (" + busquedaId + "):");
        if (muestrasInvestigador.containsKey(busquedaId)) {
            System.out.println("Investigador: " + muestrasInvestigador.get(busquedaId));
        } else {
            System.out.println("ID de muestra no encontrado.");
        }
    }
}

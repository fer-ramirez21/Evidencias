import java.io.*;

public class AnalizadorDeLogs {
    public static void main(String[] args) {
        String rutaArchivo = "errores.log";
        int totalLineas = 0;
        int errores = 0;
        int advertencias = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                totalLineas++;
                if (linea.contains("ERROR")) {
                    errores++;
                }
                if (linea.contains("WARNING")) {
                    advertencias++;
                }
            }

            System.out.println("Resumen del análisis:");
            System.out.println("Total de líneas leídas: " + totalLineas);
            System.out.println("Cantidad de errores: " + errores);
            System.out.println("Cantidad de advertencias: " + advertencias);

            double porcentaje = 0;
            if (totalLineas > 0) {
                porcentaje = ((double) (errores + advertencias) / totalLineas) * 100;
            }
            System.out.printf("Porcentaje de líneas con errores/advertencias: %.2f%%\n", porcentaje);

        } catch (IOException e) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("registro_fallos.txt"))) {
                bw.write("Ocurrió un error al leer el archivo: " + e.getMessage());
                System.out.println("Se registró un error en 'registro_fallos.txt'.");
            } catch (IOException ex) {
                System.err.println("No se pudo escribir el archivo de registro de fallos.");
            }
        }
    }
}

import java.util.HashSet;
import java.util.Scanner;

class ConsumoCriticoException extends Exception {
    public ConsumoCriticoException(String mensaje) {
        super(mensaje);
    }
}

public class MonitorCPU {
    public static void main(String[] args) {
        HashSet<Double> consumos = new HashSet<>();
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Ingrese consumos de CPU de servidores (porcentaje). Escriba 'fin' para terminar:");

            while (true) {
                System.out.print("Consumo CPU: ");
                String entrada = scanner.nextLine();

                if (entrada.equalsIgnoreCase("fin")) {
                    break;
                }

                try {
                    double consumo = Double.parseDouble(entrada);

                    if (consumo < 0 || consumo > 100) {
                        System.out.println("Error: El valor debe estar entre 0 y 100.");
                        continue;
                    }

                    if (consumos.contains(consumo)) {
                        System.out.println("Error: Valor duplicado, no se permite.");
                        continue;
                    }

                    if (consumo > 95) {
                        throw new ConsumoCriticoException("Consumo crítico detectado: " + consumo + "%");
                    }

                    consumos.add(consumo);
                    System.out.println("Consumo registrado correctamente.");

                } catch (NumberFormatException e) {
                    System.out.println("Error: Debe ingresar un número válido.");
                } catch (ConsumoCriticoException e) {
                    System.out.println("Excepción: " + e.getMessage());
                }
            }

        } finally {
            scanner.close();
            System.out.println("Scanner cerrado. MonitorCPU finalizado.");
        }
    }
}

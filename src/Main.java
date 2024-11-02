import java.io.*;

public class Main {
    public static void main(String[] args) {

        String filePath = "D:\\Practicas\\ManejoArchivos\\test.txt";
        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("La ruta del archivo no es correcta.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            int suma = 0;
            int i = 0;
            int maximo = Integer.MIN_VALUE;
            int minimo = Integer.MAX_VALUE;

            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (linea.chars().allMatch(Character::isDigit)) {
                    int numbero = Integer.parseInt(linea);
                    suma += numbero;
                    i++;
                    if (numbero > maximo) {
                        maximo = numbero;
                    }
                    if (numbero < minimo) {
                        minimo = numbero;
                    }
                }
            }

            if (i > 0) {
                double promedio = (double) suma / i;
                System.out.println("Promedio: " + promedio);
                System.out.println("Número mayor: " + maximo);
                System.out.println("Número menor: " + minimo);
            } else {
                System.out.println("El archivo está vacío o no contiene números válidos.");
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("El archivo contiene datos no numéricos.");
        }
    }
}

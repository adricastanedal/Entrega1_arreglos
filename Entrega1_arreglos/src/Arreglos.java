import javax.swing.JOptionPane;

public class Arreglos {

    public static void main(String[] args) {

        int numNotas = ingresarNumNotas(
                "Ingrese el número de notas:",
                "Error: el valor ingresado debe ser un número entero positivo."
        );

        double[] notas = ingresarNnotas("Ingrese la nota ", numNotas);

        double promedio = calcularPromedio(notas);
        double notaMayor = buscarNotaMayor(notas);
        double notaMenor = buscarNotaMenor(notas);
        double notaMasRepetida = buscarNotaMasRepetida(notas);
        ordenarBurbuja(notas);

        String mensaje = resumen(promedio, notaMayor, notaMenor, notaMasRepetida);
        JOptionPane.showMessageDialog(null, mensaje);
    }

    // ---------------- MÉTODOS ----------------
    /**
     * método que solicita y valida la cantidad de notas.
     * @return número entero positivo de notas
     */
    public static int ingresarNumNotas(String mensaje1, String mensaje2) {

        int numNotas = 0;
        boolean valido = false;

        while (!valido) {
            try {
                int n = Integer.parseInt(
                        JOptionPane.showInputDialog(null, mensaje1)
                );

                if (n > 0) {
                    numNotas = n;
                    valido = true;
                } else {
                    JOptionPane.showMessageDialog(null, mensaje2);
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Error: debe ingresar un número entero.");
            }
        }

        return numNotas;
    }
    /**
     * Ingresa las notas del usuario.
     * @return arreglo de notas
     */
    public static double[] ingresarNnotas(String mensaje, int numNotas) {

        double[] notas = new double[numNotas];

        for (int i = 0; i < notas.length; i++) {
            notas[i] = Double.parseDouble(
                    JOptionPane.showInputDialog(null, mensaje + (i + 1) + ":")
            );
        }

        return notas;
    }
    /**
     * Calcula el promedio de las notas.
     * @return promedio
     */
    public static double calcularPromedio(double[] notas) {

        double suma = 0;

        for (int i = 0; i < notas.length; i++) {
            suma += notas[i];
        }

        return suma / notas.length;
    }
    /**
     * Busca la nota mayor.
     * @return nota mayor
     */
    public static double buscarNotaMayor(double[] notas) {

        double mayor = notas[0];

        for (int i = 1; i < notas.length; i++) {
            if (notas[i] > mayor) {
                mayor = notas[i];
            }
        }

        return mayor;
    }
    /**
     * Busca la nota menor.
     * @return nota menor
     */
    public static double buscarNotaMenor(double[] notas) {

        double menor = notas[0];

        for (int i = 1; i < notas.length; i++) {
            if (notas[i] < menor) {
                menor = notas[i];
            }
        }

        return menor;
    }
    /**
     * Determina la nota más repetida.
     * @return nota más frecuente
     */
    public static double buscarNotaMasRepetida(double[] notas) {

        double notaRepetida = notas[0];
        int maxContador = 0;

        for (int i = 0; i < notas.length; i++) {
            int contador = 0;

            for (int j = 0; j < notas.length; j++) {
                if (notas[i] == notas[j]) {
                    contador++;
                }
            }

            if (contador > maxContador) {
                maxContador = contador;
                notaRepetida = notas[i];
            }
        }

        return notaRepetida;
    }
    /**
     * Ordena el arreglo de notas en forma ascendente
     * utilizando el algoritmo de burbuja.
     *
     * @param notas arreglo de valores a ordenar
     */
    public static void ordenarBurbuja(double[] notas) {

        for (int i = 0; i < notas.length - 1; i++) {
            for (int j = 0; j < notas.length - 1 - i; j++) {
                if (notas[j] > notas[j + 1]) {
                    double x = notas[j];
                    notas[j] = notas[j + 1];
                    notas[j + 1] = x;
                }
            }
        }
    }

    /**
     * Genera el resumen final.
     * @return resumen de resultados
     */
    public static String resumen(double promedio, double mayor,
                                 double menor, double repetida) {

        String mensaje = "--- RESUMEN DE NOTAS ---\n\n";
        mensaje += "Promedio: " + promedio + "\n";
        mensaje += "Nota mayor: " + mayor + "\n";
        mensaje += "Nota menor: " + menor + "\n";
        mensaje += "Nota más repetida: " + repetida;

        return mensaje;
    }
}

/**
 * Simulador de Editor de Texto con Undo/Redo
 * Utiliza dos pilas para gestionar las acciones realizadas y deshechas
 *
 * Autora: Yenni Vanessa Delgado
 */
import java.util.Stack;

public class EditorDeTexto {
    // Pila para guardar el historial de acciones realizadas
    static Stack<String> pilaHistorial = new Stack<>();
    // Pila para guardar las acciones que se pueden rehacer
    static Stack<String> pilaRehacer = new Stack<>();
    // Texto actual del editor
    static String textoActual = "";

    /**
     * Función para escribir texto
     */
    public static void escribirTexto(String nuevoTexto) {
        // push() : Guardar el estado actual en la pila de historial
        pilaHistorial.push(textoActual);

        // Actualizar el texto actual
        if (textoActual.isEmpty()) {
            textoActual = nuevoTexto;
        } else {
            textoActual += "\n" + nuevoTexto;
        }

        // clear() : Limpiar la pila de rehacer al realizar nueva acción
        pilaRehacer.clear();

        System.out.println("Texto agregado ");
    }

    /**
     * Función para mostrar el texto actual
     */
    public static void mostrarTextoActual() {
        // isEmpty() : Verificar si el texto está vacío
        if (textoActual.isEmpty()) {
            System.out.println("El editor está vacío.");
        } else {
            System.out.println("Texto actual:");
            System.out.println("================");
            System.out.println(textoActual);
            System.out.println("================");
        }
    }

    /**
     * Función para deshacer la última acción (Undo)
     */
    public static void deshacer() {
        // isEmpty() : Verificar si hay acciones para deshacer
        if (pilaHistorial.isEmpty()) {
            System.out.println("No hay acciones para deshacer.");
            return;
        }

        // push() : Guardar el estado actual en pilaRehacer
        pilaRehacer.push(textoActual);
        // pop() :  Recuperar el último estado de pilaHistorial
        textoActual = pilaHistorial.pop();

        System.out.println("Acción deshecha correctamente.");
    }

    /**
     * Función para rehacer la última acción deshecha (Redo)
     */
    public static void rehacer() {
        // isEmpty() : Verificar si hay acciones para rehacer
        if (pilaRehacer.isEmpty()) {
            System.out.println("No hay acciones para rehacer.");
            return;
        }

        // push() : Guardar el estado actual en pilaHistorial
        pilaHistorial.push(textoActual);
        // pop() :  Recuperar el último estado de pilaRehacer
        textoActual = pilaRehacer.pop();

        System.out.println("Acción rehecha correctamente.");
    }

    /**
     * Función para mostrar el menú
     */
    public static void mostrarMenu() {
        System.out.println("\n===== EDITOR DE TEXTO =====");
        System.out.println("1. Escribir texto");
        System.out.println("2. Deshacer (Undo)");
        System.out.println("3. Rehacer (Redo)");
        System.out.println("4. Mostrar texto actual");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }
}

}

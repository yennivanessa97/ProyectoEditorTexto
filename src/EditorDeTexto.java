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

}

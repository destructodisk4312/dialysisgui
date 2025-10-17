// ✅ Objective: Include a main class that launches the GUI.
public class Main {
    public static void main(String[] args) {
        // ✅ Launch the GUI on the Swing event dispatch thread
        javax.swing.SwingUtilities.invokeLater(() -> {
            new ConverterGUI(); // creates an instance of the GUI
        });
    }
}
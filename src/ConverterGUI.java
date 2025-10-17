import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// ✅ Objective: Create a GUI using Swing components
public class ConverterGUI extends JFrame {

    // ✅ Objective: Include two text entry boxes
    private JTextField lbsField;
    private JTextField kgField;

    // ✅ Objective: Include two labels with text
    private JLabel lbsLabel;
    private JLabel kgLabel;

    // ✅ Objective: Include three buttons (each does something different)
    private JButton toKgButton;
    private JButton toLbsButton;
    private JButton exitButton;  // <-- New exit button

    // ✅ Objective: Include an image
    private JLabel imageLabel;

    // ✅ Constructor initializes all GUI elements
    public ConverterGUI() {

        // ✅ Basic window setup
        setTitle("Pounds ↔ Kilograms Converter");
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // ✅ Load and display an image at the top of the GUI
        ImageIcon icon = new ImageIcon("images/scale.png"); // Make sure the image exists
        imageLabel = new JLabel(icon);
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        add(imageLabel, BorderLayout.NORTH);

        // ✅ Center panel for labels and text boxes
        JPanel centerPanel = new JPanel(new GridLayout(2, 2, 10, 10));

        lbsLabel = new JLabel("Pounds (lbs):");
        kgLabel = new JLabel("Kilograms (kg):");

        lbsField = new JTextField();
        kgField = new JTextField();

        centerPanel.add(lbsLabel);
        centerPanel.add(lbsField);
        centerPanel.add(kgLabel);
        centerPanel.add(kgField);
        add(centerPanel, BorderLayout.CENTER);

        // ✅ South panel for all three buttons
        JPanel buttonPanel = new JPanel(new FlowLayout());

        toKgButton = new JButton("Convert lbs → kg");
        toLbsButton = new JButton("Convert kg → lbs");
        exitButton = new JButton("Exit Program"); // <-- New button

        buttonPanel.add(toKgButton);
        buttonPanel.add(toLbsButton);
        buttonPanel.add(exitButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // ✅ Objective: Each button performs a unique action

        // --- Button 1: Convert pounds to kilograms ---
        toKgButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double lbs = Double.parseDouble(lbsField.getText());
                    double kg = lbs * 0.45359237;
                    kgField.setText(String.format("%.4f", kg));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(ConverterGUI.this, "Please enter a valid number for pounds.");
                }
            }
        });

        // --- Button 2: Convert kilograms to pounds ---
        toLbsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double kg = Double.parseDouble(kgField.getText());
                    double lbs = kg / 0.45359237;
                    lbsField.setText(String.format("%.4f", lbs));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(ConverterGUI.this, "Please enter a valid number for kilograms.");
                }
            }
        });

        // --- Button 3: Exit program ---
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // ✅ Objective: Create a unique button action that exits the application
                int confirm = JOptionPane.showConfirmDialog(
                        ConverterGUI.this,
                        "Are you sure you want to exit?",
                        "Exit Confirmation",
                        JOptionPane.YES_NO_OPTION
                );
                if (confirm == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        // ✅ Final setup
        setLocationRelativeTo(null); // center the window
        setVisible(true);            // make it visible
    }
}
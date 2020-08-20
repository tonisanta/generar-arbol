package GenerarArbol;

import Excepciones.RecorridoInvalidoException;

import javax.swing.*;
import java.awt.Font;
import java.util.ArrayList;

public class UserInterface extends JFrame {
    private JLabel jlTitulo;
    private JLabel jlpreorden;
    private JLabel jlinorden;
    private JLabel jlpostorden;
    private JTextField jtpreorden;
    private JTextField jtinorden;
    private JButton jbGenerar;

    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
    }

    public UserInterface() {
        initComponents();
    }

    /**
     * Obtenemos los datos introducidos en los JTextField como tokens separados a partir de una expresión regular.
     * Concretamente (espacio)* , (espacio)*
     */
    private void generarPostorden() {
        String[] preorden = jtpreorden.getText().split("\\s*,\\s*");
        String[] inorden = jtinorden.getText().split("\\s*,\\s*");

        try {
            Arbol arbol = new Arbol(preorden, inorden);
            ArrayList<String> postorden = arbol.getPostorden();
            JOptionPane.showMessageDialog(this, postorden.toString(), "Recorrido postorden", JOptionPane.INFORMATION_MESSAGE);
        } catch (RecorridoInvalidoException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Inicialización de los componentes gráficos y ActionListener
     */
    private void initComponents() {
        jlTitulo = new JLabel("Generar recorrido postorden");
        jlpreorden = new JLabel("Preorden:");
        jlinorden = new JLabel("Inorden:");
        jtpreorden = new JTextField();
        jtinorden = new JTextField();
        jbGenerar = new JButton("Generar postorden");

        jlTitulo.setBounds(200, 70, 350, 25);
        jlTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        this.add(jlTitulo);

        jlpreorden.setBounds(50, 140, 150, 25);
        jlpreorden.setFont(new Font("Arial", Font.BOLD, 20));
        this.add(jlpreorden);

        jlinorden.setBounds(50, 200, 200, 25);
        jlinorden.setFont(new Font("Arial", Font.BOLD, 20));
        this.add(jlinorden);

        jtpreorden.setBounds(200, 140, 300, 25);
        this.add(jtpreorden);

        jtinorden.setBounds(200, 200, 300, 25);
        this.add(jtinorden);

        jbGenerar.setBounds(200, 250, 300, 25);
        this.add(jbGenerar);

        jlpostorden = new JLabel("Postorden:");
        jlpostorden.setBounds(50, 325, 500, 25);
        jlpostorden.setFont(new Font("Arial", Font.BOLD, 20));
        jlpostorden.setVisible(false);
        this.add(jlpostorden);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Generar recorrido postorden");
        this.setSize(625, 400);
        this.setLocationRelativeTo(null);//situar en el centro de la pantalla
        this.setLayout(null);
        this.setResizable(false);
        this.setVisible(true);

        jbGenerar.addActionListener(actionEvent -> {
            this.generarPostorden();
        });
    }
}

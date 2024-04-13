package GUI;

import javax.swing.*;
import java.awt.*;

public class CalculadoraSaludView extends JFrame {

    private JTextField txtPeso;
    private JTextField txtAltura;
    private JTextField txtEdad;
    private JComboBox<String> comboBoxGenero;
    private JButton btnCalcularPesoIdeal;
    private JButton btnCalcularBMR;

    public CalculadoraSaludView() {
        inicializarInterfaz();
    }

    private void inicializarInterfaz() {
        setTitle("Calculadora de Salud");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        JLabel lblPeso = new JLabel("Peso (kg):");
        txtPeso = new JTextField();
        panel.add(lblPeso);
        panel.add(txtPeso);

        JLabel lblAltura = new JLabel("Altura (cm):");
        txtAltura = new JTextField();
        panel.add(lblAltura);
        panel.add(txtAltura);

        JLabel lblEdad = new JLabel("Edad:");
        txtEdad = new JTextField();
        panel.add(lblEdad);
        panel.add(txtEdad);

        JLabel lblGenero = new JLabel("Género:");
        comboBoxGenero = new JComboBox<>();
        comboBoxGenero.addItem("M");
        comboBoxGenero.addItem("F");
        panel.add(lblGenero);
        panel.add(comboBoxGenero);

        btnCalcularPesoIdeal = new JButton("Calcular Peso Ideal");
        panel.add(btnCalcularPesoIdeal);

        btnCalcularBMR = new JButton("Calcular BMR");
        panel.add(btnCalcularBMR);

        add(panel);
    }

    public JTextField getTxtPeso() {
        return txtPeso;
    }

    public JTextField getTxtAltura() {
        return txtAltura;
    }

    public JTextField getTxtEdad() {
        return txtEdad;
    }

    public JComboBox<String> getComboBoxGenero() {
        return comboBoxGenero;
    }

    public JButton getBtnCalcularPesoIdeal() {
        return btnCalcularPesoIdeal;
    }

    public JButton getBtnCalcularBMR() {
        return btnCalcularBMR;
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
}






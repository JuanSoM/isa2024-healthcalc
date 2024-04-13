package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import healthcalc.HealthCalcImpl;

public class CalculadoraSaludController {

    private CalculadoraSaludView vista;
    private HealthCalcImpl model;

    public CalculadoraSaludController(CalculadoraSaludView vista, HealthCalcImpl model) {
        this.vista = vista;
        this.model = model;
        
        // Suscribir el controlador a los eventos de los botones en la vista
        vista.getBtnCalcularPesoIdeal().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularPesoIdeal();
            }
        });

        vista.getBtnCalcularBMR().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularBMR();
            }
        });
    }

    private void calcularPesoIdeal() {
        try {
            int altura = Integer.parseInt(vista.getTxtAltura().getText());
            char genero = vista.getComboBoxGenero().getSelectedItem().toString().charAt(0);
            float pesoIdeal = model.idealWeight(altura, genero);
            vista.mostrarMensaje("Peso Ideal: " + pesoIdeal + " kg");
        } catch (NumberFormatException ex) {
            vista.mostrarMensaje("Por favor, ingrese valores numéricos válidos para la altura.");
        } catch (IllegalArgumentException ex) {
            vista.mostrarMensaje(ex.getMessage());
        }
    }

    private void calcularBMR() {
        try {
            float peso = Float.parseFloat(vista.getTxtPeso().getText());
            int altura = Integer.parseInt(vista.getTxtAltura().getText());
            int edad = Integer.parseInt(vista.getTxtEdad().getText());
            char genero = vista.getComboBoxGenero().getSelectedItem().toString().charAt(0);
            float bmr = model.basalMetabolicRate(peso, altura, genero, edad);
            vista.mostrarMensaje("BMR: " + bmr + " kcal/día");
        } catch (NumberFormatException ex) {
            vista.mostrarMensaje("Por favor, ingrese valores numéricos válidos para peso, altura y edad.");
        } catch (IllegalArgumentException ex) {
            vista.mostrarMensaje(ex.getMessage());
        }
    }
}


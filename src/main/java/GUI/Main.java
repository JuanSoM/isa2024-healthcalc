package GUI;

import healthcalc.HealthCalcImpl;


public class Main {
    public static void main(String[] args) {
        HealthCalcImpl model = HealthCalcImpl.getInstance();
        CalculadoraSaludView view = new CalculadoraSaludView();
        CalculadoraSaludController controller = new CalculadoraSaludController(view, model);

        view.setVisible(true);
    }
}
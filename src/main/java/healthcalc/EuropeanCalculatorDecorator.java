package healthcalc;

import java.util.Locale;

public class EuropeanCalculatorDecorator extends HealthHospitalDecorator {
    public EuropeanCalculatorDecorator(HealthStatsProxy healthHospital) {
        super(healthHospital);
    }

    @Override
    public double bmr(char gender, int age, int height, float weight) {
        double bmr = super.bmr(gender, age, height, (float)(weight));
        displayMessage("BMR", height, weight, bmr);
        return bmr;
    }

    @Override
    public float pesoIdeal(char gender, int height) {
        return super.pesoIdeal(gender, height * 100);
    }

    private void displayMessage(String operation, double height, double weight, double result) {
        // Mensaje en inglés
        String messageEnglish = String.format(Locale.ENGLISH, "The person with height %.2f meters and %.2f Kg has a %s of %.2f.", height / 100, weight, operation, result);

        // Mensaje en español
        String messageSpanish = String.format("La persona con altura %.2f metros y %.2f Kg tiene un %s de %.2f.", height / 100, weight, operation, result);

        // Imprimir el mensaje en inglés
        System.out.println("English: " + messageEnglish);

        // Imprimir el mensaje en español
        System.out.println("Español: " + messageSpanish);
    }

}

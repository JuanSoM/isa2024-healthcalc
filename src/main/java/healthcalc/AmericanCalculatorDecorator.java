package healthcalc;

import java.util.Locale;

public class AmericanCalculatorDecorator extends HealthHospitalDecorator {
    public AmericanCalculatorDecorator(HealthStatsProxy healthHospital) {
        super(healthHospital);
    }

    @Override
    public double bmr(char gender, int age, int height, float weight) {
    	
    	int heightInMeters = Math.round(height * 0.3048f * 100);
        double bmr = super.bmr(gender, age, (int)heightInMeters, (float)(weight * 0.453592));
        displayMessage("BMR", height, weight, bmr);
        return bmr;
    }

    @Override
    public float pesoIdeal(char gender, int height) {
        return super.pesoIdeal(gender, (int)(height * 0.3048));
    }

    private void displayMessage(String operation, double height, double weight, double result) {
        String messageEnglish = String.format(Locale.ENGLISH, "The person with height %.2f feet and %.2f pounds has a %s of %.2f.", height, weight, operation, result);
        String messageSpanish = String.format("La persona con altura %.2f pies y %.2f libras tiene un %s de %.2f.", height, weight, operation, result);

        // Imprimir el mensaje en inglés
        System.out.println("English: " + messageEnglish);
        
        // Imprimir el mensaje en español
        System.out.println("Español: " + messageSpanish);
    }

}
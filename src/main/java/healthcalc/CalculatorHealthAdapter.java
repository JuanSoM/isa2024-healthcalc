package healthcalc;

//Adaptador que implementa la interfaz HealthHospital y utiliza la clase HealthCalcImpl
public class CalculatorHealthAdapter implements HealthHospital {
 private HealthCalcImpl healthCalculator;

 // Constructor que recibe una instancia de HealthCalcImpl
 public CalculatorHealthAdapter(HealthCalcImpl healthCalculator) {
     this.healthCalculator = healthCalculator;
 }

 // Implementación del método bmr de la interfaz HealthHospital
 @Override
 public double bmr(char gender, int age, int height, float weight) {
     return healthCalculator.basalMetabolicRate(weight, height, gender, age);
 }

 // Implementación del método pesoIdeal de la interfaz HealthHospital
 @Override
 public float pesoIdeal(char gender, int height) {
     return healthCalculator.idealWeight(height, gender);
 }
}

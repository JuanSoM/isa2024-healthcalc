package healthcalc;

// Adaptador que implementa la interfaz HealthHospital y utiliza la clase HealthCalcImpl
public class CalculatorHealthAdapter implements HealthHospital {
    private HealthCalcImpl healthCalculator;

    // Constructor que recibe una instancia de HealthCalcImpl
    public CalculatorHealthAdapter(HealthCalcImpl healthCalculator) {
        this.healthCalculator = healthCalculator;
    }

    // Implementación del método bmr de la interfaz HealthHospital
    @Override
    public double bmr(char gender, int age, int height, float weight) {
        // Convertimos el char gender a Gender enum y creamos un objeto Person
        Gender genderEnum = Character.toUpperCase(gender) == 'M' ? Gender.MALE : Gender.FEMALE;
        Person person = new PersonImpl(weight, height, genderEnum, age);
        return healthCalculator.basalMetabolicRate(person);
    }

    // Implementación del método pesoIdeal de la interfaz HealthHospital
    @Override
    public float pesoIdeal(char gender, int height) {
        // Convertimos el char gender a Gender enum y creamos un objeto Person
        Gender genderEnum = Character.toUpperCase(gender) == 'M' ? Gender.MALE : Gender.FEMALE;
        // El peso y la edad no son relevantes para este cálculo, se usan valores arbitrarios válidos
        Person person = new PersonImpl(height, genderEnum);
        return (float) healthCalculator.getIdealBodyWeight(person);
    }
}

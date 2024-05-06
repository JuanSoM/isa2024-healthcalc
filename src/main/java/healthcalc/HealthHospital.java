package healthcalc;

public interface HealthHospital {
    // Método para calcular el BMR (Tasa Metabólica Basal)
    double bmr(char gender, int age, int height, float weight);
    
    // Método para calcular el peso ideal
    float pesoIdeal(char gender, int height);
}
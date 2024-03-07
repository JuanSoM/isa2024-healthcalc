package healthcalc;

public class HealthCalcImpl {
    
    public float idealWeight(int height, char gender) {
        // Restricciones para la altura
        if (height <= 0) {
            throw new IllegalArgumentException("La altura debe ser un valor positivo.");
        }

        // Restricciones para el género
        if (gender != 'M' && gender != 'F') {
            throw new IllegalArgumentException("El género debe ser 'M' o 'F'.");
        }

        // Calcular el peso ideal según la fórmula de Lorentz
        float idealWeight;
        if (gender == 'M') {
            idealWeight = height - 100 - (height - 150) / 4f;
        } else {
            idealWeight = height - 100 - (height - 150) / 2.5f;
        }

        // Asegurarse de que el peso ideal sea positivo
        if (idealWeight <= 0) {
            throw new IllegalStateException("El peso ideal calculado es no válido.");
        }

        return idealWeight;
    }
    public float basalMetabolicRate(float weight, int height, char gender, int age) {
        // Restriccion para el peso: <=0
        if (weight <= 0 ) {
            throw new IllegalArgumentException("El peso debe ser positivo.");
        }
       
        // Restriccion para la altura: <=0
        if (height <= 0) {
            throw new IllegalArgumentException("La altura debe ser positiva.");
        }
        
        // Restriccion para la edad: <=0
        if (age <= 0) {
            throw new IllegalArgumentException("La edad debe ser positiva.");
        }
        // Restricciones para el género
        if (gender != 'M' && gender != 'F') {
            throw new IllegalArgumentException("El género debe ser 'M' o 'F'.");
        }

        // Calcular la Tasa Metabólica Basal (BMR) según la fórmula especificada
        float bmr;
        if (Character.toUpperCase(gender) == 'M') {
            bmr = 10 * weight + 6.25f * height - 5 * age + 5; 
            // Restricciones para el bmr
            if (bmr <= 0) {
                throw new IllegalArgumentException("El bmr debe ser positivo.");
            }
        } else {
            bmr = 10 * weight + 6.25f * height - 5 * age - 161; 
            // Restricciones para el bmr
            if (bmr <= 0) {
                throw new IllegalArgumentException("El bmr debe ser positivo.");
            }

        }

        return bmr;
    } 
}

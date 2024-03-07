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

    
}

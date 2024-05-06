package healthcalc;

public class HealthCalcImpl {
    
	// Paso 3: Crear un campo estático para almacenar la única instancia
    private static HealthCalcImpl instance;

    // Paso 1 y 2: Hacer el constructor privado
    private HealthCalcImpl() {
        // Constructor privado para evitar la instanciación desde fuera de la clase
    }

    // Paso 4: Proporcionar un método estático para acceder a la instancia única
    public static HealthCalcImpl getInstance() {
        if (instance == null) {
            instance = new HealthCalcImpl();
        }
        return instance;
    }
	
	
	public float idealWeight(int height, char gender) {
        // Restricciones para la altura
        if (height <= 0) {
            throw new IllegalArgumentException("La altura debe ser un valor positivo.");
        }
        // Restriccion para la altura: supera los limites operables
        if(height>=Integer.MAX_VALUE){
            throw new IllegalArgumentException("La altura supera los limites operables.");
        }

        // Restricciones para el género
        if (Character.toUpperCase(gender) != 'M' && Character.toUpperCase(gender) != 'F') {
            throw new IllegalArgumentException("El género debe ser 'M' o 'F'.");
        }

        // Calcular el peso ideal según la fórmula de Lorentz
        float idealWeight;
        if (Character.toUpperCase(gender) == 'M') {
            idealWeight = height - 100 - (height - 150) / 4f;
        } else {
            idealWeight = height - 100 - (height - 150) / 2.5f;
        }

        // Asegurarse de que el peso ideal sea positivo
        if (idealWeight <= 0) {
            throw new IllegalArgumentException("El peso ideal calculado es no válido.");
        }

        return idealWeight;
    }



    public float basalMetabolicRate(float weight, int height, char gender, int age) {
        // Restriccion para el peso: <=0
        if (weight <= 0 ) {
            throw new IllegalArgumentException("El peso debe ser positivo.");
        }
         // Restriccion para el peso: supera los limites operables
         if(weight>=Float.MAX_VALUE){
            throw new IllegalArgumentException("El peso supera los limites operables.");
        }
       
        // Restriccion para la altura: <=0
        if (height <= 0) {
            throw new IllegalArgumentException("La altura debe ser positiva.");
        }
        // Restriccion para la altura: supera los limites operables
        if(height>=Integer.MAX_VALUE){
            throw new IllegalArgumentException("La altura supera los limites operables.");
        }
        // Restriccion para la edad: <=0
        if (age <= 0) {
            throw new IllegalArgumentException("La edad debe ser positiva.");
        }
        // Restriccion para la edad: supera los limites operables
        if(age>=Integer.MAX_VALUE){
            throw new IllegalArgumentException("La edad supera los limites operables.");
        }
        // Restricciones para el género
        if (Character.toUpperCase(gender) != 'M' && Character.toUpperCase(gender) != 'F') {
            throw new IllegalArgumentException("El género debe ser 'M' o 'F'.");
        }

        // Calcular la Tasa Metabólica Basal (BMR) según la fórmula especificada
        float bmr;
        if (Character.toUpperCase(gender) == 'M') {
            bmr = 10 * weight + 6.25f * height - 5 * age + 5; 
            // Restricciones para el bmr: <=0
            if (bmr <= 0) {
                throw new IllegalArgumentException("El bmr debe ser positivo.");
            }
        } else {
            bmr = 10 * weight + 6.25f * height - 5 * age - 161; 
            // Restricciones para el bmr: <=0
            if (bmr <= 0) {
                throw new IllegalArgumentException("El bmr debe ser positivo.");
            }

        }

        return bmr;
    } 
}

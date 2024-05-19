package healthcalc;

public class HealthCalcImpl implements CardiovascularMetrics, MetabolicMetrics {

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

    @Override
    public double getIdealBodyWeight(Person person) {
        float height = person.height();
        Gender gender = person.gender();

        // Calcular el peso ideal según la fórmula de Lorentz
        double idealWeight;
        if (gender == Gender.MALE) {
            idealWeight = height - 100 - (height - 150) / 4.0;
        } else {
            idealWeight = height - 100 - (height - 150) / 2.5;
        }

        // Asegurarse de que el peso ideal sea positivo
        if (idealWeight <= 0) {
            throw new IllegalArgumentException("El peso ideal calculado es no válido.");
        }

        return idealWeight;
    }

    @Override
    public double basalMetabolicRate(Person person) {
        float weight = person.weight();
        float height = person.height();
        int age = person.age();
        Gender gender = person.gender();

        // Calcular la Tasa Metabólica Basal (BMR) según la fórmula especificada
        double bmr;
        if (gender == Gender.MALE) {
            bmr = 10 * weight + 6.25 * height - 5 * age + 5;
            // Restricciones para el bmr: <=0
            if (bmr <= 0) {
                throw new IllegalArgumentException("El BMR debe ser positivo.");
            }
        } else {
            bmr = 10 * weight + 6.25 * height - 5 * age - 161;
            // Restricciones para el bmr: <=0
            if (bmr <= 0) {
                throw new IllegalArgumentException("El BMR debe ser positivo.");
            }
        }

        return bmr;
    }
}


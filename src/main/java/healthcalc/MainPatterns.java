package healthcalc;

public class MainPatterns {
    public static void main(String[] args) {
        // Paso 1: Crear una instancia de HealthCalcImpl
        HealthCalcImpl healthCalcImpl = HealthCalcImpl.getInstance();

        // Paso 2: Crear una instancia de CalculatorHealthAdapter
        CalculatorHealthAdapter adapter = new CalculatorHealthAdapter(healthCalcImpl);

        // Paso 3: Utilizar los métodos de la interfaz HealthHospital a través del adaptador
        char gender = 'M';
        int age = 30;
        int height = 180;
        float weight = 70.5f;

        double bmr = adapter.bmr(gender, age, height, weight);
        float idealWeight = adapter.pesoIdeal(gender, height);

        // Paso 4: Imprimir los resultados o realizar cualquier otra acción
        System.out.println("BMR: " + bmr);
        System.out.println("Peso Ideal: " + idealWeight);
        
        // Paso 2: Crear una instancia del Proxy
        HealthStatsProxy proxy = new HealthStatsProxy(adapter);

        // Llamamos a los métodos proxy.pesoIdeal() y proxy.bmr() para agregar valores a las listas
        proxy.pesoIdeal(gender, height);
        proxy.bmr(gender, age, height, weight);

        // Probamos con otros valores
        char gender2 = 'F';
        int age2 = 25;
        int height2 = 160;
        float weight2 = 60.0f;

        // Llamamos a los métodos proxy.pesoIdeal() y proxy.bmr() nuevamente con diferentes valores
        proxy.pesoIdeal(gender2, height2);
        proxy.bmr(gender2, age2, height2, weight2);

        // Ahora podemos obtener las medias y otros datos
        float averageWeight = proxy.averageWeight();
        float averageHeight = proxy.averageHeight();
        float averageAge = proxy.averageAge();
        float averageBMR = proxy.averageBMR();
        int numMale = proxy.numSexoH();
        int numFemale = proxy.numSexoM();
        int numTotalPatients = proxy.numTotalPacientes();

        // Paso 4: Imprimir los resultados o realizar cualquier otra acción
        System.out.println("Media de peso: " + averageWeight);
        System.out.println("Media de altura: " + averageHeight);
        System.out.println("Media de edad: " + averageAge);
        System.out.println("Media de BMR: " + averageBMR);
        System.out.println("Número de pacientes masculinos: " + numMale);
        System.out.println("Número de pacientes femeninos: " + numFemale);
        System.out.println("Número total de pacientes: " + numTotalPatients);
    }
}

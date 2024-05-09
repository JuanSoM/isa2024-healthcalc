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
        
        char gender3 = 'F';
        int age3 = 30;
        int height3 = 5;
        float weight3 = 160.0f;
        
       
        // Paso 2: Crear una instancia del Proxy
        HealthStatsProxy proxy = new HealthStatsProxy(adapter);
    
        
        HealthHospitalDecorator europeanDecorator = new EuropeanCalculatorDecorator(proxy);
        HealthHospitalDecorator americanDecorator = new AmericanCalculatorDecorator(proxy);
        
        
        europeanDecorator.bmr(gender, age, height, weight);

        americanDecorator.bmr(gender3, age3, height3, weight3);
        
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

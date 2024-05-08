package healthcalc;

public interface HealthStats {
    // Métodos para calcular las estadísticas de salud
    float averageHeight();
    float averageWeight();
    float averageAge();
    float averageBMR();
    int numSexoH();
    int numSexoM();
    int numTotalPacientes();
}

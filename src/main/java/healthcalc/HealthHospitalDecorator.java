package healthcalc;

public abstract class HealthHospitalDecorator implements HealthHospital {
    protected HealthStatsProxy healthHospital;

    public HealthHospitalDecorator(HealthStatsProxy healthHospital) {
        this.healthHospital = healthHospital;
    }

    @Override
    public double bmr(char gender, int age, int height, float weight) {
        return healthHospital.bmr(gender, age, height, weight);
    }

    @Override
    public float pesoIdeal(char gender, int height) {
        return healthHospital.pesoIdeal(gender, height);
    }
}

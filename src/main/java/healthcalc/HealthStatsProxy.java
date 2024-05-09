package healthcalc;

import java.util.ArrayList;
import java.util.List;

public class HealthStatsProxy implements HealthStats {
    private HealthHospital healthHospital;
    private List<Integer> heights;
    private List<Float> weights;
    private List<Integer> ages;
    private List<Float> bmrs;
    private int numMales;
    private int numFemales;


    public HealthStatsProxy(HealthHospital healthHospital) {
        this.healthHospital = healthHospital;
        this.heights=new ArrayList<>();
        this.weights = new ArrayList<>();
        this.ages = new ArrayList<>();
        this.bmrs = new ArrayList<>();
        this.numMales=0;
        this.numFemales=0;
    }
    
    public int pesoIdeal(char gender, int height) {
        float idealWeight = healthHospital.pesoIdeal(gender, height);
        heights.add(height);
        if (gender == 'M') {
        	numMales++;
        } else if (gender == 'F') {
        	numFemales++;
        }
        return (int)idealWeight;
    }
    
    public double bmr(char gender, int age, int height, float weight) {
        double bmr = healthHospital.bmr(gender, age, height, weight);
        weights.add((float) weight);
        heights.add(height);
        ages.add(age);
        bmrs.add((float) bmr);
        if (gender == 'M') {
        	numMales++;
        } else if (gender == 'F') {
        	numFemales++;
        }
        return bmr;
    }
 

    @Override
    public float averageWeight() {
    	return MediasFloat(weights);
    }

    @Override
    public float averageHeight() {
    	return MediasInteger(heights); 
    }
    
    @Override
    public float averageAge() {
    	return MediasInteger(ages);
    }

    @Override
    public float averageBMR() {
        return MediasFloat(bmrs);
    }
	@Override
	public int numSexoH() {
		// TODO Auto-generated method stub
		return numMales;//sumamos dos veces porque ejecutamos tanto bmr como iw
	}

	@Override
	public int numSexoM() {
		// TODO Auto-generated method stub
		return numFemales;
	}

	@Override
	public int numTotalPacientes() {
		// TODO Auto-generated method stub
		return numMales+numFemales;
	}
	
	private float MediasFloat(List<Float> lista) {
	    float total = 0;
	    for (Float value : lista) {
	        total += value;
	    }
	    if (lista.size() > 0) {
	        return total / lista.size();
	    } else {
	        return 0; // Manejo de caso cuando la lista está vacía para evitar división por cero
	    }
	}
	public float MediasInteger(List<Integer> lista) {
    	float total = 0;
	    for (Integer value : lista) {
	        total += value;
	    }
	    if (lista.size() > 0) {
	        return total / lista.size();
	    } else {
	        return 0; // Manejo de caso cuando la lista está vacía para evitar división por cero
	    } 
    }
}

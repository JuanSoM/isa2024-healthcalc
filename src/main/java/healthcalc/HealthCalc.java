package healthcalc;

/**
 * Calculator of some health parameters of persons.
 * 
 */
public interface HealthCalc {
    
    /**
     * Calculate the ideal weight (IW) of a person following the Lorentz formula:
     * For men: IW = height - 100 - (height - 150) / 4)
     * For women: IW = height - 100 - (height - 150) / 2.5)
     *
     * @param person 	Person object containing height and gender.
     * @return 		 	The ideal weight of the person (kg).
     * @throws IllegalArgumentException if the height is not a positive value or if the gender is invalid.
     */
    public double getIdealBodyWeight(Person person);
    
    /**
     * Calculate the Basal Metabolic Rate (BMR) of a person with the following formula:
     * For men: BMR = 10 * weight + 6.25 * height - 5 * age + 5
     * For women: BMR = 10 * weight + 6.25 * height - 5 * age - 161
     *   
     * @param person	Person object containing weight, height, gender, and age.
     * @return	  		The Basal Metabolic Rate of the person.
     * @throws IllegalArgumentException if any of the parameters are not valid.
     */
    public double basalMetabolicRate(Person person);
}

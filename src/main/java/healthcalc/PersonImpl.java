package healthcalc;

public class PersonImpl implements Person {
    private float weight;
    private float height;
    private Gender gender;
    private int age;

    public PersonImpl(float weight, float height, Gender gender, int age) {
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
        if (gender == null) {
            throw new IllegalArgumentException("El genero no es correcto");
        }
        // Additional overflow checks can be done as required
        
        this.weight = weight;
        this.height = height;
        this.gender = gender;
        this.age = age;
    }
    public PersonImpl(float height, Gender gender) {
        
    	// Restricciones para la altura
        if (height <= 0) {
            throw new IllegalArgumentException("La altura debe ser un valor positivo.");
        }
        // Restriccion para la altura: supera los limites operables
        if(height>=Integer.MAX_VALUE){
            throw new IllegalArgumentException("La altura supera los limites operables.");
        }
        
        if (gender == null) {
            throw new IllegalArgumentException("El genero no es correcto");
        }
        this.height = height;
        this.gender = gender;
    }

    @Override
    public float weight() {
        return weight;
    }

    @Override
    public float height() {
        return height;
    }

    @Override
    public Gender gender() {
        return gender;
    }

    @Override
    public int age() {
        return age;
    }
}


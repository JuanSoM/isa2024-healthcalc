package bdd;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import healthcalc.HealthCalcImpl;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

public class BMR_StepsDef {
    private HealthCalcImpl healthCalc;
    private int height;
    private char gender;
    private float weight;
    private int age;
    private float result2;
    private String raiseException;
    private boolean error;


    @Before
    public void initialization() {
        this.healthCalc = null;
        this.height = 0;
        this.gender = ' ';
        this.age=0;
        this.weight=0;
        this.result2=0;
        this.raiseException="";
        this.error=false;
    }
    //TASA METABOLICA BASAL

    @Given("que tengo una calculadora para la tasa metabolica basal")
    public void un_persona_con_datos() {
        this.healthCalc = new HealthCalcImpl();
    }

    @When("calculo la tasa metabólica basal con peso {float}, altura {int}, genero {string} y edad {int}")
    public void calculo_la_tasa_metabólica_basal(float weight, int height, String gender, int age) {
        char genderChar = gender.charAt(0);
        try {
            this.result2 = healthCalc.basalMetabolicRate(weight, height, genderChar, age);
        } catch (Exception e) {
            this.raiseException = e.getMessage();
        }
    }

    @Then("el sistema debería devolver el BMR {float}, de acuerdo con la formula especificada")
    public void el_sistema_debería_devolver_el_BMR_de_acuerdo_con_la_formula_especificada(float expectedBMR ) {
        float delta = 0.001f; 
        Assert.assertEquals(expectedBMR, result2, delta);
    }
    
    //ALTURA OVERFLOW
    @When("Hacemos el calculo con un altura overflow, peso {float}, genero {string} y edad {int}")
	public void calculo_la_tasa_metabólica_basal_con_una_altura_overflow(float weight, String gender, int age) {
		try {
            this.height=Integer.MAX_VALUE;
            char genderChar = gender.charAt(0);
			this.result2 = healthCalc.basalMetabolicRate(weight, height, genderChar, age);
		} catch (Exception e) {
			this.raiseException = e.getMessage();
            this.error = true;
		}
	}
    
    //PESO OVERFLOW
    @When("Hacemos el calculo con un peso overflow, genero femenino, edad 61 y altura 180")
	public void calculo_la_tasa_metabólica_basal_con_un_peso_overflow() {
		try {
			this.result2 = healthCalc.basalMetabolicRate(Float.MAX_VALUE, 180, 'F', 61);
		} catch (Exception e) {
			this.raiseException = e.getMessage();
		}
	}
    //EDAD OVERFLOW
    @When("Hacemos el calculo con una edad overflow, genero masculino, peso 67 y altura 180")
    public void calculo_la_tasa_metabólica_basal_con_una_edad_overflow() {
        try {
            this.result2 = healthCalc.basalMetabolicRate(67, 180, 'M', Integer.MAX_VALUE);
        } catch (Exception e) {
            this.raiseException = e.getMessage();
        }
    }

    //DEVUELVE EXCEPCION DE OVERFLOW
    @Then("Devuelve una excepcion de overflow")
	public void Overf_BMR() {
        if (this.raiseException.contains("supera los limites operables.")) {
            this.error = true;
        }
	    Assertions.assertTrue(error);
	}
    //DEVUELVE UNA EXCEPCION DE BMR NEGATIVO
    @Then("Devuelve una excepcion de BMR negativo o igual a 0")
	public void devuelve_excepcion_BMR() {
        if (this.raiseException.contains("El bmr debe ser positivo.")) {
            this.error = true;
        }
	    Assertions.assertTrue(error);
	}
    //DEVUELVE UNA EXCEPCION DE PARAMETROS INCORRECTOS
    @Then("el sistema detecta parametros incorrectos")
    public void el_sistema_detecta_parametros_incorrectos() {
        
        if ((this.raiseException.contains("debe ser positiv") || 
             this.raiseException.contains("género debe ser"))) {
                this.error = true;
             }
        Assertions.assertTrue(error);
        
    }  
}

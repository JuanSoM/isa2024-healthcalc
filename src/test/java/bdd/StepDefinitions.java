package bdd;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import healthcalc.HealthCalc;
import healthcalc.HealthCalcImpl;
import healthcalc.NegativeValueException;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

public class StepDefinitions {
    
    private HealthCalcImpl healthCalc;
    private int height;
    private char gender;
    private float result;
    private float weight; 
    private int age; 
    private boolean raiseException;

    

    @Before
    public void initialization() {
        healthCalc = null;
        height = 0;
        gender = '\0';
        result = 0.0f;
        age = 0;
        weight = 0;
    }

    @Given("que tengo una calculadora para el peso ideal")
    public void un_hombre_con_una_altura_de_cm(int height) {
        this.healthCalc = new HealthCalcImpl();
    }

    @When("^calculo el peso ideal$")
    public void calculo_el_peso_ideal() {
        result = healthCalc.idealWeight(height, gender);
    }

    @Then("el sistema debería devolver el peso ideal de acuerdo con la formula de Lorentz")
    public void el_sistema_debería_devolver_el_peso_ideal_de_acuerdo_con_la_formula_de_Lorentz(float expected) {
        Assert.assertNotEquals(expected, result);
    }



    @When("Hacer la {int}")
	public void i_compute_the_factorial_of_a_negative_number(Integer int1) {
		try {
			result = factCalc.compute(int1);
		} catch (NegativeValueException e) {
			raiseException = true;
		}
	}
    @Then("The system raises an exception")
	public void the_system_raises_an_exception() {
	    Assertions.assertTrue(raiseException);
	}










    @Given("que tengo una calculadora para la tasa metabolica basal")
    public void un_persona_con_datos(int age, float weight, int height) {
        this.healthCalc = new HealthCalcImpl();
    }

    @When("^calculo la tasa metabólica basal$")
    public void calculo_la_tasa_metabólica_basal(float weight, int height, char gender, int age) {
        // Aquí necesitarías llamar al método basalMetabolicRate y almacenar el resultado
        result = healthCalc.basalMetabolicRate(weight, height, gender, age);
    }

    @Then("^el sistema debería devolver el BMR de acuerdo con la formula especificada$")
    public void el_sistema_debería_devolver_el_BMR_de_acuerdo_con_la_formula_especificada(float expectedBMR ) {
        float delta = 0.001f; // Cambia este valor al margen de error adecuado para tus pruebas
        // Aquí necesitarías agregar las aserciones para verificar si el resultado es el esperado
        Assert.assertEquals(expectedBMR, result, delta);
    }
}

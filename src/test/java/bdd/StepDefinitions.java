package bdd;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import healthcalc.HealthCalcImpl;
import healthcalc.IncorrectCharacterException;
import healthcalc.NegativeValueException;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

public class StepDefinitions {
    
    private HealthCalcImpl healthCalc;
    private float result;
    private boolean raiseException;

    

    @Before
    public void initialization() {
        healthCalc = null;
        result=0;
        raiseException=false;
    }

    //PESO IDEAL

    @Given("que tengo una calculadora para el peso ideal")
    public void un_hombre_con_una_altura_de_cm() {
        this.healthCalc = new HealthCalcImpl();
    }


    @When("calculo el peso ideal")
    public void calculo_el_peso_ideal(int height, char gender) {
        result = healthCalc.idealWeight(height, gender);
    }

    @Then("el sistema debería devolver el peso ideal de acuerdo con la formula de Lorentz")
    public void el_sistema_debería_devolver_el_peso_ideal_de_acuerdo_con_la_formula_de_Lorentz(float expected) {
        float delta = 0.001f;
        Assert.assertEquals(expected, result,delta);
    }


    //ALTURA OVERFLOW
    @When("Hacemos el calculo con un altura overflow {int}")
	public void calculo_el_peso_ideal_con_una_altura_overflow(int height,char gender) {
		try {
			result = healthCalc.idealWeight(height, gender);
		} catch (NegativeValueException e) {
			raiseException = true;
		}
	}
    @Then("Devuelve una excepcion de altura overflow")
	public void ParameterValueCausesOverflow() {
	    Assertions.assertTrue(raiseException);
	}


    //ALTURA NEGATIVA
    @When("Hacemos el calculo con un altura negativa {int}")
	public void calculo_el_peso_ideal_con_una_altura_negativa(int height,char gender) {
		try {
			result = healthCalc.idealWeight(height, gender);
		} catch (NegativeValueException e) {
			raiseException = true;
		}
	}
    @Then("Devuelve una excepcion de altura negativa")
	public void devuelve_excepcion_peso() {
	    Assertions.assertTrue(raiseException);
	}

    //GENERO INCORRECTO
    @When("Hacemos el calculo con un genero incorrecto {char}")
	public void calculo_el_peso_ideal_con_un_genero_incorrecto(int height,char gender) {
		try {
			result = healthCalc.idealWeight(height, gender);
		} catch (IncorrectCharacterException e) {
			raiseException = true;
		}
	}
    @Then("The system raises an exception")
	public void devuelve_excepcion_genero() {
	    Assertions.assertTrue(raiseException);
	}











    //TASA METABOLICA BASAL

    @Given("que tengo una calculadora para la tasa metabolica basal")
    public void un_persona_con_datos(int age, float weight, int height) {
        this.healthCalc = new HealthCalcImpl();
    }


    

    @When("calculo la tasa metabólica basal")
    public void calculo_la_tasa_metabólica_basal(float weight, int height, char gender, int age) {
        // Aquí necesitarías llamar al método basalMetabolicRate y almacenar el resultado
        result = healthCalc.basalMetabolicRate(weight, height, gender, age);
    }

    @Then("el sistema debería devolver el BMR de acuerdo con la formula especificada")
    public void el_sistema_debería_devolver_el_BMR_de_acuerdo_con_la_formula_especificada(float expectedBMR ) {
        float delta = 0.001f; // Cambia este valor al margen de error adecuado para tus pruebas
        // Aquí necesitarías agregar las aserciones para verificar si el resultado es el esperado
        Assert.assertEquals(expectedBMR, result, delta);
    }
    
    //ALTURA OVERFLOW
    @When("Hacemos el calculo con un altura overflow {int}")
	public void calculo_la_tasa_metabólica_basal_con_una_altura_overflow(float weight, int height, char gender, int age) {
		try {
			result = healthCalc.basalMetabolicRate(weight, height, gender, age);
		} catch (NegativeValueException e) {
			raiseException = true;
		}
	}
    @Then("Devuelve una excepcion de altura overflow")
	public void ParameterValueCausesOverflow_BMR() {
	    Assertions.assertTrue(raiseException);
	}

    //ALTURA NEGATIVA
    @When("Hacemos el calculo con un altura negativa {int}")
	public void calculo_la_tasa_metabólica_basal_con_una_altura_negativa(float weight, int height, char gender, int age) {
		try {
			result = healthCalc.basalMetabolicRate(weight, height, gender, age);
		} catch (NegativeValueException e) {
			raiseException = true;
		}
	}
    @Then("Devuelve una excepcion de altura negativa")
	public void devuelve_excepcion_altura_BMR() {
	    Assertions.assertTrue(raiseException);
	}

    //PESO OVERFLOW
    @When("Hacemos el calculo con un peso overflow {int}")
	public void calculo_la_tasa_metabólica_basal_con_un_peso_overflow(float weight, int height, char gender, int age) {
		try {
			result = healthCalc.basalMetabolicRate(weight, height, gender, age);
		} catch (NegativeValueException e) {
			raiseException = true;
		}
	}
    @Then("Devuelve una excepcion de peso overflow")
	public void ParameterValueCausesOverflow_BMR_peso() {
	    Assertions.assertTrue(raiseException);
	}

    //PESO NEGATIVO
    @When("Hacemos el calculo con un peso negativo {int}")
	public void calculo_la_tasa_metabólica_basal_con_un_peso_negativo(float weight, int height, char gender, int age) {
		try {
			result = healthCalc.basalMetabolicRate(weight, height, gender, age);
		} catch (NegativeValueException e) {
			raiseException = true;
		}
	}
    @Then("Devuelve una excepcion de peso negativo")
	public void devuelve_excepcion_peso_BMR() {
	    Assertions.assertTrue(raiseException);
	}

    //EDAD OVERFLOW
    @When("Hacemos el calculo con una edad overflow {int}")
	public void calculo_la_tasa_metabólica_basal_con_una_edad_overflow(float weight, int height, char gender, int age) {
		try {
			result = healthCalc.basalMetabolicRate(weight, height, gender, age);
		} catch (NegativeValueException e) {
			raiseException = true;
		}
	}
    @Then("Devuelve una excepcion de edad overflow")
	public void ParameterValueCausesOverflow_BMR_edad() {
	    Assertions.assertTrue(raiseException);
	}

    //EDAD NEGATIVA
    @When("Hacemos el calculo con una edad negativa {int}")
	public void calculo_la_tasa_metabólica_basal_con_una_edad_negativa(float weight, int height, char gender, int age) {
		try {
			result = healthCalc.basalMetabolicRate(weight, height, gender, age);
		} catch (NegativeValueException e) {
			raiseException = true;
		}
	}
    @Then("Devuelve una excepcion de edad negativa")
	public void devuelve_excepcion_edad_BMR() {
	    Assertions.assertTrue(raiseException);
	}


    //GENERO INCORRECTO
    @When("Hacemos el calculo con un genero incorrecto {char}")
	public void calculo_la_tasa_metabólica_basal_con_un_genero_incorrecto(float weight, int height, char gender, int age) {
		try {
			result = healthCalc.basalMetabolicRate(weight, height, gender, age);
		} catch (IncorrectCharacterException e) {
			raiseException = true;
		}
	}
    @Then("Devuelve una excepcion de genero incorrecto")
	public void devuelve_excepcion_genero_BMR() {
	    Assertions.assertTrue(raiseException);
	}
}

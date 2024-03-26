package bdd;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import healthcalc.HealthCalcImpl;


import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

public class IdealWeigth_StepsDef {
    
    private HealthCalcImpl healthCalc;
    private int height;
    private char gender;
    private float result;
    private String raiseException;
    private boolean error;

    

    @Before
    public void initialization() {
        healthCalc = null;
        this.height = 0;
        this.gender = ' ';
        result=0;
        raiseException="";
        error=false;
    }

    //PESO IDEAL

    @Given("que tengo una calculadora para el peso ideal")
    public void un_hombre_con_una_altura_de_cm() {
        this.healthCalc = new HealthCalcImpl();
    }


    @When("calculo el peso ideal con altura {int} y genero {string}")
    public void calculo_el_peso_ideal(int height, String gender) {
        char genderChar = gender.charAt(0);
        this.gender = genderChar;
        this.height = height;
        try {
            result = healthCalc.idealWeight(height, genderChar); 
        } catch (Exception e) {
            this.raiseException = e.getMessage();
            error = true;
        }
        
    }

    
    @Then("el sistema deberia devolver el peso ideal {float}, de acuerdo con la formula de Lorentz")
    public void el_sistema_deberia_devolver_el_peso_ideal_de_acuerdo_con_la_formula_de_Lorentz(float expected) {
        float delta = 0.001f;
        Assert.assertEquals(expected, result,delta);
    }

    @Then("la calculadora debe lanzar un error")
    public void the_calculator_should_raise_an_error() {
        
        if ((this.raiseException.contains("valor positivo") || 
             this.raiseException.contains("género debe ser"))) {
                this.error = true;
             }
        Assertions.assertTrue(error);
        
    }
    @Then("Devuelve una excepcion de idealWeigth negativa")
	public void devuelve_excepcion_peso() {
        if (this.raiseException.contains("El peso ideal calculado es no válido.")) {
            this.error = true;
        }
	    Assertions.assertTrue(error);
	}
     //ALTURA OVERFLOW
     @When("Hacemos el calculo con un altura overflow y genero masculino")
     public void calculo_el_peso_ideal_con_una_altura_overflow() {
         try {
             int height=Integer.MAX_VALUE;
             result = healthCalc.idealWeight(height, 'M');
         } catch (Exception e) {
             this.raiseException = e.getMessage();
         }
     }
    @Then("Devuelve una excepcion de altura overflow")
	public void ParameterValueCausesOverflow_ideal() {
        if (this.raiseException.contains("La altura supera los limites operables.")) {
            this.error = true;
        }
	    Assertions.assertTrue(error);
	}


    
    
}

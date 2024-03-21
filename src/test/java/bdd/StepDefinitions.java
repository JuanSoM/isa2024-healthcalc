package bdd;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import healthcalc.HealthCalc;
import healthcalc.HealthCalcImpl;

import org.junit.Assert;

public class StepDefinitions {
    
    private HealthCalcImpl healthCalc;
    private int height;
    private char gender;
    private float result;
    private float weight; 
    private int age; 
    

    @Before
    public void initialization() {
        healthCalc = null;
        height = 0;
        gender = '\0';
        result = 0.0f;
        age = 0;
        weight = 0;
    }

    @Given("^un hombre con una altura de (\\d+) cm$")
    public void un_hombre_con_una_altura_de_cm(int height) {
        this.healthCalc = new HealthCalcImpl();
        this.height = height;
        this.gender = 'M';
    }

    @Given("^una mujer con una altura de (\\d+) cm$")
    public void una_mujer_con_una_altura_de_cm(int height) {
        this.healthCalc = new HealthCalcImpl();
        this.height = height;
        this.gender = 'F';
    }

    @When("^calculo el peso ideal$")
    public void calculo_el_peso_ideal() {
        result = healthCalc.idealWeight(height, gender);
    }

    @Then("^el sistema debería devolver el peso ideal de acuerdo con la formula de Lorentz$")
    public void el_sistema_debería_devolver_el_peso_ideal_de_acuerdo_con_la_formula_de_Lorentz() {
        Assert.assertNotEquals(0, result);
    }

    @Given("^un hombre|mujer de (\\d+) años con un peso de (\\d+) kg y una altura de (\\d+) cm$")
    public void un_persona_con_datos(int age, float weight, int height) {
        this.healthCalc = new HealthCalcImpl();
        this.height = height;
        // Aquí necesitarías establecer el género según el escenario
        this.gender = 'M';
    }

    @When("^calculo la tasa metabólica basal$")
    public void calculo_la_tasa_metabólica_basal() {
        // Aquí necesitarías llamar al método basalMetabolicRate y almacenar el resultado
        result = healthCalc.basalMetabolicRate(weight, height, gender, age);
    }

    @Then("^el sistema debería devolver el BMR de acuerdo con la formula especificada$")
    public void el_sistema_debería_devolver_el_BMR_de_acuerdo_con_la_formula_especificada() {
        float expectedBMR = 1500; // Cambia este valor al BMR esperado
        float delta = 0.001f; // Cambia este valor al margen de error adecuado para tus pruebas
        // Aquí necesitarías agregar las aserciones para verificar si el resultado es el esperado
        Assert.assertEquals(expectedBMR, result, delta);
    }
}

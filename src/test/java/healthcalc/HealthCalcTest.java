package healthcalc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Tests para la calculadora de salud.")
public class HealthCalcTest {

    private HealthCalcImpl healthCalc = HealthCalcImpl.getInstance();

    // Tests para getIdealBodyWeight

    @Test
    @DisplayName("Test altura negativa en getIdealBodyWeight")
    public void testAlturaNegativaIdealWeight() {
        assertThrows(IllegalArgumentException.class, () -> new PersonImpl(-1, Gender.MALE));
    }

    @Test
    @DisplayName("Test altura cero en getIdealBodyWeight")
    public void testAlturaCeroIdealWeight() {
        assertThrows(IllegalArgumentException.class, () -> new PersonImpl(0, Gender.MALE));
    }

    @Test
    @DisplayName("Test altura cuando el valor sobrepasa el limite operable en getIdealBodyWeight")
    public void testAlturaOverflowIdealWeight() {
        assertThrows(IllegalArgumentException.class, () -> new PersonImpl(Integer.MAX_VALUE, Gender.MALE));
    }

    @Test
    @DisplayName("Test género no válido para getIdealBodyWeight")
    public void testGeneroNoValidoIdealWeight() {
        assertThrows(IllegalArgumentException.class, () -> new PersonImpl(85, null));
    }

    @Test
    @DisplayName("Test peso ideal negativo con hombre")
    public void testPesoIdealNegativoHombre() {
        PersonImpl persona = new PersonImpl(40, Gender.MALE);
        assertThrows(IllegalArgumentException.class, () -> healthCalc.getIdealBodyWeight(persona));
    }

    @Test
    @DisplayName("Test peso ideal negativo con mujer")
    public void testPesoIdealNegativoMujer() {
    	PersonImpl persona =new PersonImpl(40, Gender.FEMALE);
        assertThrows(IllegalArgumentException.class, () -> healthCalc.getIdealBodyWeight(persona));
    }

    @Test
    @DisplayName("Test peso ideal hombre")
    public void testPesoIdealHombre() throws Exception {
        int height1 = 180;
        Gender gender1 = Gender.MALE;
        float pesoIdealEsperado = height1 - 100 - (height1 - 150) / 4f;
        PersonImpl persona = new PersonImpl(height1, gender1);
        assertEquals(pesoIdealEsperado, healthCalc.getIdealBodyWeight(persona));
    }

    @Test
    @DisplayName("Test peso ideal mujer")
    public void testPesoIdealMujer() throws Exception {
        int height1 = 170;
        Gender gender1 = Gender.FEMALE;
        float pesoIdealEsperado = height1 - 100 - (height1 - 150) / 2.5f;
        PersonImpl persona = new PersonImpl(height1, gender1);
        assertEquals(pesoIdealEsperado, healthCalc.getIdealBodyWeight(persona));
    }

    // Tests para basalMetabolicRate

    @Test
    @DisplayName("Test peso negativo basalMetabolicRate")
    public void testPesoNegativoBasalMetabolicRate() {
        assertThrows(IllegalArgumentException.class, () -> new PersonImpl(-1, 170, Gender.MALE, 20));
    }

    @Test
    @DisplayName("Test peso cero basalMetabolicRate")
    public void testPesoCeroBasalMetabolicRate() {
        assertThrows(IllegalArgumentException.class, () -> new PersonImpl(0, 170, Gender.MALE, 20));
    }

    @Test
    @DisplayName("Test altura negativa basalMetabolicRate")
    public void testAlturaNegativaBasalMetabolicRate() {
        assertThrows(IllegalArgumentException.class, () -> new PersonImpl(60, -1, Gender.MALE, 20));
    }

    @Test
    @DisplayName("Test altura cero basalMetabolicRate")
    public void testAlturaCeroBasalMetabolicRate() {
        assertThrows(IllegalArgumentException.class, () -> new PersonImpl(60, 0, Gender.MALE, 20));
    }

    @Test
    @DisplayName("Test edad negativa basalMetabolicRate")
    public void testEdadNegativaBasalMetabolicRate() {
        assertThrows(IllegalArgumentException.class, () -> new PersonImpl(60, 170, Gender.MALE, -1));
    }

    @Test
    @DisplayName("Test edad cero basalMetabolicRate")
    public void testEdadCeroBasalMetabolicRate() {
        assertThrows(IllegalArgumentException.class, () -> new PersonImpl(60, 170, Gender.MALE, 0));
    }

    @Test
    @DisplayName("Test género no válido para basalMetabolicRate")
    public void testGeneroNoValidoBasalMetabolicRate() {
        assertThrows(IllegalArgumentException.class, () -> new PersonImpl(60, 170, null, 20), "El género no es válido.");
    }

    @Test
    @DisplayName("Test basalMetabolicRate negativo con hombre")
    public void testBasalMetabolicRateNegativoHombre() {
        PersonImpl persona = new PersonImpl(5, 5, Gender.MALE, 50);
        assertThrows(IllegalArgumentException.class, () -> healthCalc.basalMetabolicRate(persona));
    }

    @Test
    @DisplayName("Test basalMetabolicRate negativo con mujer")
    public void testBasalMetabolicRateNegativoMujer() {
        PersonImpl persona = new PersonImpl(5, 5, Gender.FEMALE, 50);
        assertThrows(IllegalArgumentException.class, () -> healthCalc.basalMetabolicRate(persona));
    }

    @Test
    @DisplayName("Test peso sobrepasa el valor valido en basalMetabolicRate")
    public void testPesoOverflowBasalMetabolicRate() {
        assertThrows(IllegalArgumentException.class, () -> new PersonImpl(Float.MAX_VALUE, 170, Gender.MALE, 20));
    }

    @Test
    @DisplayName("Test altura sobrepasa el valor valido en basalMetabolicRate")
    public void testAlturaOverflowBasalMetabolicRate() {
        assertThrows(IllegalArgumentException.class, () -> new PersonImpl(60, Integer.MAX_VALUE, Gender.MALE, 20));
    }

    @Test
    @DisplayName("Test edad sobrepasa el valor valido en basalMetabolicRate")
    public void testEdadOverflowBasalMetabolicRate() {
        assertThrows(IllegalArgumentException.class, () -> new PersonImpl(60, 170, Gender.MALE, Integer.MAX_VALUE));
    }

    @Test
    @DisplayName("Test metabolismo basal mujer")
    public void testMetabolismoBasalMujer() throws Exception {
        float weight = 60;
        int height = 170;
        Gender gender = Gender.FEMALE;
        int age = 20;
        float bmrEsperado = 10 * weight + 6.25f * height - 5 * age - 161;
        PersonImpl persona = new PersonImpl(weight, height, gender, age);
        assertEquals(bmrEsperado, healthCalc.basalMetabolicRate(persona));
    }

    @Test
    @DisplayName("Test metabolismo basal hombre")
    public void testMetabolismoBasalHombre() throws Exception {
        float weight = 60;
        int height = 180;
        Gender gender = Gender.MALE;
        int age = 20;
        float bmrEsperado = 10 * weight + 6.25f * height - 5 * age + 5;
        PersonImpl persona = new PersonImpl(weight, height, gender, age);
        assertEquals(bmrEsperado, healthCalc.basalMetabolicRate(persona));
    }

}

package healthcalc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Tests para la calculadora de salud.")
public class HealthCalcTest {

	private HealthCalcImpl healthCalc = new HealthCalcImpl();

	//Tests para idealweight

	@Test
	@DisplayName("Test altura negativa en idealWeight")
	public void testAlturaNegativaIdealWeight() {
		assertThrows(IllegalArgumentException.class, () -> healthCalc.idealWeight(-1, 'M'));
	}

	@Test
	@DisplayName("Test altura cero en idealWeight")
	public void testAlturaCeroIdealWeight() {
		assertThrows(IllegalArgumentException.class, () -> healthCalc.idealWeight(0, 'M'));
	}

	@Test
	@DisplayName("Test altura cuando el valor sobrepasa el limite operable en idealWeight ")
	public void testAlturaOverflowIdealWeight() {
		assertThrows(IllegalArgumentException.class, () -> healthCalc.idealWeight(Integer.MAX_VALUE, 'M'));
	}

	@Test
	@DisplayName("Test género no válido para idealWeight")
	public void testGeneroNoValidoIdealWeight() {
		assertThrows(IllegalArgumentException.class, () -> healthCalc.idealWeight(85, 'U'), "El género es 'M' (hombre) o 'F' (mujer).");
	}

	@Test
	@DisplayName("Test idealweight negativo con hombre")
	public void testPesoIdealNegativoHombre() {
		assertThrows(IllegalArgumentException.class, () -> healthCalc.idealWeight(40, 'M'));
	}

	@Test
	@DisplayName("Test idealweight negativo con mujer")
	public void testPesoIdealNegativoMujer() {
		assertThrows(IllegalArgumentException.class, () -> healthCalc.idealWeight(40, 'F'));
	}

	@Test
    @DisplayName("Test peso ideal hombre")
    public void testPesoIdealHombre() throws Exception {
        int height1 = 180;
        char gender1 = 'M';
        float pesoIdealEsperado = height1 - 100 - (height1 - 150) / 4f;
		assertEquals(pesoIdealEsperado, healthCalc.idealWeight(height1, gender1));
    }

    @Test
    @DisplayName("Test peso ideal mujer ")
    public void testPesoIdealMujer() throws Exception {
        int height1 = 170;
        char gender1 = 'F';
        float pesoIdealEsperado = height1 - 100 - (height1 - 150) / 2.5f;
        assertEquals(pesoIdealEsperado, healthCalc.idealWeight(height1, gender1));
    }











	// Tests para basalMetabolicRate

	
	@Test
	@DisplayName("Test peso negativo basalMetabolicRate")
	public void testPesoNegativoBasalMetabolicRate() {
		assertThrows(IllegalArgumentException.class, () -> healthCalc.basalMetabolicRate(-1, 170, 'M', 20));
	}
	
	@Test
	@DisplayName("Test peso cero basalMetabolicRate")
	public void testPesoCeroBasalMetabolicRate() {
		assertThrows(IllegalArgumentException.class, () -> healthCalc.basalMetabolicRate(0, 170, 'M', 20));
	}

	@Test
	@DisplayName("Test altura negativa basalMetabolicRate")
	public void testAlturaNegativaBasalMetabolicRate() {
		assertThrows(IllegalArgumentException.class, () -> healthCalc.basalMetabolicRate(60, -1, 'M', 20));
	}

	@Test
	@DisplayName("Test altura cero basalMetabolicRate")
	public void testAlturaCeroBasalMetabolicRate() {
		assertThrows(IllegalArgumentException.class, () -> healthCalc.basalMetabolicRate(60, 0, 'M', 20));
	}

	@Test
	@DisplayName("Test edad negativa basalMetabolicRate")
	public void testEdadNegativaBasalMetabolicRate() {
		assertThrows(IllegalArgumentException.class, () -> healthCalc.basalMetabolicRate(60, 170, 'M', -1));
	}

	@Test
	@DisplayName("Test edad cero basalMetabolicRate")
	public void testEdadCeroBasalMetabolicRate() {
		assertThrows(IllegalArgumentException.class, () -> healthCalc.basalMetabolicRate(60, 170, 'M', 0));
	}

	@Test
	@DisplayName("Test género no válido para basalMetabolicRate")
	public void testGeneroNoValidoBasalMetabolicRate() {
		assertThrows(IllegalArgumentException.class, () -> healthCalc.basalMetabolicRate(60, 170, 'X', 20));
	}

	@Test
	@DisplayName("Test basalMetabolicRate negativo con hombre")
	public void testbasalMetabolicRateNegativoHombre() {
		assertThrows(IllegalArgumentException.class, () -> healthCalc.basalMetabolicRate(5, 5, 'M', 50));
	}

	@Test
	@DisplayName("Test basalMetabolicRate negativo con mujer")
	public void testbasalMetabolicRateNegativoMujer() {
		assertThrows(IllegalArgumentException.class, () -> healthCalc.basalMetabolicRate(5, 5, 'F', 50));
	}

	@Test
	@DisplayName("Test peso sobrepasa el valor valido en basalMetabolicRate")
	public void testPesoOverflowBasalMetabolicRate() {
		assertThrows(IllegalArgumentException.class, () -> healthCalc.basalMetabolicRate(Float.MAX_VALUE, 170, 'M', 20));
	}

	@Test
	@DisplayName("Test altura sobrepasa el valor valido en basalMetabolicRate")
	public void testAlturaOverflowBasalMetabolicRate() {
		assertThrows(IllegalArgumentException.class, () -> healthCalc.basalMetabolicRate(60, Integer.MAX_VALUE, 'M', 20));
	}

	@Test
	@DisplayName("Test edad sobrepasa el valor valido en basalMetabolicRate")
	public void testEdadOverflowBasalMetabolicRate() {
		assertThrows(IllegalArgumentException.class, () -> healthCalc.basalMetabolicRate(60, 170, 'M', Integer.MAX_VALUE));
	}

	@Test
    @DisplayName("Test metabolismo basal mujer ")
    public void testMetabolismoBasalMujer() throws Exception {
		float weight = 60;
		int height = 170;
		char gender = 'F';
		int age = 20;
        float pesoIdealEsperado = 10 * weight + 6.25f * height - 5 * age - 161;
        assertEquals(pesoIdealEsperado, healthCalc.basalMetabolicRate(weight, height, gender, age));
    }

	@Test
    @DisplayName("Test metabolismo basal hombre ")
    public void testMetabolismoBasalHombre() throws Exception {
        float weight = 60;
		int height = 180;
		char gender = 'M';
		int age = 20;
        float pesoIdealEsperado =  10 * weight + 6.25f * height - 5 * age + 5;
        assertEquals(pesoIdealEsperado, healthCalc.basalMetabolicRate(weight, height, gender, age));
    }

}

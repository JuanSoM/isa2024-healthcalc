# isa2024-healtcalc
Health calculator
# Pruebas para la Calculadora de Salud

Este conjunto de pruebas tiene como objetivo validar los métodos de la `HealthCalcImpl` que calculan el peso ideal (`idealWeight`) y la tasa metabólica basal (`basalMetabolicRate`). Aquí se detallan los casos de prueba y su significado.

## Pruebas para **idealWeight**

### 1. Test Altura Negativa en **idealWeight**
- **Descripción:** Verifica que el método lance una excepción `IllegalArgumentException` cuando la altura es negativa.
- **Caso de Prueba:** `healthCalc.idealWeight(-1, 'M')`

### 2. Test Altura Cero en **idealWeight**
- **Descripción:** Verifica que el método lance una excepción `IllegalArgumentException` cuando la altura es cero.
- **Caso de Prueba:** `healthCalc.idealWeight(0, 'M')`

### 3. Test Altura que Sobrepasa el Límite Operable en **idealWeight**
- **Descripción:** Verifica que el método lance una excepción `IllegalArgumentException` cuando la altura supera los límites operables.
- **Caso de Prueba:** `healthCalc.idealWeight(Integer.MAX_VALUE, 'M')`

### 4. Test Género No Válido para **idealWeight**
- **Descripción:** Verifica que el método lance una excepción `IllegalArgumentException` cuando se proporciona un género no válido.
- **Caso de Prueba:** `healthCalc.idealWeight(85, 'U')`

### 5. Test Peso Ideal Negativo con Hombre
- **Descripción:** Verifica que el método lance una excepción `IllegalArgumentException` cuando el cálculo del peso ideal da como resultado un valor negativo para un hombre.
- **Caso de Prueba:** `healthCalc.idealWeight(40, 'M')`

### 6. Test Peso Ideal Negativo con Mujer
- **Descripción:** Verifica que el método lance una excepción `IllegalArgumentException` cuando el cálculo del peso ideal da como resultado un valor negativo para una mujer.
- **Caso de Prueba:** `healthCalc.idealWeight(40, 'F')`

### 7. Test Peso Ideal Hombre
- **Descripción:** Verifica que el método calcule correctamente el peso ideal para un hombre.
- **Caso de Prueba:** `healthCalc.idealWeight(180, 'M')`

### 8. Test Peso Ideal Mujer
- **Descripción:** Verifica que el método calcule correctamente el peso ideal para una mujer.
- **Caso de Prueba:** `healthCalc.idealWeight(170, 'F')`


## Pruebas para **basalMetabolicRate**

### 9. Test Peso Negativo en **basalMetabolicRate**
- **Descripción:** Verifica que el método lance una excepción `IllegalArgumentException` cuando el peso es negativo.
- **Caso de Prueba:** `healthCalc.basalMetabolicRate(-1, 170, 'M', 20)`

### 10. Test Peso Cero en **basalMetabolicRate**
- **Descripción:** Verifica que el método lance una excepción `IllegalArgumentException` cuando el peso es cero.
- **Caso de Prueba:** `healthCalc.basalMetabolicRate(0, 170, 'M', 20)`

### 11. Test Altura Negativa en **basalMetabolicRate**
- **Descripción:** Verifica que el método lance una excepción `IllegalArgumentException` cuando la altura es negativa.
- **Caso de Prueba:** `healthCalc.basalMetabolicRate(60, -1, 'M', 20)`

### 12. Test Altura Cero en **basalMetabolicRate**
- **Descripción:** Verifica que el método lance una excepción `IllegalArgumentException` cuando la altura es cero.
- **Caso de Prueba:** `healthCalc.basalMetabolicRate(60, 0, 'M', 20)`

### 13. Test Edad Negativa en **basalMetabolicRate**
- **Descripción:** Verifica que el método lance una excepción `IllegalArgumentException` cuando la edad es negativa.
- **Caso de Prueba:** `healthCalc.basalMetabolicRate(60, 170, 'M', -1)`

### 14. Test Edad Cero en **basalMetabolicRate**
- **Descripción:** Verifica que el método lance una excepción `IllegalArgumentException` cuando la edad es cero.
- **Caso de Prueba:** `healthCalc.basalMetabolicRate(60, 170, 'M', 0)`

### 15. Test Género No Válido en **basalMetabolicRate**
- **Descripción:** Verifica que el método lance una excepción `IllegalArgumentException` cuando se proporciona un género no válido.
- **Caso de Prueba:** `healthCalc.basalMetabolicRate(60, 170, 'X', 20)`

### 16. Test Metabolismo Basal Negativo con Hombre
- **Descripción:** Verifica que el método lance una excepción `IllegalArgumentException` cuando el cálculo del metabolismo basal da como resultado un valor negativo para un hombre.
- **Caso de Prueba:** `healthCalc.basalMetabolicRate(5, 5, 'M', 50)`

### 17. Test Metabolismo Basal Negativo con Mujer
- **Descripción:** Verifica que el método lance una excepción `IllegalArgumentException` cuando el cálculo del metabolismo basal da como resultado un valor negativo para una mujer.
- **Caso de Prueba:** `healthCalc.basalMetabolicRate(5, 5, 'F', 50)`

### 18. Test Peso que Sobrepasa el Valor Válido en **basalMetabolicRate**
- **Descripción:** Verifica que el método lance una excepción `IllegalArgumentException` cuando el peso sobrepasa el valor válido.
- **Caso de Prueba:** `healthCalc.basalMetabolicRate(Float.MAX_VALUE, 170, 'M', 20)`

### 19. Test Altura que Sobrepasa el Valor Válido en **basalMetabolicRate**
- **Descripción:** Verifica que el método lance una excepción `IllegalArgumentException` cuando la altura sobrepasa el valor válido.
- **Caso de Prueba:** `healthCalc.basalMetabolicRate(60, Integer.MAX_VALUE, 'M', 20)`

### 20. Test Edad que Sobrepasa el Valor Válido en **basalMetabolicRate**
- **Descripción:** Verifica que el método lance una excepción `IllegalArgumentException` cuando la edad sobrepasa el valor válido.
- **Caso de Prueba:** `healthCalc.basalMetabolicRate(60, 170, 'M', Integer.MAX_VALUE)`

### 21. Test Metabolismo Basal Mujer
- **Descripción:** Verifica que el método calcule correctamente el metabolismo basal para una mujer.
- **Caso de Prueba:** `healthCalc.basalMetabolicRate(60, 170, 'F', 20)`

### 22. Test Metabolismo Basal Hombre
- **Descripción:** Verifica que el método calcule correctamente el metabolismo basal para un hombre.
- **Caso de Prueba:** `healthCalc.basalMetabolicRate(60, 180, 'M', 20)`



![p1SoftAvan](https://github.com/JuanSoM/isa2024-healthcalc/assets/160397659/0b689b01-163f-416a-9c2b-74512e27675a)
![p1SoftAvan2](https://github.com/JuanSoM/isa2024-healthcalc/assets/160397659/54d7d58e-c966-4bbe-8416-b14c7a57e072)
# Practica 3

## Historia de Usuario 1: Calcular Peso Ideal

As a Usuario
Quiero calcular mi peso ideal
Para poder mantener un estilo de vida saludable

## Criterios de Aceptación

### Scenario 1: Calcular peso ideal
Given que tiene una calculadora de idealWeigth
When el usuario selecciona su género e ingresa su altura
Then la calculadora debe devolver el peso ideal según la fórmula de Lorentz

### Scenario 2: Error al ingresar una altura negativa o igual a 0
Given que tiene una calculadora de idealWeigth
When el usuario ingresa su altura menor o igual a 0
Then la calculadora debe mostrar un mensaje de error indicando que la altura debe ser un valor positivo

### Scenario 3: Error al ingresar un género incorrecto
Given que tiene una calculadora de idealWeigth
When el usuario selecciona su género y no está especificado correctamente (no es 'M' o 'F')
Then la calculadora debe mostrar un mensaje de error indicando que el género debe ser 'M' o 'F'

### Scenario 4: Error al ingresar una altura overflow
Given que tiene una calculadora de idealWeigth
When el usuario ingresa su altura que supera los límites operables
Then la calculadora debe mostrar un mensaje de error indicando que la altura ha superado los límites operables

### Scenario 5: Error de idealWeigth negativo
Given que tiene una calculadora de idealWeigth
When el usuario ingresa una altura muy cercana o igual a 1
Then la calculadora debe mostrar un mensaje de error indicando que el idealWeigth calculado es inválido

## Historia de Usuario 2: Calcular Tasa Metabólica Basal (BMR)

As a Usuario
Quiero calcular mi tasa metabólica basal (BMR)
Para poder gestionar mi ingesta diaria de calorías

## Criterios de Aceptación

### Scenario 1: Calcular BMR con datos válidos
Given que tiene una calculadora para BMR
When el usuario ingresa su peso, altura, género y edad
Then la calculadora debe devolver la tasa metabólica basal según la fórmula especificada

### Scenario 2: Error al ingresar una altura overflow 
Given que tiene una calculadora para BMR
When el usuario ingresa su altura overflow
Then la calculadora debe mostrar un mensaje de error indicando que la altura supera los límites operables

### Scenario 3: Error al ingresar una altura negativa
Given que tiene una calculadora para BMR
When el usuario ingresa su altura menor o igual a 0
Then la calculadora debe mostrar un mensaje de error indicando que la altura debe ser un valor positivo

### Scenario 4: Error al ingresar un peso overflow
Given que tiene una calculadora para BMR
When el usuario ingresa su peso overflow
Then la calculadora debe mostrar un mensaje de error indicando que el peso supera los límites operables

### Scenario 5:  Error al ingresar un peso negativo
Given que tiene una calculadora para BMR
When el usuario ingresa su peso menor o igual a 0
Then la calculadora debe mostrar un mensaje de error indicando que el peso debe ser un valor positivo

### Scenario 6: Error al ingresar una edad overflow
Given que tiene una calculadora para BMR
When el usuario ingresa su edad overflow
Then la calculadora debe mostrar un mensaje de error indicando que la edad supera los límites operables

### Scenario 7: Error al ingresar una edad negativa
Given que tiene una calculadora para BMR
When el usuario ingresa su edad menor o igual a 0
Then la calculadora debe mostrar un mensaje de error indicando que la edad debe ser un valor positivo

### Scenario 8: Error al ingresar un género incorrecto
Given que tiene una calculadora para BMR
When el usuario selecciona su género y no está especificado correctamente (no es 'M' o 'F')
Then la calculadora debe mostrar un mensaje de error indicando que el género debe ser 'M' o 'F'

### Scenario 9: Error de BMR negativo o igual a 0
Given que tiene una calculadora para BMR
When el usuario ingresa una altura y peso muy cercanos o igual a 1
Then la calculadora debe mostrar un mensaje de error indicando que el BMR calculado es inválido

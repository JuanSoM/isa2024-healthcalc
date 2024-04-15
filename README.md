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

# Práctica 4 - Interfaz Gráfica de la Calculadora de Salud

## Título
- La parte superior de la interfaz gráfica incluye un título que indica el propósito de la aplicación, en este caso, "Calculadora de Salud".

## Campos de Entrada
- Hay cuatro campos de entrada donde el usuario puede ingresar datos:
  - **Peso (kg):** Un campo de texto donde el usuario puede ingresar su peso en kilogramos.
  - **Altura (cm):** Un campo de texto donde el usuario puede ingresar su altura en centímetros.
  - **Edad:** Un campo de texto donde el usuario puede ingresar su edad.
  - **Género:** Un menú desplegable donde el usuario puede seleccionar su género, con opciones para masculino (M) o femenino (F).

## Botones de Acción
- Hay dos botones que el usuario puede utilizar para realizar diferentes cálculos:
  - **Calcular Peso Ideal:** Un botón que, al hacer clic, calcula y muestra el peso ideal del usuario.
  - **Calcular BMR:** Un botón que, al hacer clic, calcula y muestra la tasa metabólica basal (BMR) del usuario.

## Mensajes de Salida
- En la parte inferior de la interfaz gráfica, hay un área donde se mostrarán los resultados de los cálculos realizados, como el peso ideal o la BMR. También se mostrarán mensajes de error si el usuario ingresa datos incorrectos o si ocurren errores durante los cálculos.

## Diseño y Organización
- La interfaz gráfica está organizada de manera clara y ordenada, con los campos de entrada y botones de acción dispuestos en columnas y filas. Esto facilita al usuario la comprensión de qué datos debe ingresar y qué acciones puede realizar.
## Sketch
![sketch](https://github.com/JuanSoM/isa2024-healthcalc/assets/160397659/ec9989eb-4e23-4fcb-bad8-8ec6f2767c13)

## App
![app](https://github.com/JuanSoM/isa2024-healthcalc/assets/160397659/ba9c9aa4-b0b3-42d4-aed0-9362d176b1ea)

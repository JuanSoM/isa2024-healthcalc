# isa2024-healtcalc
Health calculator
# Práctica 1 - Pruebas para la Calculadora de Salud

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


# Práctica 2 - Diagrama Casos de Uso


## Especificación del Caso de Uso - idealWeight:

**Nombre:** idealWeight

**Stakeholders:**
- Usuario: La persona que utiliza la calculadora de salud para obtener su peso ideal.
- Desarrollador: Encargado de mantener y mejorar la calculadora.

**Actor Principal:** Usuario

**Alcance (Scope):**
- Este caso de uso se centra en el cálculo del peso ideal de una persona utilizando la fórmula de Lorentz.

**Nivel de Abstracción:**
- Nivel de Caso de Uso.

**Escenario Principal:**
1. El usuario proporciona la altura y el género.
2. El sistema verifica que la altura sea un valor positivo y que el género sea 'M' o 'F'.
3. El sistema utiliza la fórmula de Lorentz para calcular el peso ideal.
4. El sistema retorna el peso ideal calculado al usuario.

**Precondición:**
- El usuario ha ingresado una altura positiva y un género válido ('M' o 'F').

**Garantía Mínima:**
- El sistema no permite la entrada de datos inválidos y garantiza un cálculo preciso.

**Garantía de Éxito:**
- El sistema devuelve un resultado preciso y positivo que representa el peso ideal del usuario.

**Trigger:**
- El usuario desea conocer su peso ideal.

**Extensiones (Escenarios Alternativos):**
- **Altura Negativa:**
  - El sistema detecta que la altura ingresada es negativa.
  - Se muestra un mensaje de error indicando que la altura debe ser un valor positivo.
  
- **Altura Cero:**
  - El sistema detecta que la altura ingresada es cero.
  - Se muestra un mensaje de error indicando que la altura debe ser un valor positivo.

- **Altura Fuera de Límites:**
  - El sistema detecta que la altura ingresada supera los límites operables.
  - Se muestra un mensaje de error indicando que la altura está fuera de los límites válidos.

- **Género No Válido:**
  - El sistema detecta que el género ingresado no es 'M' ni 'F'.
  - Se muestra un mensaje de error indicando que el género debe ser 'M' o 'F'.

- **Peso Ideal Negativo:**
  - El sistema calcula un peso ideal negativo.
  - Se muestra un mensaje de error indicando que el peso ideal calculado no es válido.

![alt text](P2.PNG)
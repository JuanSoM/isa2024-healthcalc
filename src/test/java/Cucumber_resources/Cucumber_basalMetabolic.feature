@calcular-bmr
Feature: Calcular Tasa Metabólica Basal (BMR)

  As a usuario
  I want to calculate my Basal Metabolic Rate (BMR)
  So that I can manage my daily calorie intake

  Scenario: Calcular BMR con datos válidos
    Given que se proporciona el peso, la altura, el género y la edad del usuario
    When el usuario ingresa su peso, altura, género y edad
    Then la calculadora devuelve la tasa metabólica basal según la fórmula especificada

  Scenario: Error al ingresar un peso no válido
    Given que el peso del usuario es menor o igual a 0
    When el usuario ingresa su peso
    Then la calculadora muestra un mensaje de error indicando que el peso debe ser un valor positivo

  Scenario: Error al ingresar una altura no válida
    Given que la altura del usuario es menor o igual a 0
    When el usuario ingresa su altura
    Then la calculadora muestra un mensaje de error indicando que la altura debe ser un valor positivo

  Scenario: Error al ingresar una edad no válida
    Given que la edad del usuario es menor o igual a 0
    When el usuario ingresa su edad
    Then la calculadora muestra un mensaje de error indicando que la edad debe ser un valor positivo

  Scenario: Error al especificar un género inválido
    Given que el género del usuario no está especificado correctamente
    When el usuario selecciona su género
    Then la calculadora muestra un mensaje de error indicando que el género debe ser 'M' o 'F'

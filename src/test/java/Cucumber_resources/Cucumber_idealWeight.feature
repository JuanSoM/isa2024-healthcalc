@calcular-peso-ideal
Feature: Calcular Peso Ideal

  As a usuario
  I want to calculate my ideal weight
  So that I can maintain a healthy lifestyle

  Scenario: Calcular peso ideal con altura válida y género masculino
    Given que se proporciona la altura del usuario
    And el usuario selecciona su género como 'M'
    When el usuario ingresa su altura
    Then la calculadora devuelve el peso ideal según la fórmula de Lorentz

  Scenario: Error al ingresar una altura no válida
    Given que la altura del usuario es menor o igual a 0
    When el usuario ingresa su altura
    Then la calculadora muestra un mensaje de error indicando que la altura debe ser un valor positivo

  Scenario: Error al especificar un género inválido
    Given que el género del usuario no está especificado correctamente
    When el usuario selecciona su género
    Then la calculadora muestra un mensaje de error indicando que el género debe ser 'M' o 'F'

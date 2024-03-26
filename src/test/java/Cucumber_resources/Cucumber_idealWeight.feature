@calcular-peso-ideal
Feature: Calcular Peso Ideal

  As a usuario
  I want to calculate my ideal weight
  So that I can maintain a healthy lifestyle

  @tag1
  Scenario: Calcular peso ideal 
    Given que tengo una calculadora para el peso ideal
    When calculo el peso ideal con altura 180 y genero "M"
    Then el sistema deberia devolver el peso ideal 72.5, de acuerdo con la formula de Lorentz

  @tag2
  Scenario: Error al ingresar una altura negativa o igual a 0
    Given que tengo una calculadora para el peso ideal
    When calculo el peso ideal con altura -1 y genero 'M'
    Then la calculadora debe lanzar un error
  @tag3
  Scenario: Error al ingresar un genero incorrecto
    Given que tengo una calculadora para el peso ideal
    When calculo el peso ideal con altura 180 y genero 'S'
    Then la calculadora debe lanzar un error
  @tag4
  Scenario: Error al ingresar una altura overflow
    Given que tengo una calculadora para el peso ideal
    When Hacemos el calculo con un altura overflow y genero masculino
    Then Devuelve una excepcion de altura overflow

  @tag5
  Scenario: Error de idealWeigth negativo
    Given que tengo una calculadora para el peso ideal
    When calculo el peso ideal con altura 1 y genero 'M'
    Then Devuelve una excepcion de idealWeigth negativa o 0

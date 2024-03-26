@calcular-bmr
Feature: Calcular Tasa Metabólica Basal (BMR)

  As a usuario
  I want to calculate my Basal Metabolic Rate (BMR)
  So that I can manage my daily calorie intake

  @tag1
  Scenario: Calcular BMR con datos válidos
    Given que tengo una calculadora para la tasa metabolica basal
    When calculo la tasa metabólica basal con peso 67, altura 180, genero 'M' y edad 61
    Then el sistema debería devolver el BMR 1495, de acuerdo con la formula especificada
  @tag2
  Scenario: Error al ingresar una altura overflow 
    Given que tengo una calculadora para la tasa metabolica basal
    When Hacemos el calculo con un altura overflow, peso 67, genero 'M' y edad 61
    Then Devuelve una excepcion de overflow
  @tag3
  Scenario: Error al ingresar una altura negativa
    Given que tengo una calculadora para la tasa metabolica basal
    When calculo la tasa metabólica basal con peso 67, altura -1, genero 'M' y edad 61
    Then el sistema detecta parametros incorrectos
  @tag4
  Scenario: Error al ingresar un peso overflow 
    Given que tengo una calculadora para la tasa metabolica basal
    When Hacemos el calculo con un peso overflow, genero femenino, edad 61 y altura 180
    Then Devuelve una excepcion de overflow
  @tag5
  Scenario: Error al ingresar un peso negativo
    Given que tengo una calculadora para la tasa metabolica basal
    When calculo la tasa metabólica basal con peso -1, altura 180, genero 'M' y edad 61
    Then el sistema detecta parametros incorrectos
  @tag6
  Scenario: Error al ingresar una edad overflow 
    Given que tengo una calculadora para la tasa metabolica basal
    When Hacemos el calculo con una edad overflow, genero masculino, peso 67 y altura 180
    Then Devuelve una excepcion de overflow
  @tag7
  Scenario: Error al ingresar una edad negativa
    Given que tengo una calculadora para la tasa metabolica basal
    When calculo la tasa metabólica basal con peso 67, altura 180, genero 'M' y edad -1
    Then el sistema detecta parametros incorrectos
  @tag8
  Scenario: Error al ingresar un genero incorrecto
    Given que tengo una calculadora para la tasa metabolica basal
    When calculo la tasa metabólica basal con peso 67, altura 180, genero 'S' y edad 61
    Then el sistema detecta parametros incorrectos
  @tag9
  Scenario: Error de BMR negativo o igual a 0
    Given que tengo una calculadora para la tasa metabolica basal
    When calculo la tasa metabólica basal con peso 1, altura 1, genero 'M' y edad 61
    Then Devuelve una excepcion de BMR negativo o igual a 0


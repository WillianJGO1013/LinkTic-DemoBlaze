#Author: william.granados.2015@gmail.com
@demoblaze
Feature: Validar sitio ecommerce demoblaze

	Background:
		Given El usuario ingresa a la página de DemoBlaze

  @registro_Usuario
  Scenario: Validar el registro de usuario
    When El usuario ingresa al módulo de registro de usuario
    And Ingresa el nombre de usuario desde el archivo usuarios.xlsx fila "1"
    And Ingresa la contraseña desde el archivo usuarios.xlsx fila "1"
    Then Confirmar creación de usuario

  @login_Usuario
  Scenario: Validar el login de usuario
    When El usuario ingresa al módulo de login de usuario
    And Ingresa el nombre de usuario existente desde el archivo usuarios.xlsx fila "1"
    And Ingresa la contraseña de usuario existente desde el archivo usuarios.xlsx fila "1"
    Then Confirmar login de usuario "1"
    
  @formulario_Contacto
  Scenario: Validar el registro del formulario de contacto
    When El usuario ingresa al módulo de contacto
    And Ingresa el correo de contacto desde el archivo contacto.xlsx fila "1"
    And Ingresa el nombre de la persona a contactar desde el archivo contacto.xlsx fila "1"
    And Ingresa el mensaje para la persona a contactar desde el archivo contacto.xlsx fila "1"
    Then Confirmar envío del mensaje
    
  @seleccion_Producto
  Scenario: Validar la selección del producto MacBook Pro
    When El usuario ingresa a la categoria Laptops
    And Selecciona el producto MacBook Pro
    And Agrega el producto MacBook Pro a la sección de compras
    And El usuario ingresa al modulo Cart
    Then Confirmar que el producto se añadio correctamente
Feature: Product - Store
@validacionProduct
  Scenario: Validación del precio de un producto
    Given estoy en la página de la tienda
    And me logueo con mi usuario "melissasud27@gmail.com" y clave "$Jul1093*"
    When navego a la categoria "Clothes" y subcategoria "Men"
    And agrego 2 unidades del primer producto al carrito
    Then valido en el popup la confirmación del producto agregado
    And valido en el popup que el monto total sea calculado correctamente


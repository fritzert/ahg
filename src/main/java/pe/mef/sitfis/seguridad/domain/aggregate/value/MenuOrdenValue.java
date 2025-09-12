package pe.mef.sitfis.seguridad.domain.aggregate.value;

public record MenuOrdenValue(Integer valor) {

  private static final int ORDEN_MINIMO = 1;
  private static final int ORDEN_MAXIMO = 999;

  /**
   * Constructor que valida el orden del menu.
   *
   * @param valor número entero que representa el orden del menu
   * @throws IllegalArgumentException si el orden no cumple las reglas de negocio
   */
  public MenuOrdenValue {
    validarOrden(valor);
  }

  /**
   * Valida las reglas de negocio para el orden del menu.
   *
   * @param orden valor a validar
   * @throws IllegalArgumentException si el orden no es valido
   */
  private void validarOrden(Integer orden) {
    if (orden == null) {
      throw new IllegalArgumentException("El orden del menú no puede ser nulo");
    }
    if (orden < ORDEN_MINIMO) {
      throw new IllegalArgumentException(
          "El orden del menú debe ser mayor o igual a " + ORDEN_MINIMO);
    }
    if (orden > ORDEN_MAXIMO) {
      throw new IllegalArgumentException("El orden del menú no puede ser mayor a " + ORDEN_MAXIMO);
    }
  }

  /**
   * Crea un MenuOrdenValue a partir de un Integer.
   *
   * @param orden valor del orden
   * @return nueva instancia de MenuOrdenValue
   */
  public static MenuOrdenValue de(Integer orden) {
    return new MenuOrdenValue(orden);
  }

}
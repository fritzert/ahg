package pe.mef.sitfis.seguridad.domain.aggregate;

import pe.mef.sitfis.seguridad.domain.aggregate.id.MenuId;
import pe.mef.sitfis.seguridad.domain.aggregate.value.MenuNombreValue;
import pe.mef.sitfis.seguridad.domain.aggregate.value.MenuOrdenValue;

public class MenuAggregate {

  private final MenuId id;
  private final MenuNombreValue nombre;
  private final MenuOrdenValue orden;

  /**
   * Constructor para crear un Menu Aggregate.
   *
   * @param id     identificador único del menu
   * @param nombre valor que representa el nombre del menu
   * @param orden  valor que representa el orden del menu
   */
  public MenuAggregate(MenuId id, MenuNombreValue nombre, MenuOrdenValue orden) {
    this.id = id;
    this.nombre = nombre;
    this.orden = orden;
    validarReglasDeNegocio();
  }

  /**
   * Valida las reglas de negocio del aggregate.
   *
   * @throws IllegalArgumentException si alguna regla de negocio no se cumple
   */
  private void validarReglasDeNegocio() {
//    if (id == null) {
//      throw new IllegalArgumentException("El ID del menu no puede ser nulo");
//    }
    if (nombre == null) {
      throw new IllegalArgumentException("El nombre del menu no puede ser nulo");
    }
    if (orden == null) {
      throw new IllegalArgumentException("El orden del menu no puede ser nulo");
    }
  }

  /**
   * Verifica si el menu coincide con el criterio de busqueda por nombre.
   *
   * @param criterio cadena de texto para filtrar por nombre
   * @return verdadero si el menú coincide con el criterio
   */
  public boolean coincideConNombre(String criterio) {
    if (criterio == null || criterio.trim().isEmpty()) {
      return true;
    }
    return nombre.contiene(criterio);
  }

  public MenuId getId() {
    return id;
  }

  public MenuNombreValue getNombre() {
    return nombre;
  }

  public MenuOrdenValue getOrden() {
    return orden;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    MenuAggregate that = (MenuAggregate) obj;
    return id.equals(that.id);
  }

  @Override
  public int hashCode() {
    return id.hashCode();
  }
}
package pe.mef.sitfis.seguridad.domain.aggregate.id;

/**
 * Value Object que representa el identificador unico de un RolGrupo
 *
 */
public record RolGrupoId(Long valor) {

  /**
   * Constructor que valida el ID del rolGrupo
   *
   * @param valor identificador numerico del menu
   * @throws IllegalArgumentException si el valor es nulo o menor o igual a cero
   */
  public RolGrupoId {
    if (valor == null || valor <= 0) {
      throw new IllegalArgumentException("El ID del menú debe ser un número positivo");
    }
  }

  /**
   * Crea un RolGrupoId a partir de un Long.
   *
   * @param id valor del identificador
   * @return nueva instancia de RolGrupoId
   */
  public static RolGrupoId de(Long id) {
    return new RolGrupoId(id);
  }
}


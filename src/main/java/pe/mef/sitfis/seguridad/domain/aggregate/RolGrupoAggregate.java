package pe.mef.sitfis.seguridad.domain.aggregate;

import pe.mef.sitfis.seguridad.domain.aggregate.id.GrupoId;
import pe.mef.sitfis.seguridad.domain.aggregate.id.RolGrupoId;
import pe.mef.sitfis.seguridad.domain.aggregate.id.RolId;
import pe.mef.sitfis.seguridad.domain.aggregate.value.RolGrupoFlagAdjuntarArchivoValue;
import pe.mef.sitfis.seguridad.domain.aggregate.value.RolGrupoFlagAsignarRecursosValue;
import pe.mef.sitfis.seguridad.domain.aggregate.value.RolGrupoFlagConsultaValue;
import pe.mef.sitfis.seguridad.domain.aggregate.value.RolGrupoFlagEnviarBandejaValue;
import pe.mef.sitfis.seguridad.domain.aggregate.value.RolGrupoFlagEnviarEtapaValue;
import pe.mef.sitfis.seguridad.domain.aggregate.value.RolGrupoFlagOperacionValue;
import pe.mef.sitfis.seguridad.domain.aggregate.value.RolGrupoFlagRestriccionValue;

public class RolGrupoAggregate {

  private final RolGrupoId id;
  private final RolId rolId;
  private final GrupoId grupoId;
  private final RolGrupoFlagRestriccionValue flagRestriccion;
  private final RolGrupoFlagConsultaValue flagConsulta;
  private final RolGrupoFlagOperacionValue flagOperacion;
  private final RolGrupoFlagAsignarRecursosValue flagAsignarRecursos;
  private final RolGrupoFlagEnviarBandejaValue flagEnviarBandeja;
  private final RolGrupoFlagEnviarEtapaValue flagEnviarEtapa;
  private final RolGrupoFlagAdjuntarArchivoValue flagAdjuntarArchivo;

  /**
   * Constructor para crear una nueva instancia del agregado RolGrupo.
   *
   * @param id                  El identificador único del RolGrupo.
   * @param rolId               La entidad Rol asociada a esta relación.
   * @param grupoId             La entidad Grupo asociada a esta relación.
   * @param flagRestriccion     El valor que indica si hay restricción.
   * @param flagConsulta        El valor que indica el permiso de consulta.
   * @param flagOperacion       El valor que indica el permiso de operación.
   * @param flagAsignarRecursos El valor que indica el permiso para asignar recursos.
   * @param flagEnviarBandeja   El valor que indica el permiso para enviar a bandeja.
   * @param flagEnviarEtapa     El valor que indica el permiso para enviar a etapa.
   * @param flagAdjuntarArchivo El valor que indica el permiso para adjuntar archivos.
   */
  public RolGrupoAggregate(RolGrupoId id, RolId rolId, GrupoId grupoId,
      RolGrupoFlagRestriccionValue flagRestriccion, RolGrupoFlagConsultaValue flagConsulta,
      RolGrupoFlagOperacionValue flagOperacion,
      RolGrupoFlagAsignarRecursosValue flagAsignarRecursos,
      RolGrupoFlagEnviarBandejaValue flagEnviarBandeja,
      RolGrupoFlagEnviarEtapaValue flagEnviarEtapa,
      RolGrupoFlagAdjuntarArchivoValue flagAdjuntarArchivo) {
    this.id = id;
    this.rolId = rolId;
    this.grupoId = grupoId;
    this.flagRestriccion = flagRestriccion;
    this.flagConsulta = flagConsulta;
    this.flagOperacion = flagOperacion;
    this.flagAsignarRecursos = flagAsignarRecursos;
    this.flagEnviarBandeja = flagEnviarBandeja;
    this.flagEnviarEtapa = flagEnviarEtapa;
    this.flagAdjuntarArchivo = flagAdjuntarArchivo;
    validarReglasDeNegocio();
  }

  /**
   * Valida las reglas de negocio del aggregate.
   *
   * @throws IllegalArgumentException si alguna regla de negocio no se cumple
   */
  private void validarReglasDeNegocio() {
    if (id == null) {
      throw new IllegalArgumentException("El ID de RolGrupo no puede ser nulo");
    }
    if (rolId == null) {
      throw new IllegalArgumentException("El ID del Rol no puede ser nulo");
    }
    if (grupoId == null) {
      throw new IllegalArgumentException("El ID del Grupo no puede ser nulo");
    }
    if (flagRestriccion == null) {
      throw new IllegalArgumentException("El flag de restricción no puede ser nulo");
    }
    if (flagConsulta == null) {
      throw new IllegalArgumentException("El flag de consulta no puede ser nulo");
    }
    if (flagOperacion == null) {
      throw new IllegalArgumentException("El flag de operación no puede ser nulo");
    }
    if (flagAsignarRecursos == null) {
      throw new IllegalArgumentException("El flag de asignar recursos no puede ser nulo");
    }
    if (flagEnviarBandeja == null) {
      throw new IllegalArgumentException("El flag de enviar a bandeja no puede ser nulo");
    }
    if (flagEnviarEtapa == null) {
      throw new IllegalArgumentException("El flag de enviar a etapa no puede ser nulo");
    }
    if (flagAdjuntarArchivo == null) {
      throw new IllegalArgumentException("El flag de adjuntar archivo no puede ser nulo");
    }
  }

}

package pe.mef.sitfis.seguridad.application.command;

public record CrearActualizarRolGrupoCommand(
    Long id,
    Long rolId,
    Long grupoId,
    int flagRestriccion,
    int flagConsulta,
    int flagOperacion,
    int flagAsignarRecursos,
    int flagEnviarBandeja,
    int flagEnviarEtapa,
    int flagAdjuntarArchivo) {

}

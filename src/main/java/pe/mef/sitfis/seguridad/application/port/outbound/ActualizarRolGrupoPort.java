package pe.mef.sitfis.seguridad.application.port.outbound;

import pe.mef.sitfis.seguridad.application.command.CrearActualizarRolGrupoCommand;

public interface ActualizarRolGrupoPort {

  int actualizar(CrearActualizarRolGrupoCommand grupoCommand);
}

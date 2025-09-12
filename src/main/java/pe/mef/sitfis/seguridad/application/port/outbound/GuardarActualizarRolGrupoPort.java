package pe.mef.sitfis.seguridad.application.port.outbound;

import java.util.List;
import pe.mef.sitfis.seguridad.application.command.CrearActualizarRolGrupoCommand;

public interface GuardarActualizarRolGrupoPort {

  int guardarActualizar(List<CrearActualizarRolGrupoCommand> grupoCommandList);

}

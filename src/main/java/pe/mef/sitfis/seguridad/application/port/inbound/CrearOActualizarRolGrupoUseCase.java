package pe.mef.sitfis.seguridad.application.port.inbound;

import java.util.List;
import pe.mef.sitfis.seguridad.application.command.CrearActualizarRolGrupoCommand;

public interface CrearOActualizarRolGrupoUseCase {

  void crearOActualizar(List<CrearActualizarRolGrupoCommand> request);

}

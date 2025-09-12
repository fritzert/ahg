package pe.mef.sitfis.seguridad.application.port.outbound;

import java.util.List;
import pe.mef.sitfis.seguridad.application.dto.RolGrupoDto;

public interface BuscarRolGrupoPorGrupoIdPort {

  List<RolGrupoDto> buscarPorGrupoId(Long id);
}

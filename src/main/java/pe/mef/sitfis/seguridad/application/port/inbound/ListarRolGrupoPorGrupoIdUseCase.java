package pe.mef.sitfis.seguridad.application.port.inbound;

import java.util.List;
import pe.mef.sitfis.seguridad.application.dto.RolGrupoDto;

public interface ListarRolGrupoPorGrupoIdUseCase {

  List<RolGrupoDto> listarPorGrupoId(Long id);

}

package pe.mef.sitfis.seguridad.application.port.inbound;

import java.util.List;
import pe.mef.sitfis.seguridad.application.dto.SubMenuDto;

public interface ListarSubmenuPorMenuIdUseCase {

  List<SubMenuDto> listarTodosPorMenuId(String nombre, Long menuId);

}

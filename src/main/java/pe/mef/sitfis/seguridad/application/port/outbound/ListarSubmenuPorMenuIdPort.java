package pe.mef.sitfis.seguridad.application.port.outbound;

import java.util.List;
import pe.mef.sitfis.seguridad.application.dto.SubMenuDto;

public interface ListarSubmenuPorMenuIdPort {

  List<SubMenuDto> listarTodosPorMenuId(String filtro, Long menuId);
}

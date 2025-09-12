package pe.mef.sitfis.seguridad.application.port.outbound;

import java.util.List;
import pe.mef.sitfis.seguridad.application.dto.MenuDto;
import pe.mef.sitfis.seguridad.domain.query.ListarMenuDomainQuery;

public interface ListarMenuPort {

  /**
   * Lista todos los menus aplicando el filtro especificado.
   *
   * @param query consulta de dominio con criterios de filtrado
   * @return lista de agregados de menu que cumplen los criterios
   */
  List<MenuDto> listarTodosMenu(ListarMenuDomainQuery query);

}

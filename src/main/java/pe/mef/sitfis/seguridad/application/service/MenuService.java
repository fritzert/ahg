package pe.mef.sitfis.seguridad.application.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pe.mef.sitfis.seguridad.application.dto.MenuDto;
import pe.mef.sitfis.seguridad.application.mapper.MenuDomainMapper;
import pe.mef.sitfis.seguridad.application.port.inbound.ListarMenuUseCase;
import pe.mef.sitfis.seguridad.application.port.outbound.ListarMenuPort;
import pe.mef.sitfis.seguridad.application.query.ListarMenuApplicationQuery;

@RequiredArgsConstructor
@Slf4j
public class MenuService implements ListarMenuUseCase {

  private final ListarMenuPort listarMenuPort;
  private final MenuDomainMapper domainMapper;

  /**
   * Lista todos los menus filtrados por los criterios especificados.
   *
   * @param query consulta con criterios de filtrado
   * @return lista de menus que cumplen los criterios
   */
  @Override
  public List<MenuDto> listarTodosMenu(ListarMenuApplicationQuery query) {
    var domainQuery = domainMapper.toDomainQuery(query);
    return listarMenuPort.listarTodosMenu(domainQuery);
  }

}

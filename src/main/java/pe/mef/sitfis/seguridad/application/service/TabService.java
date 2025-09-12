package pe.mef.sitfis.seguridad.application.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import pe.mef.sitfis.seguridad.application.dto.TabDto;
import pe.mef.sitfis.seguridad.application.dto.TabPaginadoDto;
import pe.mef.sitfis.seguridad.application.mapper.TabDomainMapper;
import pe.mef.sitfis.seguridad.application.port.inbound.BuscarTabPorMenuSubmenuUseCase;
import pe.mef.sitfis.seguridad.application.port.inbound.BuscarTabPorParametrosPaginadoUseCase;
import pe.mef.sitfis.seguridad.application.port.outbound.BuscarTabPorMenuSubmenuPort;
import pe.mef.sitfis.seguridad.application.port.outbound.BuscarTabPorParametrosPaginadoPort;
import pe.mef.sitfis.seguridad.application.query.BuscarTabApplicationQuery;
import pe.mef.sitfis.seguridad.application.query.BuscarTabPaginadoApplicationQuery;
import pe.mef.sitfis.seguridad.application.query.Pagina;
import pe.mef.sitfis.seguridad.application.query.PaginaApplicationQuery;

@RequiredArgsConstructor
public class TabService implements
    BuscarTabPorMenuSubmenuUseCase
    , BuscarTabPorParametrosPaginadoUseCase {

  private final BuscarTabPorMenuSubmenuPort buscarTabPorMenuSubmenuPort;
  private final BuscarTabPorParametrosPaginadoPort paginadoPort;
  private final TabDomainMapper domainMapper;

  @Override
  public List<TabDto> buscarPorMenuSubmenu(BuscarTabApplicationQuery applicationQuery) {
    var domainQuery = domainMapper.toDomainQuery(applicationQuery);
    return buscarTabPorMenuSubmenuPort.buscarTabs(domainQuery);
  }

  @Override
  public Pagina<TabPaginadoDto> buscarPorMenuSubmenuTabPaginado(Long menuId, Long submenuId,
      Long tabId, PaginaApplicationQuery paginaQuery) {
    var applicationQuery = new BuscarTabPaginadoApplicationQuery(menuId, submenuId, tabId,
        paginaQuery);
    var domainQuery = domainMapper.toPaginadoDomainQuery(applicationQuery);
    return paginadoPort.buscarPaginado(domainQuery);
  }

}

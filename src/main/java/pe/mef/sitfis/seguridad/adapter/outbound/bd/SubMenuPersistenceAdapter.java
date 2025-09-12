package pe.mef.sitfis.seguridad.adapter.outbound.bd;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pe.mef.sitfis.seguridad.adapter.inbound.api.mapper.SubmenuJpaMapper;
import pe.mef.sitfis.seguridad.adapter.outbound.bd.repository.SubMenuRepository;
import pe.mef.sitfis.seguridad.application.dto.SubMenuDto;
import pe.mef.sitfis.seguridad.application.port.outbound.ListarSubmenuPorMenuIdPort;

@Component
@RequiredArgsConstructor
public class SubMenuPersistenceAdapter implements ListarSubmenuPorMenuIdPort {

  private final SubMenuRepository repository;
  private final SubmenuJpaMapper mapper;

  @Override
  public List<SubMenuDto> listarTodosPorMenuId(String filtro, Long menuId) {
    return repository.findAllSubMenuByMenuId(filtro, menuId).stream()
        .map(mapper::toDto)
        .toList();
  }
}

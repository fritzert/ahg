package pe.mef.sitfis.seguridad.application.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import pe.mef.sitfis.seguridad.application.dto.SubMenuDto;
import pe.mef.sitfis.seguridad.application.port.inbound.ListarSubmenuPorMenuIdUseCase;
import pe.mef.sitfis.seguridad.application.port.outbound.ListarSubmenuPorMenuIdPort;

@RequiredArgsConstructor
public class SubMenuService implements ListarSubmenuPorMenuIdUseCase {

  private final ListarSubmenuPorMenuIdPort listarSubmenuPorMenuIdPort;

  /**
   * Listar todos los submenús por el ID del menú.
   *
   * @param nombre el nombre del submenú a filtrar (opcional)
   * @param menuId el ID del menú al que pertenecen los submenús
   * @return una lista de objetos SubMenuDto que representan los submenús filtrados por el ID del
   * menú
   */
  @Override
  public List<SubMenuDto> listarTodosPorMenuId(String nombre, Long menuId) {
    String filtro =
        (nombre == null || nombre.isBlank()) ? null : "%" + nombre.trim().toUpperCase() + "%";
    return listarSubmenuPorMenuIdPort.listarTodosPorMenuId(filtro, menuId);
  }

}

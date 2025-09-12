package pe.mef.sitfis.seguridad.application.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import pe.mef.sitfis.seguridad.application.command.CrearActualizarRolGrupoCommand;
import pe.mef.sitfis.seguridad.application.dto.RolGrupoDto;
import pe.mef.sitfis.seguridad.application.exception.BusinessException;
import pe.mef.sitfis.seguridad.application.port.inbound.CrearOActualizarRolGrupoUseCase;
import pe.mef.sitfis.seguridad.application.port.inbound.EliminarRolGrupoUseCase;
import pe.mef.sitfis.seguridad.application.port.inbound.ListarRolGrupoPorGrupoIdUseCase;
import pe.mef.sitfis.seguridad.application.port.outbound.BuscarRolGrupoPorGrupoIdPort;
import pe.mef.sitfis.seguridad.application.port.outbound.EliminarRolGrupoPort;
import pe.mef.sitfis.seguridad.application.port.outbound.GuardarActualizarRolGrupoPort;

@RequiredArgsConstructor
public class RolGrupoService implements ListarRolGrupoPorGrupoIdUseCase,
    CrearOActualizarRolGrupoUseCase, EliminarRolGrupoUseCase {

  private final BuscarRolGrupoPorGrupoIdPort buscarRolGrupoPorGrupoIdPort;
  private final GuardarActualizarRolGrupoPort guardarActualizarRolGrupoPort;
  private final EliminarRolGrupoPort eliminarRolGrupoPort;

  @Override
  public List<RolGrupoDto> listarPorGrupoId(Long id) {
    return buscarRolGrupoPorGrupoIdPort.buscarPorGrupoId(id);
  }

  @Override
  public void crearOActualizar(List<CrearActualizarRolGrupoCommand> request) {
    if (request == null || request.isEmpty()) {
      throw new BusinessException("Error al evaluar la lista, no se encontraron datos");
    }

    var resultado = guardarActualizarRolGrupoPort.guardarActualizar(request);
    if (resultado <= 0) {
      throw new BusinessException("Error al crear/actualizar los registros");
    }
  }

  @Override
  public void eliminar(Long id) {
    eliminarRolGrupoPort.eliminar(id);
  }

}

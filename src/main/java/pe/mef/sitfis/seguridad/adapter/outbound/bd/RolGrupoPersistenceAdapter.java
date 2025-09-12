package pe.mef.sitfis.seguridad.adapter.outbound.bd;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pe.mef.sitfis.seguridad.adapter.inbound.api.mapper.RolGrupoJpaMapper;
import pe.mef.sitfis.seguridad.adapter.outbound.bd.repository.RolGrupoRepository;
import pe.mef.sitfis.seguridad.application.command.CrearActualizarRolGrupoCommand;
import pe.mef.sitfis.seguridad.application.dto.RolGrupoDto;
import pe.mef.sitfis.seguridad.application.port.outbound.BuscarRolGrupoPorGrupoIdPort;
import pe.mef.sitfis.seguridad.application.port.outbound.EliminarRolGrupoPort;
import pe.mef.sitfis.seguridad.application.port.outbound.GuardarActualizarRolGrupoPort;

@Component
@RequiredArgsConstructor
public class RolGrupoPersistenceAdapter implements
    BuscarRolGrupoPorGrupoIdPort,
    GuardarActualizarRolGrupoPort,
    EliminarRolGrupoPort {

  private final RolGrupoRepository repository;
  private final RolGrupoJpaMapper mapper;

  @Override
  public List<RolGrupoDto> buscarPorGrupoId(Long id) {
    return repository.findAllByGrupoId(id).stream()
        .map(mapper::toDto)
        .toList();
  }

  @Transactional
  @Override
  public int guardarActualizar(List<CrearActualizarRolGrupoCommand> grupoCommandList) {
    var listaNuevos = grupoCommandList.stream().filter(x -> x.id() == null).toList();
    var commandNuevos = listaNuevos.stream()
        .map(mapper::toEntity)
        .toList();
    var resultadoNuevos = repository.saveAll(commandNuevos);

    var listaActualizados = grupoCommandList.stream().filter(x -> x.id() != null).toList();
    for (var rolGrupoCommand : listaActualizados) {
      repository.actualizarRolGrupoConRecord(rolGrupoCommand);
    }

    return resultadoNuevos.size() + listaActualizados.size();
  }

  @Transactional
  @Override
  public void eliminar(Long id) {
    var query = repository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException(
            String.format("No se encontraron datos para el id: %s", id)));
    repository.deleteById(query.getId());
  }
}

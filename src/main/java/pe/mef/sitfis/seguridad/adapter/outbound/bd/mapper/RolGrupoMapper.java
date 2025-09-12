package pe.mef.sitfis.seguridad.adapter.outbound.bd.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import pe.mef.sitfis.seguridad.adapter.inbound.api.dto.CrearActualizarRolGrupoRequest;
import pe.mef.sitfis.seguridad.adapter.inbound.api.dto.RolGrupoResponse;
import pe.mef.sitfis.seguridad.application.command.CrearActualizarRolGrupoCommand;
import pe.mef.sitfis.seguridad.application.dto.RolGrupoDto;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RolGrupoMapper {

  List<RolGrupoResponse> toResponse(List<RolGrupoDto> dto);

  @Mapping(source = "rolId.id", target = "rolId")
  @Mapping(source = "grupoId.id", target = "grupoId")
  CrearActualizarRolGrupoCommand toCommand(CrearActualizarRolGrupoRequest request);

}

package pe.mef.sitfis.seguridad.adapter.inbound.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import pe.mef.sitfis.seguridad.adapter.outbound.bd.entity.GrupoJpaEntity;
import pe.mef.sitfis.seguridad.adapter.outbound.bd.entity.RolJpaEntity;
import pe.mef.sitfis.seguridad.adapter.outbound.bd.entity.RolGrupoJpaEntity;
import pe.mef.sitfis.seguridad.adapter.outbound.bd.projection.RolGrupoProjection;
import pe.mef.sitfis.seguridad.application.command.CrearActualizarRolGrupoCommand;
import pe.mef.sitfis.seguridad.application.dto.RolGrupoDto;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RolGrupoJpaMapper {

  RolGrupoDto toDto(RolGrupoProjection projection);

  @Mapping(source = "rolId", target = "roles", qualifiedByName = "rolFromId")
  @Mapping(source = "grupoId", target = "grupos", qualifiedByName = "grupoFromId")
  RolGrupoJpaEntity toEntity(CrearActualizarRolGrupoCommand request);

  @Named("rolFromId")
  default RolJpaEntity rolFromId(Long id) {
    if (id == null) {
      return null;
    }
    RolJpaEntity rol = new RolJpaEntity();
    rol.setId(id);
    return rol;
  }

  @Named("grupoFromId")
  default GrupoJpaEntity grupoFromId(Long id) {
    if (id == null) {
      return null;
    }
    GrupoJpaEntity grupo = new GrupoJpaEntity();
    grupo.setId(id);
    return grupo;
  }
}

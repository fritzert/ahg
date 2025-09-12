package pe.mef.sitfis.seguridad.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import pe.mef.sitfis.seguridad.application.query.ListarMenuApplicationQuery;
import pe.mef.sitfis.seguridad.domain.query.ListarMenuDomainQuery;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface MenuDomainMapper {

  MenuDomainMapper INSTANCE = Mappers.getMapper(MenuDomainMapper.class);

  ListarMenuDomainQuery toDomainQuery(ListarMenuApplicationQuery applicationQuery);

}
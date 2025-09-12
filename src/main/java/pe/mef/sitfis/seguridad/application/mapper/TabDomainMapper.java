package pe.mef.sitfis.seguridad.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import pe.mef.sitfis.seguridad.application.query.BuscarTabApplicationQuery;
import pe.mef.sitfis.seguridad.application.query.BuscarTabPaginadoApplicationQuery;
import pe.mef.sitfis.seguridad.domain.query.BuscarTabDomainQuery;
import pe.mef.sitfis.seguridad.domain.query.BuscarTabPaginadoDomainQuery;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TabDomainMapper {

  TabDomainMapper INSTANCE = Mappers.getMapper(TabDomainMapper.class);

  BuscarTabDomainQuery toDomainQuery(BuscarTabApplicationQuery applicationQuery);

  @Mapping(source = "paginaApplicationQuery", target = "paginaDomainQuery")
  BuscarTabPaginadoDomainQuery toPaginadoDomainQuery(
      BuscarTabPaginadoApplicationQuery applicationQuery);
}
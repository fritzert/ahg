package pe.mef.sitfis.seguridad.adapter.inbound.api.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pe.mef.sitfis.seguridad.adapter.inbound.api.dto.TabComboResponse;
import pe.mef.sitfis.seguridad.adapter.inbound.api.dto.TabPaginadoResponse;
import pe.mef.sitfis.seguridad.application.dto.TabDto;
import pe.mef.sitfis.seguridad.application.dto.TabPaginadoDto;
import pe.mef.sitfis.seguridad.application.query.BuscarTabApplicationQuery;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TabApiMapper {

  BuscarTabApplicationQuery toQuery(String nombre, Long submenuId, Long menuId);

  List<TabComboResponse> toListResponse(List<TabDto> dtos);

  List<TabPaginadoResponse> toListPaginadoResponse(List<TabPaginadoDto> dtoList);

}

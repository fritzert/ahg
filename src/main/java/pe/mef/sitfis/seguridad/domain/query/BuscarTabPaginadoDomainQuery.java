package pe.mef.sitfis.seguridad.domain.query;

public record BuscarTabPaginadoDomainQuery(
    Long menuId,
    Long submenuId,
    Long tabId,
    PaginaDomainQuery paginaDomainQuery) {

}

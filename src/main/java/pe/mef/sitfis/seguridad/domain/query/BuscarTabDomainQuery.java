package pe.mef.sitfis.seguridad.domain.query;

public record BuscarTabDomainQuery(
    String nombre,
    Long menuId,
    Long submenuId) {

}

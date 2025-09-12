package pe.mef.sitfis.seguridad.adapter.outbound.bd.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.mef.sitfis.seguridad.adapter.outbound.bd.entity.RolGrupoJpaEntity;
import pe.mef.sitfis.seguridad.adapter.outbound.bd.projection.RolGrupoProjection;
import pe.mef.sitfis.seguridad.application.command.CrearActualizarRolGrupoCommand;

@Repository
public interface RolGrupoRepository extends JpaRepository<RolGrupoJpaEntity, Long> {

  @Query("""
          SELECT rg.id AS id, rg.roles.id AS rolId, rg.roles.nombre AS rolNombre,
          rg.grupos.id AS grupoId,
          rg.flagRestriccion AS flagRestriccion,
          rg.flagConsulta AS flagConsulta,
          rg.flagOperacion AS flagOperacion,
          rg.flagAsignarRecursos AS flagAsignarRecursos,
          rg.flagEnviarBandeja AS flagEnviarBandeja,
          rg.flagEnviarEtapa AS flagEnviarEtapa,
          rg.flagAdjuntarArchivo AS flagAdjuntarArchivo,
          rg.usuarioModificacion AS usuarioModificacion,
          rg.fechaModificacion AS fechaModificacion
          FROM RolGrupo rg
          WHERE rg.grupos.id = :grupoId
          ORDER BY rg.roles.nombre ASC
      """)
  List<RolGrupoProjection> findAllByGrupoId(@Param("grupoId") Long grupoId);

  @Query("SELECT rg FROM RolGrupo rg WHERE rg.grupos.id = :grupoId")
  List<RolGrupoJpaEntity> findByGrupoId(@Param("grupoId") Long grupoId);

  @Query("SELECT rg FROM RolGrupo rg WHERE rg.roles.id = :rolId")
  List<RolGrupoJpaEntity> findByRolId(@Param("rolId") Long rolId);

  @Modifying
  @Query("""
          UPDATE RolGrupo rg SET
          rg.roles.id = :#{#command.rolId},
          rg.grupos.id = :#{#command.grupoId},
          rg.flagRestriccion = :#{#command.flagRestriccion},
          rg.flagConsulta = :#{#command.flagConsulta},
          rg.flagOperacion = :#{#command.flagOperacion},
          rg.flagAsignarRecursos = :#{#command.flagAsignarRecursos},
          rg.flagEnviarBandeja = :#{#command.flagEnviarBandeja},
          rg.flagEnviarEtapa = :#{#command.flagEnviarEtapa},
          rg.flagAdjuntarArchivo = :#{#command.flagAdjuntarArchivo}
          WHERE rg.id = :#{#command.id}
      """)
  void actualizarRolGrupoConRecord(@Param("command") CrearActualizarRolGrupoCommand command);

}

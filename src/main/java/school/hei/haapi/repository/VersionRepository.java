package school.hei.haapi.repository;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import school.hei.haapi.model.Version;

@Repository
public interface VersionRepository extends JpaRepository<Version,String> {
  List<Version> findAllByCreatedBy_IdAndTranscript_Id(String createdById, String transcriptId, Pageable pageable);
  Version getVersionByCreatedBy_IdAndTranscript_IdAndId(String createdById, String transcriptId, String id);
}

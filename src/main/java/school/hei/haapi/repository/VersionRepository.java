package school.hei.haapi.repository;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import school.hei.haapi.model.Version;

@Repository
public interface VersionRepository extends JpaRepository<Version,String> {

  List<Version> findAllByTranscript_Id( String transcriptId, Pageable pageable);
  Version getVersionByTranscript_IdAndId(String transcriptId, String id);

}

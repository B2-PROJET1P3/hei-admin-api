package school.hei.haapi.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import school.hei.haapi.model.Claim;


@Repository
public interface ClaimRepository extends JpaRepository<Claim,String> {
  List<Claim> findAllByVersionIdAndTranscriptId(String versionId, String  transcriptId);
  
  Claim findByVersionIdAndTranscriptIdAndId(String versionId,String transcriptId,String id);
}

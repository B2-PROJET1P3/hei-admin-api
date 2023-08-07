package school.hei.haapi.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import school.hei.haapi.model.Claim;


@Repository
public interface ClaimRepository extends JpaRepository<Claim,String> {
  List<Claim> findAllByVersion_IdAndTranscript_Id(String versionId, String  transcriptId);
  
  Claim findByVersion_IdAndTranscript_IdAndId(String versionId,String transcriptId,String id);
}

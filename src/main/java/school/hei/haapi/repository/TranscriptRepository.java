package school.hei.haapi.repository;

import java.awt.print.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import school.hei.haapi.model.Transcript;

@Repository
public interface TranscriptRepository extends JpaRepository<Transcript,String> {
  Transcript findByStudent_IdAndId(String studentId, String transcriptId);
}
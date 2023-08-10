package school.hei.haapi.repository;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import school.hei.haapi.model.Transcript;

@Repository
public interface TranscriptRepository extends JpaRepository<Transcript, String> {
  List<Transcript> findAllByStudentId(String student_id, Pageable pageable);

  Transcript findByStudentIdAndId(String studentId, String transcriptId);

}

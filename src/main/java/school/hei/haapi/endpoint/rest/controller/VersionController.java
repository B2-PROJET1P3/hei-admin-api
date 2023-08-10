package school.hei.haapi.endpoint.rest.controller;

import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import school.hei.haapi.endpoint.rest.mapper.TranscriptMapper;
import school.hei.haapi.endpoint.rest.mapper.UserMapper;
import school.hei.haapi.endpoint.rest.mapper.VersionMapper;
import school.hei.haapi.endpoint.rest.model.Student;
import school.hei.haapi.endpoint.rest.model.Transcript;
import school.hei.haapi.endpoint.rest.model.User;
import school.hei.haapi.endpoint.rest.model.Version;
import school.hei.haapi.model.BoundedPageSize;
import school.hei.haapi.model.PageFromOne;
import school.hei.haapi.service.TranscriptService;
import school.hei.haapi.service.UserService;
import school.hei.haapi.service.VersionService;

@RestController
@AllArgsConstructor
public class VersionController {
  private final VersionService service;
  private final VersionMapper mapper;
  private final UserService userService;
  private final UserMapper userMapper;
  private final TranscriptMapper transcriptMapper;
  private final TranscriptService transcriptService;

  @GetMapping("/students/{student_id}/transcripts/{transcript_id}/versions")
  public List<Version> getVersions(@PathVariable(value = "student_id") String studentId,
                                   @PathVariable(value = "transcript_id") String transcriptId,
                                   @RequestParam("page") PageFromOne page,
                                   @RequestParam("page_size") BoundedPageSize pageSize){
    Student student = userMapper.toRestStudent(userService.getById(studentId));
    Transcript transcript = transcriptMapper.toRest(transcriptService.getTranscriptById(studentId, transcriptId),
        student);

    return service.getVersions(transcriptId, page, pageSize).stream()
        .map(version -> mapper.toRest(version, transcript, student)).collect(Collectors.toUnmodifiableList());
  }
  @GetMapping("/students/{student_id}/transcripts/{transcript_id}/versions/{version_id}")
  public Version getVersionById(@PathVariable(value = "student_id") String studentId,
                                @PathVariable(value = "transcript_id") String transcriptId,
                                @PathVariable(value = "version_id") String versionId){
    Student student = userMapper.toRestStudent(userService.getById(studentId));
    Transcript transcript = transcriptMapper.toRest(transcriptService.getTranscriptById(studentId, transcriptId),
        student);

    return mapper.toRest(service.getVersionById(transcriptId,versionId),transcript,student);
  }
}

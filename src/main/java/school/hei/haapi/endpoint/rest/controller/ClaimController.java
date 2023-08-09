package school.hei.haapi.endpoint.rest.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import school.hei.haapi.endpoint.rest.mapper.ClaimMapper;
import school.hei.haapi.endpoint.rest.mapper.TranscriptMapper;
import school.hei.haapi.endpoint.rest.mapper.VersionMapper;
import school.hei.haapi.service.ClaimService;
import school.hei.haapi.service.TranscriptService;
import school.hei.haapi.service.VersionService;

@RestController
@AllArgsConstructor
public class ClaimController {
  private final TranscriptService transcriptService;
  private final TranscriptMapper transcriptMapper;
  private final ClaimService claimService;
  private final ClaimMapper claimMapper;
  private final VersionService versionService;
  private final VersionMapper versionMapper;
  
  
  
}

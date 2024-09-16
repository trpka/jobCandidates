package com.example.jobcandidates.controller;


import com.example.jobcandidates.DTO.CandidatePageDTO;
import com.example.jobcandidates.model.Candidate;
import com.example.jobcandidates.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CandidateController {
    @Autowired
    private CandidateService candidateService;

    @RequestMapping(value="api/candidates", params= {"page","size"},method = RequestMethod.GET,produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<CandidatePageDTO> findCandidatesPage(Pageable pageable){
        Page<Candidate> candidates = this.candidateService.getCandidates(pageable);
        CandidatePageDTO candidatePageDTO =new CandidatePageDTO(this.candidateService.convert(candidates.getContent()), candidates.isLast());
        return new ResponseEntity<>(candidatePageDTO, HttpStatus.OK);
    }
}
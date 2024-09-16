package com.example.jobcandidates.service;

import com.example.jobcandidates.DTO.CandidateDTO;
import com.example.jobcandidates.model.Candidate;
import com.example.jobcandidates.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CandidateService {
    @Autowired
    private CandidateRepository candidateRepository;

    public Page<Candidate> getCandidates(Pageable pageable) {
        return candidateRepository.findAll(pageable);
    }

    public List<CandidateDTO> convert(List<Candidate> candidates){
        List<CandidateDTO> candidateDTOS = new ArrayList<>();
        for(Candidate candidate: candidates){
            CandidateDTO candidateDTO = new CandidateDTO(candidate);
            candidateDTOS.add(candidateDTO);
        }
        return candidateDTOS;
    }
}

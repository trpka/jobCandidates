package com.example.jobcandidates.DTO;

import java.util.List;

public class CandidatePageDTO {

    List<CandidateDTO> content;
    boolean last;

    public List<CandidateDTO> getContent() {
        return content;
    }

    public void setContent(List<CandidateDTO> content) {
        this.content = content;
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    public CandidatePageDTO() {
    }

    public CandidatePageDTO(List<CandidateDTO> content, boolean last) {
        this.content = content;
        this.last = last;
    }
}

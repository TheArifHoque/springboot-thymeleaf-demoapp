package com.arifhoque.main.service;

import com.arifhoque.main.model.Candidate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CandidateService {
    List<Candidate> candidateList = new ArrayList<>();

    public void init() {
        candidateList.add(new Candidate(101, "ABC", "Java Batch -6"));
        candidateList.add(new Candidate(102, "DEF", "Java Batch -6"));
        candidateList.add(new Candidate(103, "GHI", "Java Batch -6"));
        candidateList.add(new Candidate(104, "JKL", "Java Batch -6"));
        candidateList.add(new Candidate(105, "MNO", "Java Batch -6"));
    }

    public Candidate findById(Integer id){
        for (Candidate c:candidateList){
            if (Objects.equals(c.getId(),id))
                return c;
        }
        return null;
    }

    public List<Candidate> getAllCandidate(){
        return candidateList;
    }

    public void addCandidate(Candidate candidate){
        candidateList.add(candidate);
    }
}

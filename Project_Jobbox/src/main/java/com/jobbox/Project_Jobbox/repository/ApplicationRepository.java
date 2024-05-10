package com.jobbox.Project_Jobbox.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jobbox.Project_Jobbox.entity.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer> {
@Query("select app from Application app where app.candidateId=?1")
List<Application> getApplicationsByCandidateId(int candidateId);


@Query("select app from Application app where app.hrId=?1")
List<Application> getApplicationsByHRId(int hrId);

@Query("select app from Application app where app.jobId=?1")
List<Application> getApplicationsByJobId(int jobId);

}

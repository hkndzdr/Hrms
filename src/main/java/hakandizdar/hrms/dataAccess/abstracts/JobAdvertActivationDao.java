package hakandizdar.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hakandizdar.hrms.entities.concretes.JobAdvertActivation;

public interface JobAdvertActivationDao extends JpaRepository<JobAdvertActivation, Integer>{

}

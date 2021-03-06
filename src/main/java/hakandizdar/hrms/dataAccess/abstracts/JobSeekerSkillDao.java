package hakandizdar.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hakandizdar.hrms.entities.concretes.JobSeekerSkill;

public interface JobSeekerSkillDao extends JpaRepository<JobSeekerSkill, Integer>{
	List<JobSeekerSkill> getAllByJobSeekerId(int jobSeekerId);
}

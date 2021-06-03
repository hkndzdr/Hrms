package hakandizdar.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hakandizdar.hrms.entities.concretes.JobSeekerSocialPlatform;

public interface JobSeekerSocialPlatformDao extends JpaRepository<JobSeekerSocialPlatform, Integer>{
	List<JobSeekerSocialPlatform> getAllByJobSeekerId(int jobSeekerId);
}

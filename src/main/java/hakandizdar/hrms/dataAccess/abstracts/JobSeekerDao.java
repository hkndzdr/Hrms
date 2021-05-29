package hakandizdar.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hakandizdar.hrms.entities.concretes.JobSeeker;

public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer> {
	JobSeeker getByNationality(String nationality);
}

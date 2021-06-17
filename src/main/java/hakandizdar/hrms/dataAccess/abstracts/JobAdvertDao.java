package hakandizdar.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hakandizdar.hrms.entities.concretes.JobAdvert;

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer> {
	List<JobAdvert> getAllByIsActiveTrue();
	List<JobAdvert> getAllByIsActiveTrue(Sort sort);
	List<JobAdvert> getAllByEmployerId(int id);
	List<JobAdvert> getAllByEmployer_CompanyName(String companyName);
	@Query("From JobAdvert where isActive = false order by application_deadline asc")
	List<JobAdvert> getAllByIsActiveFalse();
}

package hakandizdar.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hakandizdar.hrms.entities.concretes.JobAdvert;

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer> {
	@Query("From JobAdvert where isActive = true")
	List<JobAdvert> getAllActiveAdverts();
	
	@Query("From JobAdvert where isActive = true Order By releaseDate ASC")
	List<JobAdvert> getAllActiveAdvertsByReleasedDateByAsc();
	
	@Query("From JobAdvert where isActive = true Order By releaseDate DESC")
	List<JobAdvert> getAllActiveAdvertsByReleasedDateByDesc();
	
	@Query("From JobAdvert where isActive = true")
	List<JobAdvert> getAllActiveAdvertsByEmployer(int employerId);
}

package hakandizdar.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hakandizdar.hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer>{
	
}

package hakandizdar.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hakandizdar.hrms.entities.concretes.Workplace;

public interface WorkplaceDao extends JpaRepository<Workplace, Integer>{

}

package hakandizdar.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hakandizdar.hrms.entities.concretes.Staff;

public interface StaffDao extends JpaRepository<Staff, Integer>{

}

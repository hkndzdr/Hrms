package hakandizdar.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hakandizdar.hrms.entities.concretes.WorkSchedule;

public interface WorkScheduleDao extends JpaRepository<WorkSchedule, Integer>{

}

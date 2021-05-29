package hakandizdar.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hakandizdar.hrms.entities.concretes.City;

public interface CityDao extends JpaRepository<City, Integer>{

}

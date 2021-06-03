package hakandizdar.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hakandizdar.hrms.entities.concretes.Image;

public interface ImageDao extends JpaRepository<Image, Integer>{
	List<Image> getAllByJobSeekerId(int jobSeekerId);
}

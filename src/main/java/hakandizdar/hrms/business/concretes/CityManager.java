package hakandizdar.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hakandizdar.hrms.business.abstracts.CityService;
import hakandizdar.hrms.core.utilities.results.DataResult;
import hakandizdar.hrms.core.utilities.results.Result;
import hakandizdar.hrms.core.utilities.results.SuccessDataResult;
import hakandizdar.hrms.core.utilities.results.SuccessResult;
import hakandizdar.hrms.dataAccess.abstracts.CityDao;
import hakandizdar.hrms.entities.concretes.City;

@Service
public class CityManager implements CityService{
	private CityDao cityDao;
	
	@Autowired
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}

	@Override
	public Result add(City city) {
		this.cityDao.save(city);
		return new SuccessResult("Şehir eklendi");
	}
	
	@Override
	public DataResult<List<City>> getAll() {
		return new SuccessDataResult<List<City>>
		(cityDao.findAll(),"Tüm şehirler listelendi");
	}

}

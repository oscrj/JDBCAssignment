package ECutb.Data;

import ECutb.Model.City;

import java.util.List;

public interface CityDao {

    City findById(int id);
    List<City> findByCountryCode(String countryCode);
    List<City> findByName(String name);
    List<City> findAll();
    City add(City city);
    City update(City city);
    int delete(City city);
 }

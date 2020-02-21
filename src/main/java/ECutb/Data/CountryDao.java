package ECutb.Data;

import ECutb.Model.Country;

import java.util.List;

public interface CountryDao {

    Country findByCountryCode(String countryCode);
    List<Country> findAll();
    List<Country> findByName(String name);
    List<Country> findByRegion(String region);
    List<Country> findByGovernmentForm(String governmentForm);
    List<Country> findByPopulationsBetween(int lowest, int highest);
    Country add(Country country);
    Country update(Country country);
    int delete(Country country);

}

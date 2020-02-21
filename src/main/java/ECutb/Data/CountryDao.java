package ECutb.Data;

import ECutb.Model.Country;

import java.util.List;

public interface CountryDao {

    Country findByCountryCode(String countryCode);
    List<Country> findAll();
    List<Country> findByName(String name);
    List<Country> findByRegion(String region);
    List<Country> findAllInRegion(String region);
    List<Country> findByGovernmentForm(String governmentForm);
    Country findWhoIsTheBoss(String headOfState);
    Country add(Country country);
    Country update(Country country);
    int delete(Country country);

}

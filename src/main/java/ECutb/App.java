package ECutb;

import ECutb.Data.CityDaoImpl;
import ECutb.Data.CountryDao;
import ECutb.Data.CountryDaoImpl;
import ECutb.Model.City;
import ECutb.Model.Country;

public class App
{
    public static void main( String[] args ) {
        CityDaoImpl cityDao = new CityDaoImpl();

        //  Find By ID.
        //System.out.println(cityDao.findById(4080));

        //  Find By CountryCode.
        //System.out.println(cityDao.findByCountryCode("SWE"));

        //  Find By Name.
        //System.out.println(cityDao.findByName("Gothenburg [Göteborg]"));

        //  Find All Cities.
        //System.out.println(cityDao.findAll());

        //  Add City.
        /*City vxo = new City("Växjö", "SWE","Kronobergs län",92000);
        City kalmar = new City("Kalmar", "SWE", "Kalmar län", 69185);
        City ronneby = new City("Ronneby", "SWE", "Blekinge län", 29694);
        City vbg = new City("Varberg", "SWE", "Hallands län", 64446);
        City fbg = new City("Falkenberg", "SWE", "Hallands län", 27301);
        cityDao.add(vxo);
        cityDao.add(kalmar);
        cityDao.add(ronneby);
        cityDao.add(vbg);
        cityDao.add(fbg);*/

        //  Update City By ID.
        //City vxoUpdate = cityDao.findById(4081);
        //vxoUpdate.setName("Alvesta");
        //vxoUpdate.setPopulation(20187);
        //System.out.println(cityDao.update(vxoUpdate));

        // Delete City.
        /*City deletedCity = cityDao.findById(4091);
        System.out.println(cityDao.delete(deletedCity));*/


        CountryDaoImpl countryDao = new CountryDaoImpl();

        // Find country with countryCode.
        //System.out.println(countryDao.findByCountryCode("SWE"));

        //  Find All.
        //System.out.println(countryDao.findAll().size());

        //  Find By Name.
        //System.out.println(countryDao.findByName("Norway"));

        //  Find By Government
        //System.out.println(countryDao.findByGovernmentForm("Monarchy"));

        // Find By Population Between.
        //System.out.println(countryDao.findByPopulationsBetween(8000000, 15000000));

        //  Find By Region.
        //System.out.println(countryDao.findByRegion("Northern Africa"));

        // Add Country
        /*Country country = new Country("AAA", "LandetLagom", "Europe","Northern Countries", 1000.0,1200, 10300000, 80.1,220000.00, 222.001, "LandetLagom", "Monarchy", "Nisse Pistol", 1000000, "LL");
        Country country2 = new Country("AAB", "LandetLagom2", "Europe","Northern Countries", 1000.0,1200, 10300000, 80.1,220000.00, 222.001, "LandetLagom", "Monarchy", "Nisse Pistol", 1000000, "LL");
        Country country3 = new Country("AAC", "LandetLagom3", "Europe","Northern Countries", 1000.0,1200, 10300000, 80.1,220000.00, 222.001, "LandetLagom", "Monarchy", "Nisse Pistol", 1000000, "LL");
        Country country4 = new Country("AAD", "LandetLagom4", "Europe","Northern Countries", 1000.0,1200, 10300000, 80.1,220000.00, 222.001, "LandetLagom", "Monarchy", "Nisse Pistol", 1000000, "LL");
        countryDao.add(country);
        countryDao.add(country2);
        countryDao.add(country3);
        countryDao.add(country4);*/

        //  Update Country.
        Country updatedCountry = countryDao.findByCountryCode("AAA");
        updatedCountry.setName("AANeverland");
        updatedCountry.setHeadOfState("Peter Pan");
        updatedCountry.setPopulation(150);
        updatedCountry.setRegion("In a place far far away");

        System.out.println(countryDao.update(updatedCountry));


        //  Delete Countries.
        //System.out.println(countryDao.delete(country, country2, country3, country4));
    }
}

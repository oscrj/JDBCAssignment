package ECutb;

import ECutb.Data.CityDaoImpl;
import ECutb.Data.CountryDao;
import ECutb.Data.CountryDaoImpl;
import ECutb.Model.City;

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

        //Find All.

        System.out.println(countryDao.findAll().size());
    }
}

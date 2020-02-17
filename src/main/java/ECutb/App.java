package ECutb;

import ECutb.Data.CityDaoImpl;

public class App
{
    public static void main( String[] args ) {
        CityDaoImpl cityDao = new CityDaoImpl();

        //  Find By ID.
        //System.out.println(cityDao.findById(101));

        //  Find By CountryCode.
        //System.out.println(cityDao.findByCountryCode("SWE"));

        //  Find All Cities.
        //System.out.println(cityDao.findAll());
    }
}

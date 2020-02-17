package ECutb;

import ECutb.Data.CityDaoImpl;

public class App
{
    public static void main( String[] args ) {
        CityDaoImpl cityDao = new CityDaoImpl();

        System.out.println(cityDao.findAll());
    }
}

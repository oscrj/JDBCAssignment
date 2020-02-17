package ECutb.Data;

import ECutb.Model.City;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.PrimitiveIterator;

import static ECutb.Data.Database.getConnections;

public class CityDaoImpl implements CityDao {

    private static final String FIND_BY_ID = "SELECT * FROM City WHERE ID = ?";
    private static final String FIND_BY_COUNTRYCODE = "SELECT * FROM City WHERE CountryCode = ?";
    private static final String FIND_BY_NAME = "";
    private static final String FIND_ALL = "SELECT * FROM City";

    @Override
    public City findById(int id) {
        City city = null;
        try(
                Connection connection = getConnections();
                PreparedStatement statement = createFindById(connection, id);
                ResultSet resultSet = statement.executeQuery();
                ){
            while (resultSet.next()){
               city = new City(
                        resultSet.getInt("ID"),
                        resultSet.getString("Name"),
                        resultSet.getString("CountryCode"),
                        resultSet.getString("District"),
                        resultSet.getInt("Population")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return city;
    }

    private PreparedStatement createFindById(Connection connection, int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(FIND_BY_ID);
        statement.setInt(1, id);
        return statement;
    }

    @Override
    public List<City> findByCountryCode(String countryCode) {
        List<City> citiesByCountryCode = new ArrayList<>();
        try (
                Connection connection = getConnections();
                PreparedStatement statement = createFindByCountryCode(connection, countryCode);
                ResultSet resultSet = statement.executeQuery();
                ){
            while (resultSet.next()){
                citiesByCountryCode.add(
                        new City(
                                resultSet.getInt("ID"),
                                resultSet.getString("Name"),
                                resultSet.getString("CountryCode"),
                                resultSet.getString("District"),
                                resultSet.getInt("Population")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return citiesByCountryCode;
    }

    private PreparedStatement createFindByCountryCode(Connection connection, String countryCode) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(FIND_BY_COUNTRYCODE);
        statement.setString(1, countryCode);
        return statement;
    }

    @Override
    public List<City> findByName(String name) {
        List<City> citiesByName = new ArrayList<>();


        return citiesByName;
    }

    @Override
    public List<City> findAll() {
        List<City> allCities = new ArrayList<>();
        try (
                Connection connection = getConnections();
                PreparedStatement statement = connection.prepareStatement(FIND_ALL);
                ResultSet resultSet = statement.executeQuery();){

            while(resultSet.next()){
                allCities.add(
                    new City(
                        resultSet.getInt("ID"),
                        resultSet.getString("Name"),
                        resultSet.getString("CountryCode"),
                        resultSet.getString("District"),
                        resultSet.getInt("Population")
                    )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allCities;
    }

    /*
    private PreparedStatement createFindAll(Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(FIND_ALL);
        return statement;
    }*/

    @Override
    public City add(City city) {
        return null;
    }

    @Override
    public City update(City city) {
        return null;
    }

    @Override
    public int delete(City city) {
        return 0;
    }
}

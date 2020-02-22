package ECutb.Data;

import ECutb.Model.City;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static ECutb.Data.Database.getConnections;

public class CityDaoImpl implements CityDao {

    private static final String FIND_BY_ID = "SELECT * FROM City WHERE ID = ?";
    private static final String FIND_BY_COUNTRYCODE = "SELECT * FROM City WHERE CountryCode = ?";
    private static final String FIND_BY_NAME = "SELECT * FROM City WHERE Name = ?";
    private static final String FIND_ALL = "SELECT * FROM City";
    private static final String ADD_CITY_TO_DATABASE = "INSERT INTO City(Name, CountryCode, District, population)VALUES(?,?,?,?)";
    private static final String UPDATE_CITY = "UPDATE City SET Name = ?, CountryCode = ?, District = ?, Population = ? WHERE ID = ?";
    private static final String DELETE_CITY = "DELETE FROM City WHERE ID = ?";

    @Override
    public City findById(int id) {
        City city = null;
        try(
                Connection connection = getConnections();
                PreparedStatement statement = setStatementFindById(connection, id);
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

    private PreparedStatement setStatementFindById(Connection connection, int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(FIND_BY_ID);
        statement.setInt(1, id);
        return statement;
    }

    @Override
    public List<City> findByCountryCode(String countryCode) {
        List<City> citiesByCountryCode = new ArrayList<>();
        try (
                Connection connection = getConnections();
                PreparedStatement statement = setStatementFindByCountryCodeStatement(connection, countryCode);
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

        if(citiesByCountryCode.isEmpty()){
            System.out.println("City with CountryCode " + countryCode + " was not found....");
        }

        return citiesByCountryCode;
    }

    private PreparedStatement setStatementFindByCountryCodeStatement(Connection connection, String countryCode) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(FIND_BY_COUNTRYCODE);
        statement.setString(1, countryCode);
        return statement;
    }

    @Override
    public List<City> findByName(String name) {
        List<City> citiesByName = new ArrayList<>();
        try (
                Connection connection = getConnections();
                PreparedStatement statement = setStatementFindByName(connection, name);
                ResultSet resultSet = statement.executeQuery();
                ){
            while(resultSet.next()){
                citiesByName.add(
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
        if(citiesByName.isEmpty()){
            System.out.println("City with name: " + name + " was not found..");
        }
        return citiesByName;
    }

    private PreparedStatement setStatementFindByName(Connection connection, String name) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(FIND_BY_NAME);
        statement.setString(1, name);
        return statement;
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
        if(allCities.isEmpty()){
            System.out.println("No cities were found...");
        }
        return allCities;
    }

    @Override
    public City add(City city) {
        ResultSet resultSet = null;
        try (
                Connection connection = getConnections();
                PreparedStatement statement = setStatementAddCity(connection, city);
            ){
            statement.execute();
            resultSet = statement.getGeneratedKeys();
            while (resultSet.next()){
                city = new City(
                        resultSet.getInt(1),
                        city.getName(),
                        city.getCountryCode(),
                        city.getDistrict(),
                        city.getPopulation()
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return city;
    }

    private PreparedStatement setStatementAddCity(Connection connection, City city) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(ADD_CITY_TO_DATABASE, Statement.RETURN_GENERATED_KEYS);
        // City(Name, CountryCode, District, population)VALUES(?,?,?,?).
        statement.setString(1, city.getName());
        statement.setString(2, city.getCountryCode());
        statement.setString(3, city.getDistrict());
        statement.setInt(4, city.getPopulation());
        return statement;
    }

    @Override
    public City update(City city) {
        try (
                Connection connection = getConnections();
                PreparedStatement statement = connection.prepareStatement(UPDATE_CITY);
                ){
            statement.setString(1, city.getName());
            statement.setString(2, city.getCountryCode());
            statement.setString(3, city.getDistrict());
            statement.setInt(4, city.getPopulation());
            statement.setInt(5, city.getCityId());
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return city;
    }

    @Override
    // Check out delete(Countries) to see a method to delete multiple objects at once.
    public int delete(City city) {
        try (
                Connection connection = getConnections();
                PreparedStatement statement = connection.prepareStatement(DELETE_CITY);
                ){
            statement.setInt(1, city.getCityId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(findById(city.getCityId()) != null) {
            return 0;
        }
        else {
            // If city with id is null, then its removed.
            return 1;
        }
    }
}

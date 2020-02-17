package ECutb.Data;

import ECutb.Model.City;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static ECutb.Data.Database.getConnections;

public class CityDaoImpl implements CityDao {

    private static final String FIND_ALL = "SELECT * FROM City";

    @Override
    public City findById(int id) {
        return null;
    }

    @Override
    public List<City> findByCountryCode(String countryCode) {
        return null;
    }

    @Override
    public List<City> findByName(String name) {
        return null;
    }

    @Override
    public List<City> findAll() {
        List<City> allCities = new ArrayList<>();

        try (
                Connection connection = getConnections();
                PreparedStatement statement = createFindAll(connection);
                ResultSet resultSet = statement.executeQuery();
                ){
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

    private PreparedStatement createFindAll(Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(FIND_ALL);
        return statement;
    }

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

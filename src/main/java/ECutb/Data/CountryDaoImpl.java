package ECutb.Data;

import ECutb.Model.Country;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static ECutb.Data.Database.getConnections;

public class CountryDaoImpl implements CountryDao {

    @Override
    public Country findByCountryCode(String countryCode) {
        Country country = null;
        try (
                Connection connection = getConnections();
                PreparedStatement statement = setStatementFindByCountryCode(connection, countryCode);
                ResultSet resultSet = statement.executeQuery();
                ){
            while (resultSet.next()){
                country = new Country(
                        resultSet.getString("Code"),
                        resultSet.getString("Name"),
                        resultSet.getString("Continent"),
                        resultSet.getString("Region"),
                        resultSet.getDouble("SurfaceArea"),
                        resultSet.getInt("IndepYear"),
                        resultSet.getInt("Population"),
                        resultSet.getDouble("LifeExpectancy"),
                        resultSet.getDouble("GNP"),
                        resultSet.getDouble("GNPOld"),
                        resultSet.getString("LocalName"),
                        resultSet.getString("GovernmentForm"),
                        resultSet.getString("HeadOfState"),
                        resultSet.getInt("Capital"),
                        resultSet.getString("Code2")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return country;
    }

    private PreparedStatement setStatementFindByCountryCode(Connection connection, String countryCode) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Country WHERE Code = ?");
        statement.setString(1, countryCode);
        return statement;
    }

    @Override
    public List<Country> findAll() {
        List<Country> countryList = new ArrayList<>();
        try (
                Connection connection = getConnections();
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM Country");
                ResultSet resultSet = statement.executeQuery();
                ){
            while(resultSet.next()){
                countryList.add(
                        new Country(
                                resultSet.getString("Code"),
                                resultSet.getString("Name"),
                                resultSet.getString("Continent"),
                                resultSet.getString("Region"),
                                resultSet.getDouble("SurfaceArea"),
                                resultSet.getInt("IndepYear"),
                                resultSet.getInt("Population"),
                                resultSet.getDouble("LifeExpectancy"),
                                resultSet.getDouble("GNP"),
                                resultSet.getDouble("GNPOld"),
                                resultSet.getString("LocalName"),
                                resultSet.getString("GovernmentForm"),
                                resultSet.getString("HeadOfState"),
                                resultSet.getInt("Capital"),
                                resultSet.getString("Code2")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countryList;
    }

    @Override
    public List<Country> findByName(String name) {
        List<Country> countryList = new ArrayList<>();
        try (
                Connection connection = getConnections();
                PreparedStatement statement = setStatementFindByName(connection, name);
                ResultSet resultSet = statement.executeQuery();
                ){
            while(resultSet.next()){
                countryList.add(new Country(
                        resultSet.getString("Code"),
                        resultSet.getString("Name"),
                        resultSet.getString("Continent"),
                        resultSet.getString("Region"),
                        resultSet.getDouble("SurfaceArea"),
                        resultSet.getInt("IndepYear"),
                        resultSet.getInt("Population"),
                        resultSet.getDouble("LifeExpectancy"),
                        resultSet.getDouble("GNP"),
                        resultSet.getDouble("GNPOld"),
                        resultSet.getString("LocalName"),
                        resultSet.getString("GovernmentForm"),
                        resultSet.getString("HeadOfState"),
                        resultSet.getInt("Capital"),
                        resultSet.getString("Code2")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(countryList.isEmpty()){
            System.out.println("No Country with name: " + name + " exist.");
        }
        return countryList;
    }

    private PreparedStatement setStatementFindByName(Connection connection, String name) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Country WHERE Name = ?");
        statement.setString(1, name);
        return statement;
    }

    @Override
    public List<Country> findByRegion(String region) {
        return null;
    }

    @Override
    public List<Country> findAllInRegion(String region) {
        return null;
    }

    @Override
    public List<Country> findByGovernmentForm(String governmentForm) {
        return null;
    }

    @Override
    public Country findWhoIsTheBoss(String headOfState) {
        return null;
    }

    @Override
    public Country add(Country country) {
        return null;
    }

    @Override
    public Country update(Country country) {
        return null;
    }

    @Override
    public int delete(Country country) {
        return 0;
    }
}

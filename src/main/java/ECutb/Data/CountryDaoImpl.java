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
        List<Country> countryList = new ArrayList<>();
        try (
                Connection connection = getConnections();
                PreparedStatement statement = setStatementFindByRegion(connection, region);
                ResultSet resultSet = statement.executeQuery();
                ){
            while (resultSet.next()){
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
        return countryList;
    }

    private PreparedStatement setStatementFindByRegion(Connection connection, String region) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM country WHERE Region = ?");
        statement.setString(1,region);
        return statement;
    }

    @Override
    public List<Country> findByGovernmentForm(String governmentForm) {
        List<Country> countryList = new ArrayList<>();
        try(
                Connection connection = getConnections();
                PreparedStatement statement = setStatementFindByGovernmentForm(connection, governmentForm);
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
        return countryList;
    }

    private PreparedStatement setStatementFindByGovernmentForm(Connection connection, String governmentForm) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Country WHERE GovernmentForm = ?");
        statement.setString(1, governmentForm);
        return statement;
    }

    @Override
    public List<Country> findByPopulationsBetween(int lowest, int highest) {
        List<Country> countryList = new ArrayList<>();

        try (
                Connection connection = getConnections();
                PreparedStatement statement = setStatementPopulationBetween(connection, lowest, highest);
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
        return countryList;
    }

    private PreparedStatement setStatementPopulationBetween(Connection connection, int lowest, int highest) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Country WHERE Population BETWEEN ? AND ?");
        statement.setInt(1, lowest);
        statement.setInt(2, highest);
        return statement;
    }

    @Override
    public Country add(Country country) {
        ResultSet resultSet = null;
        try (
                Connection connection = getConnections();
                PreparedStatement statement = setStatementAddCountry(connection, country)
                ){

            statement.execute();
            resultSet = statement.getGeneratedKeys();
            while (resultSet.next()){
                country = new Country(
                        resultSet.getString(1),
                        country.getName(),
                        country.getContinent(),
                        country.getRegion(),
                        country.getSurfaceArea(),
                        country.getIndepYear(),
                        country.getPopulation(),
                        country.getLifeExpectancy(),
                        country.getGnp(),
                        country.getGnpOld(),
                        country.getLocalName(),
                        country.getGovernmentForm(),
                        country.getHeadOfState(),
                        country.getCapital(),
                        country.getCountryCode2()
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return country;
    }

    private PreparedStatement setStatementAddCountry(Connection connection, Country country) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO Country(Code, Name, Continent, Region, SurfaceArea, IndepYear, Population, lifeExpectancy, GNP , GNPOld, LocalName, GovernmentForm, HeadOfState, capital, code2)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, country.getCountryCode());
        statement.setString(2, country.getName());
        statement.setString(3, country.getContinent());
        statement.setString(4, country.getRegion());
        statement.setDouble(5, country.getSurfaceArea());
        statement.setInt(6, country.getIndepYear());
        statement.setInt(7, country.getPopulation());
        statement.setDouble(8, country.getLifeExpectancy());
        statement.setDouble(9, country.getGnp());
        statement.setDouble(10, country.getGnpOld());
        statement.setString(11, country.getLocalName());
        statement.setString(12, country.getGovernmentForm());
        statement.setString(13, country.getHeadOfState());
        statement.setInt(14, country.getCapital());
        statement.setString(15, country.getCountryCode2());

        return statement;
    }

    @Override
    public Country update(Country country) {
        try (
                Connection connection = getConnections();
                PreparedStatement statement = connection.prepareStatement("UPDATE Country SET Name = ?, Continent = ?, Region = ?, SurfaceArea = ?, IndepYear = ?, Population = ?, lifeExpectancy = ?, GNP = ?, GNPOld = ?, LocalName = ?, GovernmentForm = ?, HeadOfState = ?, capital = ?, code2 = ? WHERE Code = ?")
                ){
            statement.setString(1, country.getName());
            statement.setString(2, country.getContinent());
            statement.setString(3, country.getRegion());
            statement.setDouble(4, country.getSurfaceArea());
            statement.setInt(5, country.getIndepYear());
            statement.setInt(6, country.getPopulation());
            statement.setDouble(7, country.getLifeExpectancy());
            statement.setDouble(8, country.getGnp());
            statement.setDouble(9, country.getGnpOld());
            statement.setString(10, country.getLocalName());
            statement.setString(11, country.getGovernmentForm());
            statement.setString(12, country.getHeadOfState());
            statement.setInt(13, country.getCapital());
            statement.setString(14, country.getCountryCode2());
            statement.setString(15, country.getCountryCode());

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return country;
    }

    @Override
    public int delete(Country...countries) {
        int deletedCountries = 0;
        try (Connection connection = getConnections();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM Country WHERE Code = ?");
        ){
            for (Country country: countries) {
                statement.setString(1, country.getCountryCode());
                statement.executeUpdate();
                //  Keeps count on deleted Countries.
                ++deletedCountries;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //  Return number of Rows deleted.
        return deletedCountries;
    }
}

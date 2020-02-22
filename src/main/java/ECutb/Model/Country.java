package ECutb.Model;

import java.util.Objects;

public class Country {

    private String countryCode;
    private String Name;
    private String Continent;
    private String region;
    private double surfaceArea;
    private int IndepYear;
    private int population;
    private double lifeExpectancy;
    private double gnp;
    private double gnpOld;
    private String localName;
    private String governmentForm;
    private String headOfState;
    private int capital;
    private String countryCode2;

    public Country(String countryCode, String name, String continent, String region, double surfaceArea, int indepYear, int population, double lifeExpectancy, double gnp, double gnpOld, String localName, String governmentForm, String headOfState, int capital, String countryCode2) {
        setCountryCode(countryCode);
        setName(name);
        setContinent(continent);
        setRegion(region);
        setSurfaceArea(surfaceArea);
        setIndepYear(indepYear);
        setPopulation(population);
        setLifeExpectancy(lifeExpectancy);
        setGnp(gnp);
        setGnpOld(gnpOld);
        setLocalName(localName);
        setGovernmentForm(governmentForm);
        setHeadOfState(headOfState);
        setCapital(capital);
        setCountryCode2(countryCode2);
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getContinent() {
        return Continent;
    }

    public void setContinent(String continent) {
        Continent = continent;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public int getIndepYear() {
        return IndepYear;
    }

    public void setIndepYear(int indepYear) {
        IndepYear = indepYear;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getLifeExpectancy() {
        return lifeExpectancy;
    }

    public void setLifeExpectancy(double lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    public double getGnp() {
        return gnp;
    }

    public void setGnp(double gnp) {
        this.gnp = gnp;
    }

    public double getGnpOld() {
        return gnpOld;
    }

    public void setGnpOld(double gnpOld) {
        this.gnpOld = gnpOld;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public String getGovernmentForm() {
        return governmentForm;
    }

    public void setGovernmentForm(String governmentForm) {
        this.governmentForm = governmentForm;
    }

    public String getHeadOfState() {
        return headOfState;
    }

    public void setHeadOfState(String headOfState) {
        this.headOfState = headOfState;
    }

    public int getCapital() {
        return capital;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }

    public String getCountryCode2() {
        return countryCode2;
    }

    public void setCountryCode2(String countryCode2) {
        this.countryCode2 = countryCode2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Double.compare(country.surfaceArea, surfaceArea) == 0 &&
                IndepYear == country.IndepYear &&
                population == country.population &&
                Double.compare(country.lifeExpectancy, lifeExpectancy) == 0 &&
                Double.compare(country.gnp, gnp) == 0 &&
                Double.compare(country.gnpOld, gnpOld) == 0 &&
                capital == country.capital &&
                Objects.equals(countryCode, country.countryCode) &&
                Objects.equals(Name, country.Name) &&
                Objects.equals(Continent, country.Continent) &&
                Objects.equals(region, country.region) &&
                Objects.equals(localName, country.localName) &&
                Objects.equals(governmentForm, country.governmentForm) &&
                Objects.equals(headOfState, country.headOfState) &&
                Objects.equals(countryCode2, country.countryCode2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryCode, Name, Continent, region, surfaceArea, IndepYear, population, lifeExpectancy, gnp, gnpOld, localName, governmentForm, headOfState, capital, countryCode2);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(" Country: ");
        sb.append("countryCode='").append(countryCode).append('\'');
        sb.append(", Name='").append(Name).append('\'');
        sb.append(", Continent='").append(Continent).append('\'');
        sb.append(", region='").append(region).append('\'');
        sb.append(", surfaceArea=").append(surfaceArea);
        sb.append(", IndepYear=").append(IndepYear);
        sb.append(", Population=").append(population);
        sb.append(", lifeExpectancy=").append(lifeExpectancy);
        sb.append(", gnp=").append(gnp);
        sb.append(", gnpOld=").append(gnpOld);
        sb.append(", localName='").append(localName).append('\'');
        sb.append(", governmentForm='").append(governmentForm).append('\'');
        sb.append(", headOfState='").append(headOfState).append('\'');
        sb.append(", capital=").append(capital);
        sb.append(", countryCode2='").append(countryCode2).append('\'');
        sb.append('\n');
        return sb.toString();
    }
}

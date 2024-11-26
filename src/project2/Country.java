package project2;

/** 
 * The country class converts the countries in the csv file into country objects and
 * calculates their GDPPC, CFR, case rates, death rates, and population density. 
 * 
 * @author <Kenniece Harris> 
 * @version <10/09/2022> 
 */ 
 
public class Country {
	private String name;
	private String capitol;
	private String population;
	private String gdp;
	private String covidCases;
	private String covidDeaths;
	private String area;
	
/** 
* Stores the name, capitol, population, GDP, covid cases, covid deaths and area of a country.
* 
* @param  name, the name of a country.
* @param  captiol, the capitol of a country.
* @param  population, the population of a country.
* @param  gdp, the GDP of a country.
* @param  covidCases, the covid cases of a country.
* @param  covidDeaths, the covid deaths of a country.
* @param  area, the area of a country.
 */
	
	public Country(String name, String capitol, String population, String gdp, String covidCases, String covidDeaths, String area) {
		
		this.name = name;
		this.capitol = capitol;
		this.population = population;
		this.gdp = gdp;
		this.covidCases = covidCases;
		this.covidDeaths = covidDeaths;
		this.area = area;
				
	}
	
/** 
* Stores the name of country to name. 
* 
* @param  name, country name.
 */ 
	public void setName(String name) {
		this.name = name;
	}
	
/** 
* Returns the name of the country as a string.
* @return name, name of the country.
 */ 

	public String getName() {
		return this.name;
	}
	
/** 
* Stores the capitol of the country to capitol.
* 
* @param  capitol, the capitol of the country.
 */ 
	public void setCapitol(String capitol) {
		this.capitol = capitol;
	}
	
/** 
* Returns the capitol of the country.
* 
* @return capitol, the capitol of the country.
 */ 
	public String getCapitol() {
		return this.capitol;
	}
	
/** 
* Stores the population of a country to population.
* 
* @param  population, population of a country.
 */ 
	public void setPopulation(String population) {
		this.population = population;
	}
	
/** 
* Returns the population of a country.
* 
* @return population, population of a country.
 */ 
	public String getPopulation() {
		return this.population;
	}
	
/** 
* Stores the GDP of a country to gdp. 
* 
* @param  gdp, the gdp of a country.
 */ 
	public void setGDP(String gdp) {
		this.gdp = gdp;
	}
	
/** 
* Returns the GDP of a country.
*  
* @return gdp, the gdp of a country.
 */ 
	public String getGDP() {
		return this.gdp;
	}
	
/** 
* Stores the covid cases of a country to covidCases.
* 
* @param  covidCases, the covid cases of a country.
 */ 
	public void setCovidCases(String covidCases) {
		this.covidCases = covidCases;
	}
	
/** 
* Returns the covid cases of a country. 
*  
* @return covidCases, covid cases of a country.
 */ 
	public String getCovidCases() {
		return this.covidCases;
		
	}
	
/** 
* Stores the covid deaths of a country in covidDeaths. 
* 
* @param  covidDeaths, the covid deaths of a country.
 */ 
	public void setCovidDeaths(String covidDeaths) {
		this.covidDeaths = covidDeaths;
	}
	
/** 
* Returns the covid deaths of a country.
*  
* @return covidDeaths, covid deaths of a country.
 */ 
	public String getCovidDeaths() {
		return this.covidDeaths;
	}

/** 
* Stores the area of a country to area.
* 
* @param  area, the area of a country.
 */ 
	public void setArea(String area) {
		this.area = area;
	}
	
/** 
* Returns the area of a country.
* 
* @return area, the area of a country.
 */ 
	public String getArea() {
		return this.area;
	}
	
/** 
* Calculates the GDPPC of a country (GDP/Population). 
*  
* @return GDPPC, the GDDPC of a country.
 */ 
	public double getGDPPC() {
		double GDPPC = Double.parseDouble(getGDP())/ Double.parseDouble(getPopulation());
		
		return GDPPC;
	}
	
/** 
* Calculates the CFR of a country (covid deaths/ covid cases).
* 
* @return description of the return value CFR, the CFR of a country.
 */ 
	public double getCFR() {
		double CFR = Double.parseDouble(getCovidDeaths())/ Double.parseDouble(getCovidCases());;
		
		return CFR;
	}
	
/** 
* Calculates the case rate of a country (100000 * (covid cases/population). 
* 
* @return caseRate, the case rate of a country. 
 */ 
	public double getCaseRate() {
		double caseRate = (100000.0) *Double.parseDouble(getCovidCases())/ Double.parseDouble(getPopulation());
		
		return caseRate;
	}
	
/** 
* Calculates the death rate of a country (100000 * (covid deaths/population). 
* 
* @return deathRate, the death rate of a country. 
 */  
	public double getDeathRate() {
		double deathRate = (100000.0) * Double.parseDouble(getCovidDeaths())/ Double.parseDouble(getPopulation());
		
		return deathRate;
	}
	
/** 
* Calculates the population density of a country (population/area).
* 
* @return popDensity, the population density of a country.
 */ 
	public double getPopDensity() {
		double popDensity = Double.parseDouble(getPopulation())/ Double.parseDouble(getArea());
		
		return popDensity;
	}
	
/** 
* Prints the country object.
* 
* 
* @return countryData, contains the name, capitol, GDPPC, CFR, case rate, death rate, and population density of a country.
 */ 
	public String getCountryData() {
		String countryData;
		
		
		countryData = String.format("%-15s", getName()) +  String.format("%10s", getCapitol()) +  String.format("%15.3f", getGDPPC()) +  String.format("%12.6f", getCFR()) +  String.format("%12.3f", getCaseRate()) +  String.format("%14.3f", getDeathRate()) + String.format("%14.3f", getPopDensity());
		
		
		
		return countryData;
	}
}


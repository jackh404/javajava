import java.lang.reflect.Array;
import java.util.ArrayList;

class City {
	public String name;
	public float latitude;
	public float longitude;
	public int population;
	public City(String name) {
		this.name = name;
	}
}


class CityList {
	ArrayList<City> cities = new ArrayList<City>();

	public void addCity(City c) {
		cities.add(c);
	}

	public ArrayList<City> getCities(){
		return cities;
	}

	public int getTotalPopulation() {
		int total_population = 0;
		for (City c : cities)
			total_population += c.population;
		return total_population;
	}
}

class Map {
	String map_name;
	int height;
	int width;
	CityList cities;

	public Map(String name, int h, int w, CityList cities) {
		this.map_name = name;
		this.height = h;
		this.width = w;
		this.cities = cities;
	}

	public void displayMap() {
		System.out.println("Drawing " + map_name + " with dimensions " + height + " x " + width);
		for (City c : cities.getCities())
			System.out.print(c.name + " --> ");
	}
}

public class SingleResponsibilityPrincipleGood {
    public static void main(String[] args) {
        City c1 = new City("Raleigh");
        City c2 = new City("Durham");

        CityList ct = new CityList();
        ct.addCity(c1);
        ct.addCity(c2);

        Map map = new Map("Triangle Map", 10, 10, ct);
        map.displayMap();
    }
}
package metier;

import java.util.List;

public interface ImetierCatalogue {
	public List<Boisson> getBoissonsParMotCle(String mc);
	public void addBoisson(Boisson b);


}

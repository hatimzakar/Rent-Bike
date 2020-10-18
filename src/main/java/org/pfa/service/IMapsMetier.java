package org.pfa.service;

import java.util.List;

import org.pfa.entities.Position;
import org.pfa.entities.Station;
import org.pfa.entities.Velo;

public interface IMapsMetier {
	
	public void ajouterStation(Station s,Position position);
	public void supprimerStation(long idStation);
	public List<Station> consulterStation();
	public Velo AffichernbrVelosDiponible();

}

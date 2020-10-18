package org.pfa.service;

import java.util.List;

import org.pfa.dao.StationRepository;
import org.pfa.entities.Position;
import org.pfa.entities.Station;
import org.pfa.entities.Velo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional 
@Service 
public class MapsMetierImpl implements IMapsMetier{
	
	@Autowired 
	private StationRepository stationRepository ;
	
	
	@Override
	public void ajouterStation(Station s,Position position) {
		
		if(s!=null && position!= null)
		{	
		
			s.setPosition(position);
			
			stationRepository.save(s);
		}
		
		
	}

	@Override
	public void supprimerStation(long idStation) {
		
		//stationRepository.deleteById(idStation);
		
	}

	@Override
	public List<Station> consulterStation() {
		
		List<Station> s1=  stationRepository.findAll();
		
		
		return s1;
	}

	@Override
	public Velo AffichernbrVelosDiponible() {
		// TODO Auto-generated method stub
		return null;
	}

}

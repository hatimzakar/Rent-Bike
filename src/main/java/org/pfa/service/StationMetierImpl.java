package org.pfa.service;

import java.util.Date;
import java.util.List;

import org.pfa.dao.HistoriqueStationRepository;
import org.pfa.dao.StationRepository;
import org.pfa.dao.VeloRepository;
import org.pfa.entities.HistoriqueStation;
import org.pfa.entities.Station;
import org.pfa.entities.Velo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;


@Service
public class StationMetierImpl implements IStationMetier
{
	@Autowired 
	private StationRepository stationRepository ;
	
	@Autowired
	private VeloRepository veloRep;
	
	@Autowired
	private HistoriqueStationRepository historiqueStationRepo;
	
	@Override
	public void EntrerVelo(int idclient,String Matricule,int idStation) {
		
		HistoriqueStation hs=new HistoriqueStation(idclient,Matricule,new Date(),"Entrante",idStation);
		
		historiqueStationRepo.save(hs);
		
		
		Station c=stationRepository.getOne(idStation);
		
		List<Velo> listVelo=c.getVelo();
		Velo v2=veloRep.findByMatricule(Matricule);
		boolean z=listVelo.add(v2);
		stationRepository.save(c);
		
		
		
	}

	@Override
	public void SortirVelo(int idclient,String MatriculeVelo,int idStation ) {
		
		
		HistoriqueStation hs=new HistoriqueStation(idclient,MatriculeVelo,new Date(),"Sortante",idStation);
		
		historiqueStationRepo.save(hs);
		Station c=stationRepository.getOne(idStation);
		
		List<Velo> listVelo=c.getVelo();
		Velo v2=veloRep.findByMatricule(MatriculeVelo);
		listVelo.remove(v2);
		stationRepository.save(c);
		
	}

	@Override
	public int nbrVeloPresent(int idStation) {
	
		
		Station c=stationRepository.getOne(idStation);
		List<Velo> listVelo=c.getVelo();
		int i =listVelo.size();
		
		return i;
		
	}

	@Override
	public double calculerTempsUtilisation() {
		
		StopWatch stopWatch = new StopWatch("My Stop Watch");
		stopWatch.start();
		
		
		return 0;
	}

	@Override
	public List<HistoriqueStation> AfficherHistorique() {
		
		List<HistoriqueStation>d=historiqueStationRepo.findAll();
		
		return d;
	}
	
	/*
	@Override
	public List<HistoriqueStation> ConsulterHistorique()
	{
		
		List <HistoriqueStation> ListHistorique =historiqueStationRepo.findAll();
		
		return ListHistorique ;
				
	}

	*/
	
	

}

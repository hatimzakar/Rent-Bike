package org.pfa;

import java.util.ArrayList;
import java.util.List;

import org.pfa.dao.AbonnementRepository;
import org.pfa.dao.GerantRepository;
import org.pfa.dao.HistoriqueStationRepository;
import org.pfa.dao.ReclamationRepository;
import org.pfa.dao.StationRepository;
import org.pfa.entities.Reclamation;
import org.pfa.service.ReclamationService;
import org.pfa.service.StationMetierImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LocationVeloApplication implements CommandLineRunner {
	@Autowired
	private GerantRepository gerantRepository;
	@Autowired
	private StationRepository stationRepository;
	@Autowired
	private StationMetierImpl historiqueservice;
	@Autowired
	private HistoriqueStationRepository historiqueRepo;
	@Autowired
	private AbonnementRepository abnRepo;
	@Autowired
	private ReclamationService reclamamtionService;

	@Autowired
	private ReclamationRepository RecRepo;

	public static void main(String[] args) {

		SpringApplication.run(LocationVeloApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		/*
		 * //gerantRepository.save(new
		 * Gerant("Hamza","hamzaoui","hamza@gmail.com","admin","admin"));
		 * //gerantRepository.save(new
		 * Gerant("Ali","alaoui","ali@gmail.com","admin","admin")); List<Gerant> g=
		 * gerantRepository.findAll(); for( Gerant g1: g) {
		 * System.out.print(g1.toString()+"\n"); }
		 * 
		 * Position p=new Position(90,-20); Station st=new
		 * Station("massira","massira 2"); st.setPosition(p);
		 * 
		 * //stationRepository.save(st);
		 * 
		 * List<Station> s1= stationRepository.findAll();
		 * 
		 * List<HistoriqueStation> h=historiqueservice.AfficherHistorique();
		 * 
		 * for(HistoriqueStation o :h) { System.out.print(o+"\n");
		 * 
		 * }
		 * 
		 * //historiqueservice.SortirVelo(2, "30F");
		 * 
		 * List<HistoriqueStation> r1= historiqueRepo.findAll();
		 * 
		 * for(HistoriqueStation s :r1) { System.out.print(s+"\n");
		 * 
		 * }
		 * 
		 * List<Reclamation> l = reclamamtionService.getListId(2);
		 * System.out.println(l);
		 */
		
		  List<Reclamation> l1 = RecRepo.findAll();
		  
		 // System.out.println(l1);
		 
				
			/*
			 * Reclamation r=RecRepo.getOne(1); r.getClient();
			 * System.out.println(r.getClient());
			 */
				
				
				
				  List<Reclamation> l2=new ArrayList<Reclamation>(); 
				  for(Reclamation o: l1) {
				  if(o.getClient().getId()==2)
				  { 
					  l2.add(o);
					  
					  }
				  
				  } 
				  System.out.println(l2);
				 
		/*
		 * Calendar cal = Calendar.getInstance(); Date date=cal.getTime(); DateFormat
		 * dateFormat = new SimpleDateFormat("HH:mm:ss"); String
		 * formattedDate=dateFormat.format(date); System.out.
		 * println("Current time of the day using Calendar - 24 hour format: "+
		 * formattedDate); LocalTime time = LocalTime.now();
		 * System.out.println("Current time of the day: " + time);
		 * 
		 * 
		 * 
		 * 
		 * for(Station s2 :s1) { System.out.print(s2.getPosition());
		 * 
		 * }
		 */

	}

}

package org.pfa.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.pfa.dao.ClientRepository;
import org.pfa.dao.ReclamationRepository;
import org.pfa.entities.Client;
import org.pfa.entities.Reclamation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReclamationService {
	
	@Autowired
	private ReclamationRepository reclamationRepo;
	@Autowired
	private ClientRepository clientRepo;
	
	
	
	public List <Reclamation> ListRaclamation() {
		List <Reclamation> reclamation =reclamationRepo.findAll();
		
		return reclamation ;
		
		
	}
	
	
	
	
	  public List<Reclamation> getListId(int idClient)
	  { 
		  List<Reclamation>r1=reclamationRepo.findAll(); 
		  List<Reclamation>r2=new ArrayList<Reclamation>();
		  for(Reclamation o: r1) {
			  if(o.getClient().getId()==idClient)
			  { 
				 r2.add(o);
				  
				  }
			  
			  } 
		  
	  	
	  return r2; 
	  }
	  
	  public void AjouterReclamamtion(int idClient ,String discription)
	  	{	Client c1= clientRepo.getOne(idClient);
		  	Reclamation r=new Reclamation(discription,new Date(),c1);
		  	reclamationRepo.save(r);
	  	}
	 

}

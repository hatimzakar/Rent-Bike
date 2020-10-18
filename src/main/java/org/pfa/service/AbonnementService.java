package org.pfa.service;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.pfa.dao.AbonnementRepository;
import org.pfa.entities.Abonnement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AbonnementService {
	@Autowired
	private AbonnementRepository abonnementRepo;

	
	
	
	
	public void AjouterAbonnement(Abonnement abn)
	{
		abonnementRepo.save(abn);
		
	}
	
	public void ModifierAbonnement(Abonnement abn)
	{
		abonnementRepo.save(abn);
		
	}
	public void SupprimerAbonnement(int id)
	{
		abonnementRepo.deleteById(id);
		
	}
	
	
	public void FindByID(int id)
	{
		abonnementRepo.findById(id);
		
	}
	
	
	
	
	
	
	public List<Abonnement> listAbonnemnent()
	{
		List<Abonnement> list=abonnementRepo.findAll();
		
		return list;
	}
	
	public boolean ValiderMensuel(long pin)
	{
		Abonnement a1=abonnementRepo.findByPin(pin);
		Date d=a1.getDate();
		long d0=d.getTime();
		Date d2=new Date();
		long d3=d2.getTime();
		d0=d0/1000;
		d3=d3/1000;
		long dif=d3-d0;
		
		if(dif<2592000)
			{
				System.out.println("mensuel true called");
				return true;
			}
		else 
			
			{System.out.println("mensel flse called");
			return false;
			}
	}
	public Boolean validerAnnuel(long pin)
	{
		Abonnement a0=abonnementRepo.findByPin(pin);
		//Abonnement a1=abonnementRepo.getOne(id);
		Date d=a0.getDate();
		long d0=d.getTime();
		Date d2=new Date();
		long d3=d2.getTime();
		d0=d0/1000;
		d3=d3/1000;
		long dif=d0-d3;
		
		if(dif<31536000)
			{
			System.out.println("Annuel true called called");
				return true;
			}
		else 
			{System.out.println("Annuel false called ");
			return false;}
	}
	
	public long GenererPin()
	{
		 Random rnd = new Random();
		 long n = 100000 + rnd.nextInt(900000);
		 return n;
		 
		
			}
	
	
}

package org.pfa.web;



import java.util.List;

import javax.servlet.http.HttpSession;

import org.pfa.entities.Client;
import org.pfa.entities.Gerant;
import org.pfa.entities.HistoriqueStation;
import org.pfa.service.StationMetierImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StationController {
	@Autowired
	private StationMetierImpl stationService ;
	
	
	@RequestMapping("/Station1")
	public String getStation1(Model model ,Model model2,HttpSession x)
	{	
		if(x.getAttribute("session2")==null) 
		{
			return "login_v2.html";
			
		}
		
		Gerant GerantSession=(Gerant)x.getAttribute("session2");
		model2.addAttribute("userLive",GerantSession);
		
		
		List <HistoriqueStation> h=stationService.AfficherHistorique();
		 model.addAttribute("listHistorique", h);
		 	int r=1;
			int s=stationService.nbrVeloPresent(r);
			
			model2.addAttribute("nbr", s);
		return  "Station1.html";
		
	}
	
	@RequestMapping("/Station2")
	public String getStation2(Model model ,Model model2,HttpSession x)
	{	
		
		if(x.getAttribute("session2")==null) 
		{
			return "login_v2.html";
			
		}
		
		
		Gerant GerantSession=(Gerant)x.getAttribute("session2");
		model2.addAttribute("userLive",GerantSession);
		
		 List <HistoriqueStation> h=stationService.AfficherHistorique();
		 model.addAttribute("listHistorique", h);
		 	int r=2;
			int s=stationService.nbrVeloPresent(r);
			
			model2.addAttribute("nbr", s);
		return  "Station2.html";
		
	}
	
	
	
	
	
	@RequestMapping("/Station3")
	public String getStation3(Model model ,Model model2,Model model3, HttpSession x)
	{		
		if(x.getAttribute("session2")==null) 
		{
			return "login_v2.html";
			
		}
		
		
		Gerant GerantSession=(Gerant)x.getAttribute("session2");
	model3.addAttribute("userLive",GerantSession);
	
		
		 List <HistoriqueStation> h=stationService.AfficherHistorique();
		 model.addAttribute("listHistorique", h);
		 	int r=3;
			int s=stationService.nbrVeloPresent(r);
			
			model2.addAttribute("nbr", s);
		return  "Station3.html";
		
	}
	
	
	
	
	
	
	
	

	@RequestMapping("/EntrerVelo")
	public String EntrerVelo(Model model,Model model2,@RequestParam int idClient,@RequestParam(name = "matriculeVelo") String matriculeVelo,@RequestParam int idStation,HttpSession x,Model model3)
	{	
		if(x.getAttribute("session2")==null) 
		{
			return "login_v2.html";
			
		}
		
		Gerant GerantSession=(Gerant)x.getAttribute("session2");
		model3.addAttribute("userLive",GerantSession);
		
		
		try {
			stationService.EntrerVelo(idClient, matriculeVelo,idStation);
			 List <HistoriqueStation> h=stationService.AfficherHistorique();
			 model.addAttribute("listHistorique", h);
			 
				int s=stationService.nbrVeloPresent(idStation);
				
				model2.addAttribute("nbr", s);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			model.addAttribute("Exception", true);
		}
		
		 return  "Station"+idStation+".html";
	}
	
	
	
	
	
	
	@RequestMapping("/SortirVelo")
	public String SortirVelo(Model model3, HttpSession x,Model model,Model model2,@RequestParam int idClient,@RequestParam(name = "matriculeVelo") String matriculeVelo,@RequestParam int idStation)
	{
		if(x.getAttribute("session2")==null) 
		{
			return "login_v2.html";
			
		}
		
		Gerant GerantSession=(Gerant)x.getAttribute("session2");
		model3.addAttribute("userLive",GerantSession);
		
		int s;
		try {
			stationService.SortirVelo(idClient, matriculeVelo,idStation);
			 List <HistoriqueStation> h=stationService.AfficherHistorique();
			 model.addAttribute("listHistorique", h);
			
				s = stationService.nbrVeloPresent(idStation);
				model2.addAttribute("nbr", s);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			model.addAttribute("Exception", true);
		}
			
			
	
	
		
			 return  "Station"+idStation+".html";
	}
	
	
	

}

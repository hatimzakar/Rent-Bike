package org.pfa.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.pfa.entities.Client;
import org.pfa.entities.Gerant;
import org.pfa.entities.Reclamation;
import org.pfa.service.ReclamationService;
import org.pfa.service.StationMetierImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReclamationController {
	
	@Autowired 
	private ReclamationService reclamationService;
	
	@Autowired
	private StationMetierImpl stationService;
	
	
	
	
	@RequestMapping("/listReclamation")
	public String getReclamationAdmin(Model model,Model model2,HttpSession x)
	{	
		if(x.getAttribute("session2")==null) 
		{
			return "login_v2.html";
			
		}
		
		
		Gerant GerantSession=(Gerant)x.getAttribute("session2");
		model2.addAttribute("userLive",GerantSession);
	
		
		
		List<Reclamation> l=reclamationService.ListRaclamation();
		
		
		model.addAttribute("listReclamation", l);
		return "Reclamation.html";
	}
	
	
	
	  @RequestMapping("/ListReclamamtionClient")
	  public String getListReclamamtionclient(Model model, Model model2,HttpSession x ) 
	   { 	 
		  if(x.getAttribute("session1")==null) 
			{
				return "login_v2.html";
				
			}
		  
		  Client ClientSession=(Client)x.getAttribute("session1");
	  			model2.addAttribute("userLive",ClientSession);
		  
		  List <Reclamation> l=reclamationService.getListId(ClientSession.getId()); 
	  		
	  			System.out.println("Controller "+l);
	  			model.addAttribute("listReclamation",l);
	  	return "ReclamationClient.html";
	  
	  }
	 
	
	
	@RequestMapping("/PageNvReclamation")
		public String getListReclamation(Model model2,HttpSession x)
		{ 
		if(x.getAttribute("session1")==null) 
		{
			return "login_v2.html";
			
		}
		
		
		Client ClientSession=(Client)x.getAttribute("session1");
			model2.addAttribute("userLive",ClientSession);
			
			return "formulaireReclamation.html";
		}
	
		@RequestMapping("/nvReclamation")
		public String nvReclamation(Model model ,Model model2,String description,HttpSession x)
		{	
			if(x.getAttribute("session1")==null) 
			{
				return "login_v2.html";
				
			}
			
			
			 try {
				Client ClientSession=(Client)x.getAttribute("session1");
					model2.addAttribute("userLive",ClientSession);
				
					reclamationService.AjouterReclamamtion(ClientSession.getId(), description);
			} catch (Exception e) {
				
				
				model.addAttribute("Exception", true);
			}
			
				
				return "formulaireReclamation";
		}
	

}

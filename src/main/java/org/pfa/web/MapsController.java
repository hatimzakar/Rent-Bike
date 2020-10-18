package org.pfa.web;

import javax.servlet.http.HttpSession;

import org.pfa.entities.Client;
import org.pfa.entities.Gerant;
import org.pfa.service.MapsMetierImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MapsController 
{
	@Autowired
	private MapsMetierImpl mapMetier;
	
	
	@RequestMapping("/Maps")
	public String DisplayMarkers(Model model ,Model model2,HttpSession x)
	{
		if(x.getAttribute("session2")==null) 
		{
			return "login_v2.html";
			
		}
		
		Gerant GerantSession=(Gerant)x.getAttribute("session2");
		model2.addAttribute("userLive",GerantSession);
		
		
		return  "google_map.html";
	}
	
	@RequestMapping("/MapsClient")
	public String DisplayMarkersClient(Model model ,Model model2,HttpSession x)
	{			
		if(x.getAttribute("session1")==null) 
	{
				return "login_v2.html";
		
	}
		
		Client ClientSession=(Client)x.getAttribute("session1");
			model2.addAttribute("userLive",ClientSession);
		
		return  "google_map_Cient.html";
	}
	

	
	
}

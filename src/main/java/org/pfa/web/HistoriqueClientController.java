package org.pfa.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.pfa.dao.HistoriqueStationRepository;
import org.pfa.entities.Client;
import org.pfa.entities.HistoriqueStation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HistoriqueClientController {

	@Autowired
	private HistoriqueStationRepository repoHis;
	
	
	
	@RequestMapping("/HistoriqueClient")
	public String HistoriqueClient(Model model ,Model model2, HttpSession s)
	{	
		if(s.getAttribute("session1")==null) 
		{
			return "login_v2.html";
			
		}
		
		Client ClientSession=(Client)s.getAttribute("session1");
		List<HistoriqueStation> list1=repoHis.findAll();
		List<HistoriqueStation> list2=new ArrayList<HistoriqueStation>();
		model2.addAttribute("userLive", ClientSession);
		for(HistoriqueStation o:list1)
		{
			if(o.getId()==ClientSession.getId())
			{
				list2.add(o);
			}
			
		}
		
		model.addAttribute("historiqueclient", list2);
		
		return "HistoriqueClient.html";
		
	}
	
}

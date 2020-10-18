package org.pfa.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.pfa.dao.AbonnementRepository;
import org.pfa.dao.ClientRepository;
import org.pfa.dao.GerantRepository;
import org.pfa.entities.Abonnement;
import org.pfa.entities.Client;
import org.pfa.entities.Gerant;
import org.pfa.service.StationMetierImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GerantController {
	@Autowired
	private GerantRepository gerantRepository;
	
	@Autowired
	private StationMetierImpl stationService ;
	@Autowired
	private AbonnementRepository  abn;
	
	@Autowired
	private ClientRepository  cl;
	
	
	
	

	
	
	
	
	
	
	
	@RequestMapping("/")
	public String racine(Model model,Model model2,Model model3,Model model4)
	{
		
		return "login_v2.html";
		
	}
	
	@RequestMapping("/Acceuil")
	public String Acceuil(Model model,Model model2,Model model3,Model model4,Model model5 ,HttpSession x)
	{
		if (x.getAttribute("session1") == null) {
			return "login_v2.html";

		}

		Client ClientSession = (Client) x.getAttribute("session1");
		model5.addAttribute("userLive", ClientSession);
		
		
		
		List<Abonnement> a1=abn.findAll();
		
		
		
		int s=stationService.nbrVeloPresent(1);
		int r=stationService.nbrVeloPresent(2);
		int t=stationService.nbrVeloPresent(3);
		
		model.addAttribute("s1", s);
		model2.addAttribute("s2", r);
		model3.addAttribute("s3", t);
		model4.addAttribute("abn",a1.size()+1);
		
		return "Acceuil.html";
		
	}
	
	
	@RequestMapping("/AcceuilAdmin")
	public String AcceuilAdmin(Model model,Model model2,Model model3,Model model4,Model model5,HttpSession x)
	{
		

		if (x.getAttribute("session2") == null) 
		{
			return "login_v2.html";

		}

		Gerant GerantSession = (Gerant) x.getAttribute("session2");
		model5.addAttribute("userLive", GerantSession);
		
		
		List<Abonnement> a1=abn.findAll();
		
		
		
		int s=stationService.nbrVeloPresent(1);
		int r=stationService.nbrVeloPresent(2);
		int t=stationService.nbrVeloPresent(3);
		
		model.addAttribute("s1", s);
		model2.addAttribute("s2", r);
		model3.addAttribute("s3", t);
		model4.addAttribute("abn",a1.size()+1);
		
		return "AcceuilAdmin.html";
		
	}
	
	
	
	
	@RequestMapping("/logout")
	public String logout(Model model,HttpSession x)
	{
		
		x.removeAttribute("session1");
		x.removeAttribute("session2");
		
		
		
		return "login_v2.html";
		
	}
	
	
	@RequestMapping("/register")
	public String register(Model model,String username,String password,String email,String nom,String prenom)
	{
				
		
		Client client1=new Client(nom,prenom,email,username,password);
			cl.save(client1);
		
			return "login_v2.html";
	}
	
	
	
	
	
	@RequestMapping("/login")
	public String login(Model model,HttpSession x)
	{
	
		
		
		return "login_v2.html";
		
	}
	
	
	
}

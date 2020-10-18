package org.pfa.web;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.pfa.dao.ClientRepository;
import org.pfa.dao.PaymentRepository;
import org.pfa.entities.Abonnement;
import org.pfa.entities.Client;
import org.pfa.entities.Gerant;
import org.pfa.entities.Payment;
import org.pfa.service.AbonnementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AbonnementController {
	@Autowired
	private AbonnementService abnService;
	@Autowired
	private PaymentRepository pym;
	@Autowired
	private ClientRepository clRepo;

	@RequestMapping("/ListAbn")
	public String getListAbonnement(Model model,Model model2,HttpSession x) {
		
		if(x.getAttribute("session2")==null) 
		{
			return "login_v2.html";
			
		}
		
		Gerant GerantSession=(Gerant)x.getAttribute("session2");
		model2.addAttribute("userLive",GerantSession);
		
		
		List<Abonnement> listAbn = abnService.listAbonnemnent();
		model.addAttribute("listAbn", listAbn);
		return "AbonnementAdmin.html";

	}

	@RequestMapping("/PageSabonner")
	public String GetAjouterabonnement(Model model ,HttpSession x) {
		if(x.getAttribute("session1")==null) 
		{
			return "login_v2.html";
			
		}	
		
		Client ClientSession=(Client)x.getAttribute("session1");
		model.addAttribute("userLive",ClientSession);
			
		return "sabonner.html";
	}

	@RequestMapping("/AjouterAbn")
	public String AjouterAbonnement(Model model3,Model model,Model model2, String reference, int type,HttpSession x) {
		if(x.getAttribute("session1")==null) 
		{
			return "login_v2.html";
			
		}
		
		Client ClientSession=(Client)x.getAttribute("session1");
			model2.addAttribute("userLive",ClientSession);
			int idClient=ClientSession.getId(); 
		
		try {
			Payment p1 = pym.findByReference(reference);
			Client c0 = clRepo.getOne(idClient);
			System.out.println(idClient);
			System.out.println(reference);
			System.out.println(type);
			System.out.println("avant verification");
			System.out.println(p1.getClient().getId());
			System.out.println(p1.getReference());
			System.out.println(p1.getStatus());

			
			  if((idClient==p1.getClient().getId())&&(p1.getReference().equals(reference)&&
			  (p1.getStatus()==true)))
			  
			  { System.out.println("condition 1 verfier"); 
			  if(type==1)
				
			  { 
				  System.out.println("condition 2 verfier"); 
				  Client c1=clRepo.getOne(idClient);
				  Abonnement a1=new Abonnement(500, "Mensuel", new Date(),c1); 
				  a1.setPin(abnService.GenererPin());
				  abnService.AjouterAbonnement(a1); }
			  
			  
			  else if(type==2)
			  {
				  Client c1=clRepo.getOne(idClient);
				  Abonnement a1=new Abonnement(300, "Annuel", new Date(),c1); 
				  a1.setPin(abnService.GenererPin());
				  abnService.AjouterAbonnement(a1);
			  }
			  
			  }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			model.addAttribute("Exception", true);
		}
		 

		List<Abonnement> listAbn = abnService.listAbonnemnent();
		model.addAttribute("listAbn", listAbn);
		return "sabonner.html";

	}

	@RequestMapping("/SupprimerAbn")
	public String SupprimerAbonnement(Model model, int id) {
		abnService.SupprimerAbonnement(id);
		List<Abonnement> listAbn = abnService.listAbonnemnent();
		model.addAttribute("listAbn", listAbn);
		return "AbonnementAdmin.html";

	}

	@RequestMapping("/ValiderPin")	
	public String ValiderPin(Model model3,Model model, Model model2, long pin, int type,HttpSession x) {
			
		
		
		if(x.getAttribute("session2")==null) 
		{
			return "login_v2.html";
			
		}
		Gerant GerantSession=(Gerant)x.getAttribute("session2");
		model2.addAttribute("userLive",GerantSession);
		
		
			try {
				if (type == 1) {
					if (abnService.ValiderMensuel(pin) == true) {
						System.out.println("type 1 called");
						model.addAttribute("validation", true);

					}

					else {
						System.out.println("type 1 called");
						model.addAttribute("validation", false);
					}

				}

				else if (type == 2) {

					if (abnService.validerAnnuel(pin) == true) {
						System.out.println("type 2 true  called ");
						model.addAttribute("validation", true);
						// System.out.println(abnService.validerAnnuel(pin));
					}

					else {
						System.out.println("type 2  false called");
						model.addAttribute("validation", false);
					}

				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				
				
				
				
				
				model.addAttribute("Exception", true);
			
				
				
			}
		
		List<Abonnement> listAbn = abnService.listAbonnemnent();
		model2.addAttribute("listAbn", listAbn);
		return "AbonnementAdmin.html";

	}

}

package org.pfa.security;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.pfa.dao.ClientRepository;
import org.pfa.dao.GerantRepository;
import org.pfa.entities.Client;
import org.pfa.entities.Gerant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class Authentification {
	@Autowired
	public GerantRepository gerant;
	@Autowired
	public ClientRepository client;

	
	
	
	@PostMapping("/auth")
	public RedirectView Authentification(Model model ,String username,String password,HttpSession s)
	{
			List<Client>c1 =client.findAll();
			List<Gerant>g1 =gerant.findAll();
			int i=1;
			int j=1;
			for(Client c:c1)
			{
				
				if(c.getUsername().contentEquals(username) && c.getPassword().equals(password))
				{	
					s.setAttribute("session1",c );
					return new RedirectView("/Acceuil");
					
				}

			}
			
			
			
			
			  for(Gerant g:g1) { 
			if(g.getUsername().equals(username)&& g.getPassword().equals(password))
			  { 	
					s.setAttribute("session2",g );
				return new RedirectView("/AcceuilAdmin"); 
			  												}
			  						}
			 
		
			return new RedirectView("/login");
	}

}

package org.pfa.security;

import java.util.List;

import org.pfa.dao.ClientRepository;
import org.pfa.dao.GerantRepository;
import org.pfa.entities.Gerant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AuthentificationService {
	@Autowired
	public GerantRepository gerant;
	@Autowired
	public ClientRepository client;
	
	
	/*
	 * public boolean AuthentificationGerant(String username,String password) {
	 * List<Gerant >g=gerant.findAll();
	 * 
	 * for(Gerant g1:g) {
	 * 
	 * if(g1.)
	 * 
	 * } return true; }
	 */

}

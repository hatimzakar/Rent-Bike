package org.pfa.service;

import java.util.List;

import org.pfa.entities.Reclamation;

public interface IReclamation {
	
	public List<Reclamation> getListRaclamation();

	public List<Reclamation> getListId(int idClient);

}

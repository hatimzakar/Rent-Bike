package org.pfa.service;

import java.util.List;

import org.pfa.entities.HistoriqueStation;

public interface IStationMetier {
	
	public void EntrerVelo(int idclient,String Matricule,int idStation); 
	public void SortirVelo(int idclient ,String Matricule,int idstation);
	public int nbrVeloPresent(int idStation);
	public double calculerTempsUtilisation();
	public List<HistoriqueStation> AfficherHistorique();
	
}

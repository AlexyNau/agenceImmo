package fr.adaming.service;

import fr.adaming.model.Conseiller;

public interface IConseillerService {

	public Conseiller isExist(String mail, String mdp);
}

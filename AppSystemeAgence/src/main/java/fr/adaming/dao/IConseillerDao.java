package fr.adaming.dao;

import fr.adaming.model.Conseiller;

public interface IConseillerDao {

	public Conseiller isExist(String mail,String mdp);
}

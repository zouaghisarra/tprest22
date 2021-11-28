package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Animal;

public class AnimalRep {
	//private EntityManager em;
	
	private EntityManager em = null;
	private EntityManagerFactory emf;

	public EntityManager getEm() {
		if (em == null) {
			emf = Persistence.createEntityManagerFactory("tprest2");
			em = emf.createEntityManager();
		}
		return em;
	}
	/*public EntityManager getEm() {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("tprest2");
		em=emf.createEntityManager();
		return em;
	}*/

	public  Animal ajout(Animal a) {
		//int res=0;
		getEm().getTransaction().begin();
		getEm().persist(a);
		getEm().getTransaction().commit();
		/*if(cherchera(a.getId())!= null)
			res=1;*/
			
		return a;
	}
	public List<Animal> cherchertout(){
		Query query=getEm().createNamedQuery("Animal.findAll");
		return   query.getResultList();
		
	}
	public boolean supprimer(Animal a)
	{ 
		Animal animal=getEm().find(Animal.class,a.getId());
		
		if (animal==null)
			return false;
		else {

   
		getEm().getTransaction().begin();
		Animal a1=getEm().merge(a);
		getEm().remove(a1);
		getEm().getTransaction().commit();
		
			return true;}
		
		 
		
		
	}
	public Animal modifier(Animal a){
		//int res;
		
	
		/*if(article==null)
			res=0;
		else {*/
			getEm().getTransaction().begin();
			getEm().merge(a);
			getEm().getTransaction().commit();
			/*res=1;
		}
		*/
			Animal animal=getEm().find(Animal.class,a.getId());
		return animal;
	
	}
	public Animal cherchera(String id){
		Animal animal=getEm().find(Animal.class,id);
		return animal;


	}

	
	
	

}

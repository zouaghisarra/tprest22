package service;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import model.Animal;
import repository.AnimalRep;

@Path("/animals")
public class CrudAnimal {
	AnimalRep rep=new AnimalRep();
	
	@POST
	@Path("/ajoutanimal")
	@Consumes({MediaType.APPLICATION_XML})
	public Animal insert(Animal a) {
		Animal x = rep.ajout(a);
		return x;
	}
	
	@GET
	@Path("/cherchera")
	@Produces({MediaType.APPLICATION_JSON})
	public Animal search(@QueryParam("id") String id) {
		return rep.cherchera(id);
	}
	
	@GET
	@Path("/chercherall")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Animal> searchAll() {
		return rep.cherchertout();
	}
	
	@POST
	@Path("/modification")
	@Consumes({MediaType.APPLICATION_JSON})
	public Animal edit(Animal a1) {
		Animal a=rep.modifier(a1);
		return a;
	}
	
	@DELETE
	@Path("/supprimeranimal")
	@Consumes({MediaType.APPLICATION_XML})
	public String delete1(Animal a) {
		
		 if (rep.supprimer(a) == true ) {
		        return "suppresion effectuée" ;

	    		
	    	}
	    	else {
		        return "suppresion non effectuée" ;

	    	}
	    
		 
		 
	}
	
	
	

	
	

}

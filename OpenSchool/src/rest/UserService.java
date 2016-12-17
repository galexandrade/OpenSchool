package rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.UserDAO;
import model.User;

@Path("/user")
public class UserService {
	private static final String CHARSET_UTF8 = ";charset=utf-8";
	
	@GET
	@Path("/{id}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(@PathParam("id") int idUser){
		
		User user = null;
		try{
			user = UserDAO.getInstance().getUser(idUser);
		}catch(Exception e){
			e.printStackTrace();
		}
		return user;
	}
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> listUsers(){
		
		List<User> list = null;
		try{
			list = UserDAO.getInstance().listUsers();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteUser(@PathParam("id") int idUser){
		String result;
		
		try{
			UserDAO.getInstance().deleteUser(idUser);
			result = "OK";
		}catch(Exception e){
			e.printStackTrace();
			result = "ERROR";
		}
		return result;
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	@Produces(MediaType.TEXT_PLAIN)
	public String addUser(User user){
		String result;
		
		try{
			UserDAO.getInstance().addUser(user);
			result = "OK";
		}catch(Exception e){
			e.printStackTrace();
			result = "ERROR";
		}
		
		return result;
	}
	
	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateUser(User user){
		String result;
		
		try{
			UserDAO.getInstance().updateUser(user);
			result = "OK";
		}catch(Exception e){
			e.printStackTrace();
			result = "ERROR";
		}
		
		return result;
	}
}

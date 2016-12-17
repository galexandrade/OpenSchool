package rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.UserDAO;
import model.User;

@Path("/user")
public class UserService {
	private static final String CHARSET_UTF8 = ";charset=utf-8";
	
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
}

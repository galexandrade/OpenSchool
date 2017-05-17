package rest;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dao.UserDAO;
import exception.AppException;
import model.User;
import rest.util.AppRest;
import security.JWTService;

@Path("account")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PublicAccountRest extends AppRest {
	
	@Path("authenticate")
	@POST
	public Response authenticate(User user) throws AppException {
		JWTService jwtService = new JWTService();
		user = UserDAO.getInstance().authenticateUser(user.getUserName(), user.getPassword());
		return super.buildSaveResponse(jwtService.encodeToken(user));
	}
}

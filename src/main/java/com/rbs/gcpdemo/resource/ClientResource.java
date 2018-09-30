package com.rbs.gcpdemo.resource;


import com.rbs.gcpdemo.PersistenceHelper;
import com.rbs.gcpdemo.entity.Client;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.net.InetAddress;
import java.net.UnknownHostException;


@Path("/client")
@Produces("application/json")
@Consumes("application/json")
public class ClientResource {

	@Inject
	PersistenceHelper helper;

	@GET
	public Response test() throws UnknownHostException {
		return Response.ok().build();
	}

	@POST
	@Transactional
	public Client register(Client client) throws UnknownHostException {
		client.setSegmentId(Math.round(Math.random()*100));
		 helper.getEntityManager().persist(client);
		 return client;
	}
}

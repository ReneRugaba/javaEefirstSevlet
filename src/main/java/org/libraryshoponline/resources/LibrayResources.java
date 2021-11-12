package org.libraryshoponline.resources;

import org.libraryshoponline.library.dto.Book;
import org.libraryshoponline.library.dto.Library;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/library")
public class LibrayResources {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/listbooks")
    public Response getListBooks(){
        return Response.status(Response.Status.OK).entity(Library.books).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/listbooks")
    public Response PostBookInList(@FormParam("title") final String title, @FormParam("dateAjout") final String dateAjout,
                                   @FormParam("description") final String description, final @FormParam("prix") Float amount){
        Book book = new Book(){{
            setTitle(title);
            setDateAjout(dateAjout);
            setDescription(description);
            setAmount(amount);
        }};
        (new Library()).addBookLibrary(book);

        return Response.status(Response.Status.CREATED).entity(book).build();


    }

    @GET
    @Path("/listbooks/{index}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOneinListBooks(@PathParam("index") int index){
        return Response.status(Response.Status.OK).entity((new Library()).getBookInList(index)).build();
    }

    @PUT
    @Path("/listbooks/{index}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateBookInList(@PathParam("index") final int index, @FormParam("title") final String title, @FormParam("dateAjout") final String dateAjout,
                                     @FormParam("description") final String description, @FormParam("prix") final Float amount){
        Book newBook = new Book(){{
            setTitle(title);
            setDescription(description);
            setDateAjout(dateAjout);
            setAmount(amount);
            setId(index);
        }};
        return Response.status(Response.Status.OK).entity(((new Library()).update(index,newBook)).getId()).build();
    }

    @DELETE
    @Path("/listbooks/{index}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeBookInList(@PathParam("index") int index){
        return Response.status(Response.Status.OK).entity((new Library()).removeBookInList(index)).build();
    }
}

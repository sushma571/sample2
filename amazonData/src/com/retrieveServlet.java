package com;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@SuppressWarnings("serial")
public class retrieveServlet extends HttpServlet {
	  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
	    resp.setContentType("text/html");
	      
	    
	    PersistenceManager pm = PMF.get().getPersistenceManager();
	    javax.jdo.Query query = pm.newQuery(NewsItem.class);
	    Long res = query.deletePersistentAll();
	    String query2 = "select from " + NewsItem.class.getName();
	    @SuppressWarnings("unchecked")
		List<NewsItem> newsitems = (List<NewsItem>) pm.newQuery(query2).execute();
	    List<String> list=new ArrayList<String>();
	    
	    
	    // Loop through current news items and broadcast to clients
	    int j=0;
	    for (NewsItem k : newsitems) {
	      j++;
	      if (k.getTitle() != null && k.getLink() != null ){
	        String description = null;
	        if (k.getDescription() != null){
	          description =  k.getDescription().getValue();
	          list.add(k.getTitle().toString());
	        }
	      }
	    }
	    for(int a=0;a<list.size();a++)
	    {
	    	 System.out.println(list.get(a));	
	    }
	  
	   resp.getWriter().println(list.toString());
	 

	   

	  }
	  
	 
}


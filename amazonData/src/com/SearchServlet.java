package com;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@SuppressWarnings("serial")
public class SearchServlet extends HttpServlet {
	
	
	 public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
	      process(req, resp);
	    }

	    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
	      process(req, resp);
	    }

	
	
	
	  public void process(HttpServletRequest req, HttpServletResponse resp) throws IOException {
	    resp.setContentType("text/html");
	     String searchTitle= req.getParameter("keyword");
	     
	     System.out.println("searchTitle"+searchTitle);
	    
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
	          String str=k.getTitle().toString();
	          
	          System.out.println("Before function...."+str);
	          System.out.println("searchTitle  before........."+searchTitle);
	          if(searchTitle.contains(str))
	        		  {
	        	 System.out.println("the value of k......."+k);
	        	  resp.getWriter().println("<div class=\"thumbnail\"   >");
	        	  if (k.getDescription().getValue() != null){
	      	        resp.getWriter().println( k.getDescription().getValue());        
	      	      }
	      	      
	      	      resp.getWriter().println(
	      	          "<a  href=\"" + k.getTitle().toString() +   "\">");
	      	      
	      	      resp.getWriter().println("<font color='blue'>");
	      	      resp.getWriter().println("shop on amazon");
	      	      resp.getWriter().println("</font>");
	      	      resp.getWriter().println("</a>");

	      	      resp.getWriter().println("<br/><br/>");
	      	      resp.getWriter().println("</div>");    
	      	  
	      	   
	        	 
	        	 
	         }
	          else{
	        	  System.out.println("No match found");
	         }
	        }
	      }
	    }
	  
	     
	    
	 

	   

	  }
	  
	 
}


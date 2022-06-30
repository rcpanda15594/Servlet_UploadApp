package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadException;
import javazoom.upload.UploadFile;

public class UploadServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter pw=null;
		UploadBean bean=null;
		MultipartFormDataRequest nreq=null;
		Hashtable ht=null;
		Enumeration e=null;
		
		
		pw=res.getWriter();
		res.setContentType("text/html");
		
	
		try {
			
			nreq=new MultipartFormDataRequest(req);
			bean=new UploadBean();
			bean.setFolderstore("f:/store");
			bean.setOverwrite(false);
			bean.store(nreq);
			
			
			pw.println("<h2>The Uploaded files are</h2>");
			
			ht=nreq.getFiles();
			e=ht.elements();
			
			
			while(e.hasMoreElements()) {
				
				UploadFile file=(UploadFile)e.nextElement();
				pw.println("<br>"+file.getFileName()+"  "+file.getFileSize());
				
			}//while
			}//try
	
	 
		catch (Exception es) {
		
			es.printStackTrace();
		}
		
		
	}//doget
	
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}
}//class

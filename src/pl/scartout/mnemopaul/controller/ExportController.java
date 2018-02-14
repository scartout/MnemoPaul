package pl.scartout.mnemopaul.controller;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.scartout.mnemopaul.model.User;
import pl.scartout.mnemopaul.model.Word;
import pl.scartout.mnemopaul.service.WordService;
 
@WebServlet("/exporttofile")
public class ExportController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private static final String EXPORT_FOLDER = System.getProperty("user.home") + "/Desktop/";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        doPost(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	User loggedUser = (User) request.getSession().getAttribute("user");
        long user_id  = loggedUser.getUser_id();
        request.setAttribute("user", user_id);
        String deck = request.getParameter("deck");
        if (deck.equals("null")) exportWords(request, user_id);
        else exportWordsByDeck(request, user_id, deck);
        response.sendRedirect(request.getContextPath() + "/export");
    }
    
    private void exportWords(HttpServletRequest request, long user_id) throws FileNotFoundException {
        WordService wordService = new WordService();
        List<Word> allWords = wordService.getAllWordExport(user_id);
        
	    OutputStream output = new FileOutputStream(EXPORT_FOLDER+"words.txt");
	
	    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output, StandardCharsets.UTF_8));
	    
    	try {
    		for(int i=0; i<allWords.size(); i++){	
			writer.write(allWords.get(i).getCard_pl()+";");
			writer.write(allWords.get(i).getCard_en()+";\n");
			writer.newLine();
    	}
    		writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    
    }
    
    private void exportWordsByDeck(HttpServletRequest request, long user_id, String deck) throws FileNotFoundException {
        WordService wordService = new WordService();
        List<Word> allWords = wordService.getAllWordExportByDeck(user_id, deck);
        
	    OutputStream output = new FileOutputStream(EXPORT_FOLDER+"words-"+deck+".txt");
	
	    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output, StandardCharsets.UTF_8));
	    
    	try {
    		for(int i=0; i<allWords.size(); i++){	
			writer.write(allWords.get(i).getCard_pl()+";");
			writer.write(allWords.get(i).getCard_en()+";\n");
			writer.newLine();
    	}
    		writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

    }
    
}
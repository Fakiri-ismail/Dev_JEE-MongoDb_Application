package Metier;

import java.sql.SQLException;
import java.util.ArrayList;

import Dao.ServiceDAO;

public class ServiceMetier {
	private static ArrayList<new_user> listNews ; 
	private static ArrayList<user_reaction> listReactions ; 
    
	public ServiceMetier ()  {
	}
	
	public static ArrayList<new_user> getListNews() {
		return ServiceDAO.getAllNews();
	}
	public static void setListNews(ArrayList<new_user> listNews) {
		ServiceMetier.listNews = listNews;
	}
	public static ArrayList<user_reaction> getListReactions() {
		return ServiceDAO.getAllReactions();
	}
	public static void setListReactions(ArrayList<user_reaction> listReactions) {
		ServiceMetier.listReactions = listReactions;
	}

	// Methodes metiers
	public static user getUserByEmail(String email) {
			for(user user:ServiceDAO.getAllUser()) {
				if (user.getEmail().equals(email)) return user;
			}
			return null;
	}
	public static user getUser(String email, String motPasse) {
			for(user user:ServiceDAO.getAllUser()) {
				if (user.getEmail().equals(email) && user.getMotPasse().equals(motPasse)) return user;
			}
			return null;
	}
	public static new_user getNewsByUrl(String url) {
		for(new_user news:ServiceDAO.getAllNews()) {
			if (news.getNews().getUrl().equals(url)	) return news;
		}
		return null;
	}
	public static ArrayList<String> getAllUrl() {
		ArrayList<String> urls= new ArrayList<String>();
		for(new_user news:ServiceDAO.getAllNews()) {
			urls.add(news.getNews().getUrl());
		}
		return urls;
	}
	
	public static boolean addNews(new_user news) throws NewsExistant, SQLException {
		if ( getNewsByUrl(news.getNews().getUrl())!= null) throw new NewsExistant("News exixt d�ja");
		ServiceDAO.AddNews(news);
		return true;
	}
	public static boolean addReaction(user_reaction reaction) throws SQLException {
		for(user_reaction react:ServiceDAO.getAllReactions()) {
		  if (react.equals(reaction)) {
			react.getReaction().setReaction(reaction.getReaction().getReaction());
			return true;
		  }
		}
		ServiceDAO.AddReaction(reaction);
		return true;
	}
	public static ArrayList<new_user> getNewsCreateByUser(user user){
		ArrayList<new_user> lesNews= new ArrayList<new_user>();
		for(new_user news:ServiceDAO.getAllNews()) {
			  if (news.getUser().equals(user)) 
				  lesNews.add(news);
			 
		}
		return lesNews;
	}
	public static ArrayList<user_reaction> getReactionByUser(user user){
		ArrayList<user_reaction> lesReaction= new ArrayList<user_reaction>();
		for(user_reaction reaction:ServiceDAO.getAllReactions()) {
			  if (reaction.getUser().equals(user)) 
				  lesReaction.add(reaction);
		}
		return lesReaction;
	}
	public static ArrayList<user_reaction> getReactionByNews(new_user news){
		ArrayList<user_reaction> lesReaction= new ArrayList<user_reaction>();
		for(user_reaction reaction:ServiceDAO.getAllReactions()) {
			  if (reaction.getNews().equals(news)) 
				  lesReaction.add(reaction);
		}
		return lesReaction;
	}
	public static int getNombreJaime(new_user news){
		return ServiceDAO.NbAimeNews(news.getNews());
//		int nombreJaime=0;
//		for(user_reaction reaction:ServiceDAO.getAllReactions()) {
//			  if (reaction.getNews().equals(news) && reaction.getReaction().getReaction()) 
//				  nombreJaime++;	 
//		}
//		return nombreJaime;
	}
	public static int getNombreJeDeteste(new_user news){
		return ServiceDAO.NbDetesteNews(news.getNews());
//		int nombreJeDeteste=0;
//		for(user_reaction reaction:ServiceDAO.getAllReactions()) {
//			  if (reaction.getNews().equals(news) && !reaction.getReaction().getReaction()) 
//				  nombreJeDeteste++;	 
//		}
//		return nombreJeDeteste;
	}
	
}

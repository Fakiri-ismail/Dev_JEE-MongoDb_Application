package Metier;

public class user_reaction {

	private user user;
	private reaction reaction;
	private news news;
	
	public user getUser() {
		return user;
	}
	public void setUser(user user) {
		this.user = user;
	}
	
	public reaction getReaction() {
		return reaction;
	}
	public void setReaction(reaction reaction) {
		this.reaction = reaction;
	}
	
	public news getNews() {
		return news;
	}
	public void setNews(news news) {
		this.news = news;
	}
	
	@Override
	public String toString() {
		return "user_reaction [user=" + user + ", reaction=" + reaction + ", news=" + news + "]";
	}
	
}

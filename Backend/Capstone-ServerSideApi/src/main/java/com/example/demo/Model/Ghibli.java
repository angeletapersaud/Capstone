package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ghibli")
public class Ghibli {

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String Title;
    private String Director;
    private String movie_poster;
    private String release_date;
    private String Description;
    private String movie_banner;
    //private byte[] movie_poster_alt;
	public Ghibli() {
		// TODO Auto-generated constructor stub
	}
	
	 public Ghibli(int id, String title, String director, String moviePoster, 
			       String releaseDate, String description, String movieBanner){//,byte[] movie_poster_alt) {
			super();
			this.id = id;
			this.Title = title;
			this.Director = director;
			this.movie_poster = moviePoster;
			this.release_date = releaseDate;
			this.Description = description;
			this.movie_banner = movieBanner;
			//this.movie_poster_alt = movie_poster_alt;
		}
	    
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getTitle() {
			return Title;
		}
		public void setTitle(String title) {
			this.Title = title;
		}
		public String getDirector() {
			return Director;
		}
		public void setDirector(String director) {
			this.Director = director;
		}
		
		public String getMoviePoster() {
			return movie_poster;
		}
		public void setMoviePoster(String moviePoster) {
			this.movie_poster = moviePoster;
		}
		
		public String getReleaseDate() {
			return release_date;
		}
		public void setReleaseDate(String releaseDate) {
			this.release_date = releaseDate;
		}
		
		public String getDescription() {
			return Description;
		}
		public void setDescription(String description) {
			this.Description = description;
		}
		public String getMovieBanner() {
			return movie_banner;
		}
		public void setMovieBanner(String movie_banner) {
			this.movie_banner = movie_banner;
		}
//		public byte[] getMoviePosterAlt() {
//			return movie_poster_alt;
//		}
//		public void setMoviePosterAlt(byte[] movie_poster_alt) {
//			this.movie_poster_alt = movie_poster_alt;
//		}

}

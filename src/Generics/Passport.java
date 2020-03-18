package Generics;

import Generics.Country.France;

public class Passport<C extends Country> {

	private C country;

	public Passport(C country) {
		this.country = country;
	}
	
	public C getCountry() {
		return this.country;
	}
	
	public boolean hasLanguage(String language) {
		return this.country.getLanguages().contains(language); // this line wouldn't work with an unbounded type C
	}
	

	public static void main(String[] args) {
		France france = new France();
		Passport<France> passport = new Passport<>(france);
		France country = passport.getCountry();
		
//		Passport<String> pp = new Passport<>("France"); // Not OK
	}
}

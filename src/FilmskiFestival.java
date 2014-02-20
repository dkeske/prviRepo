public class FilmskiFestival {

	private String nazivFestivala = null;
	private String mestoOdrzavanja = null;
	private int brojPosetilaca;

	public String getNazivFestivala() {
		return nazivFestivala;
	}

	public void setNazivFestivala(String nazivFestivala) {
		if (nazivFestivala == null || nazivFestivala.equals("")) {
			throw new FilmskiFestivalException("Naziv festivala ne moze biti null ili prazan string.");
		}
		this.nazivFestivala = nazivFestivala;
	}

	public String getMestoOdrzavanja() {
		return mestoOdrzavanja;
	}

	public void setMestoOdrzavanja(String mestoOdrzavanja) {
		if (mestoOdrzavanja == null || mestoOdrzavanja.equals("")) {
			throw new FilmskiFestivalException("Mesto odrzavanja festivala ne moze biti null ili prazan string.");
		}
		this.mestoOdrzavanja = mestoOdrzavanja;
	}

	public int getBrojPosetilaca() {
		return brojPosetilaca;
	}

	public void setBrojPosetilaca(int brojPosetilaca) {
		if (brojPosetilaca < 0) {
			throw new FilmskiFestivalException("Broj posetilaca ne moze biti manji od nule.");
		}
		this.brojPosetilaca = brojPosetilaca;
	}
	
	@Override
	public String toString() {
		if (brojPosetilaca == 0) {
			return "Naziv festivala: "+nazivFestivala+", mesto odrzavanja: "+mestoOdrzavanja;
		} else {
			return "Naziv festivala: "+nazivFestivala+", mesto odrzavanja: "+mestoOdrzavanja+", brojPosetilaca: "+brojPosetilaca;
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		
		// proveravamo da li je prosledjen objekat klase FilmskiFestival
		if (!(obj instanceof FilmskiFestival)) {
			throw new FilmskiFestivalException("Ovo nije objekat klase FilmskiFestival.");
		}
		
		FilmskiFestival ff = (FilmskiFestival) obj;
		
		if (this.getNazivFestivala().equals(ff.getNazivFestivala()) && 
				this.getMestoOdrzavanja().equals(ff.getMestoOdrzavanja())) {
			return true;
		}
		return false;
	}
}

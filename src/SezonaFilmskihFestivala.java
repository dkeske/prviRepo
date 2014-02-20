import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;

public class SezonaFilmskihFestivala {

	private LinkedList<FilmskiFestival> festivali;

	public SezonaFilmskihFestivala() {
		festivali = new LinkedList<FilmskiFestival>();
	}

	public void upisiNajboljeFestivale() {
		try {
			PrintWriter out = new PrintWriter(
									new BufferedWriter(
											new FileWriter("izvestaj.txt")));

			for (int i = 0; i < festivali.size(); i++) {
				if (festivali.get(i).getBrojPosetilaca() > 100) {
					out.println(festivali.get(i));
				}
			}
			out.close();
		} catch (Exception e) {
			System.out.println("Greska: " + e.getMessage());
		}
	}

	public void dodajFestivalSaTastature() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.print("Unesite naziv festivala: ");
			String naziv = br.readLine();

			System.out.print("Unesite mesto odrzavanja festivala: ");
			String mesto = br.readLine();

			System.out.print("Unesite broj posetilaca: ");
			int brojPosetilaca = Integer.parseInt(br.readLine());

			FilmskiFestival noviFestival = new FilmskiFestival();
			noviFestival.setNazivFestivala(naziv);
			noviFestival.setMestoOdrzavanja(mesto);
			noviFestival.setBrojPosetilaca(brojPosetilaca);

			if (!festivali.contains(noviFestival)) {
				festivali.add(noviFestival);
			}
		} catch (Exception e) {
			System.out.println("Greska: " + e.getMessage());
		}
	}

	public void prethodniFestivali(LinkedList<FilmskiFestival> prethodnaSezona) {
		try {
			PrintWriter out = new PrintWriter(
									new BufferedWriter(
											new FileWriter("popularni_festivali.txt")));

			// prvi nacin
			for (int i = 0; i < prethodnaSezona.size(); i++) {
				for (int j = 0; j < festivali.size(); j++) {
					if (prethodnaSezona.get(i).equals(festivali.get(j))	&& 
							prethodnaSezona.get(i).getBrojPosetilaca() < festivali.get(j).getBrojPosetilaca()) {
						out.println(festivali);
					}
				}
			}
			
			
			// drugi nacin
			for (int i = 0; i < prethodnaSezona.size(); i++) {
				FilmskiFestival festivalIzPrethodneSezone = prethodnaSezona.get(i);
				
				// proveravamo da li postoji festival sa istim imenom i mestom u tekucoj sezoni. 
				// Obratiti paznju da metoda indexOf() interno poziva reimplementiranu metodu 
				// equals() klase FilmskiFestival
				int indexFestivala = festivali.indexOf(festivalIzPrethodneSezone);
				
				// ako je indexFestivala -1, onda nije pronadjen u listi tekucih festivala
				if (indexFestivala != -1) {
					FilmskiFestival festivalIzTekuceSezone = festivali.get(indexFestivala);
					
					if (festivalIzPrethodneSezone.getBrojPosetilaca() < festivalIzTekuceSezone.getBrojPosetilaca()) {
						out.println(festivalIzTekuceSezone);
					}
				}
			}
			out.close();
		} catch (Exception e) {
			System.out.println("Greska: " + e.getMessage());
		}
	}
}

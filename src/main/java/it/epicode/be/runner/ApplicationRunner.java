package it.epicode.be.runner;

import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.opencsv.CSVReader;

import it.epicode.be.BookRepository;
import it.epicode.be.model.Book;

@Component
public class ApplicationRunner implements CommandLineRunner {

	@Autowired
	BookRepository bookRepo;

	@Override
	public void run(String... args) throws Exception {
		// la prima lista dà le righe, la seconda lista le colonne
		try (CSVReader csvReader = new CSVReader(new FileReader("book.csv"));) {
			String[] values = null;
			csvReader.readNext(); // aggiungiamo un primo readNext() per saltare la prima riga (intestazione)
			while ((values = csvReader.readNext()) != null) {
				bookRepo.save(new Book(values[0], values[1]));// ogni libro viene valorizzato e salvato nel DB
				// poi ricomincia il ciclo, si passa alla prossima riga(readNext) e si salva
				// ancora il libro
			}
		}
	}

}

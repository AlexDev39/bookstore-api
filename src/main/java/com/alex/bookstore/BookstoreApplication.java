package com.alex.bookstore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alex.bookstore.domain.Categoria;
import com.alex.bookstore.domain.Livro;
import com.alex.bookstore.repositories.CategoriaRepository;
import com.alex.bookstore.repositories.LivroRepository;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "informatica", "Livros de TI");
		
		Livro li = new Livro(null, "Java", "Alexsandro", "Loren ipsun", cat1 );
		
		cat1.getLivros().addAll(Arrays.asList(li));
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1));
		this.livroRepository.saveAll(Arrays.asList(li));
		
	}

}

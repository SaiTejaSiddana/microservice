package com.example.MicroService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
@EnableSwagger2
public class MicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceApplication.class, args);
	}
	private static Logger _logger = LoggerFactory.getLogger(MicroServiceApplication.class);

	@Bean
	public CommandLineRunner demo(BooksRepository booksRepository, AuthorsRepository authorsRepository){
		return (args -> {
//			for(int i=0;i<50;i++){
//				String s1 = "book"+Integer.toString(i);
//				int i1 = (ThreadLocalRandom.current().nextInt(100));
//				booksRepository.save(new Books(s1, i1));
////				Optional<Authors> authors = authorsRepository.findById(i1);
////				if(authors.isEmpty()) authorsRepository.save(new Authors(i1,"author"+Integer.toString(i1)));
//
//			}


//			_logger.info("Finding Customers using findALL");
//			for (Books books : booksRepository.getAllBooks()){
//				_logger.info(books.toString());
//			}

//			for(int i=1;i<=50;i++){
//				Authors authors = new Authors(i,"author"+Integer.toString(i));
//				authorsRepository.save(authors);
//			}
		});
	}

	@Bean
	public Docket productApi(){
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.example.MicroService"))
				.build();
	}


}

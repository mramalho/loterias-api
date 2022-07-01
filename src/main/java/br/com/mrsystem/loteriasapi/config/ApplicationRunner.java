package br.com.mrsystem.loteriasapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

import br.com.mrsystem.loteriasapi.consumer.LoteriasUpdate;

@Configuration
@EnableCaching
public class ApplicationRunner implements CommandLineRunner {

	@Autowired
	private LoteriasUpdate loteriasUpdate;

	@Override
	public void run(String... args) throws Exception {
		loteriasUpdate.checkForUpdates();
	}

}

package br.com.devinhouse.processos.mock;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.devinhouse.processos.entities.Processo;
import br.com.devinhouse.processos.repository.ProcessoRepository;

@Configuration
public class Mock implements CommandLineRunner {
	
	@Autowired
	private ProcessoRepository repository;

	@Override
	public void run(String... args) throws Exception {
		List<Processo> allProcess = new ArrayList<Processo>();
		int numProcess = 40;
		
		for(int i = 0; i < numProcess; i++) {
			Processo process = new Processo();
			
			process.setCdAssunto(i+1);
			process.setCdInteressado(i+1);
			process.setDescricao("Processo " + (i + 1) + " de testes DEVinHouse");
			process.setDescricaoAssunto("Assunto " + (i + 1) + " de testes DEVinHouse");
			process.setNmInteressado("Cristian " + i);
			process.setNuAnoProcesso(i <= 20? "2020" : "2021");
			process.setNuProcesso(i+1);
			process.setSgOrgaoProcesso("SOFT");
			process.setChaveProcesso(process.getSgOrgaoProcesso() +process.getNuProcesso());
			allProcess.add(process);
		}
		
		for(Processo process : allProcess) {
			repository.save(process);
		}	
	}		
}

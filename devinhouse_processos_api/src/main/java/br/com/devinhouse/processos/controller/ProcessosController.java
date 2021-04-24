package br.com.devinhouse.processos.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.devinhouse.processos.entity.Processo;
import br.com.devinhouse.processos.service.ProcessoService;

@RestController
@RequestMapping(value = "/processos", headers = "api-version=1")
public class ProcessosController {
	
	@Autowired
	private ProcessoService service;
	
	// endpoint de cadastro
	@RequestMapping(value = "/cadastrar", method = POST, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public Processo registerProcess(@RequestBody Processo processo) {
		return service.create(processo);
	}
	
	// endpoint de consulta de todos os processos
	@RequestMapping(value = "/consultar", method = GET, produces = APPLICATION_JSON_VALUE)
	public List<Processo> allProcess() {
		return service.getAllProcess();
	}
	
	// endpoint de consulta de processos por id
	@RequestMapping(value = "/consultar/id/{id}", method = GET, produces = APPLICATION_JSON_VALUE)
	public Processo processById(@PathVariable Integer id) {
		return service.getProcessByID(id);
	}
	
	// endpoint de consulta de processos pela chave do processo
	@RequestMapping(value = "/consultar/chaveprocesso", method = GET, produces = APPLICATION_JSON_VALUE)
	public Processo processByKey(@RequestParam("chaveprocesso") String key) {
		return service.getProcessByKey(key);
	}
	
	// endpoint para atualizacao de todos os atributos de um processo
	@RequestMapping(value = "/atualizar/id/{id}", method = PUT, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public List<Processo> updateProcessAttribute(@PathVariable Integer id, @RequestBody Processo newObj){
		return service.updateProcess(id, newObj);
	}
	
	// endpoint de remocao de processos
	@RequestMapping(value = "/remover/id/{id}", method = DELETE)
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void removeProcess(@PathVariable Integer id) {
		service.removeProcess(id);
	}
	
	
}

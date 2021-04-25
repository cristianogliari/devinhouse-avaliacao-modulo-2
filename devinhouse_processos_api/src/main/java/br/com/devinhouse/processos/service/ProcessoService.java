package br.com.devinhouse.processos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devinhouse.processos.entities.Processo;
import br.com.devinhouse.processos.repository.ProcessoRepository;

@Service
public class ProcessoService {

	@Autowired
	private ProcessoRepository processoRepository;

	// criar processo
	public Processo create(Processo processo) {
		return processoRepository.save(processo);
	}
		
	// pegar todos os processos
	public List<Processo> getAllProcess(){
		return processoRepository.findAll();
	}
	
	// pegar processo por id
	public Processo getProcessByID(Integer id) {
		Processo filterProcess = processoRepository.findById(id).get();
		return filterProcess;
	}
	
	// pegar processo por chave
	public Processo getProcessByKey(String key) {
		List<Processo> allProcess = getAllProcess();
		Processo filteredProcess = new Processo();
		
		for(Processo each : allProcess) {
			if(each.getChaveProcesso().equals(key)) {
				filteredProcess = each;
			}
		}
		
		return filteredProcess;
	}
	
	// atualizar atributos do processo
	public List<Processo> updateProcess(Integer id, Processo newObj) {
		List<Processo> allProcess = getAllProcess();
		
		for(Processo each : allProcess) {
			if(id.equals(each.getId()))  {
				if(newObj.getNuProcesso() != null) {
					each.setNuProcesso(newObj.getNuProcesso());
				}
				if(newObj.getChaveProcesso() != null) {
					each.setChaveProcesso(newObj.getChaveProcesso());
				}
				if(newObj.getSgOrgaoProcesso() != null) {
					each.setSgOrgaoProcesso(newObj.getChaveProcesso());
				}
				if(newObj.getNuAnoProcesso() != null) {
					each.setNuAnoProcesso(newObj.getNuAnoProcesso());
				}
				if(newObj.getDescricao() != null) {
					each.setDescricao(newObj.getDescricao());
				}
				if(newObj.getCdAssunto() != null) {
					each.setCdAssunto(newObj.getCdAssunto());
				}
				if(newObj.getDescricaoAssunto() != null) {
					each.setDescricaoAssunto(newObj.getDescricaoAssunto());
				}
				if(newObj.getCdInteressado() != null) {
					each.setCdInteressado(newObj.getCdInteressado());
				}
				if(newObj.getNmInteressado() != null) {
					each.setNmInteressado(newObj.getNmInteressado());
				}
			}
		}
		
		return allProcess;
	}
	
	// remover processo
	public void removeProcess(Integer id) {
		Processo filteredProcess = processoRepository.findById(id).get();
		processoRepository.delete(filteredProcess);
	}
}

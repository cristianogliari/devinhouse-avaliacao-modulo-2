package br.com.devinhouse.processos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devinhouse.processos.entity.Processo;
import br.com.devinhouse.processos.repository.ProcessoRepository;

@Service
public class ProcessoService {

	@Autowired
	private ProcessoRepository processoRepository;

	public Processo create(Processo processo) {
		return processoRepository.save(processo);
	}
		
	public List<Processo> getAllProcess(){
		return processoRepository.findAll();
	}
	
	public Processo getProcessByID(Integer id) {
		Processo filterProcess = processoRepository.findById(id).get();
		return filterProcess;
	}
	
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
	
	public void removeProcess(Integer id) {
		Processo filteredProcess = processoRepository.findById(id);
		processoRepository.delete(filteredProcess);
	}
}

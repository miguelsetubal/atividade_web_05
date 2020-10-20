package br.ufc.web.atividade05.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import br.ufc.web.atividade05.model.Func;
import br.ufc.web.atividade05.repository.FuncRepository;

@Service
public class FuncService {
	
	@Autowired
    FuncRepository funcRepo;
	
	public Func addFunc(String nome, String cargo, String dnascimento, String dempresa) {
		Func func = new Func(nome, cargo, dnascimento, dempresa);
		return funcRepo.save(func);
	}
	
	public boolean remoneFunc(Integer id) {
		if(funcRepo.existsById(id)) {
			funcRepo.deleteById(id);
			return true;
		}
		return false;
	}
	
	public List<Func> getFuncByCargo(String cargo) {
		 List<Func> funcs = funcRepo.findByCargo(cargo);
		 return funcs;
	 }
	
	public List<Func> getFuncByQtd(Integer qtd) {
		 List<Func> funcs = funcRepo.findByQtd(qtd);
		 return funcs;
	 }
	
	 
	public List<Func> getFuncs(){
		return  funcRepo.findAll();
	}
	
	public Func getFunc(Integer id) {
		return funcRepo.findById(id).get();
	}
	
	public Func updateFunc(Integer id, String nome, String cargo, String dnascimento, String dempresa) {
		Func funcAux = funcRepo.findById(id).get();		
		if(funcAux != null) {
			funcAux.setNome(nome);
			funcAux.setCargo(cargo);
			funcAux.setDnascimento(dnascimento);
			funcAux.setDempresa(dempresa);	
			funcRepo.save(funcAux);
			
		}
		return funcAux;
	}

}

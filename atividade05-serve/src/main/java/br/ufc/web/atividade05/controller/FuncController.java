package br.ufc.web.atividade05.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.ufc.web.atividade05.model.Func;
import br.ufc.web.atividade05.service.FuncService;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/funcs")
public class FuncController {

	@Autowired
	FuncService funcService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Func>> getFuncs() {
		return new ResponseEntity<List<Func>>(funcService.getFuncs(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public ResponseEntity<Func> getUser(@PathVariable("id") Integer id) {
		return new ResponseEntity<Func>(funcService.getFunc(id), HttpStatus.OK);
	}	
	
	@RequestMapping(method = RequestMethod.GET, value = "/search")
	public ResponseEntity<List<Func>> getFuncByCargo(@RequestParam("cargo") String cargo) {
		return new ResponseEntity<List<Func>>(funcService.getFuncByCargo(cargo), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/search2")
	public ResponseEntity<List<Func>> getFuncByQtd(@RequestParam("qtd") Integer qtd) {
		return new ResponseEntity<List<Func>>(funcService.getFuncByQtd(qtd), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Func> addFunc(@RequestBody Func func) {
		return new ResponseEntity<Func>(
				funcService.addFunc(func.getNome(), func.getCargo(), func.getDnascimento(), func.getDempresa()),
				HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	public ResponseEntity<Func> updateFunc(@PathVariable("id") Integer id, @RequestBody Func func) {
		return new ResponseEntity<Func>(
				funcService.updateFunc(id, func.getNome(), func.getCargo(), func.getDnascimento(), func.getDempresa()),
				HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public ResponseEntity<Void> deleteFunc(@PathVariable("id") Integer id) {
		if (funcService.remoneFunc(id)) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

}

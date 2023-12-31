package edu.ifam.dra.chat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.ifam.dra.chat.dto.MensagemDTO;
import edu.ifam.dra.chat.model.Contato;
import edu.ifam.dra.chat.model.Mensagem;
import edu.ifam.dra.chat.service.ContatoService;
import edu.ifam.dra.chat.service.MensagemService;

@RestController
public class MensagemController {
	@Autowired
	MensagemService mensagemService;
	
	@Autowired
	ContatoService contatoService;
	
	@GetMapping("/mensagem/{id}")
	ResponseEntity<List<Mensagem>> getMensagens(@PathVariable Long id) {
		Contato receptor = contatoService.getContato(id);
		List<Mensagem> mensagens = mensagemService.getMensagens(receptor);
		
		if(mensagens.isEmpty()) 
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagens);
		else 
			return ResponseEntity.ok(mensagens);
		
	}
	
	@PostMapping("/mensagem")
	ResponseEntity<Mensagem> setMensagem(@RequestBody MensagemDTO mensagemDTO) {
		Contato emissor = contatoService.getContato(mensagemDTO.getEmissor());
		Contato receptor = contatoService.getContato(mensagemDTO.getReceptor());
		
		Mensagem mensagem = new Mensagem();
		mensagem.setDataHora(mensagemDTO.getDataHora());
		mensagem.setConteudo(mensagemDTO.getConteudo());
		mensagem.setEmissor(emissor);
		mensagem.setReceptor(receptor);
		
		mensagemService.setMensagem(mensagem);
		return ResponseEntity.created(null).body(null);
	}
}

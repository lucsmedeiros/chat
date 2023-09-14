package edu.ifam.dra.chat.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.ifam.dra.chat.model.Contato;
import edu.ifam.dra.chat.model.Mensagem;

public interface MensagemRepository extends JpaRepository<Mensagem, Long>{
	List<Mensagem> findAllByReceptor(Contato receptor);
}

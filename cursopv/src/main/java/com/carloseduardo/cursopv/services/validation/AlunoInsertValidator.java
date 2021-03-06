package com.carloseduardo.cursopv.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.carloseduardo.cursopv.domain.Aluno;
import com.carloseduardo.cursopv.dto.AlunoNewDTO;
import com.carloseduardo.cursopv.repositories.AlunoRepository;
import com.carloseduardo.cursopv.resources.exception.FieldMessage;

public class AlunoInsertValidator implements ConstraintValidator<AlunoInsert, AlunoNewDTO> {

	@Autowired
	private AlunoRepository alunoRepository;
	
	@Override
	public void initialize(AlunoInsert aln) {
	}
	
	@Override
	public boolean isValid(AlunoNewDTO objDto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();
		
		Aluno aux = alunoRepository.findByEmail(objDto.getEmail());
		if(aux != null) {
			list.add(new FieldMessage("email", "Email já existe!"));
		}
		
		for(FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName()).addConstraintViolation();
		}
		
		return list.isEmpty();
	}
}

package br.ifba.edu.aval1.state;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.model.BoletimProva;

public class MomentoLargada extends AbstractFaseDaCorrida {

	public MomentoLargada(BoletimProva boletimProva) {
		super(boletimProva);
	}
	
	@Override
	public void apresentarPraLargada() throws AtividadeNaoPermitidaException {
		return;
	}
	
	@Override
	public void registrarLargada() throws AtividadeNaoPermitidaException {
		this.boletimProva.setFase(new Pista(this.boletimProva));
	}
	
}

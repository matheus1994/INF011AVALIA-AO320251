package br.ifba.edu.aval1.state;

import java.time.Duration;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.model.BoletimProva;
import br.ifba.edu.aval.model.Prisma;

public class Pista extends AbstractFaseDaCorrida{

	public Pista(BoletimProva boletimProva) {
		super(boletimProva);
	}
	
	@Override
	public void registrarLargada() throws AtividadeNaoPermitidaException {
		return;
	}
	
	@Override
	public void registrar(Integer prismaID, Duration tempo) throws AtividadeNaoPermitidaException {
		this.boletimProva.passagens.registrarPassagem(prismaID, tempo);
	}	
	
	@Override
	public void registrarChegada(Duration tempo) throws AtividadeNaoPermitidaException {
		this.boletimProva.setFase(new PosProva(this.boletimProva));
		this.boletimProva.passagens.registrarPassagem(Prisma.CHEGADA, tempo);
	}	
	
}

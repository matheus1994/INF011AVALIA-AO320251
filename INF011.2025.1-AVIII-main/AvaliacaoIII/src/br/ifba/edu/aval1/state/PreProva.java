package br.ifba.edu.aval1.state;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.model.BoletimProva;

public class PreProva extends AbstractFaseDaCorrida {

	public PreProva(BoletimProva boletimProva) {
		super(boletimProva);
	}

	@Override
	public void registrarAtrasoPartida(Long minutoPartidaEfetivo) throws AtividadeNaoPermitidaException {
		throw new AtividadeNaoPermitidaException("Não pode calcular minutos de atraso");
	}

	@Override
	public Long getMinutosAtraso() throws AtividadeNaoPermitidaException {
		throw new AtividadeNaoPermitidaException("Não pode calcular minutos de atraso");
	}

	@Override
	public void apresentarPraLargada() throws AtividadeNaoPermitidaException {
		this.boletimProva.setFase(new MomentoLargada(this.boletimProva));

	}

}

package br.ifba.edu.aval1.templatemethod;

import java.time.Duration;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.exception.DNFException;
import br.ifba.edu.aval.model.BoletimProva;

public abstract class ApuradorTemplate {
	
	private Duration tempoMaximo;
	
	public ApuradorTemplate(Duration tempoMaximo) {
		this.tempoMaximo = tempoMaximo;
	}
	
	public Duration apurar(BoletimProva boletim) throws DNFException, AtividadeNaoPermitidaException {
		
		Duration tempoProva = this.obterTempoBase(boletim);
		this.verificarTempoMaximo(tempoProva);
		this.verificarOrdemPrismas(boletim);
		this.verificarPrismasRegistrados(boletim);
		return this.aplicarPenalidade(tempoProva, boletim);
		
	}
	
	public Duration getTempoMaximo() {
		return this.tempoMaximo;
	}
	
	public abstract Duration obterTempoBase(BoletimProva boletim) throws DNFException;
    public abstract void verificarTempoMaximo(Duration tempo) throws DNFException;
    public abstract void verificarOrdemPrismas(BoletimProva boletim) throws DNFException;
    public abstract void verificarPrismasRegistrados(BoletimProva boletim) throws DNFException;
    public abstract Duration aplicarPenalidade(Duration tempo, BoletimProva boletim) throws AtividadeNaoPermitidaException;
	
}


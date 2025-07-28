package br.ifba.edu.aval1.state;

import java.time.Duration;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;

public interface FaseDaCorrida {

	public void registrar(Integer prismaID, Duration tempo) throws AtividadeNaoPermitidaException;
	public void registrarAtrasoPartida(Long minutoPartidaEfetivo) throws AtividadeNaoPermitidaException;
	public Long getMinutosAtraso() throws AtividadeNaoPermitidaException;
	public void apresentarPraLargada() throws AtividadeNaoPermitidaException;
	public void registrarLargada() throws AtividadeNaoPermitidaException;
	public void registrarChegada(Duration tempo) throws AtividadeNaoPermitidaException;
	
}

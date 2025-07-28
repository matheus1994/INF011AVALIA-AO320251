package br.ifba.edu.aval1.state;

import java.time.Duration;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.model.BoletimProva;

public abstract class AbstractFaseDaCorrida implements FaseDaCorrida
{
	
	protected BoletimProva boletimProva;
	
	public AbstractFaseDaCorrida(BoletimProva boletimProva) {
		this.boletimProva = boletimProva;
	}
	
	@Override
	public void registrar(Integer prismaID, Duration tempo) throws AtividadeNaoPermitidaException {
		throw new AtividadeNaoPermitidaException("Não pode registrar prisma");
	}
	
	@Override
	public void registrarAtrasoPartida(Long minutoPartidaEfetivo) throws AtividadeNaoPermitidaException {
		this.boletimProva.minutoPartidaEfetivo = minutoPartidaEfetivo; 
	}
	
	@Override
	public Long getMinutosAtraso() throws AtividadeNaoPermitidaException {
		return boletimProva.minutoPartidaEfetivo - boletimProva.minutoPartidaPrevisto;
	}	
	
	@Override
	public void apresentarPraLargada() throws AtividadeNaoPermitidaException {
		throw new AtividadeNaoPermitidaException("Fase não permite se apresentar pra largada.");
	}
	
	@Override
	public void registrarLargada() throws AtividadeNaoPermitidaException {
		throw new AtividadeNaoPermitidaException("Fase não permite largar.");
	}
	
	@Override
	public void registrarChegada(Duration tempo) throws AtividadeNaoPermitidaException {
		throw new AtividadeNaoPermitidaException("Fase não permite registro de chegada.");
	}	
		
}

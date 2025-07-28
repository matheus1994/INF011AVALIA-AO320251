package br.ifba.edu.aval.model;

import java.time.Duration;
import java.util.List;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval1.prototype.ListaPassagens;
import br.ifba.edu.aval1.state.FaseDaCorrida;
import br.ifba.edu.aval1.state.PreProva;

public class BoletimProva {

	public String cboNumero;
	public ListaPassagens passagens;
	public Long minutoPartidaPrevisto;
	public Long minutoPartidaEfetivo;
	
	private FaseDaCorrida fase;
	
	public BoletimProva(String cboNumero, Long minutoPartidaPrevisto, ListaPassagens passagens) {
		super();
		this.cboNumero = cboNumero;
		this.passagens = passagens;
		this.minutoPartidaEfetivo = this.minutoPartidaPrevisto = minutoPartidaPrevisto;
		this.fase = new PreProva(BoletimProva.this);
	}
	
	public List<Integer> getOrdemPrismas() {
		return this.passagens.getOrdemPassagem();
	}
	
	public String cboNumero() {
		return this.cboNumero;
	}
	
	@Override
	public String toString() {
		return "BoletimProva [cboNumero=" + cboNumero + ", passagens=" + passagens + "]";
	}	
	
	public Duration getTempo(Integer prismaID) {
		return this.passagens.getTempo(prismaID);
	}
	
	public void registrar(Integer prismaID, Duration tempo) throws AtividadeNaoPermitidaException {
		this.fase.registrar(prismaID, tempo);
	}

	public void registrarAtrasoPartida(Long minutoPartidaEfetivo) throws AtividadeNaoPermitidaException {
		this.fase.registrarAtrasoPartida(minutoPartidaEfetivo);
	}
	
	public Long getMinutosAtraso() throws AtividadeNaoPermitidaException {
		return this.fase.getMinutosAtraso();
	}	
	
	public void apresentarPraLargada() throws AtividadeNaoPermitidaException {
		this.fase.apresentarPraLargada();
	}
	
	public void registrarLargada() throws AtividadeNaoPermitidaException {
		this.fase.registrarLargada();
	}
	
	public void registrarChegada(Duration tempo) throws AtividadeNaoPermitidaException {
		this.fase.registrarChegada(tempo);
	}

	public FaseDaCorrida getFase() {
		return fase;
	}

	public void setFase(FaseDaCorrida fase) {
		this.fase = fase;
	}
	
}

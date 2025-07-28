package br.ifba.edu.aval1.templatemethod;

import java.time.Duration;
import java.util.List;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.exception.DNFException;
import br.ifba.edu.aval.model.BoletimProva;
import br.ifba.edu.aval.model.Prisma;

public class Apurador extends ApuradorTemplate{

	public Apurador(Duration tempoMaximo) {
		super(tempoMaximo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Duration obterTempoBase(BoletimProva boletim) throws DNFException {
		
		Duration tempoDeChegada = boletim.getTempo(Prisma.CHEGADA);
		
		if(tempoDeChegada == null)
			throw new DNFException("Atleta não registrou chegada");
		return tempoDeChegada;
		
	}

	@Override
	public void verificarTempoMaximo(Duration tempo) throws DNFException {
		if(tempo.compareTo(this.getTempoMaximo()) > 0)
			throw new DNFException("O atleta finalizou a prova após o tempo limite");
	}

	@Override
	public void verificarOrdemPrismas(BoletimProva boletim) throws DNFException {
		List<Integer> ordens = boletim.getOrdemPrismas();
        for (int i = 0; i < ordens.size() - 1; i++) {
            Duration tempoAnterior = boletim.getTempo(ordens.get(i));
            Duration tempoAtual = boletim.getTempo(ordens.get(i + 1));
            if (tempoAnterior != null && tempoAtual != null && tempoAnterior.compareTo(tempoAtual) > 0)
                throw new DNFException("Prismas fora da ordem");
        }
	}

	@Override
	public void verificarPrismasRegistrados(BoletimProva boletim) throws DNFException {
		
		for(Integer prisma: boletim.getOrdemPrismas()) {
			if(prisma == Prisma.CHEGADA && boletim.getTempo(prisma) != null) {
				System.out.println("Prismas registrados");
			}
		}
		
	}

	@Override
	public Duration aplicarPenalidade(Duration tempo, BoletimProva boletim) throws AtividadeNaoPermitidaException {
		
		return tempo.plus(Duration.ofMinutes(boletim.getMinutosAtraso()));
		
	}

}

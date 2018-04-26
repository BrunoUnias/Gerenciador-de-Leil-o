package gerenciador;

import java.io.LineNumberInputStream;
import java.util.ArrayList;

public class Lance {
	private int qtdLance;
	private int proximoLance;
	private int lanceAnterior;
	private int valor;
	
	ArrayList<Pessoa> listaPessoa = new ArrayList<Pessoa>();
	
	public Lance() {
		
	}
	
	public Lance(int qtdLance, Pessoa pessoa) {
		this.qtdLance = qtdLance;
		this.lanceAnterior = proximoLance;
		
	}
	
	public int getQtdLance() {
		return qtdLance;
		
	}
	
	public void setQtdLance(int qtdLance) {
		this.qtdLance = qtdLance;
		
	}
	
	public int getProximoLance() {
		return proximoLance;
		
	}

	public void setProximoLance(int proximoLance) {
		if(getLanceAnterior() > proximoLance) {
			this.proximoLance = proximoLance;
			
		}
		
	}
	
	public int getLanceAnterior() {
		return lanceAnterior;
		
	}
	
	public void setLanceAnterior() {
		this.lanceAnterior = proximoLance;
	}
	
	public int getValor() {
		return valor;
		
	}
	
	public void setValor(int valor) {
		this.valor = valor;
		
	}
	
	public ArrayList<Pessoa> getPessoa(){
		return listaPessoa;
		
	}
	
	public void setListaPessoa(Pessoa pessoa) {
		this.listaPessoa.add(pessoa);
		
	}
	
	public void exibirInformacao() {
		
	}
}

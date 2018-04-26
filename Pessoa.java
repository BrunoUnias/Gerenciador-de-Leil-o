package gerenciador;

import java.util.ArrayList;

public class Pessoa {
	private String nome;
	private int dinheiroInicial;
	private int dinheiro;
	
    ArrayList<Produto> produtoAdquirido = new ArrayList<Produto>();
	ArrayList<Lance> lances = new ArrayList<Lance>();
	
	public Pessoa(String nome, int dinheiro, int dinheiroInicial) {
		this.nome = nome;
		this.dinheiroInicial = dinheiroInicial;
		this.dinheiro = dinheiro;
		
	}
	
	public Pessoa() {
		this.nome = nome;
		this.dinheiroInicial = dinheiroInicial;
		this.dinheiro = dinheiro;
		
	}
	
	public Pessoa(ArrayList<Pessoa> listaPessoa, String nome2, ArrayList<Leilao> listaLeilao) {
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
		
	}
	
	public void setNome(String nome) {
		this.nome = nome;
		
	}
	
	public int getDinheiroInicial() {
		return dinheiroInicial;
		
	}
	
	public void setDinheiroInicial(int dinheiroInicial) {
		this.dinheiroInicial = dinheiroInicial;
		
	}
	
	public int getDinheiro() {
		return dinheiro;
		
	}
	
	public void setDinheiro(int dinheiro) {
		this.dinheiro = dinheiro;
		
	}
	
	public ArrayList<Produto> getProdutoAdquirido(){
		return produtoAdquirido;
		
	}
	
	public void setProdutoAdquirido(Produto produto) {
		this.produtoAdquirido.add(produto);
		
	}
	
	public ArrayList<Lance> getLance(){
		return lances;
		
	}
	
	public void setLance(Lance lance) {
		this.lances.add(lance);
		
	}
	
	public String  getInformacao() {
		return "Nome: " + getNome() + " Dinheiro inicial: " + getDinheiroInicial();
		
	}
	
	public void verInformacao(ArrayList<Pessoa> listaPessoa) {
		int indice = listaPessoa.indexOf(this);
		String nome = getNome();
		
		System.out.println(indice + ", " + nome);
	}
	
	public int pessoaGastou() {
		return dinheiroInicial - dinheiro;
	}


}

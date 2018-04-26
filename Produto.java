package gerenciador;

public class Produto {
	private String nome;
	private int precoMinimo;
	
	public Produto(String nome, int precoMinimo) {
		this.nome = nome;
		this.precoMinimo = precoMinimo;
	}
	
	public Produto(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
		
	}
	
	public void setNome(String nome) {
		this.nome = nome;
		
	}
	
	public int getPrecoMinimo() {
		return precoMinimo;
		
	}
	
	public void setPrecoMinimo(int precoMinimo) {
		this.precoMinimo = precoMinimo;
		
	}

}

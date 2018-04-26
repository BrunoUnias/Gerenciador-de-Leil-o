package gerenciador;

import java.util.ArrayList;
import java.util.Scanner;

public class Leilao {
	private Pessoa pessoaGanhou;
	private Produto produtoLeilao;
	String nome;
	int qtdDinheiro;
	int dinheiro;
	
	ArrayList<Lance> listaLance = new ArrayList<Lance>();
	ArrayList<Produto> listaProduto = new ArrayList<Produto>();
	ArrayList<Pessoa> listaPessoa = new ArrayList<Pessoa>();
	Pessoa pessoa = new Pessoa( nome, qtdDinheiro, dinheiro);
	Produto produto = new Produto(nome);
	Scanner scanner = new Scanner(System.in);
	
	/*public Leilao() {
		this.precoMinimo = precoMinimo;
		this.pessoa = pessoa;
		
	}*/
	
	public Leilao(Produto produto) {
		this.produtoLeilao = produto; 
		
	}
	
	public Leilao() {
		
	}
	
	public Leilao(Produto produtoLeilao, ArrayList<Pessoa> listaPessoa) {
		
	}
	
	public ArrayList<Lance> getLance(){
		return listaLance;
		
	}
	
	public void setLance(Lance lance) {
		this.listaLance.add(lance);
		
	}
	
	public ArrayList<Produto> getProduto(){
		return listaProduto;
		
	}
	
	public void setProduto(Produto produto) {
		this.listaProduto.add(produto);
		
	}
	
	public ArrayList<Pessoa> getPessoa(){
		return listaPessoa;
		
	}
	
	public void setPessoa(Pessoa pessoa) {
		this.listaPessoa.add(pessoa);
		
	}
	
	public Pessoa getPessoaGanhou() {
		return pessoaGanhou;
		
	}
	
	public void setPessoaGanhou(Pessoa pessoaGanhou) {
		this.pessoaGanhou = pessoaGanhou;
		
	}
	
	public void adicionarPessoa(Pessoa pessoa) {
		this.listaPessoa.add(pessoa);
		
	}
	
	public void selecionarProduto(Produto produto) {
		this.listaProduto.add(produto);
		
	}
	
	
	
	public String getInformacao() {
		return "Produto = " + getProduto() + " Preco minimo = " + produto.getPrecoMinimo();
	}
	
	public void Lance(Pessoa pessoa, Produto produto, int lance) {
		if(lance < produto.getPrecoMinimo() || pessoa.getDinheiro() < lance) {
			System.out.println("valor insuficiente para o produto " + produto.getNome());
			
		}
		else if(pessoaGanhou != null && pessoaGanhou == pessoa) {
			System.out.println(pessoa.getNome() + "nao pode dar outro lance seguido");
			
		}
		else {
			Lance lance1 = new Lance();
			int precoMinimo = scanner.nextInt();
			scanner.nextLine();
			pessoa.setLance(lance1);
			produto.setPrecoMinimo(precoMinimo);
			
			pessoaGanhou = pessoa;
		}
	}
	
	public void finalizarLeilao(Produto produto) {
        pessoaGanhou.setDinheiro(pessoaGanhou.getDinheiro()
                - pessoaGanhou.getLance().get(pessoaGanhou.getLance().size() - 1).getValor());
        pessoaGanhou.setProdutoAdquirido(produto);
        
        System.out.println("Pessoa ganhadora " + pessoaGanhou.getNome() + " valor oferecido "
                + pessoaGanhou.getLance().get(pessoaGanhou.getLance().size() - 1).getValor()
                + " no produto " + produto.getNome());
    }

	
	public boolean verificarPessoa(ArrayList<Pessoa> listaPessoa) {
		System.out.println("nome: ");
		Scanner scanner = new Scanner(System.in); 
		String nome = scanner.next();
		for(int i = 0; i <= listaPessoa.size(); i++) {
			if(nome.equals(listaPessoa.get(i).getNome())) {
				return true;
			}
		}
		
		return false;
		
		
	}
	
	public boolean verificarProduto(ArrayList<Produto> listaProduto) {
		System.out.println("Produto: ");
		Scanner scanner = new Scanner(System.in);
		String nome = scanner.next();
		for (int i = 0; i < listaProduto.size(); i++) {
			if (nome.equals(listaProduto.get(i).getNome())) {
				return true;
						
			}
			
		}
		return false;
		
	}
}

package gerenciador;

import java.util.ArrayList;
import java.util.Scanner;

public class Evento {
	
	public static void main(String [] args) {
		ArrayList<Leilao> listaLeiloes = new ArrayList<Leilao>();
		ArrayList<Produto> listaProduto = new ArrayList<Produto>();
		ArrayList<Pessoa> listaPessoa = new ArrayList<Pessoa>();
		ArrayList<Lance> listaLance = new ArrayList<Lance>();
		
		exibirMenu();
		
		Scanner scanner = new Scanner(System.in);
		
		//edimo.souza@fapce.edu.br
		Leilao leilao = new Leilao();
		Pessoa pessoa = new Pessoa();	
		int opcao = scanner.nextInt();
		
		switch(opcao) {
		
		case 1:
			cadastrarLeilao(listaLeiloes);
			break;
			
		case 2: 
			cadastrarPessoa(listaPessoa);
			break;
			
		case 3:
			int precoMinimo = scanner.nextInt();
			String nome = scanner.next();
			cadastrarProduto( nome, precoMinimo);
			break;
			
		case 4:
			getLeiloes();
			break;
			
		case 5:
			informacoesDosLeiloes();
			
		}
	}
	
	public static void exibirMenu() {
		System.out.println("--Menu--");
		System.out.println("1 - criar leilao.");
		System.out.println("2 - cadastrar pessoa.");
		System.out.println("3 - mostrar leilao.");
		System.out.println("4 cadastrar pessoa no leilao.");
		System.out.println("5 - dar lance.");
		System.out.println("6- quem arrematou mais produto.");
		System.out.println("7- quem gastou mais.");
		System.out.println("8- quem gastou menos.");
		System.out.println("6- voltar ao menu");

	}
   
	static ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
    static ArrayList<Produto> produtos = new ArrayList<Produto>();
    static ArrayList<Leilao> listaLeiloes = new ArrayList<Leilao>();

    public static ArrayList<Pessoa> getPessoasEvento() {
        return pessoas;
    }

    public  static void cadastrarPessoa(ArrayList<Pessoa> listaPessoa) {
        pessoas = listaPessoa;
    }

    public static ArrayList<Produto> getProdutosEvento() {
        return produtos;
    }

    public void setProdutosEvento(ArrayList<Produto> listaProduto) {
        this.produtos = listaProduto;
    }

    public static ArrayList<Leilao> getLeiloes() {
        return listaLeiloes;
    }

    public static void setLeiloes(ArrayList<Leilao> leiloes) {
        listaLeiloes = leiloes;
    }

    public static void cadastrarProduto(String nome, int precoMinimo) {
       produtos.add(new Produto(nome, precoMinimo));
    }

    public void cadastrarPessoa(ArrayList<Pessoa> listaPessoa, String nome, 
    		ArrayList<Leilao> listaLeilao) {
    	Scanner scanner = new Scanner(System.in);
		System.out.println("Nome: ");
		String auxnome = scanner.next();
		System.out.println("quantidade de dinheiro");
		int qtdDinheiro = scanner.nextInt();
		System.out.println("Dinheiro inicial");
		int dinheiro = scanner.nextInt();
        this.pessoas.add(new Pessoa(listaPessoa, auxnome, listaLeilao));
    }

    public static void cadastrarLeilao(ArrayList<Leilao> listaLeiloes) {
    	Scanner scanner = new Scanner(System.in);
		Leilao leiloes = new Leilao();
			System.out.println("produto: ");
			String nome = scanner.next();
			scanner.nextLine();
			System.out.println("preco minino: ");
			int precoMinimo = scanner.nextInt();
			Produto produto = new Produto(nome,precoMinimo);
			adicionarProduto(produto);
			leiloes.selecionarProduto(produto);
		for (Leilao leilao2 : listaLeiloes) {
			listaLeiloes.add(new Leilao());
			
		}
    }

    public static void cadastrarPessoaLeilao(Integer indexLeilao, Pessoa pessoa) {
        if (listaLeiloes.get(indexLeilao) == null) {
            System.out.println("leilão nao existe");
        } else {
           listaLeiloes.get(indexLeilao).adicionarPessoa(pessoa);
        }
    }

    public static void selecionarProdutoLeilao(Integer indexLeilao, Produto produto) {
        if (listaLeiloes.get(indexLeilao) == null) {
            System.out.println("leilão nao existe");
        } else {
            listaLeiloes.get(indexLeilao).setProduto(produto);
        }
    }

    public static void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }
    
    public void adicionarPessoa(Pessoa pessoa) {
        this.pessoas.add(pessoa);
    }

    public static void informacoesDosLeiloes() {
        Pessoa pessoaMaisLances = null;
        Pessoa pessoaMaisProdutos = null;
        Pessoa pessoaMaisGastou = null;
        Pessoa pessoaMenosGastou = null;

        for (Pessoa pessoa : pessoas) {
            if (pessoa.getLance().size() > 0) {//Mais lances
                if (pessoaMaisLances == null) {
                    pessoaMaisLances = pessoa;
                } else {
                    if (pessoaMaisLances.getLance().size() < pessoa.getLance().size()) {
                        pessoaMaisLances = pessoa;
                    }
                }
            }//fim lances

            if (pessoa.getProdutoAdquirido().size() > 0) {//Mais produtos
                if (pessoaMaisProdutos == null) {
                    pessoaMaisProdutos = pessoa;
                } else {
                    if (pessoaMaisProdutos.getProdutoAdquirido().size() < pessoa.getProdutoAdquirido().size()) {
                        pessoaMaisProdutos = pessoa;
                    }
                }
            }//fim produtos

            if (pessoa.pessoaGastou() > 0) {//Mais gastou
                if (pessoaMaisGastou == null) {
                    pessoaMaisGastou = pessoa;
                } else {
                    if (pessoaMaisGastou.pessoaGastou() < pessoa.pessoaGastou()) {
                        pessoaMaisGastou = pessoa;
                    }
                }
            }//fim mais gastou

            if (pessoa.pessoaGastou() > 0) {//menos gastou
                if (pessoaMenosGastou == null) {
                    pessoaMenosGastou = pessoa;
                } else {
                    if (pessoaMenosGastou.pessoaGastou() > pessoa.pessoaGastou()) {
                        pessoaMenosGastou = pessoa;
                    }
                }
            } else {
                pessoaMenosGastou = pessoa;
            }//fim menos gastou

            for (int i = 0; i < pessoa.getProdutoAdquirido().size(); i++) {
                for (int j = 0; j < produtos.size(); j++) {
                
                        if (produtos.get(j).equals(pessoa.getProdutoAdquirido().get(i))
                                && produtos.get(j+1).equals(pessoa.getProdutoAdquirido().get(i+1))
                                && produtos.get(j+2).equals(pessoa.getProdutoAdquirido().get(i+2))) {
                                System.out.println("ALERTA!!!! Pessoa " + pessoa.getNome() + " ganhou 3 produtos seguidos!!");
                        }
                    } 
                }
            }
        
        
        System.out.println("pessoa que realizou mais lances: "+pessoaMaisLances.getNome());
        System.out.println("pessoa que arrematou mais produtos: "+pessoaMaisProdutos.getNome());
        System.out.println("pessoa que gastou mais: "+pessoaMaisGastou.getNome());
        System.out.println("pessoa que gastou menos: "+pessoaMenosGastou.getNome());
        
    }

}

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Carrinho {
    Scanner leia = new Scanner(System.in);
    public static List<Produto> listProduto = new ArrayList<>();
    public static List<ProdutoFisico> listProdutoFisico = new ArrayList<>();
    public static List<ProdutoDigital> listProdutoDigital = new ArrayList<>();
    public static List<Compra> listCompras = new ArrayList<>();

    public static void main(String[] args) {
        int opcao = 0;
        Carrinho c = new Carrinho();
        do {
            System.out.println("<============Gerenciar compras de produtos no carrinho =========>");
            System.out.println("Digite 1 para adicionar ao carrinho:");
            System.out.println("Digite 2 para remover um produto do carrinho:");
            System.out.println("Digite 3 para exibir lista de compras:");
            System.out.println("Digite 4 para exibir valor da compra:");
            System.out.println("Digite 9 para sair do sistema: ");
            opcao = Integer.parseInt(c.leia.nextLine());

            switch (opcao) {
                case 1:
                    c.execAdicionarCarrinho();
                    break;
                case 2:
                    c.execRemoverProduto();
                    break;
                case 3:
                    c.execExibirCompras();
                    break;
                case 4:
                    c.execVisualizarGasto();
                    break;
                case 9:
                    System.out.println("Programa encerrado com sucesso!");
                    System.out.println("<===============>");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (opcao != 9);
    }

    public void execAdicionarCarrinho() {
        System.out.println("<===========ADICIONE UM PRODUTO AO CARRINHO==========================>");
        System.out.println("Informe o nome do produto:");
        String nome = leia.nextLine();
        System.out.println("Informe o valor do produto:");
        double preco = Double.parseDouble(leia.nextLine());
        System.out.println("Informe a quantidade que deseja levar:");
        int quantidade = Integer.parseInt(leia.nextLine());
        System.out.println("<==========================Produto adicionado ao carrinho com sucesso!====================================>");
        Compra compra = new Compra(nome, preco, quantidade);
        listCompras.add(compra);
    }

    public void execExibirCompras() {
        System.out.println("Essas são as compras realizadas pelo cliente:");
        for (Compra compra : listCompras) {
            compra.exibirInformacoes();
        }
    }

    public void execRemoverProduto() {
        System.out.println("Informe o nome do produto a ser removido:");
        String nome = leia.nextLine();
        Compra compraRemover = null;
        for (Compra compra : listCompras) {
            if (compra.getNome().equals(nome)) {
                compraRemover = compra;
                break;
            }
        }

        if (compraRemover != null) {
            listCompras.remove(compraRemover);
            System.out.println("Produto removido do carrinho com sucesso!");
        } else {
            System.out.println("O produto não foi encontrado no carrinho.");
        }
    }

    public void execVisualizarGasto() {
        double gastoTotal = 0.0;
        for (Compra compra : listCompras) {
            gastoTotal += compra.getPreco() * compra.getQuantidade();
        }
        System.out.println("O gasto total é: R$" + gastoTotal);
    }
}

class Compra {
    private String nome;
    private double preco;
    private int quantidade;

    public Compra(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public void exibirInformacoes() {
        System.out.println("Nome do produto: " + nome);
        System.out.println("Preço unitário: R$" + preco);
        System.out.println("Quantidade: " + quantidade);
        System.out.println("-------------------------");
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }
}

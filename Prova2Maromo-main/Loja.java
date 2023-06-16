
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loja {

    Scanner leia = new Scanner(System.in);
    public static List<Produto> listProduto = new ArrayList<>();
    public static List<ProdutoFisico> listProdutoFisico = new ArrayList<>();
    public static List<ProdutoDigital> listProdutoDigital = new ArrayList<>();

    public static void main(String[] args) {
        Loja gp = new Loja();
        int opcao = 0;
        System.out.println("======Realizar o  gerenciamento e cadastro dos Produto da loja JULIANOTEC======");
        do {
            System.out.println("Digite 1 para cadastrar um produto Físico:");
            System.out.println("Digite 2 para cadastrar um produto Digital: ");
            System.out.println("Digite 3 emitr um relatorio de todos os produtos:");
            System.out.println("Digite 4 para remover o produto do estoque:");
            System.out.println("Digite 5 para  visualizar o estoque");
            System.out.println("Digite 6 para  procurar um  produto especifico  pelo seu código:");
            System.out.println("Digite 9 para sair do Sistema: ");

            opcao = Integer.parseInt(gp.leia.nextLine());

            switch (opcao) {
                case 1:
                    gp.execCadastrarProdutoFisico();
                    break;
                case 2:
                    gp.execCadastrarProdutoDigital();
                    break;
                case 3:
                    gp.execEmitirRelatorio();
                case 4:
                    gp.execRetirarPorduto();
                case 5:
                    gp.execGerenciarEstoque();
                case 6:
                    gp.execConsultarCodigo();
                    break;
                case 9:
                    System.out.println("Programa encerrado com sucesso!");
                    System.out.println("<===============>");
                    break;
                default:
                    System.out.println("Opcao invalida");

            }

        } while (opcao != 6);

    }

    public void execCadastrarProdutoFisico() {
        System.out.println("<=======CADASTRAR_PRODUTOFISICO==========>");
        System.out.println("Informe o nome do produto:");
        String nome = (leia.nextLine());
        System.out.println("Informe o preço do produto fisico:");
        double preco = Double.parseDouble(leia.nextLine());
        System.out.println("Informe a quantidade existente na loja desse produto:");
        Integer quantidadeStoque = Integer.parseInt(leia.nextLine());
        System.out.println("Informe o peso do produto:");
        double peso = Double.parseDouble(leia.nextLine());
        System.out.println("Informe a dimensao do produto:");
        String dimensao = (leia.nextLine());
        System.out.println("Informe ocodigo do produto:\n");
        Integer codigoProduto = Integer.parseInt(leia.nextLine());
        System.out.println("============Produto cadastrado com sucesso!=====");
        System.out.println("Escolha outra opção para continuar.....");
        System.out.println("<===========================================>");
        ProdutoFisico produtofisico = new ProdutoFisico(nome, preco, quantidadeStoque, peso, dimensao, codigoProduto);
        listProdutoFisico.add(produtofisico);

    }

    public void execCadastrarProdutoDigital() {
        System.out.println("<==========CADASTRAR_PRODUTO-DIGITAL===========>");
        System.out.println("Informe o nome do produto:\n");
        String nome = (leia.nextLine());
        System.out.println("Informe o  preço do produto Digital:\n");
        double preco = Double.parseDouble(leia.nextLine());
        System.out.println("Informe a quantidade do produto digital disponivel:\n");
        Integer quantidadeStoque = Integer.parseInt(leia.nextLine());
        System.out.println("Informe a categoria do produto digital:\n");
        String formato = (leia.nextLine());
        System.out.println("Informe o tamanho do arquivo:\n");
        String tamanhoArquivo = (leia.nextLine());
        System.out.println("Informe ocodigo do produto:\n");
        Integer codigoProduto = Integer.parseInt(leia.nextLine());
        System.out.println("Cadastro de produto digital efetuado com sucesso!\n");
        System.out.println("Digite outra opcao para continuar.....");
        System.out.println("<===========================================>");
        ProdutoDigital produtodigital = new ProdutoDigital(nome, preco, quantidadeStoque, formato, tamanhoArquivo, codigoProduto);
        listProdutoDigital.add(produtodigital);

    }

    public void execEmitirRelatorio() {
        System.out.println("Esses são  os dados dos produtos fisicos:\n");
        for (ProdutoFisico produtosfisicos : listProdutoFisico) {
            produtosfisicos.ExibirInformaçoes();
        }
        System.out.println("<*****************>");
        System.out.println("Esses são  os dados dos produtos Digitais:\n");
        for (ProdutoDigital produtodigital : listProdutoDigital) {
            produtodigital.ExibirInformaçoes();
           System.out.println("<%%%%%%%%%%%%%%%%%%%%>");
        }
    }

    public void execGerenciarEstoque() {
        int totalProdutoFisico = 0;
        int totalProdutoDigital = 0;
        int totalEstoque = 0;
        System.out.println("<=============================>");
        for (ProdutoFisico produtofisico : listProdutoFisico) {
            totalProdutoFisico = totalProdutoFisico + produtofisico.getQuantidadeStoque();
        }
        System.out.println("Total de produtos fisicos na loja:" + totalProdutoFisico);

        for (ProdutoDigital produtodigital : listProdutoDigital) {
            totalProdutoDigital = totalProdutoDigital + produtodigital.getQuantidadeStoque();
        }
        System.out.println("Total de produtos digitais na loja:" + totalProdutoDigital);
        totalEstoque = totalProdutoFisico + totalProdutoDigital;
        System.out.println("Total de produtos fisicos e digitais disponiveis na loja:" + totalEstoque);
    }

    public void execConsultarCodigo() {
        System.out.println("<=================BUSCANDO INFORMAÇÕES DO PRODUTO===================>");
        System.out.println("Informe o código do produto que deseja consultar:");
        int codigo = Integer.parseInt(leia.nextLine());

        boolean encontrado = false;

        // Procurar na lista de produtos físicos
        for (ProdutoFisico produtoFisico : listProdutoFisico) {
            if (produtoFisico.getCodigoProduto() == codigo) {
                produtoFisico.ExibirInformaçoes();
                encontrado = true;
                break;

            }
              System.out.println("<=============================>");
        }
        System.out.println("<=============================>");

        // Procurar na lista de produtos digitais, se não encontrado nos produtos físicos
        if (!encontrado) {
            for (ProdutoDigital produtoDigital : listProdutoDigital) {
                if (produtoDigital.getCodigoProduto() == codigo) {
                    produtoDigital.ExibirInformaçoes();
                    encontrado = true;
                    break;
                }
            }
            System.out.println("<=============================>");
        }
    }

    public void execRetirarPorduto() {
        System.out.println("<================REMOÇÃO DE PRODUTOS==================>");
        System.out.println("Informe o nome do produto a ser removido:");
        String nome = (leia.nextLine());


        ProdutoDigital produtoRemover = null;
        for (ProdutoDigital produtoDigital : listProdutoDigital) {
            if (produtoDigital.getNome().equals(nome)) {
                produtoRemover = produtoDigital;
                break;
            }
        }

        if (produtoRemover != null) {
            listProdutoDigital.remove(produtoRemover);
            System.out.println("Produto removido com sucesso!");
        }

         ProdutoFisico produtoRemoverFisico = null;
        for (ProdutoFisico produtoFisico : listProdutoFisico) {
            if (produtoFisico.getNome().equals(nome)) {
                produtoRemoverFisico = produtoFisico;
                break;
            }
        }

        if (produtoRemoverFisico != null) {
            listProdutoFisico.remove(produtoRemoverFisico);
            System.out.println("Produto removido com sucesso!");
        }
    }
}

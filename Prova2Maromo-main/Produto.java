public class 	Produto {
	protected  int codigoProduto;
	protected String nome;
	protected String descricao;
	protected double preco;
	protected int quantidadeStoque;
	public int getCodigoProduto() {
		return codigoProduto;
	}
	public void setCodigoProduto(int codigoProduto) {
		this.codigoProduto = codigoProduto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public int getQuantidadeStoque() {
		return quantidadeStoque;
	}
	public void setQuantidadeStoque(int quantidadeStoque) {
		this.quantidadeStoque = quantidadeStoque;
	}
	public void ExibirInformaçoes() {
		System.out.println(
		"Código do produto:"+codigoProduto +"\n"+
		"Nome do produto:"+nome +"\n"+
		"Descricao do produto:"+descricao +"\n"+
		"Preço do produto:"+preco +"\n"+
		"Quantidade do produto em estoque:"+quantidadeStoque +"\n");
	}
}

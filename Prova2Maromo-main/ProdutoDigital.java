public class ProdutoDigital extends Produto {
	protected String formato;
	protected String tamanhoArquivo;
	public String getFormato() {
		return formato;
	}
	public void setFormato(String formato) {
		this.formato = formato;
	}
	public String getTamanhoArquivo() {
		return tamanhoArquivo;
	}
	public void setTamanhoArquivo(String tamanhoArquivo) {
		this.tamanhoArquivo = tamanhoArquivo;
	}

	public ProdutoDigital(String nome,double preco, int quantidadeStoque,String formato,String tamanhoArquivo,int codigoProduto) {
		this.nome = nome;
		this.preco = preco;
		this.quantidadeStoque = quantidadeStoque;
		this.formato = formato;
		this.tamanhoArquivo = tamanhoArquivo;
		this.codigoProduto = codigoProduto;

	}
		public void ExibirInformaçoes() {
		System.out.println(
		"Nome  do produto:"+nome +"\n"+
		"Formato do Produto Digital:"+formato +"\n"+
		"Tamanho do arquivo:"+tamanhoArquivo +"\n"+
		"Preço do produto:"+preco +"\n"+
		"Quantidade do Produto:" +quantidadeStoque + "\n"+
                  "Codigo do Produto:" +codigoProduto + "\n");
	}
}

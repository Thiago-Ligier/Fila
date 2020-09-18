package elemento;

public class Elemento {
	private int valor;
	private Elemento proximo;
	
	public Elemento(int v) {
		this.valor =  v;
		this.proximo = null;
	}
	
	public void setProximo(Elemento e) {
		this.proximo = e;
	}
	
	public Elemento getProximo() {
		return this.proximo;
	}
	
	public int getValor() {
		return this.valor;
	}
	public void setValor(int v) {
		this.valor = v;
	}
	
	public void imprime() {
		System.out.println("Elemento: " + this.valor);
	}
}
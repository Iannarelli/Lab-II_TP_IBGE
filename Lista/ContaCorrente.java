public class ContaCorrente {

	private String titular;        // nome do titular da conta-corrente
    private int agencia;           // número da agência da conta-corrente
    private int numContaCorrente;  // número da conta-corrente

    private double saldo;          // saldo atual da conta-corrente

    public String getTitular() {
    	return (titular);
    }
    
    public void setTitular(String titular) {
    	this.titular = titular;
    }
    
    public int getAgencia() {
    	return (agencia);
    }
    
    public void setAgencia(int agencia) {
    	this.agencia = agencia;
    }
    
    public int getNumContaCorrente() {
    	return (numContaCorrente);
    }
    
    public void setNumContaCorrente(int cc) {
    	numContaCorrente = cc;
    }
    
    public double getSaldo() {
    	return (saldo);
    }
    
    public void setSaldo(double saldo) {
    	this.saldo = saldo;
    }
    
    // construtor que inicializa os atributos titular, agencia, numContaCorrente e saldo com os valores passados através dos parâmetros desse método.
    public ContaCorrente(String nome, int agencia, int numCC, double saldoInicial)
    {
        titular = nome;
        this.agencia = agencia;
        numContaCorrente = numCC;
        saldo = saldoInicial;
    }

    public ContaCorrente() {
    	titular = "";
    	agencia = 0;
    	numContaCorrente = 0;
    	saldo = 0; 	
    }
    
    // se o valor a ser creditado, passado como parâmetro para esse método, for positivo: incrementa o saldo da conta-corrente com o valor de crédito informado.
    public void depositar(double credito)
    {
        if (credito > 0)
        	saldo += credito;
        else
            System.out.println("O valor a ser creditado deve ser positivo.");
    }

    // se a quantia a ser sacada, passada como parâmetro para esse método, for positiva, e houver saldo suficiente: decrementa, do saldo atual da conta-corrente, a quantia informada.
    public void sacar(double saque)
    {
        if (saque > 0)
        {
            if ((saldo - saque) >= 0)
                saldo -= saque;
            else
                System.out.println("Não há saldo suficiente em conta-corrente para esse saque.");
        }
        else
            System.out.println("O valor a ser sacado deve ser positivo.");
    }
}

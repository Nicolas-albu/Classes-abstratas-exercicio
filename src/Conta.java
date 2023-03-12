public abstract class Conta {
    private int numeroConta;
    private String titularConta;
    private double saldo;
    private double limiteCredito;

    public abstract String getTipo();

    public abstract void saca(double valorDeSaque);

    public double getSaldo(){
        return this.saldo + this.limiteCredito;
    }

    public String getTitularConta() {
        return this.titularConta;
    }

    public int getNumeroConta() {
        return this.numeroConta;
    }

    public double getLimiteCredito() {
        return limiteCredito;
    }

    public void deposita(double valorDeposito){
        if(this.saldo < valorDeposito)
            throw new IllegalArgumentException("Valor de depósito maior que o saldo da conta");
        else
            this.saldo += valorDeposito;
    }

    public void transfere(Conta contaDestino, double valorTransferencia){
        if(this.getSaldo() < valorTransferencia)
            throw new IllegalArgumentException("Valor de transferência maior que o saldo da conta");
        else {
            this.saca(valorTransferencia);
            contaDestino.deposita(valorTransferencia);
        }
    }

    public void setTitularConta(String novoTitularConta){
        if(this.titularConta.equalsIgnoreCase(novoTitularConta))
            throw new IllegalArgumentException("Tentativa de inserção do mesmo titular da conta");
        else
            this.titularConta = novoTitularConta;
    }

    public void setNumeroConta(int novoNumeroConta){
        if(this.numeroConta == novoNumeroConta)
            throw new IllegalArgumentException("Tentativa de inserção do mesmo número da conta");
        else
            this.numeroConta = novoNumeroConta;
    }

    @Override
    public String toString(){
        return "Número da Conta: " + getNumeroConta()
                + "\nTítular: " + getTitularConta()
                + "\nSaldo: " + getSaldo()
                + "\nLimite de Crédito: " + getLimiteCredito();
    }

    public Conta(String novoTitularConta){
        this.setTitularConta(novoTitularConta);
    }

    public Conta(String novoTitularConta, int novoNumeroConta){
        this.setTitularConta(novoTitularConta);
        this.setNumeroConta(novoNumeroConta);
    }
}

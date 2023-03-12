public class ContaCorrente extends Conta {
    public ContaCorrente(String titularConta){
        super(titularConta);
    }

    public ContaCorrente(String titularConta, int numeroConta) {
        super(titularConta, numeroConta);
    }

    public String getTipo(){
        return "Conta Corrente";
    }

    public void saca(double valorSaque){

    }

}

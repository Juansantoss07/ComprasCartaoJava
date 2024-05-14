import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o limite do cartão: ");
        double limite = scanner.nextDouble();
        CartaoDeCredito cartao = new CartaoDeCredito(limite);


        int opcao = 1;
        while(opcao != 0){

            System.out.println("Digite a descrição da compra:");
            String descricaoCompra = scanner.next();

            System.out.println("Digite o valor da compra:");
            double valorCompra = scanner.nextDouble();

            Compra compra = new Compra(descricaoCompra, valorCompra);
            boolean compraRealizada = cartao.lancaCompra(compra);

            if(compraRealizada){
                System.out.println("Compra realizada!");
                System.out.println("Digite 0 para encerrar ou 1 para continuar");
                opcao = scanner.nextInt();
            } else {
                System.out.println("Saldo insulficiente.");
                System.out.println("Digite 0 para encerrar ou 1 para continuar");
                opcao = scanner.nextInt();
            }
        }

        System.out.println("----------COMPRAS REALIZADAS----------");
        for(Compra c : cartao.getCompras()){
            System.out.println("Produto: " + c.getDescricao() + " - Valor: " + c.getValor());
        }
    }
}

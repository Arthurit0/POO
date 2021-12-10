package ex1;

public class MDC implements IOperacaoInteira {

    public int executar(int valor1, int valor2) {
        int mdc = 1, maior;
        boolean divAconteceu;

        if(valor1 > valor2) maior = valor1; 
        else maior = valor2;

        do{
            divAconteceu = false;

        for (int i = 2; i <= maior; i++) {
            if((valor1 % i == 0) && (valor2 % i == 0)){
                divAconteceu = true;
                valor1 = valor1/i;
                valor2 = valor2/i;

                maior = maior/i;

                if(mdc == 1){
                    mdc = i;
                }else{
                    mdc = (mdc*i);
                }
            }
        }

        }while(divAconteceu);

        return mdc;
    }
    
}

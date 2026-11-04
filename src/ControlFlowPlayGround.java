public class ControlFlowPlayGround {
    public static void main(String[] args) {
        /**
         * developers can give the instructions to control the excution of the code
         * it's like giving directions to a person travelling
         * 1=> if and else statements
         * 2=> switch
         *  = ->assignemts
         *  == -> comparing the values
         */
        String str1 = "Eureka";
        //if condition
        if(str1 != null){ //this line true
           // System.out.println("lenght of the string:"+str1.length());
        }

        //if-else condition
        //I want to implement a randominvestment suggestion flow
        Stock sampelStock = new Stock("TSLA");
        //randomStockInvestMent(sampelStock);

        //switch block
        //randomStockInvestmentWithSwith(sampelStock);

        //ternary oprators
        double randomDouble = Math.random();//range is 0 to 1
        String someThing = randomDouble > 0.5 ? "Greater" : "Lesser";
                            //checking condition ? if : else
       // System.out.println(randomDouble);
        //System.out.println(someThing);
        if(randomDouble>0.5){
            someThing = "Greater";
        }else {
            someThing = "Lesser";
        }

        Stock TSLA = new Stock("TSLA");
        Stock MSFT = new Stock("TSLA");
        if(TSLA.equals(MSFT)) System.out.println("True");

        //this is TSLA and O outside object will MSFT


    }

    private static void randomStockInvestmentWithSwith(Stock sampelStock) {
        switch (sampelStock.getTickerSymbol()){
            case "TSLA":
                System.out.println("sell it"); break;//breaking the control flow if true
            case "MSFT":
                System.out.println("hold it"); break;
            case "NVDA":
                System.out.println("Buy it"); break;
            default:
                System.out.println("Unstable market");
        }
    }

    private static void randomStockInvestMent(Stock sampleStock){
        if(sampleStock.getTickerSymbol().equalsIgnoreCase("tsla")) System.out.println("Don't hold, Just sell it");
        else if (sampleStock.getTickerSymbol().equalsIgnoreCase("msft")) System.out.println("Hold it");
        else if (sampleStock.getTickerSymbol().equalsIgnoreCase("nvda")) System.out.println("BuyMore");
        else System.out.println("Market is not stable");
    }
}

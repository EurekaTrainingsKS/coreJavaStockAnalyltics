public class FirstProgram {
    public static void main(String[] args) {
        System.out.println("1st program on Intellj");
        //DataTypes primitives
        int a = 56;//Declaring the variable and assiging the values(intializing a values)
        int b; //decalring
        b = 44; //initaiting
        System.out.println(addition(a,b));
        System.out.println(substraction(a,b));
        //byte is capable of 128byte
        byte z = 127;
        int e = 1323;
        System.out.println(mutlipy(z,e));
        float c = 12.22f;
        float c1 = 23.33f;
        System.out.println(additionOfFloats(c,c1));
        double d = 30.00;
        short f = 11111;
        long g = 200;
        boolean h = true;
        // for example User management system
        // User age, int age(reserve), byte age(127). to avoid MemoryOutOfException.

        //creating an object
        //ClassName objectName = new(creates new object) Constrctor
        Stock firstStock = new Stock();
        firstStock.setSectorId(34);
        firstStock.setSubSectorId(219);
        firstStock.setTickerSymbol("AAPL");
        firstStock.setMarketCap(4000000);
        firstStock.setCurrentRatio(34.00);
        System.out.println(firstStock);

        Stock secondStock = new Stock(35,220,"NVDA",5000000,45.76);
        System.out.println(secondStock);

        Stock thirdStock = creatStockObject(37,221,"MSFT",450000,34.90);
        System.out.println(thirdStock);


    }

    private static Stock creatStockObject(int i, int i1, String msft, int i2, double v) {
        return new Stock(i,i1,msft,i2,v);
    }

    private static Stock creatStockObject() {
        return new Stock();
    }

    public static int substraction(int firstNum, int secondNum){
        return firstNum - secondNum;
    }

    public static int mutlipy(byte z, int e) {
        return z*e;
    }

    private static int addition(int a, int b) {
        return a+b;
    }

    private static float additionOfFloats(float a, float b){
        return a+b;
    }
}

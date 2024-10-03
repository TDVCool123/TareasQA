package calcService;

public class CalcAWS {
    CalcService calcService;
    //public CalculatorAWS(){
    //    calcService = new CalcService();
    //}


    public int getFact(int number){
        int f=1;
        for (int i = 1; i <= number; i++){
            f = calcService.mul(f,i);
        }
        return f;
    }


    // Paso 1 de mocks
    //public CalculatorAWS(CalcService calcService){
    //    this.calcService = calcService;
    //}
    // Or
    public void setCalcService(CalcService calcService){
        this.calcService = calcService;
    }
}

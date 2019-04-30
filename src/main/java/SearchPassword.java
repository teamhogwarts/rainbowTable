import java.math.BigInteger;

public class SearchPassword {

    private final String notFound = "NOT_FOUND";
   private RainbowTable rainbowTable;
   private String possibleEndValue;
   private int amountOfRounds;
   private String possiblePassword;

    public SearchPassword(RainbowTable rainbowTable) {
        this.rainbowTable = rainbowTable;
    }

    public String searchForPassword(BigInteger hashValue){

        if(!searchForEndValue(hashValue).equals(this.notFound)){
            String startValue = this.rainbowTable.getRainbowTable().inverse().get(this.possibleEndValue);
            this.possiblePassword = executeHashRoundFunction(startValue);
        }

        return possiblePassword == null ? this.notFound : this.possiblePassword;
    }

    private String executeHashRoundFunction(String startValue) {
        String result = startValue;

        for (int i = 0; i < this.amountOfRounds; i++) {
           result = this.rainbowTable.getReductionFunction().executeReductionFunction(this.rainbowTable.getHashFunction().MD5(result), i);
        }

        return result;
    }

    private String searchForEndValue(BigInteger hashValue){
        checkRow(hashValue);

        return (this.possibleEndValue == null) ? this.notFound : this.possibleEndValue;
    }

    private boolean checkRow(BigInteger hashValue) {
        int chainLength = this.rainbowTable.getChainLength();
        String endValue = this.notFound;

        int counter = 0;
        while (counter < chainLength &&  !this.rainbowTable.getRainbowTable().containsValue(endValue)){

            endValue = this.rainbowTable.getReductionFunction().executeReductionFunction(hashValue, chainLength - counter - 1);

            if (counter != 0){
                for (int i = counter; i > 0; i--) {
                    endValue = this.rainbowTable.getReductionFunction().executeReductionFunction(this.rainbowTable.getHashFunction().MD5(endValue), chainLength - i);
                }
            }

            this.amountOfRounds = chainLength - counter - 1;

            counter++;
        }

        if(this.rainbowTable.getRainbowTable().containsValue(endValue)){
            this.possibleEndValue = endValue;
            return true;
        }

        this.amountOfRounds = -1;
        return false;
    }
}

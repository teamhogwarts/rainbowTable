import java.math.BigInteger;

public class SearchPassword {

    private final String notFound = "NOT_FOUND";
   private RainbowTable rainbowTable;
   private String possibleEndValue;
    // 1d56a37fb6b08aa709fe90e12ca59e12  // HashValue von Vogt

    public SearchPassword(RainbowTable rainbowTable) {
        this.rainbowTable = rainbowTable;
    }

    public String searchForPassword(BigInteger hashValue){
//        if(!searchForEndValue(hashValue).equals(notFound)){
//
//        }

        return searchForEndValue(hashValue);
    }

    private String searchForEndValue(BigInteger hashValue){
        int sizeOfRainbowTable = rainbowTable.getRainbowTable().size();

        boolean found = false;
        int counter = 0;
        while (counter < sizeOfRainbowTable && !found){
            found = checkRow(hashValue);
            counter++;
        }

        return (this.possibleEndValue == null) ? this.notFound : this.possibleEndValue;
    }

    private boolean checkRow(BigInteger hashValue) {
        int chainLength = this.rainbowTable.getChainLength();
        String endValue = this.notFound;

        int counter = 0;
        while (counter < chainLength &&  !this.rainbowTable.getRainbowTable().containsValue(endValue)){
            int test = chainLength - counter - 1;
            endValue = this.rainbowTable.getReductionFunction().executeReductionFunction(hashValue, chainLength - counter - 1);

            if (counter != 0){
                for (int i = counter; i > 0; i--) {
                    endValue = this.rainbowTable.getReductionFunction().executeReductionFunction(this.rainbowTable.getHashFunction().MD5(endValue), chainLength - i);
                }
            }

            counter++;
        }

//        if(counter < chainLength){
//            this.possibleEndValue = endValue;
//            return true;
//        }

        if(this.rainbowTable.getRainbowTable().containsValue(endValue)){
            this.possibleEndValue = endValue;
            return true;
        }

        return false;
    }
}

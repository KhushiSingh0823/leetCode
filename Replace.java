public class Replace {
    public int chalkReplacer(int[] chalk, int initialChalkPieces) {
        long totalChalkNeeded = 0;
        for (int studentChalkUse : chalk) {
            totalChalkNeeded += studentChalkUse;
        }
        
        int remainingChalk = (int)(initialChalkPieces % totalChalkNeeded);
        
        for (int studentIndex = 0; studentIndex < chalk.length; studentIndex++) {
            if (remainingChalk < chalk[studentIndex]) {
                return studentIndex;
            }
            remainingChalk -= chalk[studentIndex];
        }
        
        return 0;  
    }

    public static void main(String[] args) {
        Replace replace = new Replace();
        int[] chalk = {5, 1, 5};
        int initialChalkPieces = 22; 
        int result = replace.chalkReplacer(chalk, initialChalkPieces);
        System.out.println("The index of the student who will run out of chalk first is: " + result);
    }
}
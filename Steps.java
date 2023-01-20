
import java.io.*;
import java.io.ObjectInputFilter.Status;
import java.util.ArrayList;
import java.util.Collections;;

class Steps {

    static int MonthlySteps[] = {29,27,30,29,30,29,30,30,29,30,29,30};
    static String Months[] = {"January","February","March","April","May","June","July","August","September","October","November","Decemver"};

    //Static method that Does the average of Steps in A month and stores the average to the Monthly Average Steps ArrayList
    static void QuantizeSteps(ArrayList<Integer> DailySteps, ArrayList<Integer> MonthlyAverageSteps) {
        for (int i=0; i<12; i++){
            int Sum = 0;
            for(int j=0; j<DailySteps.size(); j++) {
                if(j<=MonthlySteps[i]){
                    Sum += DailySteps.get(j);
        
                }else{
                    continue;
                }
            }
            MonthlyAverageSteps.add((Sum/MonthlySteps[i]));
        }

    }

    //Output of the monthly average steps and Least and Most Average Steps
    static void DisplaySteps(ArrayList<Integer> ArverageSteps){
        for(int i=0; i<12; i++) {
            System.out.println("Average steps for "+Months[i]+": "+ArverageSteps.get(i));
        }

        Integer maxVal = Collections.max(ArverageSteps);
        int maxIndex = ArverageSteps.indexOf(maxVal);   
        
        Integer minVal = Collections.min(ArverageSteps);
        int minIndex = ArverageSteps.indexOf(minVal);
        
        System.out.println("Most Average steps taken in "+Months[maxIndex] +": "+ArverageSteps.get(maxIndex));
        System.out.println("Least Average steps taken in "+Months[minIndex] +": "+ArverageSteps.get(minIndex));
    }

    public static void main(String args[]) {

        ArrayList<Integer> DailySteps= new ArrayList<Integer>(265);
        ArrayList<Integer> MonthlyAverageSteps = new ArrayList<Integer>(12);
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader("steps.txt"));
            String line = reader.readLine();

            while (line != null) {
                DailySteps.add(Integer.parseInt(line));
                line = reader.readLine();
            }
        
            reader.close();

        } catch (IOException e){
            e.printStackTrace();
        }

        QuantizeSteps(DailySteps, MonthlyAverageSteps);
        DisplaySteps(MonthlyAverageSteps);

    }
}
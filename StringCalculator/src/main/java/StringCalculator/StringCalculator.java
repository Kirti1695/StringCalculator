package StringCalculator;

import java.util.ArrayList;
public class StringCalculator {
    static int add(String input){
        if(input.isEmpty())
            return 0;

        if(input.contains("//")){

            String[] arr = input.split("\n");
            String delimiter = arr[0].substring(2);
            input = arr[1].replaceAll(delimiter,",");

        }
        if(input.contains("\n")){

            input = input.replace("\n",",");
        }
        if(input.contains(",")){

            String[] numbers = input.split(",");
            ArrayList<Integer> negatives = new ArrayList<>();
            int sum_of_numbers = 0;
            for(int i = 0 ; i<numbers.length; i++){
                int x = Integer.parseInt(numbers[i]);
                if(x<0){
                    negatives.add(x);
                }
                sum_of_numbers+=x;
            }
            if(negatives.size()>0){
                throw new RuntimeException("Negatives not Allowed : "+ negatives);
            }
            return sum_of_numbers;

        }
        else
            return Integer.parseInt(input);
    }
}
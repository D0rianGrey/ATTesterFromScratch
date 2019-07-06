package Practice;

import org.apache.tools.ant.taskdefs.Java;

import java.util.ArrayList;
import java.util.List;

public class JavaRush {


    public static void main(String[] args) {

        int number = 546;

        List<Integer> nums = new ArrayList<>();
        while (number != 0) {
            nums.add(number % 10);
            number /= 10;
        }


    }
}




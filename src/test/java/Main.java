
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by katiemi on 2017/9/20.
 */
public class Main {
    List<Integer> stack = new ArrayList<Integer>();
    private int min = Integer.MAX_VALUE;
    private int min2 = min;
    private int max = Integer.MIN_VALUE;
    private int max2 = max;
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        Main main = new Main();
        for(int i=0;i<len;i++){
            main.push(sc.nextInt());
        }
        main.pop();
        System.out.printf(main.max()+","+main.min());
    }
    public void push(int data){
        if(data <= min){
            min2 = min;
            min = data;
        }
        if(data >= max){
            max2 = max;
            max = data;
        }
        stack.add(data);
    }
    public int pop(){
        int pop = stack.remove(stack.size()-1);
        if(pop==min){
            min = min2;
        }
        if(pop == max){
            max = max2;
        }
        return pop;
    }
    public int min(){
        return min;
    }
    public int max(){
        return max;
    }
}
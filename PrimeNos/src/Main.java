import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void printPrimeNos(int num){
        List<Integer> primeNosArray=new ArrayList<Integer>();
        primeNosArray.add(2);
        for (int i = 3; i <= num; i++) {
            boolean flag=false;
            for(int j=2;j*j<i;j++){
                if(i%j==0){
                    flag=false;
                    break;
                }
                flag=true;
            }
            if(flag){
               primeNosArray.add(i);
            }
        }
        System.out.print(primeNosArray.toString());
    }


    public static void main(String[] args) {
        printPrimeNos(17);
    }
}
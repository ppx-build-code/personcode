
public class Mul {


    public static String mul(String n1, String n2){

        char [] n1s = n1.toCharArray();
        char [] n2s = n2.toCharArray();
        int[] res = new int[n1s.length + n2s.length];
        for(int i =0; i < res.length; i ++){
            res[i] = 0;
        }
        for(int i = n1s.length - 1; i >= 0; i --){
            for(int j = n2s.length - 1; j >= 0; j --){
                int mul = (n1s[i] - '0') * (n2s[j] - '0');
                int p1= (i + j);int p2 = i +j + 1;
                int sum = mul + res[p2];
                res[p1] += sum / 10;
                res[p2] = sum % 2;
            }
        }
        int i = 0;
        while(i < res.length && res[i] != 0){
            i ++;
        }
        String result = "";
        for(; i < res.length; i ++){
            result.concat(res[i] + "");
        }
        return result;
    }

    public static void main(String [] args) {
        System.out.println("start.");
        System.out.print(Mul.mul("432", "21"));
    }
    
}
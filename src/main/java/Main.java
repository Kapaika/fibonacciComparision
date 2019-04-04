import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    private static Long fibonacciRecursively(Integer n){

        if(n==null) throw new NullPointerException();
        if(n<0) throw new IllegalArgumentException("Ciąg fibonacciego zaczyna się od 0");
        if(n<2) return Long.valueOf(n);
        else return fibonacciRecursively(n-2) + fibonacciRecursively(n-1);

    }

    private static Integer fibonacciIterativelyInAnArray(Integer n){

        if(n==null) throw new NullPointerException();
        if(n<0) throw new IllegalArgumentException("Ciąg fibonacciego zaczyna się od 0");

        int[] tab = new int[n+2];
        tab[0] = 0;
        tab[1] = 1;

        for(int i=2; i<=n;i++){
            tab[i] = tab[i-2] + tab[i-1];
        }

        return tab[n];
    }

    private static Long fibonacciFromForumula(Integer n){

        if(n==null) throw new NullPointerException();
        if(n<0) throw new IllegalArgumentException("Ciąg fibonacciego zaczyna się od 0");

        double phi = (1 + Math.sqrt(5)) / 2;
        return  Math.round(Math.pow(phi, n)
                / Math.sqrt(5));

    }

    private static Integer fibonacciByStream(Integer n){

            List<Integer> list = Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                    .limit(n+1)
                    .map(t -> t[0])
                    .collect(Collectors.toList());

            return list.get(n);

    }

    private static Long fibonacciIterative(int n){

            long n2 = 0;
            long n1 = 1;
            long tmp;

            for (int i = n ; i>=2 ; i--) {
                tmp = n2;
                n2 = n1;
                n1 = n1 + tmp;
            }
            return n2 + n1;

    }

    public static void main(String[] args) {

    }
}

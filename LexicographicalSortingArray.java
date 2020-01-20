import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LexicographicalSortingArray {
    public static void main(String[] args) {
//        String grid[] = {"ebacd", "fghij","olmkn","trpqs","xywuv"};
        String msg = "YES";
        String grid[] = {"kc", "iu"};
        List<String> list = Arrays.stream(grid).map(str->
                {
                    char[] cArr = str.toCharArray();
                    Arrays.sort(cArr);
                   String s = Arrays.asList(cArr).stream().map(String::valueOf).collect(Collectors.joining());
                    System.out.println(s);
                    return s;
                }
        ).collect(Collectors.toList());

        System.out.println(list);
        for(int i=0;i<grid[0].length();i++) {
            out:
            for(int j=1;j<grid.length;j++) {
                String currStr = list.get(j);
                String preStr = list.get(j-1);
                if(preStr.charAt(i)>currStr.charAt(i)) {
                    msg = "No";
                    break out;
                }
            }
        }
        System.out.println(msg);



    }
}



import java.io.*;
import java.util.Arrays;


public class main {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub

        //private instance variables
        MergeSort _mergeSort = new MergeSort();

        //InputStreamReader는 한 문자씩 읽지만, 버퍼링을 하게 되면 IO스트림으로부터 미리 버퍼에 데이터를 갖다놓기 때문에 효율적으로 IO가능
        FileReader fileReader = new FileReader("./data02.txt");
        //버퍼에 넣기위한 FileReader, 파일 경로 지정해줌
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        //aFile의 데이터를 버퍼에 넣음(한 줄씩 읽기위해)
        FileWriter fileWriter = new FileWriter("./result02.txt");



        String s = bufferedReader.readLine();
        String[] s1 = s.split(",");


        //Integer[] dataSet = Arrays.asList(s1).mapToInt(Integer::parseInt).toArray();
        int[] dataSet  = new int[s1.length];
        //정렬할 dataSet의 배열 s1의 길이만큼 선언
        int i = 0;
        for(String str:s1) {//for each문(리스트의 모든 원소를 순차적으로 접근함)
            try {
                dataSet[i] = Integer.parseInt(str);//각 str마다 parseInt함
                i++;
            }catch(NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }

        _mergeSort.sort(dataSet);

        for(Integer data:dataSet) {//정렬된 dataSet을 파일에 써줌
            String writeData = data.toString() + ",";
            fileWriter.write(writeData);
        }


        fileReader.close();
        fileWriter.close();



    }

}

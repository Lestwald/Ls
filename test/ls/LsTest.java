package ls;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LsTest {
    @Test
    public void r() throws Exception {
        List<List<String>> listOfFiles = new ArrayList<>();

        List<String> sublist1 = new ArrayList<>();
        sublist1.add("file6.txt");
        listOfFiles.add(sublist1);

        List<String> sublist2 = new ArrayList<>();
        sublist2.add("file5.txt");
        listOfFiles.add(sublist2);

        List<String> sublist3 = new ArrayList<>();
        sublist3.add("file4.txt");
        listOfFiles.add(sublist3);

        List<String> sublist4 = new ArrayList<>();
        sublist4.add("file3.txt");
        listOfFiles.add(sublist4);

        List<String> sublist5 = new ArrayList<>();
        sublist5.add("file2.txt");
        listOfFiles.add(sublist5);

        List<String> sublist6 = new ArrayList<>();
        sublist6.add("file1.txt");
        listOfFiles.add(sublist6);

        List<String> sublist7 = new ArrayList<>();
        sublist7.add("dir4");
        listOfFiles.add(sublist7);

        List<String> sublist8 = new ArrayList<>();
        sublist8.add("dir3");
        listOfFiles.add(sublist8);

        List<String> sublist9 = new ArrayList<>();
        sublist9.add("dir2");
        listOfFiles.add(sublist9);

        List<String> sublist10 = new ArrayList<>();
        sublist10.add("dir1");
        listOfFiles.add(sublist10);

        Ls ls1 = new Ls(new File("for_tests/files"));
        ls1.r();
        assertEquals(listOfFiles, ls1.resultList);

        listOfFiles.clear();
        listOfFiles.add(sublist5);
        Ls ls2 = new Ls(new File("for_tests/files/file2.txt"));
        ls2.r();
        assertEquals(listOfFiles, ls2.resultList);
    }

    @Test
    public void l() throws Exception {
        List<List<String>> listOfFiles = new ArrayList<>();

        List<String> sublist1 = new ArrayList<>();
        sublist1.add("111");
        sublist1.add(String.format("%12s", "1111300"));
        sublist1.add("Apr 01 21:06 2017");
        sublist1.add("dir1");
        listOfFiles.add(sublist1);

        List<String> sublist2 = new ArrayList<>();
        sublist2.add("111");
        sublist2.add(String.format("%12s", "113396"));
        sublist2.add("Apr 01 21:06 2017");
        sublist2.add("dir2");
        listOfFiles.add(sublist2);

        List<String> sublist3 = new ArrayList<>();
        sublist3.add("111");
        sublist3.add(String.format("%12s", "129675"));
        sublist3.add("Apr 01 21:06 2017");
        sublist3.add("dir3");
        listOfFiles.add(sublist3);

        List<String> sublist4 = new ArrayList<>();
        sublist4.add("111");
        sublist4.add(String.format("%12s", "57502"));
        sublist4.add("Apr 01 21:06 2017");
        sublist4.add("dir4");
        listOfFiles.add(sublist4);

        List<String> sublist5 = new ArrayList<>();
        sublist5.add("111");
        sublist5.add(String.format("%12s", "2428"));
        sublist5.add("Apr 01 17:22 2017");
        sublist5.add("file1.txt");
        listOfFiles.add(sublist5);

        List<String> sublist6 = new ArrayList<>();
        sublist6.add("111");
        sublist6.add(String.format("%12s", "105298"));
        sublist6.add("Apr 01 17:22 2017");
        sublist6.add("file2.txt");
        listOfFiles.add(sublist6);

        List<String> sublist7 = new ArrayList<>();
        sublist7.add("111");
        sublist7.add(String.format("%12s", "8098"));
        sublist7.add("Apr 01 17:22 2017");
        sublist7.add("file3.txt");
        listOfFiles.add(sublist7);

        List<String> sublist8 = new ArrayList<>();
        sublist8.add("111");
        sublist8.add(String.format("%12s", "28348"));
        sublist8.add("Apr 01 17:22 2017");
        sublist8.add("file4.txt");
        listOfFiles.add(sublist8);

        List<String> sublist9 = new ArrayList<>();
        sublist9.add("111");
        sublist9.add(String.format("%12s", "56698"));
        sublist9.add("Apr 01 17:23 2017");
        sublist9.add("file5.txt");
        listOfFiles.add(sublist9);

        List<String> sublist10 = new ArrayList<>();
        sublist10.add("111");
        sublist10.add(String.format("%12s", "403"));
        sublist10.add("Apr 01 17:23 2017");
        sublist10.add("file6.txt");
        listOfFiles.add(sublist10);

        Ls ls1 = new Ls(new File("for_tests/files"));
        ls1.l();
        assertEquals(listOfFiles, ls1.resultList);

        listOfFiles.clear();
        listOfFiles.add(sublist6);
        Ls ls2 = new Ls(new File("for_tests/files/file2.txt"));
        ls2.l();
        assertEquals(listOfFiles, ls2.resultList);
    }

    @Test
    public void h() throws Exception {
        List<List<String>> listOfFiles = new ArrayList<>();

        List<String> sublist1 = new ArrayList<>();
        sublist1.add("rwx");
        sublist1.add(String.format("%8s", "1.06M"));
        sublist1.add("Apr 01 21:06 2017");
        sublist1.add("dir1");
        listOfFiles.add(sublist1);

        List<String> sublist2 = new ArrayList<>();
        sublist2.add("rwx");
        sublist2.add(String.format("%8s", "110.74K"));
        sublist2.add("Apr 01 21:06 2017");
        sublist2.add("dir2");
        listOfFiles.add(sublist2);

        List<String> sublist3 = new ArrayList<>();
        sublist3.add("rwx");
        sublist3.add(String.format("%8s", "126.64K"));
        sublist3.add("Apr 01 21:06 2017");
        sublist3.add("dir3");
        listOfFiles.add(sublist3);

        List<String> sublist4 = new ArrayList<>();
        sublist4.add("rwx");
        sublist4.add(String.format("%8s", "56.15K"));
        sublist4.add("Apr 01 21:06 2017");
        sublist4.add("dir4");
        listOfFiles.add(sublist4);

        List<String> sublist5 = new ArrayList<>();
        sublist5.add("rwx");
        sublist5.add(String.format("%8s", "2.37K"));
        sublist5.add("Apr 01 17:22 2017");
        sublist5.add("file1.txt");
        listOfFiles.add(sublist5);

        List<String> sublist6 = new ArrayList<>();
        sublist6.add("rwx");
        sublist6.add(String.format("%8s", "102.83K"));
        sublist6.add("Apr 01 17:22 2017");
        sublist6.add("file2.txt");
        listOfFiles.add(sublist6);

        List<String> sublist7 = new ArrayList<>();
        sublist7.add("rwx");
        sublist7.add(String.format("%8s", "7.91K"));
        sublist7.add("Apr 01 17:22 2017");
        sublist7.add("file3.txt");
        listOfFiles.add(sublist7);

        List<String> sublist8 = new ArrayList<>();
        sublist8.add("rwx");
        sublist8.add(String.format("%8s", "27.68K"));
        sublist8.add("Apr 01 17:22 2017");
        sublist8.add("file4.txt");
        listOfFiles.add(sublist8);

        List<String> sublist9 = new ArrayList<>();
        sublist9.add("rwx");
        sublist9.add(String.format("%8s", "55.37K"));
        sublist9.add("Apr 01 17:23 2017");
        sublist9.add("file5.txt");
        listOfFiles.add(sublist9);

        List<String> sublist10 = new ArrayList<>();
        sublist10.add("rwx");
        sublist10.add(String.format("%8s", "403.00B"));
        sublist10.add("Apr 01 17:23 2017");
        sublist10.add("file6.txt");
        listOfFiles.add(sublist10);

        Ls ls1 = new Ls(new File("for_tests/files"));
        ls1.h();
        assertEquals(listOfFiles, ls1.resultList);

        listOfFiles.clear();
        listOfFiles.add(sublist6);
        Ls ls2 = new Ls(new File("for_tests/files/file2.txt"));
        ls2.h();
        assertEquals(listOfFiles, ls2.resultList);
    }

    @Test
    public void o() throws Exception {
        Ls ls = new Ls(new File("for_tests/files"));
        ls.o("for_tests/output.txt", ls.resultList);

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader("for_tests/output.txt"));
        String st;
        while ((st = br.readLine()) != null) {
            sb.append(st);
            sb.append("\n");
        }
        assertEquals("dir1\ndir2\ndir3\ndir4\nfile1.txt\nfile2.txt\n" +
                "file3.txt\nfile4.txt\nfile5.txt\nfile6.txt\n", sb.toString());
    }
}
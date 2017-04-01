package ls;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;

class Ls {
    private List<File> listOfFiles;
    List<List<String>> resultList;

    Ls(final File file) {
        listOfFiles = new ArrayList<>();
        resultList = new ArrayList<>();
        if (file.isDirectory()) {
            for (final File element : file.listFiles()) {
                this.listOfFiles.add(element);
                List<String> sublist = new ArrayList<>();
                sublist.add(element.getName());
                resultList.add(sublist);
            }
        } else if (file.isFile()) {
            List<String> sublist = new ArrayList<>();
            this.listOfFiles.add(file);
            sublist.add(file.getName());
            resultList.add(sublist);
        } else System.out.println("File does not exist.");
    }

    void r() {
        Collections.reverse(resultList);
    }

    void l() {
        List<List<String>> result = new ArrayList<>();
        for (final File element : listOfFiles) {
            List<String> sublist = new ArrayList<>();
            sublist.add(toBitmask(element.canRead(), element.canWrite(), element.canExecute()));
            sublist.add(String.format("%12s", String.valueOf(fileSize(element))));
            sublist.add(new SimpleDateFormat("MMM dd HH:mm yyyy", Locale.ENGLISH).
                    format(new Date(element.lastModified())));
            sublist.add(element.getName());
            result.add(sublist);
        }
        resultList = result;
    }

    void h() {
        List<List<String>> result = new ArrayList<>();
        for (final File element : listOfFiles) {
            List<String> sublist = new ArrayList<>();
            sublist.add(toRWX(element.canRead(), element.canWrite(), element.canExecute()));
            sublist.add(String.format("%8s", toKMG(fileSize(element))));
            sublist.add(new SimpleDateFormat("MMM dd HH:mm yyyy", Locale.ENGLISH).
                    format(new Date(element.lastModified())));
            sublist.add(element.getName());
            result.add(sublist);
        }
        resultList = result;
    }

    void o(final String outputFileName, final List<List<String>> list) throws IOException {
        File outputFile = new File(outputFileName);
        PrintWriter out = new PrintWriter(outputFile.getAbsoluteFile());
        for (final List<String> sublist : list) {
            for (int i = 0; i < sublist.size(); i++) {
                out.print(sublist.get(i));
                if (i < sublist.size() - 1) out.print("  ");
            }
            out.println();
        }
        out.close();
    }

    void print(final List<List<String>> list) {
        for (final List<String> sublist : list) {
            for (int i = 0; i < sublist.size(); i++) {
                System.out.print(sublist.get(i));
                if (i < sublist.size() - 1) System.out.print("  ");
            }
            System.out.println();
        }
    }

    private long fileSize(final File file) {
        long size = 0;
        if (file.isFile()) size = file.length();
        else {
            for (final File subFile : file.listFiles()) {
                if (file.isFile())
                    size += subFile.length();
                else
                    size += fileSize(subFile);
            }
        }
        return size;
    }

    private String toKMG(final long sizeInBytes) {
        float size = sizeInBytes;
        int k = 0;
        String b = "B";
        while (size >= 1024) {
            size /= 1024;
            k++;
        }
        switch (k) {
            case 1:
                b = "K";
                break;
            case 2:
                b = "M";
                break;
            case 3:
                b = "G";
        }
        return String.format(Locale.ENGLISH, "%.2f", size) + b;
    }

    private String toBitmask(final Boolean r, final Boolean w, final Boolean x) {
        String result = "";
        if (r) result += "1";
        else result += "0";
        if (w) result += "1";
        else result += "0";
        if (x) result += "1";
        else result += "0";
        return result;
    }

    private String toRWX(final Boolean r, final Boolean w, final Boolean x) {
        String result = "";
        if (r) result += "r";
        else result += "-";
        if (w) result += "w";
        else result += "-";
        if (x) result += "x";
        else result += "-";
        return result;
    }
}
package ls;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.*;

public class Ls {
    private List<File> listOfFiles;

    public Ls(final File file) {
        listOfFiles = new ArrayList<>();
        if (file.isDirectory()) Collections.addAll(this.listOfFiles, file.listFiles());
        else if (file.isFile()) this.listOfFiles.add(file);
    }

    public List<List<String>> ls(final Boolean l, final Boolean h, final Boolean r) {
        List<List<String>> result = new ArrayList<>();
        for (final File file : listOfFiles) {
            result.add(fileInformation(file, l, h));
        }
        if (r) Collections.reverse(result);
        return result;
    }

    public void output(final String o, final List<List<String>> list) throws IOException {
        PrintStream out;
        if (o != null) out = new PrintStream(new File(o));
        else out = System.out;
        for (final List<String> sublist : list) {
            for (int i = 0; i < sublist.size(); i++) {
                out.print(sublist.get(i));
                if (i < sublist.size() - 1) out.print("  ");
            }
            out.println();
        }
    }

    private List<String> fileInformation(final File file, final Boolean l, final Boolean h) {
        List<String> list = new ArrayList<>();
        if (l && h) {
            list.add(S.toRWX(file.canRead(), file.canWrite(), file.canExecute()));
            list.add(String.format("%8s", S.toKMG(S.fileSize(file))));
        } else if (l) {
            list.add(S.toBitmask(file.canRead(), file.canWrite(), file.canExecute()));
            list.add(String.format("%12s", String.valueOf(S.fileSize(file))));
        }
        if (l) list.add(new SimpleDateFormat("MMM dd HH:mm yyyy", Locale.ENGLISH).
                format(new Date(file.lastModified())));
        list.add(file.getName());
        return list;
    }
}
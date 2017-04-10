package ls;

import java.io.File;
import java.util.Locale;

public class S {
    static long fileSize(final File file) {
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

    static String toKMG(final long sizeInBytes) {
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
                break;
            case 4:
                b = "T";
                break;
        }
        return String.format(Locale.ENGLISH, "%.2f%s", size, b);
    }

    static String toBitmask(final Boolean r, final Boolean w, final Boolean x) {
        String result = "";
        if (r) result += "1";
        else result += "0";
        if (w) result += "1";
        else result += "0";
        if (x) result += "1";
        else result += "0";
        return result;
    }

    static String toRWX(final Boolean r, final Boolean w, final Boolean x) {
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
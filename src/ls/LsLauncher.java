package ls;

import org.kohsuke.args4j.*;

import java.io.File;
import java.io.IOException;

public class LsLauncher {
    @Option(name = "-l")
    private boolean l;

    @Option(name = "-h")
    private boolean h;

    @Option(name = "-r")
    private boolean r;

    @Option(name = "-o")
    private String o;

    @Argument(required = true)
    private String nameOfFile;

    public static void main(String[] args) {
        new LsLauncher().launch(args);
    }

    private void launch(String[] args) {
        CmdLineParser parser = new CmdLineParser(this);
        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            System.err.println("ls [-l] [-h] [-r] [-o output.file] directory_or_file");
            return;
        }

        Ls ls = new Ls(new File(nameOfFile));
        if (h) ls.h();
        else if (l) ls.l();
        if (r) ls.r();
        if (o != null) {
            try {
                ls.o(o, ls.resultList);
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        } else
            ls.print(ls.resultList);
    }
}
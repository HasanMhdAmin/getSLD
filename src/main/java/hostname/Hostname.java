package hostname;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hasan Mhd Amin
 **/

public class Hostname {

    public static String getHostname(String url) {
        String domainName;
        try {
            domainName = getDomainName(url);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        String[] lines;
        try {
            lines = readLines("effective_tld_names.txt");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        String result = "";
        for (String line : lines) {
            if (!line.startsWith("//") && line.length() != 0) {
                line = "." + line;
                if (domainName.endsWith(line)) {
                    result = domainName.substring(0, domainName.length() - line.length());
                }
            }
        }

        // get the hostname without subdomains
        String[] parts = result.split("\\.");
        if (parts.length > 0)
            result = parts[parts.length - 1];

        return result;
    }

    private static String getDomainName(String myUrl) {
        String domainName = myUrl;

        int index = domainName.indexOf("://");

        if (index != -1) {
            // keep everything after the "://"
            domainName = domainName.substring(index + 3);
        }

        index = domainName.indexOf('/');

        if (index != -1) {
            // keep everything before the '/'
            domainName = domainName.substring(0, index);
        }

        // check for and remove a preceding 'www'
        // followed by any sequence of characters (non-greedy)
        // followed by a '.'
        // from the beginning of the string
        domainName = domainName.replaceFirst("^www.*?\\.", "");

        return domainName;
    }

    private static String[] readLines(String filename) throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classloader.getResourceAsStream(filename);
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);

        BufferedReader bufferedReader = new BufferedReader(streamReader);
        List<String> lines = new ArrayList<String>();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        bufferedReader.close();
        return lines.toArray(new String[lines.size()]);
    }

}

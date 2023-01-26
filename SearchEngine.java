import java.io.IOException;
import java.net.URI;

String[] stringList;

class Handler implements URLHandler {

    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) {
            return null;
        }
        else if (url.getPath().contains("/add")) {
            String[] parameters = url.getQuery().split("=");
            stringList.add(parameters[1]);
            return null;
        }
        else if (url.getPath().contains("/search")) {
            String[] returnList;
            String[] parameters = url.getQuery().split("=");
            for (int i = 0; i < stringList.length; i++) {
                if (stringList[i].contains(parameters[1])) {
                    returnList.add(stringList[i]);
                }
            }
            return returnList;
        }
    }
}

class SearchEngine {
    public static void main (String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try an number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}
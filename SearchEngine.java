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
            stringList.append(parameters[1]);
            return null;
        }
        else if (url.getPath().contains("/search")) {
            String[] returnList;
            String[] parameters = url.getQuery().split("=");
            
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
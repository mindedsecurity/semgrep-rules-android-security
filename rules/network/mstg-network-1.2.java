// ruleid: MSTG-NETWORK-1.1

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSession;
import java.io.IOException;
import java.net.InetSocketAddress;

public class SSLSocketExample {

    public static void main(String[] args) throws IOException {
        SSLSocket sslSocket = createSSLSocket("example.com", 443);
        SSLSession sslSession = sslSocket.getSession();
        String hostname = sslSession.getPeerHost();
        sslSocket.close();
    }

    private static SSLSocket createSSLSocket(String host, int port) throws IOException {
        SSLSocket sslSocket = (SSLSocket) SSLSocketFactory.getDefault().createSocket();
        sslSocket.connect(new InetSocketAddress(host, port));
        return sslSocket;
    }
}

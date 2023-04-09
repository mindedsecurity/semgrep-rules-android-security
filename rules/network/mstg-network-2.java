import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private SSLSocketFactory defaultSslSocketFactory(X509TrustManager trustManager)
    throws NoSuchAlgorithmException, KeyManagementException {
        // this should not be matched
        SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
        sslContext.init(null, new TrustManager[] { trustManager }, null);
        return sslContext.getSocketFactory();
    }

    private SSLSocketFactory defaultSslSocketFactory1(X509TrustManager trustManager)
    throws NoSuchAlgorithmException, KeyManagementException {
        // this should be matched
        SSLContext sslContext = SSLContext.getInstance("TLSv1.1");
        sslContext.init(null, new TrustManager[] { trustManager }, null);
        return sslContext.getSocketFactory();
    }

    private SSLSocketFactory defaultSslSocketFactory2(X509TrustManager trustManager)
    throws NoSuchAlgorithmException, KeyManagementException {
        // this should be matched
        SSLContext sslContext = SSLContext.getInstance("TLSv1");
        sslContext.init(null, new TrustManager[] { trustManager }, null);
        return sslContext.getSocketFactory();
    }

    private SSLSocketFactory defaultSslSocketFactory3(X509TrustManager trustManager)
    throws NoSuchAlgorithmException, KeyManagementException {
        // this should not be matched
        SSLContext sslContext = SSLContext.getInstance("TLSv1.3");
        sslContext.init(null, new TrustManager[] { trustManager }, null);
        return sslContext.getSocketFactory();
    }

    private SSLSocketFactory defaultSslSocketFactory4(X509TrustManager trustManager)
    throws NoSuchAlgorithmException, KeyManagementException {
        // this should be matched
        SSLContext sslContext = SSLContext.getInstance("SSL");
        sslContext.init(null, new TrustManager[] { trustManager }, null);
        return sslContext.getSocketFactory();
    }

    private SSLSocketFactory defaultSslSocketFactory5(X509TrustManager trustManager)
    throws NoSuchAlgorithmException, KeyManagementException {
        // this should be matched
        SSLContext sslContext = SSLContext.getInstance("SSLv3");
        sslContext.init(null, new TrustManager[] { trustManager }, null);
        return sslContext.getSocketFactory();
    }

    public Socket createSocket(InetAddress address, int port, InetAddress localAddress, int localPort) throws IOException
	{
        // unrecommended cipher added via array static initialization
        String[] weakCiphers = {"SSL_RSA_WITH_RC4_128_MD5"};
		if (g_IOException != null)
			throw g_IOException;
		SSLSocket s = (SSLSocket)g_factory.createSocket(address, port, localAddress, localPort);
        // this should be matched
		s.setEnabledCipherSuites(weakCiphers);
		return s;
    }

    public Socket createSocket1(InetAddress address, int port, InetAddress localAddress, int localPort) throws IOException
	{
        String[] weakCiphers = new String[2];
        for (int i=0;i < a.length; i++) {
            // unrecommended cipher added via string array
            weakCiphers[i] = "SSL_RSA_WITH_RC4_128_MD5";
        }
		if (g_IOException != null)
			throw g_IOException;
		SSLSocket s = (SSLSocket)g_factory.createSocket(address, port, localAddress, localPort);
        // this should be matched
		s.setEnabledCipherSuites(weakCiphers);
		return s;
    }

    public Socket createSocket2(InetAddress address, int port, InetAddress localAddress, int localPort) throws IOException
	{
        ArrayList<String> weakCiphers = new ArrayList<>();
        // unrecommended cipher added via arrayList.add
        weakCiphers.add("SSL_RSA_WITH_RC4_128_MD5");
		if (g_IOException != null)
			throw g_IOException;
		SSLSocket s = (SSLSocket)g_factory.createSocket(address, port, localAddress, localPort);
        // this should be matched
		s.setEnabledCipherSuites(weakCiphers.toArray());
		return s;
    }

    public Socket createSocket3(InetAddress address, int port, InetAddress localAddress, int localPort) throws IOException
	{
        ArrayList<String> mixCiphers = new ArrayList<>();
        // mixed ciphers added via arrayList.addAll
        String[] mixedStrenghtCiphers = {
            // unrecommended
            "SSL_RSA_WITH_RC4_128_MD5",
            // recommended
            "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384",
        };
        mixCiphers.addAll(mixedStrenghtCiphers);
		if (g_IOException != null)
			throw g_IOException;
		SSLSocket s = (SSLSocket)g_factory.createSocket(address, port, localAddress, localPort);
        // this should be matched but does not because taint source is not detected (unrecommended cipher is matched but pattern-not negates the match. finding a way to match directly the unrecommended ciphers would fix this.)
		s.setEnabledCipherSuites(mixCiphers.toArray());
		return s;
    }

    public Socket createSocket4(InetAddress address, int port, InetAddress localAddress, int localPort) throws IOException
	{
        ArrayList<String> weakCiphers = new ArrayList<>();
        String[] b = new String[2];
        for (int i=0;i < a.length; i++) {
            // recommended cipher added via string array
            b[i] = "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384";
        }
		if (g_IOException != null)
			throw g_IOException;
		SSLSocket s = (SSLSocket)g_factory.createSocket(address, port, localAddress, localPort);
        // this should not be matched
		s.setEnabledCipherSuites(b);
		return s;
    }

    public Socket createSocket5(InetAddress address, int port, InetAddress localAddress, int localPort) throws IOException
	{
        ArrayList<String> strongCiphers = new ArrayList<>();
        // recommended cipher added via arrayList.add
        strongCiphers.add("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384");
		if (g_IOException != null)
			throw g_IOException;
		SSLSocket s = (SSLSocket)g_factory.createSocket(address, port, localAddress, localPort);
        // this should not be matched
		s.setEnabledCipherSuites(strongCiphers);
		return s;
    }
}

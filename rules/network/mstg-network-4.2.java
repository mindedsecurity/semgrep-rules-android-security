public class Test{
    SSLContext sslContext;
    X509TrustManager trustManager;

    public void test1(){
        sslContext = SSLContext.getInstance("TLSv1.2");
        sslContext.init(null, null, null);
    }
    public void test2(){
        TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        instance.init((KeyStore) null);
    }
    public void test3(){
        OkHttpClient client = new OkHttpClient.Builder()
        .certificatePinner(new CertificatePinner.Builder()
            .add("example.com", "sha1/UwQAapahrjCOjYI3oLUx5AQxPBR02Jz6/E2pt0IeLXA=")
            .build())
        .build();
        OkHttpClient client = new OkHttpClient.Builder()
        .certificatePinner(new CertificatePinner.Builder()
            .add("example.com", "sha256/UwQAapahrjCOjYI3oLUx5AQxPBR02Jz6/E2pt0IeLXA=")
            .build())
        .build();
    }
    public void test4(){
        TrustManager[] trustManagers = new TrustManager[1];
        trustManagers[0] = new PinningTrustManager(SystemKeyStore.getInstance(context), pins, 0);

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, trustManagers, null);

        HttpsURLConnection urlConnection = (HttpsURLConnection)url.openConnection();
        //urlConnection.setSSLSocketFactory(sslContext.getSocketFactory());
        urlConnection.connect();
    }

    public void test5(){
        TrustManager[] trustManagers = new TrustManager[1];
        trustManagers[0] = new PinningTrustManager(SystemKeyStore.getInstance(context), pins, 0);

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, trustManagers, null);

        HttpsURLConnection urlConnection = (HttpsURLConnection)url.openConnection();
        test3();
        urlConnection.setSSLSocketFactory(sslContext.getSocketFactory());
        urlConnection.connect();
    }

    public void test6(){
        TrustManager[] trustManagers = new TrustManager[1];
        trustManagers[0] = new PinningTrustManager(SystemKeyStore.getInstance(context), pins, 0);

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, trustManagers, null);

        HttpsURLConnection urlConnection;
        urlConnection = (HttpsURLConnection)url.openConnection();
        test3();
        //urlConnection.setSSLSocketFactory(sslContext.getSocketFactory());
        urlConnection.connect();
    }
}
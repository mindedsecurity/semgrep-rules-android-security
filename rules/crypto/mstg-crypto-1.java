public class A{
    byte[] key = new byte[]{2,7,2,9};
    byte[] iv = new byte[]{12};
    
    private byte[] aes(byte[] data, int mode){
        Cipher cipher = Cipher.getInstance(AES_MODE);
        cipher.init(mode, new SecretKeySpec(this.key, "AES"), new IvParameterSpec(iv));
        return cipher.doFinal(data);
    }
}
public class B{
    String key = "SuperPassword123!";
    byte[] iv = new byte[]{12};
    
    private byte[] aes(byte[] data, int mode){
        Cipher cipher = Cipher.getInstance(AES_MODE);
        cipher.init(mode, new SecretKeySpec(this.key.getBytes(), "AES"), new IvParameterSpec(iv));
        return cipher.doFinal(data);
    }
}
public class C{
    String key;
    byte[] iv = new byte[]{12};
    
    private byte[] aes(byte[] data, int mode){
        key = getString(R.string.key);
        Cipher cipher = Cipher.getInstance(AES_MODE);
        cipher.init(mode, new SecretKeySpec(key.toByteArray(), "AES"), new IvParameterSpec(iv));
        return cipher.doFinal(data);
    }
}

Lintcode 128 - Hash Function.java

class Solution {
    /**
     * @param key: A String you should hash
     * @param HASH_SIZE: An integer
     * @return an integer
     */
    public int hashCode(char[] key,int HASH_SIZE) {
        // (a + b) % p == ( a % p + b % p ) % p
        long ans = 0;
        for(int i = 0; i < key.length; i++) {
            //为了防止溢出，每次都取一下模
            ans = (ans * 33 + (int)(key[i])) % HASH_SIZE;
        }
        return (int)ans;
    }
};
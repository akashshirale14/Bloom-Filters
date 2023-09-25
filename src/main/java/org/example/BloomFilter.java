package org.example;

import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

public class BloomFilter {
    boolean[] filter;
    int size;

    HashFunction murmurHash;
    public BloomFilter(int size){
        filter=new boolean[size];
        this.size = size;
        murmurHash = Hashing.murmur3_32(/* seed */ 67788);
    }

    public void add(String input){
        int index = getMurmurHashValue(input);
        System.out.println("Index for "+input+" is "+ index);
        filter[index] = true;
    }

    public boolean exists(String input){
        int index = getMurmurHashValue(input);
        if(filter[index]) {
            return true;
        }
        return false;
    }

    public int getMurmurHashValue(String input){
        int hashValue = murmurHash.hashString(input, java.nio.charset.StandardCharsets.UTF_8).asInt();
        if (hashValue<0){
            hashValue*=-1;
        }
        return hashValue%size;
    }
}

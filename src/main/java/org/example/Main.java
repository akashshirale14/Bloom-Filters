package org.example;

public class Main {
    public static void main(String[] args) {
        //Create a BloomFilter
        BloomFilter bloomFilter = new BloomFilter(8);
        //Add some elements
        bloomFilter.add("a");
        bloomFilter.add("b");
        bloomFilter.add("c");
        bloomFilter.add("d");
        bloomFilter.add("e");
        bloomFilter.add("f");
        bloomFilter.add("g");
        bloomFilter.add("h");
        //Check if element exists in the set or not
        System.out.println(bloomFilter.exists("d"));
        System.out.println(bloomFilter.exists("z"));

        //print out bloom filter
        for(int i=0;i<bloomFilter.filter.length;i++){
            System.out.print(bloomFilter.filter[i] + ", ");
        }
    }
}
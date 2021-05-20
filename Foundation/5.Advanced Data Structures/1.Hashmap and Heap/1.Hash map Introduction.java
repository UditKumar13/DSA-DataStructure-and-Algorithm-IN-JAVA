hashmap  

1.How to initialize a hashmap

Hashmap <String , Integer> hm = new Hashmap<>();

2.there are generally 3 functions 
get , put , containsKey

hm.put("India", 135);
hm.put("Uk", 20);
hm.put("Us", 14);
hm.put("pak", 25);
hm.put("korea",75);

System.out.println(hm.get("India")) ;
// output is 135
System.out.println(hm.get("Utopia")) ;
//null

System.out.println(hm.containsKey("India"));
//output :true
System.out.println(hm.containsKey("Utopia"));
//output :false

3. Keyset 

Set <String> Keys = hm.keySet();
Sopln(keys);
//output : [pak,korea,India,Us,Uk] all keys

4.how to get key value pair 
make a for loop

for (String key : keys){
Integer val = hm.get(key);
sopln(key + " " + val);
}


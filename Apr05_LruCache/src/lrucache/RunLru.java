package lrucache;

public class RunLru {

	
	public static void main(String[] args) {
		LruCache<Integer, String> lrucache = new LruCache<Integer, String>(5);
		lrucache.put(1, "One");
		lrucache.printList();
		lrucache.put(2, "Two");
		lrucache.printList();
		lrucache.put(3, "Three");
		lrucache.printList();
		lrucache.put(4, "Four");
		lrucache.printList();
		lrucache.get(1);
		lrucache.printList();
		lrucache.put(5, "Five");
		lrucache.printList();
		lrucache.get(3);
		lrucache.printList();
		lrucache.put(6, "Six");
		lrucache.printList();
		lrucache.get(3);
		lrucache.printList();
		lrucache.get(2);
		lrucache.printList();
	}

}
/*
! in Cache- adding to it 1
Adding to head One
>>>> List is: ##1 : One ##null : null

! in Cache- adding to it 2
Adding to head Two
>>>> List is: ##2 : Two ##1 : One ##null : null

! in Cache- adding to it 3
Adding to head Three
>>>> List is: ##3 : Three ##2 : Two ##1 : One ##null : null

! in Cache- adding to it 4
Adding to head Four
>>>> List is: ##4 : Four ##3 : Three ##2 : Two ##1 : One ##null : null

Cache hit: 1
Removing One
Adding to head One
>>>> List is: ##1 : One ##4 : Four ##3 : Three ##2 : Two ##null : null

! in Cache- adding to it 5
Adding to head Five
>>>> List is: ##5 : Five ##1 : One ##4 : Four ##3 : Three ##2 : Two ##null : null

Cache hit: 3
Removing Three
Adding to head Three
>>>> List is: ##3 : Three ##5 : Five ##1 : One ##4 : Four ##2 : Two ##null : null

! in Cache- adding to it 6
Adding to head Six
Removing Two
Cache full- removing last
>>>> List is: ##6 : Six ##3 : Three ##5 : Five ##1 : One ##4 : Four ##null : null

Cache hit: 3
Removing Three
Adding to head Three
>>>> List is: ##3 : Three ##6 : Six ##5 : Five ##1 : One ##4 : Four ##null : null

2 is not present in the cache
>>>> List is: ##3 : Three ##6 : Six ##5 : Five ##1 : One ##4 : Four ##null : null


*/
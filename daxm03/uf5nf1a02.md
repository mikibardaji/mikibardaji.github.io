# Estructures d'emmagatzematge

## Continguts

* Col·leccions i iteradors.
* Recorregut per col·leccions.
* Llistes, piles, cues, mapes, …

[Apunts d'Estructures de dades en Java](assets/5.1/5.1.2/dax2_m03-a512-Collections.pdf)

[Documentació de referència](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/doc-files/coll-overview.html)

## Ús de llistes 

[Colec.java (descàrrega)](assets/5.1/5.1.2/Colec.java)
```
import java.util.*;

public class Colec {

	public static void main(String[] args) {
		
		List<Integer> data = new LinkedList<>();
		
		//populate data.
		data.add(new Integer(23));
		data.add(new Integer(12));
		data.add(new Integer(10));
		data.add(new Integer(45));
		
		System.out.println("Number of elements: "+data.size());
		
		System.out.println("Iterate with for-each loop");
		for (Integer elem: data) {
			System.out.println(elem.toString());	
		}
		
		System.out.println("Iterate with iterator");
		Iterator<Integer> iter = data.iterator();
		while (iter.hasNext()) {
			Integer elem = iter.next();
			System.out.println(elem.toString());
		}
		
		System.out.println("Collection contains 23: "+data.contains(23));
		System.out.println("Collection contains 99: "+data.contains(99));
		
		System.out.println("Is empty?:" + data.isEmpty());
		
		System.out.println("Remove element 23");
		data.remove(new Integer(23));
		for (Integer elem: data) {
			System.out.println(elem.toString());	
		}
		
		System.out.println("Iterate with listiterator");
		ListIterator<Integer> iter2 = data.listIterator();
                
		while (iter2.hasNext()) {
			Integer elem = iter2.next();
			System.out.println("Next elem: " + elem.toString());
                       
		}	
                 
		System.out.println("Add an element at index 1");
		data.add(1, new Integer(55));
		printList(data);
		
		System.out.println("Add an element at the top of the list");
		data.add(new Integer(77));
		printList(data);
		
		System.out.println("Modify element at index 2");
		data.set(2, new Integer(44));
		printList(data);
		
		System.out.println("Iterate with a counter and use method get");
		for (int i = 0; i<data.size(); i++){
			Integer elem = data.get(i);
			System.out.println(elem.toString());
		}
		
		System.out.println("To string method");
		System.out.println(data.toString());
		
		System.out.println("Index of method");
		int p = data.indexOf(44);
		System.out.println("Index of elem 44= " +p);
	}

	private static void printList(List<Integer> l) {
		for (Integer elem: l) {
			System.out.println(elem.toString());	
		}
	}

}
```
La interface que ocupa la posició més alta a la jerarquia d'herència (i per tant la més general) és [***Collection***](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Collection.html). 

La interface collections ofereix aquests mètodes.

| Mètode | Descripció | 
|:----------:|----------|
| **add(T)**    | Afegeix un element |
| **iterator()**   | Obté un iterador que permet recórrer la col·lecció visitant cada element una vegada |
| **size()**     | Obté la quantitat d'elements que aquesta col·lecció emmagatzema  |
| **contains(t)**  | Pregunta si l'element t ja està dintre de la col·lecció |


Per poder il·lustrar també mètodes que proporcionen les llistes però no les col·leccions, a l'exemple usarem classes que implementin llistes.

Declarem la llista amb el tipus de la interface [***List***](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/List.html), la qual ens permet gestionar per polimorfisme tots els tipus de llistes. Disposem de dues classes implementades a la biblioteca (paquet java.util): [***ArrayList***](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/ArrayList.html) i [***LinkedList***](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/LinkedList.html).

Instanciem un tipus concret de llista.

La biblioteca de col·leccions de Java usa plantilles (*template*) per especificar el tipus d'objecte a emmagatzemar: List<Integer>.

Les dues implementacions són iguals i funcionen de la mateixa manera. La diferència està en la implementació de la llista en memòria. *ArrayList* implementa la llista amb un array, mentres que *LinkedList* utilitza una llista enllaçada. Els arrays permeten accessos ràpids i directes a la informació, donada la posició de l'element. En canvi, les llistes enllaçades són més eficients quan cal inserir i esborrar elements amb freqüència a la llista.

Per afegir elements al final de la llista utilitzem el mètode ***add()***.

Obtenim el nombre d'elements que hi ha a la llista amb el mètode ***size()***.

Per recórrer la llista es poden utilitzar diversos procediments.

### Recorregut amb un iterador (Collection)

Aquest és el procediment general per a qualsevol ***Collection***.

    Iterator<Integer> iter = data.iterator();
    while (iter.hasNext()) {
        Integer elem = iter.next();
        System.out.println(elem.toString());
    }

### Recorregut amb comptador de posició (List)

Accedim a cada posició de la llista amb el mètode ***get(int index)***.

    for (int i = 0; i<data.size(); i++){
        Integer elem = data.get(i);
        System.out.println(elem.toString());
    }

### Recorregut amb bucle foreach (Collection)

    for (Integer elem: l) {
        System.out.println(elem.toString());	
    }

# Cerca d'elements a una llista

[LinkedListTester.java (descàrrega)](assets/5.1/5.1.2/LinkedListTester.java)

```
import java.util.*;
/**
 * Program to test LinkedList functionality 
 * @author ProvenSoft
 */
public class LinkedListTester {

    public static void main(String[] args) {

        List <Integer> list1 = new LinkedList <> ();
        
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(5);
        list1.add(8);
        list1.add(13);
        list1.add(21);
        list1.add(34);
        list1.add(3);
        
        System.out.println ("Size = " +list1.size());
      
        System.out.println ("Test get method");
        Integer elem = list1.get(3);
        System.out.println ("Element at index 3  is = " +elem);
        
                        
        System.out.println ("\nTest get method  --> exception");
        try { Integer elem2 = list1.get(99);}
             
        catch (IndexOutOfBoundsException e){
            System.out.println ("Exception message " +e.getMessage());
           // e.printStackTrace();
        }

        System.out.println ("\nTest indexOf method");
        int i = list1.indexOf (13);
        System.out.println ("The index of element 13 is " +i);
        
        int i2 = list1.indexOf (0);
        System.out.println ("The index of element 0 is " +i2);
        
        
        System.out.println ("\nTest latIndexOf method");
        int i3 = list1.lastIndexOf(3);
        System.out.println ("The last index of element 3 is " +i3);
        
        int i4 = list1.lastIndexOf(0);
        System.out.println ("The last index of element 0 is " +i4);
    
        System.out.println ("\nLoop using get");
        for (int j = 0; j<list1.size(); j++){
            System.out.println(list1.get(j));
        }
        
        System.out.println ("\nTest set method");
        list1.set(2, 22);
         for (int j = 0; j<list1.size(); j++){
            System.out.println(list1.get(j));
        }   
         
    }        
        
}
```

Els mètodes **indexOf()** i **lastIndexOf()** ens proporcionen la ubicació de l'objecte buscat a la llista (la primera aparició o l'última, respectivament) o bé retorna -1 si no troba l'objecte. Cal recordar que per trobar l'objecte la implementació de la llista usa el mètode ***equals()*** definit a la classe dels objectes emmagartzemats a la llista. Cal definir allà correctament com es comparen els objectes de la llista.

## Comparació de List i Set

Un *Set* és una *Collection* on no pot haver-hi elements duplicats. El següent exemple il·lustra aquest fet en comparació amb una *List*.

[ListVsSetTester.java](assets/5.1/5.1.2/ListVsSetTester.java)

## Ordenació d'elements de col·leccions

La interface *List* proveeix el mètode ***sort()*** per ordenar els elements. El paràmetre del mètode és un objecte d'una classe que implementi l'interface Comparator<T>, definint de forma adequada el mètode compare(T o1, T o2).

El retorn del mètode *compare()* és el següent:
* enter negatiu si o1 < o2
* 0 si o1 = o2
* enter positiu si o1 > o2

[ListSort.java (descàrrega)](assets/5.1/5.1.2/ListSort.java)
```
/**Java program to demonstrate working of Comparator 
 * interface and Collections.sort() to sort according 
 * to user defined criteria.
 * @author Jose Moreno
 */ 
import java.util.*; 
import java.lang.*; 
import java.io.*; 

// A class to represent a student. 
class Student { 
	private int 	id; 
	private String 	name, 
					address; 

	// Constructor 
	public Student(int id, String name, String address) { 
		this.id = id; 
		this.name = name; 
		this.address = address; 
	} 

	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	// Used to print student details in main() 
	public String toString() { 
		return this.id + " " + this.name + " " + this.address; 
	} 
} 

// class to implement comparison by id
class SortById implements Comparator<Student> { 
	// Used for sorting in ascending order of id .
	public int compare(Student a, Student b) { 
		return a.getId() - b.getId(); 
	} 
} 

// class to implement comparison by name
class SortByName implements Comparator<Student> 
{ 
	// Used for sorting in ascending order of name.
	public int compare(Student a, Student b) { 
		return a.getName().compareTo(b.getName()); 
	} 
} 

// Main class.
public class ListSort { 
	public static void main (String[] args) { 
		List<Student> data = new ArrayList<Student>(); 
		data.add(new Student(111, "bbbb", "london")); 
		data.add(new Student(131, "aaaa", "nyc")); 
		data.add(new Student(121, "cccc", "jaipur")); 
//
		System.out.println("Unsorted"); 
		for (int i=0; i<data.size(); i++) 
			System.out.println(data.get(i)); 
//Java 7
		Collections.sort(data, new SortById()); 
		System.out.println("\nSorted by id"); 
		for (int i=0; i<data.size(); i++) 
			System.out.println(data.get(i));
//Java 7
		Collections.sort(data, new SortByName()); 
		System.out.println("\nSorted by name"); 
		for (int i=0; i<data.size(); i++) 
			System.out.println(data.get(i));			
//Java 8
		System.out.println("\nSorted by id (Java 8)"); 
		data.sort(Comparator.comparing(Student::getId));
		data.forEach(System.out::println);
		
		System.out.println("\nSorted by name (Java 8)"); 
		data.sort(Comparator.comparing(Student::getName));
		data.forEach(System.out::println);
		
		System.out.println("\nReverse sorted by name (Java 8)"); 
		data.sort(Comparator.comparing(Student::getName).reversed());
		data.forEach(System.out::println);
	}
} 
```

# Ús de mapes (Map)

La interface [***Map***](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Map.html) relaciona dues col·leccions d'elements: claus (*key*) i valors (*value*), permeten cerques per les claus.

La interface proporciona tres vistes de les dades:
* ***Set<K> keySet()***: proporciona un *Set* amb les *keys*
* ***Collection<V> values()***: proporciona una *Collection* amb els *values*
* ***Set<Map.Entry<K,V>> entrySet()***: proporciona un *Set* amb les parelles clau-valor (tipus ***Map.Entry<K,V>***)

També proporciona diversos mètodes *getXX*, *putXX*, *replaceXX*, ... per accedir a la informació i per modificar-la.

[MapExample.java (descàrrega)](assets/5.1/5.1.2/MapExample.java)
```
import java.io.*;
import java.util.*;

/**
 * MapExample.java
 * This example illustrates the use of Map interface and how to iterate it
 * @author José Moreno
 */
public class MapExample {
	
	public static void main (String args[]) {
		
		Map<String, Integer> items = new HashMap<>();
		
		//Populating the Map
		items.put("A", 10);
		items.put("B", 20);
		items.put("C", 30);
		items.put("D", 40);
		items.put("E", 50);
		items.put("F", 60);

		//Using an Iterator (previous to Java 8)
		System.out.println("Iterating a Map using an iterator:");
		
		Set<Map.Entry<String,Integer>>      set  = items.entrySet();
		Iterator<Map.Entry<String,Integer>> iter = set.iterator();
		
		while (iter.hasNext()) {
			Map.Entry<String,Integer> entry = iter.next();
			String  key                     = entry.getKey();
			Integer value                   = entry.getValue();
			System.out.println("[ Key: "+key+" ] [ Value: "+value+" ]");
		}
		
		//Getting the set of keys
		Set<String>  keys  = items.keySet();
		
		//Looping the set
		for (String key: keys) {
				Integer value = items.get(key);
				System.out.println("[ Key: "+key+" ] [ Value: "+value+" ]");
		}
		
		
		//Using for loop
		System.out.println("Iterating a Map using a foreach loop:");
		for (Map.Entry<String, Integer> entry : items.entrySet()) {
			System.out.println("[ Key: " + entry.getKey() + " ][ Value: " + entry.getValue()+" ]");
		}
		
		//Lambda expressions and passive iterators (since Java 8)
		
		//Output using a consumer
		System.out.println("Iterating a Map using lambda expressions, passive iterators and a simple action:");
		items.forEach((k,v)->System.out.println("[ Key: " + k + " ][ Value: " + v+" ]"));
		
		//Block of code
		System.out.println("Iterating a Map using lambda expressions, passive iterators and a block of code:");
		items.forEach((k,v)->{
			System.out.println("[ Key: " + k + " ][ Value : " + v+" ]");
			if("E".equals(k)){
				System.out.println("Hello E");
			}
		});
	
	}
}
```

## Programació amb estructures de dades

[Classes Menu i MenuItem per programar menús d'usuari](assets/5.1/5.1.2/generic_menu.zip)

Desenvolupat guiat de l'aplicació per gestionar clients. Els client s'emmagatzemen en una llista [ClientManager_with_ArrayList.zip](assets/5.1/5.1.2/ClientManager_with_ArrayList.zip).

## Classe Properties

La classe [***Properties***](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Properties.html) representa un conjunt persistent de propietats, les quals es poden desar i recuperar d'un *stream* (per exemple, un fitxer). Cada propietat ve definida per una clau (key) i un valor (value).

Alguns dels mètodes que proporciona són:

* String getProperty(String key)
* String getProperty(String key, String defaultValue)
* void list(PrintStream out)
* void list(PrintWriter out)
* void load(InputStream inStream)
* void load(Reader reader)
* Enumeration<?> propertyNames()
* Object setProperty(String key, String value)
* void store(Writer writer, String comments)

Consulteu la documentació per a obtenir més detalls de l'us de cada mètode.

[Exemple d'ús de Properties per mantenir usuari i paraula de pas: properties_example.zip](assets/5.1/5.1.2/properties_example.zip)

Exercici proposat:
Utilitzar els fitxers de Properties per desar la configuració d'un programa i les traduccions dels missatges. Caldrà un fitxer de propietats per desar l'idioma escollit i un fitxer de propietat per a cadascun dels idiomes.

## Col·leccions i streams (java 8+)

A partir de la versió 8 de Java, el tractament de seqüències de dades es potencia molt amb la [interface java.util.Stream<T>](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/stream/Stream.html), els **interface funcionals** i les **expressions lambda**.

L'ús combinat d'aquestes eines permet la manipulació àgil i la realització d'operacions complexes de filtrat, modificació i transformació de dades d'una manera molt potent i efectiva. 

Al llarg del curs aniran apareixen algunes d'aquestes característiques.

[Tutorial de llistes amb stream](assets/5.1/5.1.2/java8tutorial-streams.pdf)

Exemple de tractament de llistes amb streams: [Java8Tester.java](assets/5.1/5.1.2/Java8Tester.java)

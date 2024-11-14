/* 
 * file name: EdgeTree.java 
*/


// packages is to avoid name conflicts, to write a better maintainable code.  
// This is a User-defined Packages (create one's own packages)
// To create a package, use the package keyword:
// The package name is in lower case to avoid conflict with class names.
package graphalg;

// To import given classes (also including my edited parts)
//import list.*;

 
// This is EdgeTree class as an internal data structure (required as internal data
// structure)that represents an edge in a WUGraph.  
// A vertex object is HIDDEN from the application. And it maintains its edges
// in different Edge objects. The best way to map the application’s vertex
// or edge objects to the internal vertex/edge objects is to use the hash tables  
 
// When not using any keyword explicitly, Java will set a default access to a
// given class, method, or property. The default access modifier is also 
// called package-private, all members are visible within the same package,
// but aren't accessible from other packages.

// this syntax is only to compare two different EdgeTree objects
//class EdgeTree implements Comparable<EdgeTree>{

class EdgeTree {
	Object vertexA;
  	Object vertexB;
  	int edgeWeight;

    // default constructor
	EdgeTree() {

		vertexA = null;
		vertexB = null;
		edgeWeight = 0;
   }



	
	// constructor with three parameters
	EdgeTree(Object objA, Object objB, int newWeight) {

   		vertexA =  objA ;
   		vertexB =  objB ;
   		edgeWeight = newWeight;
  	}
  


	
	// getter to get edge weight
  	int weight(){

    		return edgeWeight;
  	}





	// getter to get edge weight
	// getter
	Object edge(){

		if (vertexA != null && vertexB != null){
			return this;	
		}
        return null;
    }

	// this method is only to compare two different EdgeTree objects
	//@Override
	//public int compareTo(EdgeTree other){
	//	return Integer.compare(this.edgeWeight, other.edgeWeight);
	//}
}


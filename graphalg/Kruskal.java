/* file name: Kruskal.java */



// Using packages is to avoid name conflicts, and to write a better maintainable code.  
// This is a User-defined Packages (create one's own packages)
// To create a package, use the package keyword:
// Note: The package name should be in lower case to avoid conflict with class names.
package graphalg;


import graph.*;
import set.*;
import dict.*;

/**
 * The Kruskal class contains the method minSpanTree(), which implements
 * Kruskal's algorithm for computing a minimum spanning tree of a graph.
 */

public class Kruskal {

  /**
   * minSpanTree() returns a WUGraph that represents the minimum spanning tree
   * of the WUGraph g.  The original WUGraph g is NOT changed.
   * 
   * Let G be the graph represented by the WUGraph g.  
   * The implementation run in O(|V| + |E| log |E|) time, 
   * where |V| is the number of vertices in G, 
   * and |E| is the number of edges in G.
   */
  public static WUGraph minSpanTree(WUGraph g){
 
      WUGraph miniSpanningTree = new WUGraph();

      int numOfEdges = g.edgeCount();

      // the number of all the edges in the graph g
      // undirected graph, one edge is counted twice 
      // by the paired vertices. 
      // this is a temp EdgeTree object for later usage, 
      // to be sorted as a sortedEdgeTree object
      EdgeTree edgesTreeTemp[] = new EdgeTree[2 * numOfEdges];

      // the number of all the vertices in the graph g
      int numOfVertices = g.vertexCount();
      HashTableChained vertexHash = new HashTableChained(numOfVertices);

      // in set folder
      DisjointSets treeSets = new DisjointSets(numOfVertices);

      Object[] allVerticesObjs = g.getVertices();
      Neighbors neighborVertex;
      int edgeCounter = 0;
      int vertexCounter = 0;

      for(Object vertexTemp : allVerticesObjs){
 
          // add all the vertices from graph g
          miniSpanningTree.addVertex(vertexTemp);
          vertexHash.insert(vertexTemp, vertexCounter++);
          neighborVertex = g.getNeighbors(vertexTemp);
  
          int neighborSize = neighborVertex.neighborList.length;
  
          for(int i = 0; i < neighborSize; i++){
          
            // these edges stored in edgesTreeTemp EdgeTree objects,
            // which are are mot sorted yet
            edgesTreeTemp[edgeCounter] = new EdgeTree();
            edgesTreeTemp[edgeCounter].edgeWeight = neighborVertex.weightList[i];
            edgesTreeTemp[edgeCounter].vertexA = vertexTemp;
            edgesTreeTemp[edgeCounter].vertexB = neighborVertex.neighborList[i];
            edgeCounter++;
          }
      }
 
      // use this new fresh EdgeTree objects to be sorted later
      EdgeTree newEdgeTree[] = new EdgeTree[edgeCounter];
      int len = newEdgeTree.length;
      for(int i = 0; i < len; i++){
          newEdgeTree[i] = edgesTreeTemp[i];
      }

      // use this sorted EdgeTree objects as the reference
      // for the final miniSpanningTree.
      EdgeTree sortedEdgesTree[] = new EdgeTree[edgeCounter];

      // use the sorted EdgeTree as an array of objects
      // sorted by the weight of the edge in ascending order
      sortedEdgesTree = edgeMergeSort(newEdgeTree) ;
      
      int A;
      int B;
      int vertexA;
      int vertexB;
 
      for (int i = 0; i < sortedEdgesTree.length; i++){

          // check value from hash table
          A = (Integer)vertexHash.find(sortedEdgesTree[i].vertexA).value();
          B = (Integer)vertexHash.find(sortedEdgesTree[i].vertexB).value();
          
          // find the value in set
          vertexA = treeSets.find(A);
          vertexB = treeSets.find(B);

          if(vertexA != vertexB){

            // set union in set folder
            treeSets.union(vertexA,vertexB);

            // add edges to minSpanningTrees in the sorted objects 
            // EdgeTree by edgeWeight in ascending order 
            miniSpanningTree.addEdge(sortedEdgesTree[i].vertexA,
            sortedEdgesTree[i].vertexB,sortedEdgesTree[i].edgeWeight);
          }
      } 
 
    return miniSpanningTree;
}



  
    
  /* EdgeTree version of Merge Sort 
  * Merge Sort an array of EdgeTree objects by sorting the weight
  * of the edge called edgeWeight in ascending order. 
  * runtime is in O(|E| log |E|) time as required.  
  */
  private static EdgeTree[] edgeMergeSort(EdgeTree elements[]){

      int numOfElements = elements.length;
      
      if(numOfElements < 2){
      
        return elements;
      }
      
    
      EdgeTree[] left, right;
      int mid = numOfElements/2;
      left = new EdgeTree[mid];
    
      for(int i = 0; i < mid; i++){
      
        left[i] = elements[i];
      }
    
      right = new EdgeTree[numOfElements - mid];
      
      for(int i = mid; i < numOfElements; i++){
        right[i-mid] = elements[i];
      }
      
      left = edgeMergeSort(left);
      right = edgeMergeSort(right);
      
      return edgeMerge(left,right);
  }
  
  
  
  
  
  // helper function for edgeMergeSort
  private static EdgeTree[] edgeMerge(EdgeTree left[], EdgeTree right[]){
  
      EdgeTree[] sorted = new EdgeTree[left.length+right.length];
    
      int r = 0;
      int l = 0;
      int s = 0;
      
      int leftLen = left.length;
      int rightLen = right.length;
      
      while(l < leftLen && r < rightLen){
      
        if((left[l].edgeWeight != 0 && right[r].edgeWeight != 0) 
      
                  && left[l].edgeWeight < right[r].edgeWeight){
          sorted[s++] = left[l++];
        } 
        else {
          sorted[s++] = right[r++];
        }
      }
      
      while(l < leftLen){
        sorted[s++] = left[l++];
      }
      
      while(r < rightLen){
        sorted[s++] = right[r++];
      }
    
      return sorted;
    }
}